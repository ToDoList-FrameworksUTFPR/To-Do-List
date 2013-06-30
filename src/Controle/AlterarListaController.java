/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
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
public class AlterarListaController implements Initializable {
    
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    private static Log log = new Log(AlterarListaController.class);

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
    public void editarAcao() {
        if (txtNome.getText().isEmpty()) {
            lblInformacao.setText("Favor preencher corretamente o campo.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {            
            lblInformacao.setText("Lista cadastrada com sucesso!");
            lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
            Lista l = aplicacao.retornarUsuario().encontrarLista(aplicacao.getListaTemp().getNome());
            log.info("editarAcao", "Retornada a lista em variavel");
            l.setNome(txtNome.getText());
            aplicacao.setListaTemp(null);
            //trabalhar xml
            aplicacao.goTo("Principal");       
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNome.setText(aplicacao.getListaTemp().getNome());
    }
}
