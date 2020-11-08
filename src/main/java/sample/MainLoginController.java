package sample;

import client.Client;
import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainLoginController  {


    private static Scanner scanner;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private void loginButtonClick(Event event) throws SQLException {
        if (isAllFieldFillup()) {
            String userName = userField.getText().trim();
            String password = passwordField.getText();

            if (isValidCredentials(userName, password)) {
                Client client = new Client(userName);
                client.startClient();
                try {

                    Parent chatParent = FXMLLoader.load(getClass().getResource("/connect3chat.fxml"));
                    Scene chatScene = new Scene(chatParent);
                    Stage chatStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    chatStage.setScene(chatScene);
                    chatStage.setTitle("Willkommen in Connect3 " + userName);
                    chatStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private boolean isValidCredentials(String userName, String password)  {
       boolean found = false;
       String tempUsername ="";
       String tempPassword ="";

       try{
           scanner = new Scanner(new File("src/main/resources/profile.txt"));
           scanner.useDelimiter("[,\n]");

           while(scanner.hasNext() && !found){
               tempUsername=scanner.next();
               tempPassword=scanner.next();

               if(tempUsername.equals(userName.trim()) && tempPassword.trim().equals(password.trim())){
                   found=true;
                   return found;
               }
               Notification notification = Notifications.ERROR;
               TrayNotification tray = new TrayNotification();
               tray.setTitle("Attention!!!");
               tray.setMessage("Invalid Credentials");
               tray.setNotification(notification);
               tray.showAndDismiss(Duration.millis(3000));
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
        return found;
    }

    private boolean isAllFieldFillup(){
        boolean fillup;
        if(userField.getText().trim().isEmpty()||passwordField.getText().isEmpty()){

            Notification notification = Notifications.ERROR;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Attention!!!");
            tray.setMessage("Email or Password should not be Empty.");
            tray.setNotification(notification);
            tray.showAndDismiss(Duration.millis(3000));

            fillup = false;
        }
        else fillup = true;
        return fillup;
    }


}
