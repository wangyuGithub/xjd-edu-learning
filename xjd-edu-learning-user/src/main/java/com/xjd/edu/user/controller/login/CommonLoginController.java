package com.xjd.edu.user.controller.login;

import com.xjd.edu.common.Constant;
import com.xjd.edu.common.Result;
import com.xjd.edu.common.config.HostConfig;
import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import com.xjd.edu.user.controller.login.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class CommonLoginController {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private HostConfig hostConfig;

    @RequestMapping("/login")
    public Object login(@RequestBody LoginModel loginModel, HttpServletRequest request) {
        //LoginUtil.setClientInfo(request, loginModel);
        log.info("login model: {}", loginModel);
        //final String host = request.getHeader(Constant.REQUEST_HOST);
        String host = "app.com";
        HostTypeEnum hostTypeEnum = hostConfig.getType(host);
        //用于区分新老版本创建用户
        loginModel.setType(1);
        loginModel.setDeviceCert(request.getHeader(Constant.DEVICE_CERT));
        LoginResult result = authenticationService.login(loginModel, hostTypeEnum);
        return Result.success().data(result);
    }
}
