package com.chk.pd.pub.controller;

import com.chk.pd.common.vo.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public Response healthCheck() {
        return Response.ok("Hello, CHK-PD!");
    }
}
