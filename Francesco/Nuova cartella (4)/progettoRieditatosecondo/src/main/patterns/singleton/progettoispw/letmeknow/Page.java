package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;

public class Page {
    protected Scene scene;
    protected Stage stage;
    static Stage stage1;
    static Scene scene1;
    static String title1;
    protected Parent root;
    public void back(ActionEvent event){
            System.out.println(title1);
            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene1 = ((Node) event.getSource()).getScene();
            title1 = stage1.getTitle();
    }
    public void switchTo(String name, ActionEvent event, String title) {
        try {
            back(event);
            root = FXMLLoader.load(getClass().getResource(name));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("non sono riuscito a caricare l'interfaccia"+name);
        }
    }
    public void backTo(ActionEvent event){
        stage=stage1;
        scene=scene1;
        stage.setScene(scene);
        stage.show();
        stage.setTitle(title1);
    }
/*
    public void  goTo(String title , ActionEvent event) throws IOException {
        back(event);
        switch (title){
            case ("login"): this.switchTo("login/interf1.fxml",event,"Login");
            case("signup"): this.switchTo("signup/interf1.fxml",event,"Signup");
            case("recover password"): this.switchTo("recoverPassword/interf1.fxml",event,"recover Password");
        }
    }
 */
}