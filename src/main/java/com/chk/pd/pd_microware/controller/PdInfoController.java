package com.chk.pd.pd_microware.controller;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.vo.PdDetailReq;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Dto.PdMaterialDetailRsp;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Dto.pdMaterialInfoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("pdMicrowareController")
@RequestMapping("/pd_microware/V1/microware")
public class PdInfoController {

    @GetMapping("/list_pd_microware_class")
    public Response listPdMaterialClass(){
//        List<TreeRsp> lev2 = materialService.getclz();
        Map<String, Object> result = new HashMap<>();
        result.put("lev2", "isempty");
        return Response.ok(result);
    }

    @GetMapping("/get_pd_microware_infos")
    public Response<List<pdMaterialInfoVo>> listPdMaterialInfos(materialRsp pdInfoReq, PageReq pageReq){
//        List<pdMaterialInfoVo> pdInfos = materialService.getPdMaterialInfos(pdInfoReq, pageReq);
//        return Response.ok(pdInfos);

        List<pdMaterialInfoVo> pdInfos = new ArrayList<>();
        return Response.ok(pdInfos);
    }

    @GetMapping("get_pd_microware_detail")
    public Response<PdMaterialDetailRsp> getPdDetail(PdDetailReq req) {
//        PdMaterialDetailRsp pdDetail = materialService.getPdMaterialDetail(req);
        PdMaterialDetailRsp pdDetail = new PdMaterialDetailRsp();
        pdDetail.setRule("empty");
        return Response.ok(pdDetail);
    }
}
