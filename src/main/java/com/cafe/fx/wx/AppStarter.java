package com.cafe.fx.wx;


import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.view.register.RegisterController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter {

    public static void start(Stage primaryStage){
        FXContext.setPrimaryStage(primaryStage);

        Parent root = FX.fxml(RegisterController.class);
        primaryStage.setScene(new Scene(root));
//        primaryStage.getIcons().clear();



    }

}
