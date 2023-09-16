package com.cafe.fx.wx.vo;

import javafx.beans.property.*;

public class MessageVO {

    private final LongProperty id = new SimpleLongProperty();
    private final StringProperty nickname = new SimpleStringProperty();
    private final StringProperty avtar = new SimpleStringProperty();
    private final IntegerProperty source = new SimpleIntegerProperty();
    private final StringProperty message = new SimpleStringProperty();
    private final LongProperty timestamp = new SimpleLongProperty();

    private final IntegerProperty messageCount = new SimpleIntegerProperty();

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getNickname() {
        return nickname.get();
    }

    public StringProperty nicknameProperty() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname.set(nickname);
    }

    public int getSource() {
        return source.get();
    }

    public IntegerProperty sourceProperty() {
        return source;
    }

    public void setSource(int source) {
        this.source.set(source);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public long getTimestamp() {
        return timestamp.get();
    }

    public LongProperty timestampProperty() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp.set(timestamp);
    }

    public int getMessageCount() {
        return messageCount.get();
    }

    public IntegerProperty messageCountProperty() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount.set(messageCount);
    }

    public String getAvtar() {
        return avtar.get();
    }

    public StringProperty avtarProperty() {
        return avtar;
    }

    public void setAvtar(String avtar) {
        this.avtar.set(avtar);
    }

    @Override
    public String toString() {
        return "MessageVO{" +
                "id=" + id +
                ", nickname=" + nickname +
                ", avtar=" + avtar +
                ", source=" + source +
                ", message=" + message +
                ", timestamp=" + timestamp +
                ", messageCount=" + messageCount +
                '}';
    }
}
