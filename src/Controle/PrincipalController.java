/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Lista;
import Visao.ProjetoFinal;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author Rayan
 */
public class PrincipalController implements Initializable {

    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    @FXML
    private Tab tabMenuGraficos;
    @FXML
    private Tab tabMenuTarefas;
    /* Tab gráficos */
    @FXML
    private PieChart graficoTarefas;
    @FXML
    private ComboBox comboFormato;
    /* /Tab gráficos */
    /* Tab Tarefas */
    @FXML
    private Label lblSaudacao;
    @FXML
    private Label lblAlterarDados;
    @FXML
    private Button adicionarNovaLista;
    @FXML
    private Button removerLista;
    @FXML
    private Button editarLista;
    @FXML
    private ListView listaListas;
    @FXML
    private ComboBox comboFiltro;
    @FXML
    private Label lblInformCad;
    @FXML
    private ListView listaItens;
    @FXML
    private TextField cadItemNome;
    @FXML
    private TextField cadItemLocal;
    @FXML
    private TextField cadItemDataCriacao;
    @FXML
    private TextField cadItemDataEncerramento;
    @FXML
    private TextArea cadItemDescricao;
    @FXML
    private ComboBox cadItemPrioridade;
    /* /Tab Tarefas */

    @FXML
    private void abrirAbaGraficos() {
        if (tabMenuGraficos.isSelected()) {
            try {
                ObservableList<PieChart.Data> pieChartData = null;
                graficoTarefas.setTitle("");
                graficoTarefas.setData(pieChartData);
                pieChartData = FXCollections.observableArrayList(
                        new PieChart.Data("Realizadas sem atraso", 75),
                        new PieChart.Data("Realizadas com atraso", 33.5),
                        new PieChart.Data("Não realizadas", 22));
                graficoTarefas.setTitle("Número de tarefas");
                graficoTarefas.setData(pieChartData);
            } catch (Exception e) {
                //colocar o log
            }
        }
    }

    @FXML
    private void abrirAbaTarefas() {
        if (tabMenuTarefas.isSelected()) {
            abrirListas();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> itens = null;
        comboFormato.setItems(itens);
        itens = FXCollections.observableArrayList(
                "png",
                "jpg",
                "bmp");
        comboFormato.setItems(itens);
        comboFormato.setValue(itens.get(0));
        abrirListas();
        itens = null;
        comboFiltro.setItems(itens);
        itens = FXCollections.observableArrayList(
                "Nome",
                "Data",
                "Prioridade");
        comboFiltro.setItems(itens);
        comboFiltro.setValue(itens.get(0));

        Image imagemAdicionar = new Image(getClass().getResourceAsStream("Imagens/adicionar.png"));
        Image imagemEditar = new Image(getClass().getResourceAsStream("Imagens/editar.png"));
        Image imagemRemover = new Image(getClass().getResourceAsStream("Imagens/remover.png"));

        adicionarNovaLista.setGraphic(new ImageView(imagemAdicionar));
        editarLista.setGraphic(new ImageView(imagemEditar));
        removerLista.setGraphic(new ImageView(imagemRemover));

        lblSaudacao.setText("Olá, " + aplicacao.retornarUsuario().getNome());
        lblSaudacao.setTextFill(Paint.valueOf("gray"));
    }

    @FXML
    private void salvarGrafico() throws AWTException, IOException {
        BufferedImage img = new Robot().createScreenCapture(
                new java.awt.Rectangle(
                (int) aplicacao.stage.getX() + 65, (int) aplicacao.stage.getY() + 85,
                (int) aplicacao.stage.getWidth() - 135, (int) aplicacao.stage.getHeight() - 90));
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter exts = new FileChooser.ExtensionFilter("Imagens (png, jpg, bmp)", new String[]{"*.png", "*.jpg", "*.bmp"});
        fileChooser.getExtensionFilters().add(exts);
        try {
            String arquivo = fileChooser.showSaveDialog(aplicacao.stage).getAbsolutePath();
            if (!arquivo.isEmpty()) {
                try {
                    ImageIO.write(img, comboFormato.getValue().toString(), new File(arquivo + "." + comboFormato.getValue().toString()));
                } catch (Exception e) {
                    //colocar o LOG
                }
            }
        } catch (Exception e) {
            //colocar o log
        }
    }

    @FXML
    private void abrirListas() {
        ArrayList<Lista> lista = new ArrayList<>();
        ObservableList<Lista> itens = null;
        listaListas.setItems(itens);
        for (Lista l : aplicacao.retornarUsuario().getListas()) {
            lista.add(l);
        }
        itens = FXCollections.observableArrayList(lista);
        listaListas.setItems(itens);
    }

    @FXML
    private void cadastrarLista() {
        aplicacao.goTo("CadastrarLista");
    }

    @FXML
    private void editarLista() {
        if (listaListas.getSelectionModel().getSelectedItem() != null) {
            aplicacao.setListaTemp((Lista) listaListas.getSelectionModel().getSelectedItem());
            aplicacao.goTo("AlterarLista");
        }
    }

    @FXML
    private void deletarLista() {
        if (listaListas.getSelectionModel().getSelectedItem() != null) {
            aplicacao.retornarUsuario().removerLista((Lista) listaListas.getSelectionModel().getSelectedItem());
            abrirListas();
        }
    }

    @FXML
    public void alterarDados() {
        aplicacao.goTo("AlterarDados");
    }

    @FXML
    public void alterarDados_mouseEmCima() {
        lblAlterarDados.setTextFill(Paint.valueOf("darkgray"));
    }

    @FXML
    public void alterarDados_mouseFora() {
        lblAlterarDados.setTextFill(Paint.valueOf("gray"));
    }

    @FXML
    private void cadItemAcao() {
        if (cadItemNome.getText().isEmpty() || cadItemLocal.getText().isEmpty() || cadItemPrioridade.getPromptText().isEmpty()
                || cadItemDescricao.getText().isEmpty() || cadItemDataCriacao.getText().isEmpty() || cadItemDataEncerramento.getText().isEmpty()) {
            lblInformCad.setText("Item adicionado com sucesso!");
            lblInformCad.setTextFill(Paint.valueOf("darkgreen"));
            cadItemNome.setText("");
            cadItemLocal.setText("");
            cadItemPrioridade.setValue(null);
            cadItemDataCriacao.setText("");
            cadItemDataEncerramento.setText("");
            cadItemDescricao.setText("");
            listaItens.getItems().add(cadItemNome.getText());
        } else {
            lblInformCad.setText("Erro ao adicionar item.");
            lblInformCad.setTextFill(Paint.valueOf("red"));
        }
    }
}
