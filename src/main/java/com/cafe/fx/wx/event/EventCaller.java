package com.cafe.fx.wx.event;

public interface EventCaller<T> {

    void accept(int code, T data, String message);

}
