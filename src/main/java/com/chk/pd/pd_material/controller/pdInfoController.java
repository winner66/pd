package com.chk.pd.pd_material.controller;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.vo.*;
import com.chk.pd.pd_material.Dto.PdMaterialDetailRsp;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Dto.pdMaterialInfoVo;
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

    @GetMapping("/list_pd_material_class")
    public Response listPdMaterialClass(){
        List<TreeRsp> lev2 = materialService.getclz();
        Map<String, Object> result = new HashMap<>();
        result.put("lev2", lev2);
        return Response.ok(result);
    }

    @GetMapping("/get_pd_material_infos")
    public Response<List<pdMaterialInfoVo>> listPdMaterialInfos(materialRsp pdInfoReq, PageReq pageReq){
        List<pdMaterialInfoVo> pdInfos = materialService.getPdMaterialInfos(pdInfoReq, pageReq);
        return Response.ok(pdInfos);
    }

    @GetMapping("get_pd_material_detail")
    public Response<PdMaterialDetailRsp> getPdDetail(PdDetailReq req) {
        PdMaterialDetailRsp pdDetail = materialService.getPdMaterialDetail(req);
        return Response.ok(pdDetail);
    }

}
