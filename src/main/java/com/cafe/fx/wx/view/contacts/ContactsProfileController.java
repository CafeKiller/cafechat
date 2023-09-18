package com.cafe.fx.wx.view.contacts;

import com.cafe.fx.wx.core.FXAvatar;
import com.cafe.fx.wx.view.UserDataController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ContactsProfileController implements UserDataController {

    public ImageView avatarImageView;
    public Label nicknameLabel;

    private Long contactsId;


    @Override
    public void initialize(Object data) {

        contactsId = (Long)data;
        initializeUI();
        initializeEvent();
        renderDebugDate();

    }
    void initializeUI(){}
    void initializeEvent(){}
    void renderDebugDate(){
        nicknameLabel.setText("WxID: " + contactsId);
        avatarImageView.setImage(FXAvatar.def());
    }

    public void onSendMessageClick(ActionEvent actionEvent){ }
}
