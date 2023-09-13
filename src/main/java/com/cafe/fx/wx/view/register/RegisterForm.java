package com.cafe.fx.wx.view.register;

import com.cafe.fx.wx.vo.RegisterVo;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.view.renderer.FormRenderer;

public class RegisterForm {

    private final RegisterVo vo = new RegisterVo();
    private Form form;
    private FormRenderer renderer;

    private RegisterForm(){

    }

    /* 获取单例 */
    public static RegisterForm getInstance() {
        RegisterForm rf = new RegisterForm();
        rf.build();
        return rf;
    }


    private void build(){
        String nickname = "昵称";
        String username = "账号";
        String password = "密码";
    }

    public RegisterVo getVo() {
        return vo;
    }

    public Form getForm() {
        return form;
    }

    public FormRenderer getRenderer() {
        return renderer;
    }
}
