/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Lista;
import Visao.ProjetoFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Rayan
 */
public class CadastrarListaController implements Initializable {
    
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();

    @FXML
    public TextField txtNome;
    @FXML
    public Label lblInformacao;

    @FXML
    public void cancelarAcao() {
        txtNome.setText("");
        aplicacao.goTo("Principal");
    }

    @FXML
    public void cadastrarAcao() {
        if (txtNome.getText().isEmpty()) {
            lblInformacao.setText("Favor preencher corretamente o campo.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            lblInformacao.setText("Lista cadastrada com sucesso!");
            lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
            Lista l = new Lista();
            l.setNome(txtNome.getText());
            aplicacao.retornarUsuario().adicionarLista(l);
            aplicacao.goTo("Principal");       
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}
