/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Log.Log;
import Modelo.Item;
import Modelo.Lista;
import Visao.ProjetoFinal;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 *
 * @author Rayan
 */
public class PrincipalController implements Initializable {

    private ProjetoFinal aplicacao = ProjetoFinal.getInstance();
    private Log log = new Log(PrincipalController.class);
    /* TABS */
    @FXML
    private Tab tabMenuGraficos;
    @FXML
    private Tab tabMenuTarefas;
    /* /TABS */
    /* Tab gráficos */
    @FXML
    private PieChart graficoTarefas;
    @FXML
    private ComboBox comboFormato;
    /* /Tab gráficos */
    /* Tab Tarefas */
    /* Lista */
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
    private ComboBox comboOrdenarLista;
    /* /Lista */
    /* Item */
    @FXML
    private Button adicionarItem;
    @FXML
    private Button removerItem;
    @FXML
    private Button editarItem;
    @FXML
    private ComboBox comboOrdenarItem;
    @FXML
    private ListView listaItens;
    /* /Item */
    /* SubItem */
    /* Informacoes do Item */
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtPrioridade;
    @FXML
    private TextField txtLocal;
    @FXML
    private TextField txtDataCriacao;
    @FXML
    private TextField txtDataFinalizar;
    @FXML
    private TextField txtDataFinalizado;
    /* /Informacoes do Item */
    @FXML
    private TextField txtNomeSubItem;
    @FXML
    private Label lblSubItemInfo;   
    @FXML
    private Button btnRemoverSubItem; 
    /* /SubItem */
    /* /Tab Tarefas */

    /* tabGraficos */
    @FXML
    private void abrirAbaGraficos() {
        if (tabMenuGraficos.isSelected()) {
            int contRealizadasSemAtraso = 0, contRealizadasComAtraso = 0, contNaoRealizadas = 0, totalItens = 0;
            for (Lista l : aplicacao.retornarUsuario().getListas()) {
                totalItens++;
                for (Item i : l.getListaItens()) {
                    DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        if (!i.getDataFinalizado().isEmpty()) {
                            if (d.parse(i.getDataFinalizado()).getTime() > d.parse(i.getDataFinalizar()).getTime()) {
                                contRealizadasComAtraso++;
                            } else if (d.parse(i.getDataFinalizado()).getTime() < d.parse(i.getDataFinalizar()).getTime()) {
                                contRealizadasSemAtraso++;
                            }
                        } else {
                            contNaoRealizadas++;
                        }
                    } catch (ParseException ex) {
                        log.error("abrirAbaGraficos", "Erro ao realizar conversão de datas", ex);
                    }

                }
            }
            ObservableList<PieChart.Data> pieChartData = null;
            graficoTarefas.setTitle("");
            graficoTarefas.setData(pieChartData);
            pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Realizadas sem atraso (" + contRealizadasSemAtraso + ")", contRealizadasSemAtraso),
                    new PieChart.Data("Realizadas com atraso (" + contRealizadasComAtraso + ")", contRealizadasComAtraso),
                    new PieChart.Data("Não realizadas (" + contNaoRealizadas + ")", contNaoRealizadas));
            graficoTarefas.setTitle("Número de tarefas");
            graficoTarefas.setData(pieChartData);
        }
    }
    @FXML
    private void salvarGrafico() {
        BufferedImage img = null;
        try {
            img = new Robot().createScreenCapture(
                    new java.awt.Rectangle(
                    (int) aplicacao.stage.getX() + 65, (int) aplicacao.stage.getY() + 85,
                    (int) aplicacao.stage.getWidth() - 135, (int) aplicacao.stage.getHeight() - 90));
        } catch (AWTException ex) {
            log.error("salvarGrafico", "Erro ao capturar imagem da tela.", ex);
        }
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter exts = new FileChooser.ExtensionFilter("Imagens (png, jpg, bmp)", new String[]{"*.png", "*.jpg", "*.bmp"});
        fileChooser.getExtensionFilters().add(exts);
        String arquivo = fileChooser.showSaveDialog(aplicacao.stage).getAbsolutePath();
        if (!arquivo.isEmpty()) {
            try {
                ImageIO.write(img, comboFormato.getValue().toString(), new File(arquivo + "." + comboFormato.getValue().toString()));
            } catch (IOException ex) {
                log.fatal("salvarGrafico", "Erro fatal ao exportar imagem para arquivi ->" + arquivo, ex);
            }

        }
    }
    /* /tabGraficos */
    /* tabTarefas */
    @FXML
    private void abrirAbaTarefas() {
        if (tabMenuTarefas.isSelected()) {
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
    /* lista */
    @FXML
    private void abrirListas() {
        ObservableList<Lista> itens = null;
        listaListas.setItems(itens);
        itens = FXCollections.observableArrayList();
        itens.addAll(aplicacao.retornarUsuario().getListas());
        listaListas.setItems(itens);

    }
    @FXML
    private void ordenacaoListaAcao() {
        //oredenar listas
        ArrayList<Lista> lista = new ArrayList<>();
        ObservableList<Lista> itens = null;
        listaListas.setItems(itens);
        for (Lista l : aplicacao.retornarUsuario().getListas()) {
            lista.add(l);
        }
        itens = FXCollections.observableArrayList(lista);
        switch (comboOrdenarLista.getPromptText()) {
            case "Nome":
                Collections.sort(lista);
                break;
            case "Prioridade":
                //Collections.sort(lista, new Comparator<>(){});
                break;
            case "Data":
                //Collections.sort(lista, new Comparator<>(){});
                break;
        }
        listaListas.setItems(itens);
    }
    @FXML
    private void cadastrarLista() {
        aplicacao.setListaTemp(null);
        aplicacao.goTo("GerenciarLista");
    }

    @FXML
    private void editarLista() {
        if (listaListas.getSelectionModel().getSelectedItem() != null) {
            aplicacao.setListaTemp((Lista) listaListas.getSelectionModel().getSelectedItem());
            aplicacao.goTo("GerenciarLista");
        }
    }

    @FXML
    private void deletarLista() {
        if (listaListas.getSelectionModel().getSelectedItem() != null) {
            aplicacao.retornarUsuario().removerLista((Lista) listaListas.getSelectionModel().getSelectedItem());
            abrirListas();
        }
    }
    /* /lista */
    /* item */
    @FXML
    private void abrirListaItens() {
        ObservableList<Item> itens = null;
        Callback<Item, ObservableValue<Boolean>> getProperty = new Callback<Item, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Item p) {
                return p.getSelected();
            }
        };
        listaItens.setItems(itens);
        itens = FXCollections.observableArrayList();
        int index = aplicacao.retornarUsuario().getListas().indexOf((Lista) listaItens.getSelectionModel().getSelectedItem());

        itens.addAll(aplicacao.retornarUsuario().getListas().get(index).getListaItens());
        listaItens.setItems(itens);

        Callback<ListView<Item>, ListCell<Item>> forListView = CheckBoxListCell.forListView(getProperty);
        listaItens.setCellFactory(forListView);
    }    
    @FXML
    private void ordenacaoItemAcao() {
        //oredenar itens
    }
    @FXML
    private void cadastrarItem() {
        aplicacao.setItemTemp(null);
        aplicacao.goTo("GerenciarItem");
    }

    @FXML
    private void editarItem() {
        if (listaItens.getSelectionModel().getSelectedItem() != null && listaListas.getSelectionModel().getSelectedItem() != null) {
            aplicacao.setListaTemp((Lista) listaListas.getSelectionModel().getSelectedItem());
            aplicacao.setItemTemp((Item) listaItens.getSelectionModel().getSelectedItem());
            aplicacao.goTo("GerenciarItem");
        }
    }

    @FXML
    private void deletarItem() {
        if (listaItens.getSelectionModel().getSelectedItem() != null) {
            aplicacao.retornarUsuario().removerLista((Lista) listaItens.getSelectionModel().getSelectedItem());
            abrirListas();
        }
    }
    /* /item */
    /* subitem */
    @FXML
    private void adicionarSubItem() {
        if (!txtNomeSubItem.getText().isEmpty() && aplicacao.getListaTemp() != null && aplicacao.getItemTemp() != null) {
            lblSubItemInfo.setText("Subitem adicionado com sucesso.");
            lblSubItemInfo.setTextFill(Paint.valueOf("darkgreen"));            
        }else{
            lblSubItemInfo.setText("Erro ao adicionar subitem.");
            lblSubItemInfo.setTextFill(Paint.valueOf("red")); 
        }
    }
    /* /subitem */
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
        comboOrdenarLista.setItems(itens);
        comboOrdenarItem.setItems(itens);
        itens = FXCollections.observableArrayList(
                "Nome",
                "Data",
                "Prioridade");
        comboOrdenarLista.setItems(itens);
        comboOrdenarItem.setItems(itens);
        comboOrdenarLista.setValue(itens.get(0));
        comboOrdenarItem.setValue(itens.get(0));

        Image imagemAdicionar = new Image(getClass().getResourceAsStream("Imagens/adicionar.png"));
        Image imagemEditar = new Image(getClass().getResourceAsStream("Imagens/editar.png"));
        Image imagemRemover = new Image(getClass().getResourceAsStream("Imagens/remover.png"));

        adicionarNovaLista.setGraphic(new ImageView(imagemAdicionar));
        editarLista.setGraphic(new ImageView(imagemEditar));
        removerLista.setGraphic(new ImageView(imagemRemover));

        adicionarItem.setGraphic(new ImageView(imagemAdicionar));
        editarItem.setGraphic(new ImageView(imagemEditar));
        removerItem.setGraphic(new ImageView(imagemRemover));
        
        btnRemoverSubItem.setGraphic(new ImageView(imagemRemover));

        lblSaudacao.setText("Olá, " + aplicacao.retornarUsuario().getNome());
        lblSaudacao.setTextFill(Paint.valueOf("gray"));
    }
    /* /tabTarefas */
}
