package Visao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
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
    
    public static ProjetoFinal getInstance() {
        if (instance == null)
            return new ProjetoFinal();
        else
            return instance;
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
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
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
}