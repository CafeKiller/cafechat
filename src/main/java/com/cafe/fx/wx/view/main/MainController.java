package com.cafe.fx.wx.view.main;

import javafx.fxml.Initializable;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public ImageView avatarImageView;
    public ToggleButton chatButton;
    public ToggleButton contactsButton;
    public VBox listVBox;
    public Pane mainPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeUI();
        initializeEvent();
    }

    void initializeUI(){

    }

    void initializeEvent(){

    }

    public void onChatClick(){
        listVBox.getChildren().clear();

    }
    public void onContactsClick(){

    }
    public void onMinimizeClick(){

    }
    public void onExitClick(){

    }
}
