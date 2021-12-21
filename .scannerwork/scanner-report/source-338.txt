package com.example.letmeknow;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Page {
    protected Scene scene;
    protected Stage stage;
    protected Parent root;
    public void switchTo(String name, ActionEvent event, String title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(name));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //System.out.println(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        System.out.println(stage);
        stage.show();
    }

    public void switchTo1(String name, ActionEvent event, String title,Stage stage1) throws IOException {
        root = FXMLLoader.load(getClass().getResource(name));
        System.out.println(root);
        stage = stage1;
        scene = new Scene(root);
        System.out.println("sssss");
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
    public void  goTo(String title , ActionEvent event) throws IOException {
        switch (title){
            case ("login"): this.switchTo("login.fxml",event,"Login");
            case("signup"): this.switchTo("signup.fxml",event,"Signup");
            case("recover password"): this.switchTo("recoverPassword.fxml",event,"recover Password");
        }
    }
}