package com.chk.pd.pd_material.controller;

import com.chk.pd.common.vo.ParamType;
import com.chk.pd.common.vo.Response;

import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Enum.materialSearchParamEnum;
import com.chk.pd.pd_material.Service.impl.PdParamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("pdMaterialParamController")
@RequestMapping("/pd_material/V1/Param")
public class PdParamController {

    @Autowired
    private PdParamServiceImpl paramService;


    @GetMapping("/list-params")
    public Response<List<CasRsp>> listParam(materialRsp rsp) {
        if (materialSearchParamEnum.quality.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.quality.title());

            List<CasRsp> cas = paramService.listQuality(rsp);
            return Response.ok(cas);
        }
        else if (materialSearchParamEnum.std.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.std.title());

            List<CasRsp> cas = paramService.listStd(rsp);
            return Response.ok(cas);
        }else  if (materialSearchParamEnum.size.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.size.title());

            List<CasRsp> cas = paramService.listSize(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.surfaceCode.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.surfaceCode.title());

            List<CasRsp> cas = paramService.listSurfaceCode(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.thicknessCode.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.thicknessCode.title());

            List<CasRsp> cas = paramService.listThicknessCode(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.lengthWidthCode.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.lengthWidthCode.title());

            List<CasRsp> cas = paramService.listLengthWidthCode(rsp);
            return Response.ok(cas);
        }else  if (materialSearchParamEnum.materialCode.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.materialCode.title());

            List<CasRsp> cas = paramService.listMaterialCode(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.centerFrequency.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.centerFrequency.title());

            List<CasRsp> cas = paramService.listCenterFrequency(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.passBandRange.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.passBandRange.title());

            List<CasRsp> cas = paramService.listPassBandRange(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.ripple.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.ripple.title());

            List<CasRsp> cas = paramService.listRipple(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.powerCapacity.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.powerCapacity.title());

            List<CasRsp> cas = paramService.listPowerCapacity(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.frequencyRange.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.frequencyRange.title());

            List<CasRsp> cas = paramService.listFrequencyRange(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.cutOffFrequency.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.cutOffFrequency.title());

            List<CasRsp> cas = paramService.listCutOffFrequency(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.padMetallurgy.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.padMetallurgy.title());

            List<CasRsp> cas = paramService.listPadMetallurgy(rsp);
            return Response.ok(cas);
        }
        else  if (materialSearchParamEnum.bandwidth.value().equals(rsp.getFilterType())) {


            rsp.setFilterType(materialSearchParamEnum.bandwidth.title());

            List<CasRsp> cas = paramService.listBandwidth(rsp);
            return Response.ok(cas);
        }

        else {
            return Response.ok();
        }
    }
    @GetMapping("/list-clzqa-param")
    public Response<List<TreeRsp>> listClzqaParam(materialRsp rsp){
        if(materialSearchParamEnum.clzqa.value().equals(rsp.getFilterType())){
        List<TreeRsp> cas = paramService.listClass(rsp);
        return Response.ok(cas);
     }
        return Response.ok();
    }
}
