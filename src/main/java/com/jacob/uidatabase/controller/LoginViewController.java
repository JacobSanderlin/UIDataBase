package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.MainApp;
import com.jacob.uidatabase.util.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/23/2022, Wednesday
 **/
public class LoginViewController {

    @FXML
    private TextField hostnameText;
    @FXML
    private TextField usernameText;
    @FXML
    private Label result;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button connectButton;

    public static String connectionString;

    public static String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String username, String password, String hostname) {
        connectionString = "jdbc:mysql://" + username + ":"
                + password + "@[" +
                hostname + "]";
    }
    public void handleConnect(ActionEvent event) throws SQLException, ClassNotFoundException {
        result.setText("Connecting...");
        setConnectionString(usernameText.getText(), passwordText.getText(), hostnameText.getText());
        DBUtil.dbConnect(connectionString);
        MainApp.connect();
    }

}
