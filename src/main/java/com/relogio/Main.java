package com.relogio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


//TIP Para <b>executar</b> o código, pressione <shortcut actionId="Run"/> ou
// clique no ícone <icon src="AllIcons.Actions.Execute"/> no gutter.
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlPath = "/Relogio.fxml";
        URL fxmlUrl = getClass().getResource(fxmlPath);
        if (fxmlUrl == null) {
            throw new RuntimeException("FXML não encontrado em " + fxmlPath + " — verifique src/main/resources e a capitalização.");
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Parent root = loader.load();
        primaryStage.setTitle("Relógio Digital");
        primaryStage.setScene(new Scene(root, 300, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
