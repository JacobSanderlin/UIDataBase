package com.jacob.uidatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage stage;

    private static BorderPane rootLayout;

    public MainApp() {
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        this.stage.setTitle("Animal Shelter Database");

        initRootLayout();
        showLoginView();
    }

    public static void connect() {
        showEmployeeView();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/LoginView.fxml"));
            AnchorPane loginView = (AnchorPane) loader.load();
            rootLayout.setCenter(loginView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showEmployeeView() {
        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("/view/EmployeeView.fxml"));
            TabPane employeeView = (TabPane) loader.load();
            rootLayout.setCenter(employeeView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
