package progettoispw.letmeknow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import progettoispw.letmeknow.bean.VisitBean;
import progettoispw.letmeknow.controller.ControllerClass;
import progettoispw.letmeknow.controller.VisitController;
import progettoispw.letmeknow.controller.resultSearchController;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utenti.Goal;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("login/interf1.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.setResizable(false);
        Image icon= new Image(getClass().getResourceAsStream("photo/brain.jpg"));
        stage.getIcons().add(icon);
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //SalvaUtente utente=new SalvaUtente("psicologo");
        /*Search ricerca;
        ControllerClass factory=new ControllerClass();
        //factory.controllerUser("123456");
        factory.controllerUsers();
        ricerca=factory.getSearch();
        ricerca.setAffinity(0);
        Integer [] arr={1,1,1};
        ricerca.parametricSetSearch(arr);*/
        launch();
        //ricerca.parametricSetSearch(arr);
        //ricerca.parametricSearch();
        //ricerca.goalSearch("#fair");
        //ricerca.goalSearch("#courage");
       // utente.setPersonalDes("mi piace il cocomero ");
        /*resultSearchController controller=new resultSearchController(4);
        controller.who("0123456");
        VisitBean visitctrl=new VisitBean();
        System.out.println(visitctrl.getUserId());*/









    }
}