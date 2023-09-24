package com.cafe.fx.wx.event;

import com.cafe.fx.wx.constant.IMCode;
import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXContext;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* 事件处理器 */
public class EventDispatcher {

    private static final Map<Event, EventCaller<?>> callers = new ConcurrentHashMap<>();

    public static <T> void register(Event event, EventCaller<T> caller){
        callers.put(event, caller);
    }

    public static <T> void register(Event event, Consumer<T> dataConsumer){
        register(event, dataConsumer, FXContext.getPrimaryStage());
    }

    /* 处理注册事件 */
    public static <T> void register(Event event, Consumer<T> dataConsumer, Stage owner){
        callers.put(event, (code, data, message) -> {
            if (code != IMCode.OK){
                Platform.runLater(() -> FX.error(code + ":" + message, owner));
            } else {
                dataConsumer.accept((T) data);
            }
        });
    }

    public static <T> void dispatch(Event event, T data){
        dispatch(event, IMCode.OK, data, null);
    }

    public static <T> void dispatch(Event event, int code, String message){
        dispatch(event, code , null, message);
    }

    /* 常规事件处理 */
    public static <T> void dispatch(Event event, int code, T data, String message){
        EventCaller<?> caller = callers.get(event);
        Optional.ofNullable(caller).ifPresent(c -> ((EventCaller<T>) c).accept(code, data, message));
    }

}
