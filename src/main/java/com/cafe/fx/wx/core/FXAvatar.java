package com.cafe.fx.wx.core;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FXAvatar {

    private static final Map<String, Image> cache = new HashMap<>();
    public static int index = 2;

    static Image loadLocalAvatar(String filename){
        return  new Image(Objects.requireNonNull(FXIcon.class.getResourceAsStream("/avatar/"+filename)));
    }

    public static Image load(String url){
        try{
            return new Image(url);
        }catch (Exception e){
            if (index > 6){
                index = 2;
            }
            return cache.computeIfAbsent(String.format("user%d.png",index++), FXAvatar::loadLocalAvatar);
        }

    }
    public static Image apply(){
        return cache.computeIfAbsent("apply.png", FXAvatar::loadLocalAvatar);
    }

    public static Image def(){
        return cache.computeIfAbsent("user_def.png", FXAvatar::loadLocalAvatar);
    }



}
