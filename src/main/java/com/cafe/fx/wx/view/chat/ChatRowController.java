package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.constant.MessageSource;
import com.cafe.fx.wx.vo.MessageVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Objects;

public class ChatRowController extends ListCell<MessageVO> {

    public HBox chatRowBox;
    public ImageView avatarImageView;
    public Label nicknameLabel;
    public Label messageLabel;
    public Label messageCountLabel;
    public Label timestampLabel;
    FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(MessageVO item, boolean empty) {
        super.updateItem(item, empty);

         if (empty || Objects.isNull(item)){
             setGraphic(null);
             return;
         }

         if (Objects.isNull(fxmlLoader)){
             new FXMLLoader(getClass().getResource("/views/"+getClass().getSimpleName()+".fxml"));
             fxmlLoader.setController(this);
             try {
                 fxmlLoader.load();
             }catch (IOException e){
                 throw new RuntimeException(e);
             }
         }

         if (item.getSource() == MessageSource.APPLY){

         }

    }
}
