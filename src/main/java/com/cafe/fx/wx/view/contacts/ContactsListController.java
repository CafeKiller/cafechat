package com.cafe.fx.wx.view.contacts;

import com.cafe.fx.wx.vo.ContactsVO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactsListController implements Initializable {

    public ListView<ContactsVO> contactsVOListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeUI();
        initializeEvent();
        renderDebugDate();
    }

    void initializeUI(){
        contactsVOListView.setCellFactory(f -> new ContactsRowController());
    }

    void initializeEvent(){

    }

    void renderDebugDate(){
        ContactsVO c1 = new ContactsVO();
        c1.setId(233L);
        c1.setNickname("ATX-wuying");
        contactsVOListView.getItems().add(c1);

        ContactsVO c2 = new ContactsVO();
        c2.setId(322L);
        c2.setNickname("Coffee_Killer");
        contactsVOListView.getItems().add(c2);
    }

    public void onApplyClick(ActionEvent actionEvent){

    }
}
