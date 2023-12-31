package com.example.requestdesktop;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.requestdesktop.db.DbFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class UpdateRequestController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnUpdateRequest;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField endDateTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField startDateTextField;

    @FXML
    private ChoiceBox<String> statusChoiceBox;

    private final DbFunctions dbFunctions = new DbFunctions();

    private String idRequest = "";

    @FXML
    void initialize() {
        installChoiceBox();
        btnUpdateRequest.setOnAction(e -> {
            updateRequest();
        });
    }

    private void updateRequest() {
        String name = nameTextField.getText();
        String description = descriptionTextField.getText();
        String start_date = startDateTextField.getText();
        String end_date = endDateTextField.getText();
        String status = statusChoiceBox.getValue();
        int codeError = dbFunctions.checkNameRequest(name);

        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Поле ввода Наименование пустое!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else if (description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Поле ввода Описание пустое!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else if (start_date.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Поле ввода Дата начала пустое!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else if (end_date.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Поле ввода Дата окончания пустое!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else if (status.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Выпадающий список Статус пустой!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else if (codeError == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Такая заявка уже существует!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else if (codeError == 404) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("Какая-та ошибка!");

            ButtonType buttonTypeOk = new ButtonType("Ок");

            alert.getButtonTypes().setAll(buttonTypeOk);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOk) {
                    alert.close();
                }
            });
        } else {
            dbFunctions.updateRequest(idRequest, name, description, start_date, end_date, status);
            anchorPane.getScene().getWindow().hide();
        }
    }

    private void installChoiceBox() {
        ObservableList<String> listStatuses = FXCollections.observableArrayList("В рассмотрении", "Выполнена", "Отклонена");
        statusChoiceBox.setItems(listStatuses);
        statusChoiceBox.setValue("В рассмотрении");
    }

    public void setDataRequest(String id, String name, String description, String start_date, String end_date, String status) {
        idRequest = id;
        nameTextField.setText(name);
        descriptionTextField.setText(description);
        startDateTextField.setText(start_date);
        endDateTextField.setText(end_date);
        statusChoiceBox.setValue(status);
    }

}
