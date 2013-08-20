package Controle;

import Log.Log;
import Modelo.Usuario;
import Persistencia.Autenticador;
import Visao.ProjetoFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class LoginController implements Initializable {

    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    private static Log log = new Log(LoginController.class);
    private Autenticador autenticador = new Autenticador();
    
    @FXML
    private Label lblCadastrar;
    @FXML
    private Label lblInformacao;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;

    @FXML
    private void entrarAcao() {
        if (txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()) {
            lblInformacao.setText("Login / Senha devem ser preenchidos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            Usuario temp = new Usuario();
            log.info("entrarAcao", "Criado novo usuario temporario para verificação de login");
            temp.setLogin(txtLogin.getText());
            temp.setSenha(txtSenha.getText());

            if (autenticador.verificarLogin(temp)) {
                lblInformacao.setText("Login / Senha validados com sucesso.");
                lblInformacao.setTextFill(Paint.valueOf("green"));
                aplicacao.goTo("Principal");
            } else {
                lblInformacao.setText("Login / Senha inválidos.");
                lblInformacao.setTextFill(Paint.valueOf("red"));
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void mouseDentro() {
        lblCadastrar.setTextFill(Paint.valueOf("darkgray"));
    }

    @FXML
    public void mouseFora() {
        lblCadastrar.setTextFill(Paint.valueOf("gray"));
    }

    @FXML
    public void mouseClick() {
        aplicacao.goTo("CadastrarUsuario");
    }
}
