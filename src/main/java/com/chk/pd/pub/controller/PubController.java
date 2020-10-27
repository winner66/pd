package com.chk.pd.pub.controller;

import com.chk.pd.common.vo.Response;
import com.chk.pd.pub.service.PubService;
import com.chk.pd.pub.vo.BannerRsp;
import com.chk.pd.pub.vo.PdfRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pub")
public class PubController {

    @Autowired
    private PubService pubService;

    @GetMapping("/list-banner")
    public Response<List<BannerRsp>> listBanner(){
        List<BannerRsp> banner = pubService.listBanner();
        return Response.ok(banner);
    }

    @GetMapping("/get-pdf")
    public Response<PdfRsp> getPdf(){
        PdfRsp pdf = pubService.getPdf();
        return Response.ok(pdf);
    }
}
