package com.cafe.fx.wx.view.register;

import com.cafe.fx.wx.vo.RegisterVo;
import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.model.structure.PasswordField;
import com.dlsc.formsfx.view.renderer.FormRenderer;

/* 注册表单构建 */
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

    /* 对外抛出唯一单例 */
    private void build(){
        String nickname = "昵称";
        String username = "账号";
        String password = "密码";
        String placeholderTextFmt = "请输入 %s";
        String requiredTextFmt = "%s 必填";

        /* 初始化表单对象 */
        form = Form.of(
                Group.of(
                        Field.ofStringType(vo.nicknameProperty())
                                .label(nickname)
                                .placeholder(String.format(placeholderTextFmt, nickname))
                                .required(String.format(requiredTextFmt, nickname)),

                        Field.ofStringType(vo.usernameProperty())
                                .label(username)
                                .placeholder(String.format(placeholderTextFmt, username))
                                .required(String.format(requiredTextFmt, username)),

                        PasswordField.ofPasswordType(vo.passwordProperty())
                                .label(password)
                                .placeholder(String.format(placeholderTextFmt, password))
                                .required(String.format(requiredTextFmt, password))
                )
        );
        /* 渲染表单对象 */
        renderer = new FormRenderer(form);
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
