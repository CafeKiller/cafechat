package com.cafe.fx.wx.core;


import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* icon 管理对象 */
public class FXIcon {

    private static final Map<String, Image> cache = new HashMap<>();

    /* 加载icon图 */
    static Image load(String fileName){
        return new Image(Objects.requireNonNull(
                FXIcon.class.getResourceAsStream("/icon/"+fileName)
        ));
    }


    /* 获取Logo的icon图 */
    public static Image logo(){
        return cache.computeIfAbsent("logo.png",FXIcon::load);
    }



}
