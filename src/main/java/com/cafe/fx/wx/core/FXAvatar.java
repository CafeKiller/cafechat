package com.cafe.fx.wx.core;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FXAvatar {

    private static final Map<String, Image> cache = new HashMap<>();

    static Image loadLocalAvatar(String filename){
        return  new Image(Objects.requireNonNull(FXIcon.class.getResourceAsStream("/avatar/"+filename)));
    }
    public static Image apply(){
        return cache.computeIfAbsent("apply.png", FXAvatar::loadLocalAvatar);
    }



}
