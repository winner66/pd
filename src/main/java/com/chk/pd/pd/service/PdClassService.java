package com.chk.pd.pd.service;

import com.chk.pd.pd.dao.PdClassDao;
import com.chk.pd.pd.dao.PdInfoDao;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdClassRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pub.dao.SysDictDao;
import com.chk.pd.pub.domain.SysDict;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PdClassService {

    @Autowired
    private PdInfoDao infoDao;

    @Autowired
    private PdClassDao pdClassDao;

    @Autowired
    private PdParamDao pdParamDao;

    @Autowired
    private SysDictDao dictDao;

    public List<PdClassRsp> getClzTop2() {
        List<SysDict> dicts = dictDao.listByType("打开PDF的产品分类");
        List<PdClass> lev1 = pdClassDao.getPdClasses(1);
        List<PdClass> lev2 = pdClassDao.getPdClasses(2);
        List<PdClassRsp> vos = new ArrayList<>();
        for (PdClass clz : lev1) {
            PdClassRsp vo = new PdClassRsp(clz);
            vos.add(vo);
        }
        for (PdClass clz : lev2) {
            for (PdClassRsp vo : vos) {
                if (vo.getId().equals(clz.getpId())) {
                    PdClassRsp cr = new PdClassRsp(clz);
                    vo.getChildren().add(cr);
                    for (SysDict dict : dicts) {
                        if (clz.getName().equals(dict.getName())) {
                            cr.setOpera(PdClassRsp.OPERA_FILE);
                            cr.setFileUrl(dict.getValue());
                        }
                    }
                }
            }
        }
        return vos;
    }


    public List<CasRsp> listPdClass(PdInfoReq pdInfoReq) {
        List<SysDict> dicts = dictDao.listByType("打开PDF的产品分类");
        Map<String, SysDict> pdfClz = new HashMap();
        for (SysDict dict : dicts) {
            pdfClz.put(dict.getName(), dict);
        }

        List<PdClass> lev2Clz = pdClassDao.getPdClasses(2);
        //level 2
        Map<Long, CasRsp> lev2Map = new LinkedHashMap<>();
        for (PdClass clz : lev2Clz) {
//            if (!pdfClz.contains(clz.getName())) {
            lev2Map.put(clz.getId(), new CasRsp(clz.getShowName(), clz.getId().toString(), true));
//            }
        }

        List<PdClass> lev3Clz;
        if (pdInfoReq == null || pdInfoReq.isNull()) {
            lev3Clz = pdClassDao.getPdClasses(3);
        } else {
            lev3Clz = infoDao.getExtPdInfoMapper().listLev3Class(pdInfoReq);
        }
        Map<String, CasRsp> lev2_2Map = new LinkedHashMap<>();
        for (PdClass lev3 : lev3Clz) {
            CasRsp lev2 = lev2Map.get(lev3.getpId());
            //有2级并列分类的，现放2_2,再放3
            if (StringUtils.isNotBlank(lev3.getQaGp())) {
                String key = lev2.getValue() + "_" + lev3.getQaGp();
                CasRsp lev2_2 = lev2_2Map.get(key);
                if (lev2 != null) {
                    if (lev2_2 == null) {
                        lev2_2 = new CasRsp(lev3.getQaGp(), key, true);
                        lev2.getChildren().add(lev2_2);
                        lev2_2Map.put(key, lev2_2);
                    }
                    lev2_2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false));
                }
            } else {
                //无2级并列分类, 直接放3级分类
                if (pdfClz.containsKey(lev3.getName())) {
                    String file = pdfClz.get(lev3.getName()).getValue();
                    lev2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false, file));
                } else {
                    lev2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false));
                }
            }
        }
        //过滤掉没有子分类，或者子分类是打开文件类型的二级类目, 用于搜索页
        ArrayList<CasRsp> res = new ArrayList<>(lev2Map.values());
        //pdInfoReq为null，是首页打开，首页打开的不过滤
        if (pdInfoReq != null) {
            for (Iterator<CasRsp> i = res.iterator(); i.hasNext(); ) {
                CasRsp cas = i.next();
                for (Iterator<CasRsp> j = cas.getChildren().iterator(); j.hasNext(); ) {
                    CasRsp next = j.next();
                    if (CasRsp.OPERA_FILE.equals(next.getOpera())) {
                        j.remove();
                    }
                }
            }
            for (Iterator<CasRsp> i = res.iterator(); i.hasNext(); ) {
                CasRsp cas = i.next();
                if (cas.getChildren().size() == 0) {
                    i.remove();
                }
            }
        }
        return res;
    }

//    public List<PdClassRsp> listManualTop2() {
//        List<SysDict> dicts = dictDao.listByType("应用指南");
//        List<PdClassRsp> rsp = new ArrayList<>();
//        if (dicts.size() > 0) {
//            PdClassRsp lev1 = new PdClassRsp(-1L, "应用指南", dicts.get(0).getDescription());
//            PdClassRsp lev2 = new PdClassRsp(-2L, "应用指南", dicts.get(0).getDescription());
//            rsp.add(lev1);
//            lev1.getChildren().add(lev2);
//        }
//        return rsp;
//    }

    public List<CasRsp> listManual() {
        List<SysDict> dicts = dictDao.listByType("应用指南");
        List<CasRsp> rsp = new ArrayList<>();
        for (SysDict dict : dicts) {
            rsp.add(new CasRsp(dict.getName(), dict.getName(), false, dict.getValue()));
        }
        return rsp;
    }

//    public List<CasRsp> listPdClass(PdInfoReq pdInfoReq) {
//        List<CasRsp> rsp = new ArrayList<>();
//        List<PdClass> pdClasses = pdClassDao.getPdClasses(2);
//        //level 2
//        Map<Long, PdClass> pdMap = new HashMap<>();
//        for (PdClass clz : pdClasses) {
//            if (clz.getLevel() == 2) {
//                rsp.add(new CasRsp(clz.getShowName(), clz.getId().toString(), true));
//                pdMap.put(clz.getId(), clz);
//            }
//        }
//
//        //level 3
//        List<PdClassQaVo> qas;
//        if (pdInfoReq == null || pdInfoReq.isNull()){
//            qas = pdClassDao.getExtClassMapper().listClass();
//        }else{
//            qas = infoDao.getExtPdInfoMapper().listClass(pdInfoReq);
//        }
//        for (CasRsp lev2 : rsp) {
//            //电容器 有3级
////            if (pdMap.get(Long.valueOf(lev2.getValue())).getpId() == 1000) {
//                Map<String, CasRsp> map = new HashMap<>();
//                for (PdClassQaVo qa : qas) {
//                    if (qa.getPId().toString().equals(lev2.getValue())) {
//                        String value = lev2.getValue() + "_" + qa.getQaGp();
//                        CasRsp lev3 = map.get(value);
//                        if (lev3 == null) {
//                            lev3 = new CasRsp(qa.getQaGp(), value, true);
//                            lev2.getChildren().add(lev3);
//                            map.put(value, lev3);
//                        }
//                        lev3.getChildren().add(new CasRsp(qa.getName(), qa.getPdClassId() + "__" + qa.getQaCodes(), false));
//                    }
//                }
////            }else{
////                //滤波器有2级
////                for (PdClassQaVo qa : qas) {
////                    if (qa.getPdClassId().toString().equals(lev2.getValue())) {
////                        lev2.getChildren().add(new CasRsp(qa.getQaGp(), qa.getPdClassId() + "__" + qa.getQaCodes(), false));
////                    }
////                }
////            }
//        }
//
//        for(Iterator<CasRsp> i = rsp.iterator(); i.hasNext();){
//            CasRsp cas = i.next();
//            if (cas.getChildren().size() == 0){
//                i.remove();
//            }
//        }
//        return rsp;
//    }
}
