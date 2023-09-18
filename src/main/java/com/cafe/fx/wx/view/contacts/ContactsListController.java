package com.cafe.fx.wx.view.contacts;

import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.vo.ContactsVO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ContactsListController implements Initializable {

    public ListView<ContactsVO> contactsListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeUI();
        initializeEvent();
        renderDebugDate();
    }

    void initializeUI(){
        contactsListView.setCellFactory(f -> new ContactsRowController());
    }

    void initializeEvent(){
        contactsListView.getSelectionModel().selectedItemProperty().addListener(
                (obj, ov, nv)->{
                    if (Objects.nonNull(nv)){
                        Pane main = FXComponent.mainComponent();
                        main.getChildren().clear();
                        main.getChildren().add(FXComponent.contactsProfileComponent(nv.getId()));
                    }
                }
        );
    }

    void renderDebugDate(){
        ContactsVO c1 = new ContactsVO();
        c1.setId(233L);
        c1.setNickname("ATX-wuying");
        contactsListView.getItems().add(c1);

        ContactsVO c2 = new ContactsVO();
        c2.setId(322L);
        c2.setNickname("Coffee_Killer");
        contactsListView.getItems().add(c2);
    }

    public void onApplyClick(ActionEvent actionEvent){

    }
}
