package com.cafe.fx.wx;


import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.core.FXIcon;
import com.cafe.fx.wx.view.login.LoginStage;
import com.cafe.fx.wx.view.main.MainController;
import com.cafe.fx.wx.view.register.RegisterController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/* 应用启动类 */
public class AppStarter {

    /*
        [old start]
        timer: 2023年9月16日21:05:29
        processor: Coffee_Killer
    */
    /*public static void start(Stage primaryStage){
        FXContext.setPrimaryStage(primaryStage);

        *//* 测试登录: 临时设置一个主页 并设置临时文字 *//*
       *//* BorderPane root = new BorderPane();
        root.setCenter(new Label("Cafe Chat"));*//*

        Parent root = FX.fxml(MainController.class);
        FX.drag(primaryStage, root);

        // 测试RegisterController
        // Parent root = FX.fxml(RegisterController.class);

        // 设置当前主容器为root
        primaryStage.setScene(new Scene(root));
        // 关闭掉windows默认的窗体外壳效果, 使用自定义最小化和关闭按钮
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        // 清除默认icon, 并重新设置icon
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(FXIcon.logo());
        // 禁止窗口大小变化
        primaryStage.setResizable(false);
        // 设置窗口初始大小
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);
        primaryStage.show();

        LoginStage loginStage = LoginStage.build();
        FXContext.setLoginStage(loginStage);

        // 展示login容器
        // loginStage.show();

    }*/

    public static void start(Stage primaryStage){

        FXContext.setPrimaryStage(primaryStage);

        Parent root = FX.fxml(MainController.class);
        FX.drag(primaryStage, root);
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getScene().getStylesheets().addAll("/css/app.css");
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(FXIcon.logo());


    }

}
