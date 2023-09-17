package com.cafe.fx.wx.view.contacts;

import com.cafe.fx.wx.core.FXAvatar;
import com.cafe.fx.wx.vo.ContactsVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ContactsRowController extends ListCell<ContactsVO> {

    public HBox contactsRowHBox;
    public ImageView avatarImageView;
    public Label nicknameLabel;

    private FXMLLoader loader;

    @Override
    protected void updateItem(ContactsVO item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);

        if (empty || item == null){
            setGraphic(null);
            return;
        }

        if (loader == null){
            loader = new FXMLLoader(getClass().getResource("/views/"+getClass().getSimpleName()+".fxml"));
            loader.setController(this);
            try {
                loader.load();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        avatarImageView.setImage(FXAvatar.load(item.getAvatar()));
        nicknameLabel.setText(item.getNickname());

        setGraphic(contactsRowHBox);
    }
}
