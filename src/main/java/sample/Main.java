package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.Server;

public class Main extends Application {

    private Server server;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/connect3.fxml"));
        primaryStage.setTitle("Connect3");
        primaryStage.setScene(new Scene(root, 620, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
