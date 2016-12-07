package com.hashlearning.gui.controllers;

import com.hashlearning.utils.DataManager;
import com.hashlearning.utils.SessionManager;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Label username;
@FXML
private Label mail;
    @FXML
    private JFXListView<?> list_view;
    @FXML
    private GridPane dashboardPageContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    username.setText(DataManager.students.get(SessionManager.getCurrentStudent()).getName());
    mail.setText(DataManager.students.get(SessionManager.getCurrentStudent()).getMail());
        DashboardManager dashboardManager = new DashboardManager();

        list_view.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                System.out.println("old: " + oldValue + " || new: " + newValue);
                dashboardManager.open(newValue.intValue(), dashboardPageContainer);
            }
        });

        // call DashboardManager.open(0) to open Dashboard after initialization so that the user doesn't have to look at some empty boring page.
        list_view.getSelectionModel().select(0 ); // 0 is Dashboard
    }




}
