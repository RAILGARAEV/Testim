package com.example.requestdesktop.models;

import javafx.stage.Stage;

public class StageModel {
    public static Stage myStage = new Stage();

    public static Stage getMyStage() {
        return myStage;
    }

    public static void setMyStage(Stage myStage) {
        StageModel.myStage = myStage;
    }
}
