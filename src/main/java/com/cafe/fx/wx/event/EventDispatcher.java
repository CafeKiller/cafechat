package com.cafe.fx.wx.event;

import com.cafe.fx.wx.core.FXContext;
import javafx.stage.Stage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EventDispatcher {

    private static final Map<Event, EventCaller<?>> callers = new ConcurrentHashMap<>();

    public static <T> void register(Event event, EventCaller<T> caller){
        callers.put(event, caller);
    }

    public static <T> void register(Event event, Consumer<T> dataConsumer){
        register(event, dataConsumer, FXContext.getPrimaryStage());
    }

    public static <T> void register(Event event, Consumer<T> dataConsumer, Stage stage){
        callers.put(event, (code, data, message) -> {
            if (code != )
        });
    }
}
