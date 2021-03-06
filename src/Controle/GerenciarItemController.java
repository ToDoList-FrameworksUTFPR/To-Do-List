/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
import Modelo.Item;
import Modelo.Lista;
import Persistencia.GravadorXML;
import Persistencia.ValidarData;
import Visao.ProjetoFinal;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class GerenciarItemController implements Initializable {

    private static Log log = new Log(GerenciarItemController.class);
    private static ValidarData vd = new ValidarData();
    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtNome;
    @FXML
    public ComboBox comboPrioridade;
    @FXML
    public TextField txtLocal;
    @FXML
    public TextField txtDataFinalizar;
    @FXML
    public Label lblInformacao;
    @FXML
    public Label lblTitulo;
    @FXML
    public Button btnAcao;

    @FXML
    public void cancelarAcao() {
        aplicacao.setItemTemp(null);
        aplicacao.goTo("Principal");
    }

    @FXML
    public void cadastrarAcao() {
        if (txtNome.getText().isEmpty() || txtLocal.getText().isEmpty()
                || txtDataFinalizar.getText().isEmpty() || comboPrioridade.getSelectionModel().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            if (aplicacao.getListaTemp().encontrarItem(txtNome.getText()) == null) {
                if (vd.isValid(txtDataFinalizar.getText())) {
                    lblInformacao.setText("Item alterado com sucesso!");
                    lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                    Item itemtemp = new Item();
                    itemtemp.setNome(txtNome.getText());
                    itemtemp.setPrioridade(Integer.parseInt(comboPrioridade.getSelectionModel().getSelectedItem().toString()));
                    itemtemp.setLocal(txtLocal.getText());
                    Date agora = new Date();
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    itemtemp.setDataCriacao(df.format(agora));
                    itemtemp.setDataFinalizar(txtDataFinalizar.getText());
                    itemtemp.setDataFinalizado(" ");
                    Lista l = aplicacao.retornarUsuario().encontrarLista(aplicacao.getListaTemp().getNome());
                    l.adicionarItem(itemtemp);
                    log.info("cadastrarAcao", "Cadastro de item realizado.");
                    GravadorXML gravador = new GravadorXML(aplicacao.retornarUsuario());
                    aplicacao.setItemTemp(null);
                    aplicacao.setListaTemp(null);
                    aplicacao.goTo("Principal");
                } else {
                    lblInformacao.setText("Favor preencher as datas no formato dd/MM/yyyy.");
                    lblInformacao.setTextFill(Paint.valueOf("orange"));
                }
            }else {
                    lblInformacao.setText("Já existe um item com esse nome.");
                    lblInformacao.setTextFill(Paint.valueOf("orange"));
                }
        }
    }

    @FXML
    public void alterarAcao() {
        if (txtNome.getText().isEmpty() || txtLocal.getText().isEmpty()
                || txtDataFinalizar.getText().isEmpty() || comboPrioridade.getSelectionModel().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
            lblInformacao.setText("Item alterado com sucesso!");
            lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
            Item itemtemp = aplicacao.retornarUsuario().encontrarLista(aplicacao.getListaTemp().getNome()).encontrarItem(aplicacao.getItemTemp().getNome());
            itemtemp.setNome(txtNome.getText());
            itemtemp.setPrioridade(Integer.parseInt(comboPrioridade.getSelectionModel().getSelectedItem().toString()));
            itemtemp.setLocal(txtLocal.getText());
            itemtemp.setDataFinalizar(txtDataFinalizar.getText());
            log.info("alterarAcao", "Alterado dados do item");
            GravadorXML gravador = new GravadorXML(aplicacao.retornarUsuario());
            aplicacao.setItemTemp(null);
            aplicacao.setListaTemp(null);
            aplicacao.goTo("Principal");
        }
    }

    @FXML
    public void acaoAcao() {
        if (aplicacao.getItemTemp() == null) {
            cadastrarAcao();
        } else {
            alterarAcao();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> itens = null;
        comboPrioridade.setItems(itens);
        itens = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        comboPrioridade.setItems(itens);
        if (aplicacao.getItemTemp() == null) {
            lblTitulo.setText("Cadastrar item");
            btnAcao.setText("Cadastrar");
            log.info("initialize", "Iniciado form no modo 'inserção', e carregado dados do usuário. url -> " + url);
        } else {
            lblTitulo.setText("Alterar item");
            btnAcao.setText("Alterar");
            Item i = aplicacao.getItemTemp();
            txtNome.setText(i.getNome());
            txtLocal.setText(i.getLocal());
            txtDataFinalizar.setText(i.getDataFinalizar());
            comboPrioridade.setPromptText(String.valueOf(i.getPrioridade()));
            log.info("initialize", "Iniciado form no modo 'edição', e carregado dados do usuário. url -> " + url);
        }
    }
}
