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

        BorderPane root = new BorderPane();
        root.setCenter(new Label("Cafe Chat"));

        // Parent root = FX.fxml(RegisterController.class);

        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(FXIcon.logo());
        primaryStage.setResizable(false);
        primaryStage.setWidth(640);
        primaryStage.setHeight(480);

        LoginStage loginStage = LoginStage.build();
        FXContext.setLoginStage(loginStage);

        loginStage.show();

    }

}
