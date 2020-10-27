package com.chk.pd.pub.controller;

import com.chk.pd.common.vo.Response;
import com.chk.pd.pub.domain.UserAccount;
import com.chk.pd.pub.service.UserService;
import com.chk.pd.pub.vo.UserRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/login")
    public Response<UserRsp> login(String wxcode){
        UserAccount user = userService.login(wxcode);
        UserRsp rsp = new UserRsp();
        rsp.setToken(user.getToken());
        return Response.ok(rsp);
    }
}
