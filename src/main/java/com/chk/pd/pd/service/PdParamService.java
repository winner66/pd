package com.chk.pd.pd.service;

import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.dao.PdInfoDao;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import org.apache.commons.lang3.StringUtils;
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
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
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

    public List<CasRsp> listClass(PdInfoReq pdInfoReq) {
        return this.classService.listPdClass(pdInfoReq);
    }
}
