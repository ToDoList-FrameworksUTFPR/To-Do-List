/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
import Modelo.Usuario;
import Persistencia.GravadorXML;
import Visao.ProjetoFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class AlterarDadosController implements Initializable {

    private static Log log = new Log(AlterarDadosController.class);
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
        txtNome.setText("");
        txtSenha.setText("");
        txtSenha1.setText("");
        aplicacao.goTo("Principal");
    }

    @FXML
    public void confirmarAcao() {
        if (txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() ||
                txtSenha.getText().isEmpty() || txtSenha1.getText().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            if (txtSenha.getText().equals(txtSenha1.getText())) {
                lblInformacao.setText("Usuário alterado com sucesso!");
                lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                aplicacao.retornarUsuario().setNome(txtNome.getText());
                aplicacao.retornarUsuario().setSenha(txtSenha.getText());
                log.info("cadastrarAcao", "Alterado dados do usuário");
                txtLogin.setText("");
                txtNome.setText("");
                txtSenha.setText("");
                txtSenha1.setText("");
                GravadorXML gravador = new GravadorXML(aplicacao.retornarUsuario());      
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
        log.info("initialize", "Iniciado form, e carregado dados do usuário. url -> " + url);
    }
}
