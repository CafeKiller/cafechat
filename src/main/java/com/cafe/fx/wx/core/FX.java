package com.cafe.fx.wx.core;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/* FX核心工具类 */
public class FX {


    /* 加载fxml文件 */
    public static Parent fxml(Class<? extends Initializable> controller){
        String uri = "/views/" + controller.getSimpleName() + ".fxml";

        try{
            System.out.printf(">>>>>>>>>>> %s 页面正在加载中......\n", controller.getSimpleName());
            return FXMLLoader.load(Objects.requireNonNull(controller.getResource(uri)));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void drag(Stage stage, Parent root){
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            private double offsetX= 0;
            private double offsetY= 0;
            @Override
            public void handle(MouseEvent event) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
                    offsetX = event.getSceneX();
                    offsetY = event.getSceneY();
                }else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
                    stage.setX(event.getScreenX() - offsetX);
                    if (event.getScreenY() - offsetY < 0){
                        stage.setY(0);
                    }else {
                        stage.setY(event.getScreenY() - offsetY);
                    }
                }
            }
        };
        root.setOnMousePressed(eventHandler);
        root.setOnMouseDragged(eventHandler);
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
