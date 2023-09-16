package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.constant.MessageSource;
import com.cafe.fx.wx.core.FXAvatar;
import com.cafe.fx.wx.vo.MessageVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
            avatarImageView.setImage(FXAvatar.apply());
            nicknameLabel.setText("新朋友");
            messageLabel.setText(item.getNickname() + "申请添加你为好友.");
         } else {
             avatarImageView.setImage(FXAvatar.load(item.getAvtar()));
             nicknameLabel.setText(item.getNickname());
             messageLabel.setText(item.getMessage());
         }
         timestampLabel.setText(new SimpleDateFormat("yy/MM/dd").format(item.getTimestamp()));
         messageCountLabel.setText(item.getMessageCount() >99 ? "99+" : String.valueOf(item.getMessageCount()));
         messageCountLabel.setLayoutX(item.getMessageCount() > 0 ? 35 : -35);
         setGraphic(chatRowBox);
    }

}
