package com.chk.pd.pd_material.controller;

import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdClassRsp;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Service.pdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("pdMaterialController")
@RequestMapping("/pd_material/V1/material")
@SuppressWarnings("all")
public class pdInfoController {


    @Autowired
    private pdInfoService materialService;

    @GetMapping("/list-pd_material-class")
    public Response listPdMaterialClass(){
        List<TreeRsp> lev2 = materialService.getclz();
        Map<String, Object> result = new HashMap<>();
        result.put("lev2", lev2);

        return Response.ok(result);
    }


}
