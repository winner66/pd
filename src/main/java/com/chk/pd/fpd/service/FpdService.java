package com.chk.pd.fpd.service;

import com.chk.pd.common.vo.ParamType;
import com.chk.pd.fpd.dao.FpdDao;
import com.chk.pd.fpd.domain.FpdMap;
import com.chk.pd.fpd.domain.FpdModel;
import com.chk.pd.fpd.vo.FpdModelRsp;
import com.chk.pd.fpd.vo.FpdReq;
import com.chk.pd.fpd.vo.FpdRsp;
import com.chk.pd.common.vo.PageReq;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.service.PdInfoService;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.common.util.OrderRuleUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FpdService {

    @Autowired
    private PdInfoService pdInfoService;

    @Autowired
    private PdParamDao pdParamDao;

    @Autowired
    private FpdDao fpdDao;

    public List<FpdModelRsp> getFpdModels() {
        List<FpdModel> fpdModels = this.fpdDao.getFpdModels();
        List<FpdModelRsp> rsp = new ArrayList<>();
        for (FpdModel fpdModel : fpdModels) {
            rsp.add(new FpdModelRsp(fpdModel));
        }
        return rsp;
    }

    public FpdRsp getPdInfos(FpdReq fpdReq, PageReq pageReq) {
        FpdRsp rsp = new FpdRsp();
        FpdModel model = fpdDao.getFpdModel(fpdReq.getModel());
        String[] rules = OrderRuleUtil.getRules(model.getOrderRule());
        String[] bits = model.getOrderRuleBit().split(",");
        String[] poses = model.getOrderRulePos().split(",");
        Map<String, Integer> rb = new LinkedHashMap<>();
        Map<String, Integer> rp = new LinkedHashMap<>();
        for (int i = 0; i < rules.length; i++) {
            rb.put(rules[i], Integer.valueOf(bits[i]));
            rp.put(rules[i], Integer.valueOf(poses[i]));
        }

        List<FpdMap> fpdMaps = fpdDao.getFpdMaps(model.getId());
        Map<String, String> maps = new HashMap();
        for (FpdMap fpdMap : fpdMaps) {
            maps.put(fpdMap.getFcode().toUpperCase(), fpdMap.getCode().toUpperCase());
        }

        PdInfoReq pdInfoReq = new PdInfoReq();
        String fpdCode = fpdReq.getCode().toUpperCase();
        boolean search = false;
        for (String rule : rules) {
            Integer pos = rp.get(rule);
            Integer bit = rb.get(rule);
            String fcode = getFcode(fpdCode, pos, bit);
            String code = maps.get(fcode);
            if (StringUtils.isBlank(code)) {
                continue;
            }
            rsp.addPmap(rule, pos, bit, fcode, code);
            if (ParamType.model.value().equals(rule)) {
                search = true;
                pdInfoReq.setModelCode(code);
            } else if (ParamType.voltage.value().equals(rule)) {
                search = true;
                pdInfoReq.setVoltage(code);
            } else if (ParamType.size.value().equals(rule)) {
                search = true;
                pdInfoReq.setSize(code);
            } else if (ParamType.temperature.value().equals(rule)) {
                search = true;
                pdInfoReq.setTemperature(code);
            } else if (ParamType.quality.value().equals(rule)) {
                search = true;
                pdInfoReq.setQuality(code);
            } else if (ParamType.capacity.value().equals(rule)) {
                search = true;
                if (code != null) {
                    PdParam pdParam = pdParamDao.getPdParam(ParamType.capacity.value(), code);
                    pdInfoReq.setCapacity(pdParam == null ? null : pdParam.getIdx().toString());
                }
            } else if (ParamType.tolerance.value().equals(rule)) {
                search = true;
                pdInfoReq.setTolerance(code);
            } else if (ParamType.outlet.value().equals(rule)) {
                search = true;
                pdInfoReq.setOutlet(code);
            }
            //less std
        }
        if (!search) {
            rsp.setPdInfos(new ArrayList<>());
        } else {
            rsp.setPdInfos(pdInfoService.getPdInfos(pdInfoReq, pageReq));
        }
        return rsp;
    }

    private String getFcode(String fpdCode, Integer pos, Integer bit) {
        String s = StringUtils.substring(fpdCode, pos - 1, pos + bit - 1);
        if (StringUtils.isBlank(s)) {
            return null;
        } else {
            return s;
        }
    }

//    public static void main(String[] args) {
//        String s = "123456";
//        System.out.println(StringUtils.substring(s, 1-1,4-1));
//        System.out.println(StringUtils.substring(s, 1,6));
//        System.out.println(StringUtils.substring(s, 0,5));
//        System.out.println(StringUtils.substring(s, 0,9));
//        System.out.println(StringUtils.substring(s, 9,11));
//
//        Map m = new HashMap();
//        Object o = m.get(null);
//        System.out.println(o);
//    }
}
