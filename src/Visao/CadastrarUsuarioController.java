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
    public Button btnCadastrar;
    @FXML
    public Button btnCancelar;
    @FXML
    public Label lblInformacao;
    
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    
    @FXML
    public void cancelarAcao(){
        txtLogin.setText("");
        txtSenha.setText("");
        txtSenha1.setText("");
        aplicacao.goTo("Login");
    }
    @FXML
    public void cadastrarAcao(){
        if(txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty() || txtSenha1.getText().isEmpty()){
            lblInformacao.setText("Favor preencher todos os campos.");
                lblInformacao.setTextFill(Paint.valueOf("orange"));
        }else{
            if(txtSenha.getText().equals(txtSenha1.getText())){                
                txtLogin.setText("");
                txtSenha.setText("");
                txtSenha1.setText("");
                lblInformacao.setText("Usuário cadastrado com sucesso!");    
                lblInformacao.setTextFill(Paint.valueOf("darkgreen"));     
                aplicacao.goTo("Login");             
                //trabalha com o xml para gerar o usuario              
            }else{
                lblInformacao.setText("As senhas não conferem."); 
                lblInformacao.setTextFill(Paint.valueOf("red"));           
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
