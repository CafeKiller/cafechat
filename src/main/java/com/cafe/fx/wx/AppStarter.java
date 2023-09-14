package com.cafe.fx.wx;


import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.core.FXIcon;
import com.cafe.fx.wx.view.login.LoginStage;
import com.cafe.fx.wx.view.register.RegisterController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/* 应用启动类 */
public class AppStarter {

    public static void start(Stage primaryStage){
        FXContext.setPrimaryStage(primaryStage);

        /* 临时获取一个窗格布局 并设置临时文字 */
        BorderPane root = new BorderPane();
        root.setCenter(new Label("Cafe Chat"));

        // Parent root = FX.fxml(RegisterController.class);

        // 设置当前主容器为root
        primaryStage.setScene(new Scene(root));
        // 清除默认icon, 并重新设置icon
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(FXIcon.logo());
        // 禁止窗口大小变化
        primaryStage.setResizable(false);
        // 设置窗口初始大小
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);

        LoginStage loginStage = LoginStage.build();
        FXContext.setLoginStage(loginStage);

        // 展示login容器
        loginStage.show();

    }

}
