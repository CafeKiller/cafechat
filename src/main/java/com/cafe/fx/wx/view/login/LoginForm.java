package com.cafe.fx.wx.view.login;

import com.cafe.fx.wx.vo.LoginVO;
import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.model.structure.PasswordField;
import com.dlsc.formsfx.view.renderer.FormRenderer;

public class LoginForm {

    private final LoginVO vo = new LoginVO();
    private Form form;
    private FormRenderer renderer;

    private LoginForm(){}

    public static LoginForm getInstance() {
        LoginForm lf = new LoginForm();
        lf.build();
        return lf;
    }

    private void build(){

        String username = "账号";
        String password = "密码";
        /* placeholder提示信息 */
        String placeholderTextFmt = "请输入 %s";
        String requiredTextFmt = "%s 必填";

        /* 初始化登录表单对象 */
        form = Form.of(
                Group.of(
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

    public LoginVO getVo() {
        return vo;
    }

    public Form getForm() {
        return form;
    }

    public FormRenderer getRenderer() {
        return renderer;
    }
}
