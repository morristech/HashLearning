package com.hashlearning.gui.custom_views;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Omar on 09-Dec-16
 */
public class MaterialDialog {

    private static Alert alert;

    public static void showDialog(Alert.AlertType type, String title, String header, String content) {

        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(MaterialDialog.class.getResource("/css/material_dialog_stylesheet.css").toExternalForm());
        dialogPane.getStyleClass().add("material-dialog");

        Stage dialogStage = (Stage) dialogPane.getScene().getWindow();
        dialogStage.getIcons().add(new Image(MaterialDialog.class.getResource("/HL_hash_logo.png").toString()));

        alert.showAndWait();

    }

}
