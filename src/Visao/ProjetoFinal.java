package Visao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Log.Log;
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
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Rayan
 */
public class ProjetoFinal extends Application {
    
    public Stage stage;
    public static ProjetoFinal instance;
    private Usuario usuarioUtilizador;
    private static Log log = new Log(ProjetoFinal.class);
    /* Objetos temporarios para utilizar como forma de retorno*/
    private Lista listaTemp = null;
    private Item itemTemp = null;
    private Subitem subItemTemp = null;
    /**********************************************************/
    public static ProjetoFinal getInstance() {
        if (instance == null){
            BasicConfigurator.configure();
            return new ProjetoFinal();
        }else
            return instance;
    }
    public void instanciarUsuario(Usuario u){
        this.usuarioUtilizador = u;
    }
    public Usuario retornarUsuario(){
        return usuarioUtilizador;
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
            log.error("trocarCena", "Erro ao trocar para cena:" + fxml, e);
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
            log.error("trocarCena", "Erro ao trocar para cena:" + arquivo, ex);
        }
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        log.info("start", "Carregando recurso de cena" + stage);
        Scene scene = new Scene(root);
        this.stage = stage;
        stage.setScene(scene);
        stage.setTitle("Lista - ToDo - Projeto Final - por Rayan / Robson");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        log.info("start", "Apresentando recurso, e chamando stage : " + stage);
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
        log.info("main", "Carregando main com argumentos: " + args);
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