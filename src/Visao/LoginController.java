/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

/**
 *
 * @author Rayan
 */
public class LoginController implements Initializable {
    
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    
    @FXML
    private Label lblCadastrar;
    @FXML
    private Label lblLogin;
    @FXML
    private Label lblSenha;
    @FXML
    private Label lblInformacao;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Button btnEntrar;
    
    @FXML
    private void entrarAcao() {
        if(txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()){
            lblInformacao.setText("Login / Senha devem ser preenchidos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        }else{
            if("teste".equals(txtLogin.getText()) && "teste".equals(txtSenha.getText())){
                lblInformacao.setText("Login / Senha validados com sucesso.");
                lblInformacao.setTextFill(Paint.valueOf("green"));
                aplicacao.goTo("Principal");
            }else{
                lblInformacao.setText("Login / Senha inválidos.");
                lblInformacao.setTextFill(Paint.valueOf("red"));
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void mouseDentro(){
        lblCadastrar.setTextFill(Paint.valueOf("darkgray"));
    }
    @FXML
    public void mouseFora(){
        lblCadastrar.setTextFill(Paint.valueOf("gray"));        
    }
    @FXML
    public void mouseClick(){
        aplicacao.goTo("CadastrarUsuario");
    }
}
