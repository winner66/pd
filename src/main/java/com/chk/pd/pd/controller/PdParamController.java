package com.chk.pd.pd.controller;


import com.chk.pd.common.vo.ParamType;
import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.service.PdParamService;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pd")
public class PdParamController {

    private Logger log = LoggerFactory.getLogger(PdParamController.class);

    @Autowired
    private PdParamService paramService;

    @GetMapping("list-params")
    public Response<List<CasRsp>> listParam(PdInfoReq pdInfoReq) {
        log.info(pdInfoReq.toString());
        if ("quality".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.quality.value());
            List<CasRsp> cas = paramService.listQuality(pdInfoReq);
            return Response.ok(cas);
        }else if ("size".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.size.value());
            List<CasRsp> cas = paramService.listSize(pdInfoReq);
            return Response.ok(cas);
        }else if ("temperature".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.temperature.value());
            List<CasRsp> cas = paramService.listTemperature(pdInfoReq);
            return Response.ok(cas);
        }else if ("voltage".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.voltage.value());
            List<CasRsp> cas = paramService.listVoltage(pdInfoReq);
            return Response.ok(cas);
        }else if ("tolerance".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.tolerance.value());
            List<CasRsp> cas = paramService.listTolerance(pdInfoReq);
            return Response.ok(cas);
        }else if ("outlet".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.outlet.value());
            List<CasRsp> cas = paramService.listOutlet(pdInfoReq);
            return Response.ok(cas);
        }else if ("capacity".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.capacity.value());
            List<CasRsp> cas = paramService.listCapacity(pdInfoReq);
            return Response.ok(cas);
        }else if ("clzqa".equals(pdInfoReq.getFilterType())) {
            List<CasRsp> cas = paramService.listClass(pdInfoReq);
            return Response.ok(cas);
        }else{
            return Response.ok();
        }
    }
}
