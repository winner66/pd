package com.chk.pd.pd.controller;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.service.PdInfoService;
import com.chk.pd.pd.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pd")
public class PdInfoController {

    private Logger log = LoggerFactory.getLogger(PdInfoController.class);

    @Autowired
    private PdInfoService pdInfoService;

    @GetMapping("get-pd-infos")
    public Response<List<PdInfoRsp>> getPdInfos(PdInfoReq pdInfoReq, PageReq pageReq) {
        log.info(pdInfoReq.toString() + "---" + pageReq.toString());
        List<PdInfoRsp> pdInfos = pdInfoService.getPdInfos(pdInfoReq, pageReq);
        return Response.ok(pdInfos);
    }

    @GetMapping("get-pd-detail")
    public Response<PdDetailRsp> getPdDetail(PdDetailReq req) {
        PdDetailRsp pdDetail = pdInfoService.getPdDetail(req);
        return Response.ok(pdDetail);
    }

    @GetMapping("get-pd-rule")
    public Response<PdRuleRsp> getPdRule(@RequestParam() Long piId) {
        PdRuleRsp pdRule = pdInfoService.getPdRule(piId);
        return Response.ok(pdRule);
    }

    @Deprecated
    @GetMapping("get-pd-params")
    public Response<PdParamRsp> getPdParams() {
        PdParamRsp pdParams = pdInfoService.getPdParams();
        return Response.ok(pdParams);
    }
}
