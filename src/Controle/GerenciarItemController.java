/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
import Modelo.Item;
import Modelo.Usuario;
import Visao.ProjetoFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Rayan
 */
public class GerenciarItemController implements Initializable {

    private static Log log = new Log(GerenciarItemController.class);
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
    public TextField txtDataCriacao;
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
        comboPrioridade.setPromptText("");
        txtNome.setText("");
        txtLocal.setText("");
        txtDataFinalizar.setText("");
        txtDataCriacao.setText("");
        aplicacao.goTo("Principal");
    }

    @FXML
    public void cadastrarAcao() {
        if (txtNome.getText().isEmpty() || txtLocal.getText().isEmpty() || txtDataCriacao.getText().isEmpty() || txtDataFinalizar.getText().isEmpty() || comboPrioridade.getPromptText().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
                lblInformacao.setText("Item alterado com sucesso!");
                lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                Item itemtemp = new Item();
                itemtemp.setNome(txtNome.getText());
                itemtemp.setPrioridade(Integer.parseInt(comboPrioridade.getPromptText()));
                itemtemp.setLocal(txtLocal.getText());
                itemtemp.setDataCriacao(txtDataCriacao.getText());
                itemtemp.setDataFinalizar(txtDataFinalizar.getText());
                aplicacao.retornarUsuario().encontrarLista(aplicacao.getListaTemp().getNome()).adicionarItem(itemtemp);
                log.info("cadastrarAcao", "Cadastro de item realizado.");
                //trabalha com o xml para gerar os dados     
                aplicacao.goTo("Principal");  
        }
    }
    @FXML
    public void alterarAcao() {
        if (txtNome.getText().isEmpty() || txtLocal.getText().isEmpty() || txtDataCriacao.getText().isEmpty() || txtDataFinalizar.getText().isEmpty() || comboPrioridade.getPromptText().isEmpty()) {
            lblInformacao.setText("Favor preencher todos os campos.");
            lblInformacao.setTextFill(Paint.valueOf("orange"));
        } else {
                lblInformacao.setText("Item alterado com sucesso!");
                lblInformacao.setTextFill(Paint.valueOf("darkgreen"));
                
                Item itemtemp = aplicacao.retornarUsuario().encontrarLista(aplicacao.getListaTemp().getNome()).encontrarItem(aplicacao.getItemTemp().getNome());
                itemtemp.setNome(txtNome.getText());
                itemtemp.setPrioridade(Integer.parseInt(comboPrioridade.getPromptText()));
                itemtemp.setLocal(txtLocal.getText());
                itemtemp.setDataCriacao(txtDataCriacao.getText());
                itemtemp.setDataFinalizar(txtDataFinalizar.getText());                
                log.info("alterarAcao", "Alterado dados do item");
                //trabalha com o xml para gerar os dados     
                aplicacao.goTo("Principal");  
        }
    }
    @FXML
    public void acaoAcao() {
        if(aplicacao.getItemTemp() == null)
            cadastrarAcao();
        else
            alterarAcao();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(aplicacao.getItemTemp() == null){
            lblTitulo.setText("Cadastrar item");
            btnAcao.setText("Cadastrar");
            log.info("initialize", "Iniciado form no modo 'inserção', e carregado dados do usuário. url -> " + url);
        }else{
            lblTitulo.setText("Alterar item");
            btnAcao.setText("Alterar");
            Item i = aplicacao.getItemTemp();
            txtNome.setText(i.getNome());
            txtLocal.setText(i.getLocal());
            txtDataCriacao.setText(i.getDataCriacao());
            txtDataFinalizar.setText(i.getDataFinalizar());
            comboPrioridade.setPromptText(String.valueOf(i.getPrioridade()));
            log.info("initialize", "Iniciado form no modo 'edição', e carregado dados do usuário. url -> " + url);
        }
    }
}
