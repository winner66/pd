package com.chk.pd.fpd.controller;


import com.chk.pd.fpd.service.FpdService;
import com.chk.pd.fpd.vo.FpdModelRsp;
import com.chk.pd.fpd.vo.FpdReq;
import com.chk.pd.fpd.vo.FpdRsp;
import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fpd")
public class FpdController {

    private Logger log = LoggerFactory.getLogger(FpdController.class);

    @Autowired
    private FpdService fpdService;

    @GetMapping("get-pd-infos")
    public Response<FpdRsp> getPdInfos(FpdReq fpdReq, PageReq pageReq) {
        log.info(fpdReq.toString() + "---" + pageReq.toString());
        FpdRsp pdInfos = fpdService.getPdInfos(fpdReq, pageReq);
        return Response.ok(pdInfos);
    }

    @GetMapping("get-fpd-models")
    public Response<List<FpdModelRsp>> getFpdModels(){
        List<FpdModelRsp> fpdModels = fpdService.getFpdModels();
        return Response.ok(fpdModels);
    }

}
