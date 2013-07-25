/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
import Modelo.Usuario;
import Persistencia.GravadorXML;
import Visao.ProjetoFinal;
import java.io.File;
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
public class CadastrarUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtLogin;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public PasswordField txtSenha1;
    @FXML
    public Label lblInformacao;
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    private static Log log = new Log(CadastrarUsuarioController.class);

    @FXML
    public void cancelarAcao() {
        txtLogin.setText("");
        txtSenha.setText("");
        txtSenha1.setText("");
        aplicacao.goTo("Login");
    }

    @FXML
    public void cadastrarAcao() {
        if (txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty() || txtSenha1.getText().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            if (txtSenha.getText().equals(txtSenha1.getText())) {
                log.info("cadastrarAcao", "Realizando o trabalho com xml de cadastro");
                if(!new File("src/xml/Usuarios/" + txtLogin.getText() + ".xml").exists()){                    
                    Usuario temp = new Usuario();
                    temp.setLogin(txtLogin.getText());
                    temp.setSenha(txtSenha.getText());
                    temp.setNome(txtNome.getText());
                    GravadorXML gravador = new GravadorXML(temp);                    
                    lblInformacao.setText("Usuário cadastrado com sucesso!");
                    lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                    txtLogin.setText("");
                    txtSenha.setText("");
                    txtSenha1.setText("");    
                    aplicacao.goTo("Login");
                }else{
                    lblInformacao.setText("Usuário com esse login ja existe!");
                    lblInformacao.setTextFill(Paint.valueOf("orange"));
                }
            } else {
                lblInformacao.setText("As senhas não conferem.");
                lblInformacao.setTextFill(Paint.valueOf("red"));
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}
