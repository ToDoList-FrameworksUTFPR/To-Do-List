/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
import Modelo.Lista;
import Persistencia.GravadorXML;
import Visao.ProjetoFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class GerenciarListaController implements Initializable {

    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    private static Log log = new Log(GerenciarListaController.class);
    @FXML
    public TextField txtNome;
    @FXML
    public Label lblInformacao;
    @FXML
    public Label lblTitulo;
    @FXML
    public Button btnAcao;
    @FXML
    public ComboBox comboPrioridade;

    @FXML
    public void cancelarAcao() {
        aplicacao.setListaTemp(null);
        aplicacao.setItemTemp(null);
        aplicacao.setSubItemTemp(null);
        aplicacao.goTo("Principal");
    }

    @FXML
    public void cadastrarAcao() {
        if (txtNome.getText().isEmpty() || comboPrioridade.getSelectionModel().isEmpty()) {
            lblInformacao.setText("Favor preencher corretamente os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            if (aplicacao.retornarUsuario().encontrarLista(txtNome.getText()) == null) {
                lblInformacao.setText("Lista cadastrada com sucesso!");
                lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                Lista l = new Lista();
                log.info("cadastrarAcao", "Gerado uma nova lista a ser cadastrada");
                l.setNome(txtNome.getText());
                l.setPrioridade(Integer.parseInt(comboPrioridade.getSelectionModel().getSelectedItem().toString()));
                aplicacao.retornarUsuario().adicionarLista(l);
                aplicacao.setListaTemp(null);
                GravadorXML gravador = new GravadorXML(aplicacao.retornarUsuario());
                aplicacao.goTo("Principal");
            } else {
                lblInformacao.setText("Já existe uma lista cadastrada com esse nome!");
                lblInformacao.setTextFill(Paint.valueOf("orange"));
            }
        }
    }

    @FXML
    public void alterarAcao() {
        if (txtNome.getText().isEmpty() || comboPrioridade.getSelectionModel().isEmpty()) {
            lblInformacao.setText("Favor preencher corretamente os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            lblInformacao.setText("Lista alterada com sucesso!");
            lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
            Lista l = aplicacao.retornarUsuario().encontrarLista(aplicacao.getListaTemp().getNome());
            l.setNome(txtNome.getText());
            l.setPrioridade(Integer.parseInt(comboPrioridade.getSelectionModel().getSelectedItem().toString()));
            GravadorXML gravadorXML = new GravadorXML(aplicacao.retornarUsuario());
            aplicacao.setListaTemp(null);
            aplicacao.goTo("Principal");
        }
    }

    @FXML
    public void acaoAcao() {
        if (aplicacao.getListaTemp() != null) {
            alterarAcao();
        } else {
            cadastrarAcao();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> itens = null;
        comboPrioridade.setItems(itens);
        itens = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        comboPrioridade.setItems(itens);
        if (aplicacao.getListaTemp() == null) {
            lblTitulo.setText("Cadastrar lista");
            btnAcao.setText("Cadastrar");
        } else {
            lblTitulo.setText("Alterar lista");
            btnAcao.setText("Alterar");
            txtNome.setText(aplicacao.getListaTemp().getNome());
            comboPrioridade.setPromptText(String.valueOf(aplicacao.getListaTemp().getPrioridade()));
        }
    }
}
