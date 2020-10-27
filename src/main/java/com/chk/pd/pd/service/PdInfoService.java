package com.chk.pd.pd.service;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.dao.PdClassDao;
import com.chk.pd.pd.dao.PdInfoDao;
import com.chk.pd.pd.dao.PdModelDao;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdInfo;
import com.chk.pd.pd.domain.PdModel;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.vo.*;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PdInfoService {

    private Logger log = LoggerFactory.getLogger(PdInfoService.class);

    @Autowired
    private PdInfoDao pdInfoDao;

    @Autowired
    private PdClassDao pdClassDao;

    @Autowired
    private PdModelDao pdModelDao;

    @Autowired
    private PdParamDao pdParamDao;

    public List<PdInfoRsp> getPdInfos(PdInfoReq pdInfoReq, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<PdInfoRsp> pdInfos = pdInfoDao.getExtPdInfoMapper().getPdInfos(pdInfoReq);
        for (PdInfoRsp pdInfo : pdInfos) {
            pdInfo.setReq(pdInfoReq);
            pdInfo.setTolerance(StringUtils.substringAfter(pdInfo.getTolerance(), ";"));
            pdInfo.setTolerance(StringUtils.substringBeforeLast(pdInfo.getTolerance(), ";"));
            pdInfo.setOutlet(StringUtils.substringAfter(pdInfo.getOutlet(), ";"));
            pdInfo.setOutlet(StringUtils.substringBeforeLast(pdInfo.getOutlet(), ";"));
            pdInfo.setWireMa(StringUtils.substringAfter(pdInfo.getWireMa(), ";"));
            pdInfo.setWireMa(StringUtils.substringBeforeLast(pdInfo.getWireMa(), ";"));
            pdInfo.setWireSize(StringUtils.substringAfter(pdInfo.getWireSize(), ";"));
            pdInfo.setWireSize(StringUtils.substringBeforeLast(pdInfo.getWireSize(), ";"));
            pdInfo.setPin(StringUtils.substringAfter(pdInfo.getPin(), ";"));
            pdInfo.setPin(StringUtils.substringBeforeLast(pdInfo.getPin(), ";"));
        }
        return pdInfos;
    }

    public PdDetailRsp getPdDetail(PdDetailReq req) {
        PdInfo pdInfo = pdInfoDao.getPdInfoMapper().selectByPrimaryKey(req.getId());
        PdModel pdModel = pdModelDao.getPdModelMapper().selectByPrimaryKey(pdInfo.getPdModelId());
        PdClass pdClass = pdClassDao.getPdClassMapper().selectByPrimaryKey(pdModel.getPdClassId());
        PdParam size = pdParamDao.getSize(pdInfo.getStd(), pdInfo.getSize());
        PdParam quality = pdParamDao.getPdParam(ParamType.quality.value(), pdInfo.getQuality());
        PdParam temperature = pdParamDao.getPdParam(ParamType.temperature.value(), pdInfo.getTemperature());
        List<PdParam> tolerances = getTolerance(req, pdInfo);
        List<PdParam> outlets = getOutlet(req, pdInfo);
        List<PdParam> capacities = getCapacity(req, pdInfo);
        PdDetailRsp detail = new PdDetailRsp(pdClass, pdModel, pdInfo, size, quality, temperature, tolerances, outlets, capacities, req);
        return detail;
    }

    private List<PdParam> getTolerance(PdDetailReq req, PdInfo pdInfo) {
        List<PdParam> tolerances = new ArrayList<>();
        if (StringUtils.isNotBlank(pdInfo.getTolerance())) {
            List<String> codes;
            if (StringUtils.isNotBlank(req.getTolerance())){
                codes = Arrays.asList(new String[]{req.getTolerance()});
            }else{
                codes = Arrays.asList(StringUtils.split(pdInfo.getTolerance(), ";"));
            }
            tolerances = pdParamDao.getPdParam(ParamType.tolerance.value(), codes);
        }
        return tolerances;
    }

    private List<PdParam> getOutlet(PdDetailReq req, PdInfo pdInfo) {
        List<PdParam> outlets = new ArrayList<>();
        if (StringUtils.isNotBlank(pdInfo.getOutlet())) {
            List<String> codes;
            if (StringUtils.isNotBlank(req.getOutlet())){
                codes = Arrays.asList(new String[]{req.getOutlet()});
            }else{
                codes = Arrays.asList(StringUtils.split(pdInfo.getOutlet(), ";"));
            }
            outlets = pdParamDao.getPdParam(ParamType.outlet.value(), codes);
        }
        return outlets;
    }

    private List<PdParam> getCapacity(PdDetailReq req, PdInfo pdInfo) {
        List<PdParam> capacities;
        if (StringUtils.isNotBlank(req.getCapacity())){
            capacities = pdParamDao.getCapacities(Integer.valueOf(req.getCapacity()), Integer.valueOf(req.getCapacity()));
        }else{
            capacities = pdParamDao.getCapacities(pdInfo.getCapacityMinIdx(), pdInfo.getCapacityMaxIdx());
        }
        return capacities;
    }

    public PdRuleRsp getPdRule(Long piId) {
        PdInfo pdInfo = pdInfoDao.getPdInfoMapper().selectByPrimaryKey(piId);
        PdModel pdModel = pdModelDao.getPdModelMapper().selectByPrimaryKey(pdInfo.getPdModelId());
        List<PdParam> capacities = pdParamDao.getCapacities(pdInfo.getCapacityMinIdx(), pdInfo.getCapacityMaxIdx());
        List<PdParam> outlets = new ArrayList<>();
        if (StringUtils.isNotBlank(pdInfo.getOutlet())) {
            outlets = pdParamDao.getPdParam(ParamType.outlet.value(), Arrays.asList(StringUtils.split(pdInfo.getOutlet(), ";")));
        }
        List<PdParam> tolerances = new ArrayList<>();
        if (StringUtils.isNotBlank(pdInfo.getTolerance())) {
            tolerances = pdParamDao.getPdParam(ParamType.tolerance.value(), Arrays.asList(StringUtils.split(pdInfo.getTolerance(), ";")));
        }
        PdRuleRsp pdRuleRsp = new PdRuleRsp(pdModel, pdInfo, tolerances, outlets, capacities);
        return pdRuleRsp;
    }

    @Deprecated
    public PdParamRsp getPdParams() {
        PdParamRsp ppr = new PdParamRsp();
//        List<PdParam> all = this.pdParamDao.getAll();
        List<PdParam> all = this.pdParamDao.getExtPdParamMapper().list();
        Map<String, PdParamRsp.Multi> sizeMap = new HashMap<>();
        Map<String, PdParamRsp.Multi> capacityMap = new HashMap<>();
        for (PdParam p : all) {
            if (ParamType.quality.value().equals(p.getType())) {
                ppr.getQuality().add(ppr.createItem(p.getCode(), p.getCode() + "[" + p.getName() + "]"));
            } else if (ParamType.size.value().equalsIgnoreCase(p.getType())) {
                PdParamRsp.Multi multi = sizeMap.get(p.getGp());
                if (multi == null) {
                    multi = ppr.createMulti(p.getGp(), p.getGp());
                    sizeMap.put(p.getGp(), multi);
                    ppr.getSize().get(0).add(multi);
                }
                multi.addC(p.getId().toString(), p.getCode());
            } else if (ParamType.temperature.value().equalsIgnoreCase(p.getType())) {
                ppr.getTemperature().add(ppr.createItem(p.getCode(), p.getCode() + "[" + p.getName() + "]"));
            } else if (ParamType.voltage.value().equalsIgnoreCase(p.getType())) {
                ppr.getVoltage().add(ppr.createItem(p.getCode(), p.getName()));
            } else if (ParamType.capacity.value().equalsIgnoreCase(p.getType())) {
                PdParamRsp.Multi multi = capacityMap.get(p.getGp());
                if (multi == null) {
                    multi = ppr.createMulti(p.getGp(), p.getGp());
                    capacityMap.put(p.getGp(), multi);
                    ppr.getCapacity().get(0).add(multi);
                }
                multi.addC("idx" + p.getIdx().toString(), p.getCode());
            } else if (ParamType.tolerance.value().equalsIgnoreCase(p.getType())) {
                ppr.getTolerance().add(ppr.createItem(p.getCode(), p.getCode() + "[" + p.getName() + "]"));
            } else if (ParamType.outlet.value().equalsIgnoreCase(p.getType())) {
                ppr.getOutlet().add(ppr.createItem(p.getCode(), p.getCode() + "[" + p.getName() + "]"));
            }
        }

        List<PdClass> classes = this.pdClassDao.getPdClasses(null);
        for (PdClass clz : classes) {
            ppr.getCm().add(ppr.createItem(clz.getId().toString(), clz.getShowName()));
        }
        return ppr;
    }
}
