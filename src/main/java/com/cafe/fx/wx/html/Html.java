package com.cafe.fx.wx.html;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Html {


    public static String of(String nickname, long timestamp, String content, boolean isContacts){
        String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(timestamp));

        return "<div class='message-item'>"
                + "<div class='" + (isContacts ? "user" : "contacts") + "'>"
                + "<span class='nickname'>" + nickname + "</span>"
                + "<span>" + time + "</span>"
                + "</div>"
                + "<div class='content'>" + escape(content) + "</div>"
                + "</div>";
    }

    private static String escape(String content){
        return content.replace("&", "&amp;")
                .replace("\t", "&nbsp;&nbsp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace(" ", "&nbsp;")
                .replace("'", "&#39;")
                .replace("\"", "&quot;")
                .replace("\r\n", "\n")
                .replace("\n", "<br>");
    }

}
