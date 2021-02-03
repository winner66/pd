package com.chk.pd.pd.service;

import com.chk.pd.common.vo.ClassType;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.common.vo.ParamTypeMaterial;
import com.chk.pd.pd.dao.PdInfoDao;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoReqFuzzyByIn;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_microware.Dto.microwareRsp;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PdParamService {

    @Autowired
    private PdInfoDao infoDao;

    @Autowired
    private PdParamDao paramDao;

    @Autowired
    private PdClassService classService;

    public List<CasRsp> listQuality(PdInfoReq pdInfoReq) {

        List<PdParam> params = infoDao.getExtPdInfoMapper().listQuality(pdInfoReq);

        List<CasRsp> rsp = new ArrayList<>();
//        Map<String, CasRsp> map = new LinkedHashMap<>();
//        for (PdParam param : params) {
//            CasRsp cas = map.get(param.getGp());
//            if (cas == null) {
//                cas = new CasRsp(param.getGp(), param.getGp(), true);
//                map.put(param.getGp(), cas);
//            }
//            cas.getChildren().add(new CasRsp(param.getCode() + " [" + param.getName() + "]", param.getCode(), false));
//        }
        for (PdParam param : params) {
            if ("GJB".equals(param.getCode())){

                rsp.add(new CasRsp(param.getName() == null ? param.getCode() : param.getName(), param.getCode(), false));
            }else {
                rsp.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
            }
        }
        return rsp;
    }

    public List<CasRsp> listSize(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listSize(pdInfoReq);
//        Map<String, CasRsp> map = new LinkedHashMap<>();
//        for (PdParam param : params) {
//            CasRsp cas = map.get(param.getGp());
//            if (cas == null) {
//                cas = new CasRsp(param.getGp(), param.getGp(), true);
//                map.put(param.getGp(), cas);
//            }
//            cas.getChildren().add(new CasRsp(param.getCode(), param.getCode(), false));
//        }
//        return new ArrayList<>(map.values());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
//            0805[长宽高] ：0805_12345
//            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
            cas.add(new CasRsp(param.getCode(), param.getCode() + "_" + param.getId(), false));

        }
        return cas;
    }

    public List<CasRsp> listVoltage(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listVoltage(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listTemperature(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listTemperature(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {


            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listTolerance(PdInfoReq pdInfoReq) {
        List<String> tolerances = infoDao.getExtPdInfoMapper().listTolerance(pdInfoReq);
        Set<String> set = new HashSet<>();
        for (String t : tolerances) {
            String[] ss = StringUtils.split(t, ";");
            for (String s : ss) {
                set.add(s);
            }
        }

        List<CasRsp> cas = new ArrayList<>();
        List<PdParam> params = paramDao.getPdParam(ParamType.tolerance.value());
        for (PdParam param : params) {
            if (set.contains(param.getCode())) {
                String label = param.getCode() + " [" + (param.getName() == null ? "" :param.getName()) + "]";
                cas.add(new CasRsp(label, param.getCode(), false));
            }
        }
        return cas;
    }

    public List<CasRsp> listOutlet(PdInfoReq pdInfoReq) {
        List<CasRsp> cas = new ArrayList<>();
        List<String> outlets = infoDao.getExtPdInfoMapper().listOutlet(pdInfoReq);
        Set<String> set = new HashSet<>();
        for (String outlet : outlets) {
            String[] ss = StringUtils.split(outlet, ";");
            for (String s : ss) {
                set.add(s);
            }
        }

        List<PdParam> params = paramDao.getPdParam(ParamType.outlet.value());
        for (PdParam param : params) {
            if (set.contains(param.getCode())) {
                String label = param.getCode() + " [" + (param.getName() == null ? "" :param.getName()) + "]";
                cas.add(new CasRsp(label, param.getCode(), false));
            }
        }
        return cas;
    }

    public List<CasRsp> listCapacity(PdInfoReq pdInfoReq) {
        List<Map<Integer, Integer>> capacities = infoDao.getExtPdInfoMapper().listCapacity(pdInfoReq);
        List<PdParam> params = paramDao.getPdParam(ParamType.capacity.value());
        Map<String, CasRsp> cas = new LinkedHashMap<>();
        Set<Integer> set = new HashSet<>();
        for (PdParam param : params) {
            for (Map<Integer, Integer> capacity : capacities) {
                int min = capacity.get("min");
                int max = capacity.get("max");
                if (param.getIdx() >= min && param.getIdx() <= max){
                    CasRsp c = cas.get(param.getGp());
                    if (c == null){
                        c = new CasRsp(param.getGp(), param.getGp(), true);
                        cas.put(param.getGp(), c);
                    }
                    if (set.contains(param.getIdx())){
                        continue;
                    }
                    set.add(param.getIdx());
                    CasRsp cr = new CasRsp(param.getCode(), param.getIdx().toString(), false);
                    c.getChildren().add(cr);
                }
            }
        }
        return new ArrayList<>(cas.values());
    }
    //获取所有的分类
    public List<CasRsp> listClass(PdInfoReq pdInfoReq) {
        return this.classService.listAllPdClass(pdInfoReq);
    }
//    只获取电容器的分类
    public List<CasRsp> listPdClass(PdInfoReq pdInfoReq) {
        return this.classService.listPdClass(pdInfoReq);
    }
    //    只获取材料器件的分类
    public List<CasRsp> listMaterialPdClass(materialRsp pdInfoReq) {
        return this.classService.listMaterialPdClass(pdInfoReq);
    }
    //    只获取微波的分类
    public List<CasRsp> listMicrowarePdClass(microwareRsp pdInfoReq) {
//        return this.classService.listMicrowarePdClass(pdInfoReq);
        return null;
    }
    public List<CasRsp> listLengthWidthCode(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listLengthWidthCode(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listBandwidth(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listBandwidth(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listFrequencyRange(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listFrequencyRange(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listThicknessCode(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listThicknessCode(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listMaterialCode(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listMaterialCode(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listSurfaceCode(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listSurfaceCode(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }   public List<CasRsp> listCenterFrequency(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listCenterFrequency(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }   public List<CasRsp> listCutOffFrequency(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listCutOffFrequency(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }   public List<CasRsp> listPassBandRange(PdInfoReq pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listPassBandRange(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }




    public List<CasRsp> listQualityByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {

        List<PdParam> params = infoDao.getExtPdInfoMapper().listQualityByFuzzy(pdInfoReq);

        List<CasRsp> rsp = new ArrayList<>();
//        Map<String, CasRsp> map = new LinkedHashMap<>();
//        for (PdParam param : params) {
//            CasRsp cas = map.get(param.getGp());
//            if (cas == null) {
//                cas = new CasRsp(param.getGp(), param.getGp(), true);
//                map.put(param.getGp(), cas);
//            }
//            cas.getChildren().add(new CasRsp(param.getCode() + " [" + param.getName() + "]", param.getCode(), false));
//        }
        for (PdParam param : params) {
            if ("GJB".equals(param.getCode())){

                rsp.add(new CasRsp(param.getName() == null ? param.getCode() : param.getName(), param.getCode(), false));
            }else {
                rsp.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
            }
        }
        return rsp;
    }

    public List<CasRsp> listSizeByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listSizeByFuzzy(pdInfoReq);
//        Map<String, CasRsp> map = new LinkedHashMap<>();
//        for (PdParam param : params) {
//            CasRsp cas = map.get(param.getGp());
//            if (cas == null) {
//                cas = new CasRsp(param.getGp(), param.getGp(), true);
//                map.put(param.getGp(), cas);
//            }
//            cas.getChildren().add(new CasRsp(param.getCode(), param.getCode(), false));
//        }
//        return new ArrayList<>(map.values());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
//            0805[长宽高] ：0805_12345
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
        }
        return cas;
    }

    public List<CasRsp> listVoltageByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listVoltageByFuzzy(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listTemperatureByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
        List<PdParam> params = infoDao.getExtPdInfoMapper().listTemperatureByFuzzy(pdInfoReq);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listToleranceByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
        List<String> tolerances = infoDao.getExtPdInfoMapper().listToleranceByFuzzy(pdInfoReq);
        Set<String> set = new HashSet<>();
        for (String t : tolerances) {
            String[] ss = StringUtils.split(t, ";");
            for (String s : ss) {
                set.add(s);
            }
        }

        List<CasRsp> cas = new ArrayList<>();
        List<PdParam> params = paramDao.getPdParam(ParamType.tolerance.value());
        for (PdParam param : params) {
            if (set.contains(param.getCode())) {
                String label = param.getCode() + " [" + (param.getName() == null ? "" :param.getName()) + "]";
                cas.add(new CasRsp(label, param.getCode(), false));
            }
        }
        return cas;
    }

    public List<CasRsp> listOutletByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
        List<CasRsp> cas = new ArrayList<>();
        List<String> outlets = infoDao.getExtPdInfoMapper().listOutletByFuzzy(pdInfoReq);
        Set<String> set = new HashSet<>();
        for (String outlet : outlets) {
            String[] ss = StringUtils.split(outlet, ";");
            for (String s : ss) {
                set.add(s);
            }
        }

        List<PdParam> params = paramDao.getPdParam(ParamType.outlet.value());
        for (PdParam param : params) {
            if (set.contains(param.getCode())) {
                String label = param.getCode() + " [" + (param.getName() == null ? "" :param.getName()) + "]";
                cas.add(new CasRsp(label, param.getCode(), false));
            }
        }
        return cas;
    }

    public List<CasRsp> listCapacityByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
        List<Map<Integer, Integer>> capacities = infoDao.getExtPdInfoMapper().listCapacityByFuzzy(pdInfoReq);
        List<PdParam> params = paramDao.getPdParam(ParamType.capacity.value());
        Map<String, CasRsp> cas = new LinkedHashMap<>();
        Set<Integer> set = new HashSet<>();
        for (PdParam param : params) {
            for (Map<Integer, Integer> capacity : capacities) {
                int min = capacity.get("min");
                int max = capacity.get("max");
                if (param.getIdx() >= min && param.getIdx() <= max){
                    CasRsp c = cas.get(param.getGp());
                    if (c == null){
                        c = new CasRsp(param.getGp(), param.getGp(), true);
                        cas.put(param.getGp(), c);
                    }
                    if (set.contains(param.getIdx())){
                        continue;
                    }
                    set.add(param.getIdx());
                    CasRsp cr = new CasRsp(param.getCode(), param.getIdx().toString(), false);
                    c.getChildren().add(cr);
                }
            }
        }
        return new ArrayList<>(cas.values());
    }





    public List<CasRsp> getSizeByLLPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.size.value(), ClassType.LLPF.value());

        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
//            0805[长宽高] ：0805_12345
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
        }
        return cas;
    }



    public List<CasRsp> getQualityByLLPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.quality.value(), ClassType.LLPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            if ("GJB".equals(param.getCode())){

                cas.add(new CasRsp(param.getName() == null ? param.getCode() : param.getName(), param.getCode(), false));
            }else {
                cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
            }
        }
        return cas;
    }

    public List<CasRsp> getPassBandRangeByLLPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.bandwidth.value(), ClassType.LLPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> getQualityByLHPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.quality.value(), ClassType.LHPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            if ("GJB".equals(param.getCode())){

                cas.add(new CasRsp(param.getName() == null ? param.getCode() : param.getName(), param.getCode(), false));
            }else {
                cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
            }
        }
        return cas;
    }

    public List<CasRsp> getCenterFrequencyByLHPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.centerFrequency.value(), ClassType.LHPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> getBandwidthByLHPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.bandwidth.value(), ClassType.LHPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> getSizeByLHPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.size.value(), ClassType.LHPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
//            0805[长宽高] ：0805_12345
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
        }
        return cas;
    }

    public List<CasRsp> getSizeByLBPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.size.value(), ClassType.LBPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
//            0805[长宽高] ：0805_12345
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
        }
        return cas;
    }

    public List<CasRsp> getCutOffFrequencyByLBPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.cutOffFrequency.value(), ClassType.LBPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> getQualityByLBPF() {
        List<PdParam> params =paramDao.list(ParamTypeMaterial.quality.value(), ClassType.LBPF.value());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            if ("GJB".equals(param.getCode())){

                cas.add(new CasRsp(param.getName() == null ? param.getCode() : param.getName(), param.getCode(), false));
            }else {
                cas.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
            }
        }
        return cas;
    }

//
//    public List<CasRsp> listClassByFuzzy(PdInfoReqFuzzyByIn pdInfoReq) {
//        return this.classService.listPdClassByFuzzy(pdInfoReq);
//    }

}
