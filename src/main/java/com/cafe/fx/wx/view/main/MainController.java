package com.cafe.fx.wx.view.main;

import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.core.FXContext;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.Optional;
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
        ToggleGroup leftMenuToggleGroup = new ToggleGroup();
        chatButton.setToggleGroup(leftMenuToggleGroup);
        contactsButton.setToggleGroup(leftMenuToggleGroup);
        onChatClick(null);
    }

    void initializeEvent(){

    }

    public void onChatClick(ActionEvent actionEvent){
        listVBox.getChildren().clear();
        listVBox.getChildren().add(FXComponent.chatListController());
    }
    public void onContactsClick(ActionEvent actionEvent){
        listVBox.getChildren().clear();
        listVBox.getChildren().add(FXComponent.contactsListController());
    }
    public void onMinimizeClick(ActionEvent actionEvent){
        FXContext.getPrimaryStage().setIconified(true);
    }
    public void onExitClick(ActionEvent actionEvent){
        Optional.ofNullable(FXContext.getPrimaryStage().getOnCloseRequest())
                .ifPresent(e-> e.handle(new WindowEvent(FXContext.getPrimaryStage(), WindowEvent.WINDOW_CLOSE_REQUEST )));
        FXContext.getPrimaryStage().close();
    }
}
