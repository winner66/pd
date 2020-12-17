package com.chk.pd.pd.controller;


import com.chk.pd.common.vo.ParamType;
import com.chk.pd.common.vo.Response;
import com.chk.pd.pd.service.PdParamService;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoReqFuzzyByIn;
import com.chk.pd.pd.vo.PdInfoRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pd")
public class PdParamController {

    private Logger log = LoggerFactory.getLogger(PdParamController.class);

    @Autowired
    private PdParamService paramService;

    @GetMapping("/list-params")
    public Response<List<CasRsp>> listParam(PdInfoReq pdInfoReq) {


        if ("quality".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.quality.value());
            List<CasRsp> cas = paramService.listQuality(pdInfoReq);
            return Response.ok(cas);
        }else if ("size".equals(pdInfoReq.getFilterType())) {
//            封装及外形尺寸
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
            List<CasRsp> cas = paramService.listPdClass(pdInfoReq);
            return Response.ok(cas);
        }
        else if("frequencyRange".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listFrequencyRange(pdInfoReq);
            return Response.ok(cas);
        }
        else if("materialCode".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listMaterialCode(pdInfoReq);
            return Response.ok(cas);
        }
        else if("lengthWidthCode".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listLengthWidthCode(pdInfoReq);
            return Response.ok(cas);
        }
        else if("thicknessCode".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listThicknessCode(pdInfoReq);
            return Response.ok(cas);
        }   else if("surfaceCode".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listSurfaceCode(pdInfoReq);
            return Response.ok(cas);
        }   else if("bandwidth".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listBandwidth(pdInfoReq);
            return Response.ok(cas);
        }   else if("centerFrequency".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listCenterFrequency(pdInfoReq);
            return Response.ok(cas);
        }   else if("cutOffFrequency".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listCutOffFrequency(pdInfoReq);
            return Response.ok(cas);
        } else if("listPassBandRange".equals(pdInfoReq.getFilterType())){
            List<CasRsp> cas = paramService.listPassBandRange(pdInfoReq);
            return Response.ok(cas);
        }  else{
            return Response.ok();
        }
    }

    /**
     * 国外产品对应宏科参数
     * @param pdInfoReq
     * @return
     */
    @GetMapping("/list-params-fpd")
    public Response<List<CasRsp>> listFpdParam(PdInfoReqFuzzyByIn pdInfoReq){
        List<CasRsp> res= new ArrayList<>();
        log.info(pdInfoReq.toString());

        if ("quality".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.quality.value());
            List<CasRsp> cas = paramService.listQualityByFuzzy(pdInfoReq);
            return Response.ok(cas);
        }else if ("size".equals(pdInfoReq.getFilterType())) {
//            封装及外形尺寸
            pdInfoReq.setFilterType(ParamType.size.value());
            List<CasRsp> cas = paramService.listSizeByFuzzy(pdInfoReq);
            return Response.ok(cas);

        }else if ("temperature".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.temperature.value());
            List<CasRsp> cas = paramService.listTemperatureByFuzzy(pdInfoReq);
            return Response.ok(cas);

        }else if ("voltage".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.voltage.value());
            List<CasRsp> cas = paramService.listVoltageByFuzzy(pdInfoReq);
            return Response.ok(cas);

        }else if ("tolerance".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.tolerance.value());
            List<CasRsp> cas = paramService.listToleranceByFuzzy(pdInfoReq);
            return Response.ok(cas);
        }else if ("outlet".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.outlet.value());
            List<CasRsp> cas = paramService.listOutletByFuzzy(pdInfoReq);
            return Response.ok(cas);
        }else if ("capacity".equals(pdInfoReq.getFilterType())) {
            pdInfoReq.setFilterType(ParamType.capacity.value());
            List<CasRsp> cas = paramService.listCapacityByFuzzy(pdInfoReq);
            return Response.ok(cas);
        }
//        else if ("clzqa".equals(pdInfoReq.getFilterType())) {
//            List<CasRsp> cas = paramService.listClassByFuzzy(pdInfoReq);
//            return Response.ok(cas);
//        }
        else{
            return Response.ok();
        }

    }

    //    LTCC低通滤波器 的参数

    @PostMapping("/LLPF")
    public Response  llccParam() {
        Map<String ,Object> map= new HashMap();
        List<CasRsp> qualityParam=paramService.getQualityByLLPF();
        map.put("quality",qualityParam);

        List<CasRsp> sizeParam=paramService.getSizeByLLPF();
        map.put("size",sizeParam);
        List<CasRsp> passBandRangeParam=paramService.getPassBandRangeByLLPF();
        map.put("passBandRange",passBandRangeParam);
        return Response .ok(map);
    }
    //    LTCC低通滤波器 的参数
    @PostMapping("/LBPF")
    public Response  lbccParam() {
        Map<String ,Object> map= new HashMap();
        List<CasRsp> qualityParam=paramService.getQualityByLBPF();
        map.put("quality",qualityParam);
        List<CasRsp> cutOffFrequencyParam=paramService.getCutOffFrequencyByLBPF();
        map.put("cutOffFrequency",cutOffFrequencyParam);

        List<CasRsp> sizeParam=paramService.getSizeByLBPF();
        map.put("size",sizeParam);

        return Response .ok(map);
    }
    //    LTCC低通滤波器 的参数
    @PostMapping("/LHPF")
    public Response  lhccParam() {
        Map<String ,Object> map= new HashMap();
        List<CasRsp> sizeParam=paramService.getSizeByLHPF();
        map.put("size",sizeParam);
        List<CasRsp> qualityParam=paramService.getQualityByLHPF();
        map.put("quality",qualityParam);
        List<CasRsp> centerFrequencyParam=paramService.getCenterFrequencyByLHPF();

        map.put("centerFrequency",centerFrequencyParam);
        List<CasRsp> bandwidthParam=paramService.getBandwidthByLHPF();
        map.put("bandwidth",bandwidthParam);
        return Response .ok(map);
    }

//    滤波器(包含上面的接口的参数)
    @PostMapping("/WaveFilter")
    public Response  waveFilterParam() {
        Map<String ,Object> map= new HashMap();
        List<CasRsp> sizeParam=paramService.getSizeByLHPF();
        map.put("size",sizeParam);
        List<CasRsp> qualityParam=paramService.getQualityByLHPF();
        map.put("quality",qualityParam);
        List<CasRsp> centerFrequencyParam=paramService.getCenterFrequencyByLHPF();
        map.put("centerFrequency",centerFrequencyParam);
        List<CasRsp> bandwidthParam=paramService.getBandwidthByLHPF();
        map.put("bandwidth",bandwidthParam);
        List<CasRsp> cutOffFrequencyParam=paramService.getCutOffFrequencyByLBPF();
        map.put("cutOffFrequency",cutOffFrequencyParam);
        List<CasRsp> passBandRangeParam=paramService.getPassBandRangeByLLPF();
        map.put("passBandRange",passBandRangeParam);

        return Response .ok(map);
    }

//    根据搜索获取参数
    @GetMapping("/getParamByPd/{type}")
    public Response  getParamByPd(@PathVariable("type") Integer type){
        Map<String ,Object> map= new HashMap();
        List<CasRsp> centerFrequencyParam=paramService.getCenterFrequencyByLHPF();
        map.put("centerFrequency",centerFrequencyParam);
        List<CasRsp> bandwidthParam=paramService.getBandwidthByLHPF();
        map.put("bandwidth",bandwidthParam);
        List<CasRsp> cutOffFrequencyParam=paramService.getCutOffFrequencyByLBPF();
        map.put("cutOffFrequency",cutOffFrequencyParam);
        List<CasRsp> passBandRangeParam=paramService.getPassBandRangeByLLPF();
        map.put("passBandRange",passBandRangeParam);
        return Response .ok(map);
    }

}
