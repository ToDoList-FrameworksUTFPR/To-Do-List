/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Usuario;
import Visao.ProjetoFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Rayan
 */
public class AlterarDadosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtLogin;
    @FXML
    public TextField txtNome;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public PasswordField txtSenha1;
    @FXML
    public Label lblInformacao;
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();

    @FXML
    public void cancelarAcao() {
        txtLogin.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtSenha1.setText("");
        aplicacao.goTo("Principal");
    }

    @FXML
    public void cadastrarAcao() {
        if (txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty() || txtSenha1.getText().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            if (txtSenha.getText().equals(txtSenha1.getText())) {
                lblInformacao.setText("Usuário cadastrado com sucesso!");
                lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                aplicacao.retornarUsuario().setNome(txtNome.getText());
                aplicacao.retornarUsuario().setSenha(txtSenha.getText());
                txtLogin.setText("");
                txtNome.setText("");
                txtSenha.setText("");
                txtSenha1.setText("");
                //trabalha com o xml para gerar os dados     
                aplicacao.goTo("Principal");         
            } else {
                lblInformacao.setText("As senhas não conferem.");
                lblInformacao.setTextFill(Paint.valueOf("red"));
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario temp = aplicacao.retornarUsuario();
        txtLogin.setText(temp.getLogin());
        txtNome.setText(temp.getNome());
        txtSenha.setText(temp.getSenha());
    }
}
