package com.example.letmeknow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("chat.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.setResizable(false);


        //Alert in fase di uscita dall'applicazione
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit Confirmation");
                alert.setHeaderText("Are you sure to exit program?");
                alert.setContentText("If you want to exit you'll be logged out from application.");

                if(alert.showAndWait().get() == ButtonType.OK){
                    //Log Out Account and Exit Program
                    // ...
                    System.out.println("Prompt: On Log Out phase");
                    Platform.exit();
                    System.exit(0);
                }else{
                    System.out.println("Prompt: On Cancel Confirmation Alert. Consume Event");
                    windowEvent.consume();
                }
            }
        });

        stage.show();
    }





    public static void main(String[] args) {
                launch();
    }
}