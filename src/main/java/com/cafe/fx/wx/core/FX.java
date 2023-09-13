package com.cafe.fx.wx.core;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class FX {

    public static void info(String message){
//        info(message);
    }

    public static void info(String message, Stage owner){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);

        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setTitle("提示");
        alert.initOwner(owner);
        alert.show();

    }

}
