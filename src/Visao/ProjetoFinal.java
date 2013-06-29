package Visao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelo.Item;
import Modelo.Lista;
import Modelo.Subitem;
import Modelo.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rayan
 */
public class ProjetoFinal extends Application {
    
    public Stage stage;
    public static ProjetoFinal instance;
    private Usuario usuarioUtilizador;
    /* Objetos temporarios para utilizar como forma de retorno*/
    private Lista listaTemp = null;
    private Item itemTemp = null;
    private Subitem subItemTemp = null;
    /**********************************************************/
    public static ProjetoFinal getInstance() {
        if (instance == null)
            return new ProjetoFinal();
        else
            return instance;
    }
    public void instanciarUsuario(Usuario u){
        this.usuarioUtilizador = u;
    }
    public Usuario retornarUsuario(){
        return this.usuarioUtilizador;
    }
    private Parent trocarCena(String fxml) {
        try{
            Parent page = (Parent) FXMLLoader.load(ProjetoFinal.class.getResource(fxml), null, new JavaFXBuilderFactory());
            Scene scene = stage.getScene();
            if (scene == null) {
                scene = new Scene(page);
                stage.setScene(scene);
            } else {
                stage.getScene().setRoot(page);          
            }
            stage.sizeToScene();
            stage.centerOnScreen();
            return page;
        }catch(Exception e){
            //adicionar LOG
            return null;
        }
    }
    @SuppressWarnings("LeakingThisInConstructor")
    public ProjetoFinal() {
        instance = this;
    }

    public void goTo(String arquivo) {
        try {
            trocarCena(arquivo + ".fxml");
        } catch (Exception ex) {
            //adicionar LOG
        }
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml")); //iniciando em Principal para testar
        
        Scene scene = new Scene(root);
        this.stage = stage;
        stage.setScene(scene);
        stage.setTitle("Lista - ToDo - Projeto Final - por Rayan / Robson");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the listaTemp
     */
    public Lista getListaTemp() {
        return listaTemp;
    }

    /**
     * @param listaTemp the listaTemp to set
     */
    public void setListaTemp(Lista listaTemp) {
        this.listaTemp = listaTemp;
    }

    /**
     * @return the itemTemp
     */
    public Item getItemTemp() {
        return itemTemp;
    }

    /**
     * @param itemTemp the itemTemp to set
     */
    public void setItemTemp(Item itemTemp) {
        this.itemTemp = itemTemp;
    }

    /**
     * @return the subItemTemp
     */
    public Subitem getSubItemTemp() {
        return subItemTemp;
    }

    /**
     * @param subItemTemp the subItemTemp to set
     */
    public void setSubItemTemp(Subitem subItemTemp) {
        this.subItemTemp = subItemTemp;
    }
}