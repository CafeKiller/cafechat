package com.cafe.fx.wx.core;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/* FX核心工具类 */
public class FX {


    /* 加载fxml文件 */
    public static Parent fxml(Class<? extends Initializable> controller){
        String uri = "/views/"+controller.getSimpleName()+".fxml";

        try{
            System.out.println("---------页面正在加载中-----------");
            return FXMLLoader.load(Objects.requireNonNull(controller.getResource(uri)));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void info(String message){
        info(message, FXContext.getPrimaryStage());
    }

    /* 弹窗 提示信息 */
    public static void info(String message, Stage owner){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);

        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setTitle("提示");
        alert.initOwner(owner);
        alert.show();

    }

}
