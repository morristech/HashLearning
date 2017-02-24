package com.hashlearning.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StageNavigator {

    /**
     * This method creates a new stage containing a scene which contains a scene graph from a provided fxml file.
     *
     * @param currentWindow: the current window which needs to be closed.
     * @param fxml: the fxml file name for the new stage.
     * @return new stage.
     * @throws IOException
     */
    public static Stage switchStage(Stage currentWindow, String fxml, boolean resizable) throws IOException {
        Parent root = FXMLLoader.load(StageNavigator.class.getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        StageInitializer.initializeStage(stage, resizable);
        stage.setScene(scene);
        currentWindow.close();
        return stage;
    }


    public static Stage switchStage(Stage currentWindow, String fxml, boolean resizable, String cssFileName) throws IOException {
        Parent root = FXMLLoader.load(StageNavigator.class.getResource(fxml));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/" + cssFileName);
        Stage stage = new Stage();
        StageInitializer.initializeStage(stage, resizable);
        stage.setScene(scene);
        currentWindow.close();
        return stage;
    }

    public static Stage switchStage(Parent root, boolean resizable) throws IOException {
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        StageInitializer.initializeStage(stage, resizable);
        stage.setScene(scene);
        return stage;
    }



}
