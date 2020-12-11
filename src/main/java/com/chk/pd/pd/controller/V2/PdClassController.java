package com.chk.pd.pd.controller.V2;

import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.service.PdClassService;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdClassRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("V2PdClassController")
@RequestMapping("/pd/V2")

public class PdClassController {
    @Autowired
    private PdClassService pdClassService;

    @Deprecated
    @GetMapping("/get-pd-classes")
    public Response<List<PdClassRsp>> getPdClasses(){
        List<PdClassRsp> pdClasses = pdClassService.getClzTop2();
        return Response.ok(pdClasses);
    }

    @GetMapping("/list-pd-class")
    public Response listPdClass(){
        List<PdClassRsp> lev2 = pdClassService.getClzTop2V2();
        List<CasRsp> cas = pdClassService.listPdClassV2(null);
        List<CasRsp> manual = pdClassService.listManual();
        Map<String, Object> result = new HashMap<>();
        result.put("lev2", lev2);
        result.put("cas", cas);
        result.put("manual", manual);
        return Response.ok(result);
    }

    @GetMapping("/list-pd_material-class")
    public Response listPdMaterialClass(){
        List<PdClassRsp> lev2 = pdClassService.getClzTop2V2();
        List<CasRsp> cas = pdClassService.listPdClassV2(null);
        List<CasRsp> manual = pdClassService.listManual();
        Map<String, Object> result = new HashMap<>();
        result.put("lev2", lev2);
        result.put("cas", cas);
        result.put("manual", manual);
        return Response.ok(result);
    }
}
