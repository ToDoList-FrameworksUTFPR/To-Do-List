/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.ProjetoFinal;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.CheckBoxListCellBuilder;
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
    
    @FXML
    private Tab tabMenuGraficos;
    @FXML
    private Tab tabMenuTarefas;
    
    /* Tab gráficos */
    @FXML
    private PieChart graficoTarefas;    
    @FXML
    private ComboBox comboFormato;    
    @FXML
    private Button btnExportar;
    /* /Tab gráficos */
    
    /* Tab Tarefas */
    @FXML
    private TitledPane ttListas;
    @FXML
    private TitledPane ttCadListas;
    @FXML
    private ListView listaListas;
    @FXML
    private Button btnDeletar;
    @FXML
    private ComboBox comboFiltro;
    @FXML
    private Button btnAdicionarLista;
    @FXML
    private TextField txtNomeLista;
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
    @FXML
    private Label lblInformativoCadItem;
    @FXML
    private Button cadItembtnAdicionarItem;
    /* /Tab Tarefas */
    
    @FXML
    private void abrirAbaGraficos() {
        if(tabMenuGraficos.isSelected()){
            try {
                ObservableList<PieChart.Data> pieChartData = null;
                graficoTarefas.setTitle("");
                graficoTarefas.setData(pieChartData);
                pieChartData = FXCollections.observableArrayList(
                        new PieChart.Data("Realizadas sem atraso", 75),
                        new PieChart.Data("Realizadas com atraso", 33.5),
                        new PieChart.Data("Não realizadas", 22)
                );
            graficoTarefas.setTitle("Número de tarefas");
            graficoTarefas.setData(pieChartData); 
            } catch (Exception e) {
                //colocar o log
            }
        }
    }
    @FXML
    private void abrirAbaTarefas() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> itens = null;        
        comboFormato.setItems(itens);
        itens = FXCollections.observableArrayList(
            "png",
            "jpg",
            "bmp"
        );
        comboFormato.setItems(itens);
        comboFormato.setValue(itens.get(0));
        abrirListas();
        itens = null;        
        comboFiltro.setItems(itens);
        itens = FXCollections.observableArrayList(
            "Nome",
            "Data",
            "Prioridade"
        );
        comboFiltro.setItems(itens);
        comboFiltro.setValue(itens.get(0));
    }    
    @FXML
    private void salvarGrafico() throws AWTException, IOException{
        BufferedImage img = new Robot().createScreenCapture(
        new java.awt.Rectangle(
          (int)aplicacao.stage.getX()+65,       (int)aplicacao.stage.getY()+85,
          (int)aplicacao.stage.getWidth()-135, (int)aplicacao.stage.getHeight()-90)
        );
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter exts = new FileChooser.ExtensionFilter("Imagens (png, jpg, bmp)", new String[]{"*.png", "*.jpg", "*.bmp"});
            fileChooser.getExtensionFilters().add(exts);
            try {
                String arquivo = fileChooser.showSaveDialog(aplicacao.stage).getAbsolutePath();
                if(!arquivo.isEmpty()){
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
    private void abrirListas(){
        ObservableList<String> itens = null;
        listaListas.setItems(itens);
        itens = FXCollections.observableArrayList ("123", "123", "12312312");
        listaListas.setItems(itens);
        //listaListas.setCellFactory(CheckBoxListCell.forListView((Callback<String, ObservableValue<Boolean>>) itens));
        //listaListas.setItems(itens);
        System.out.println("abriu listas");   
    }
    @FXML
    private void abrirCadastroListas(){
        //atualizar a lista 
    }
    @FXML
    private void deletarLista(){
        if(listaListas.getSelectionModel().getSelectedItem() != null){
            System.out.println("Deletar -> " +  listaListas.getSelectionModel().getSelectedItem().toString());
            listaListas.getItems().remove(listaListas.getSelectionModel().getSelectedItem());
        }
    }
    @FXML
    private void cadastrarLista(){
        if(!txtNomeLista.getText().isEmpty()){
            listaListas.getItems().add(txtNomeLista.getText());
            lblInformCad.setText("Lista adicionada com sucesso!");
            lblInformCad.setTextFill(Paint.valueOf("darkgreen"));
            txtNomeLista.setText("");
        }else{
            lblInformCad.setText("Erro ao adicionar lista.");
            lblInformCad.setTextFill(Paint.valueOf("red"));
        }
    }
    @FXML
    private void cadItemAcao(){
        if(cadItemNome.getText().isEmpty() || cadItemLocal.getText().isEmpty() || cadItemPrioridade.getPromptText().isEmpty()
           || cadItemDescricao.getText().isEmpty() || cadItemDataCriacao.getText().isEmpty()|| cadItemDataEncerramento.getText().isEmpty()){
            lblInformCad.setText("Item adicionado com sucesso!");
            lblInformCad.setTextFill(Paint.valueOf("darkgreen"));
            cadItemNome.setText("");
            cadItemLocal.setText("");
            cadItemPrioridade.setValue(null);
            cadItemDataCriacao.setText("");
            cadItemDataEncerramento.setText("");
            cadItemDescricao.setText("");
            listaItens.getItems().add(cadItemNome.getText());
        }else{
            lblInformCad.setText("Erro ao adicionar item.");
            lblInformCad.setTextFill(Paint.valueOf("red"));
        }
    }
}
