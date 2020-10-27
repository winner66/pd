package com.chk.pd.cm.controller;

import com.chk.pd.cm.service.CmService;
import com.chk.pd.cm.vo.ContactRsp;
import com.chk.pd.common.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cm")
public class CmController {

    @Autowired
    private CmService cmService;

    @GetMapping("list-contact")
    public Response<ContactRsp> listContact() {
        ContactRsp rps = cmService.listContact();
        return Response.ok(rps);
    }
}
