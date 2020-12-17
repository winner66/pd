package com.chk.pd.pd.service;

import com.chk.pd.pd.PdClassVo;
import com.chk.pd.pd.dao.PdClassDao;
import com.chk.pd.pd.dao.PdInfoDao;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdClassRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.dao.pdInfoMaterialDao;
import com.chk.pd.pd_microware.Dao.pdInfoMicrowareDao;
import com.chk.pd.pd_microware.Dto.microwareRsp;
import com.chk.pd.pub.dao.SysDictDao;
import com.chk.pd.pub.domain.SysDict;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@SuppressWarnings("all")
public class PdClassService {

    @Autowired
    private PdInfoDao infoDao;
    @Autowired
    private pdInfoMaterialDao materialDao;

//    @Autowired
//    private pdInfoMicrowareDao microwareDao;
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
//                   在目錄下打開文件 file
                    for (SysDict dict : dicts) {
                        if (clz.getName().equals(dict.getName())) {
                            cr.setOpera(PdClassRsp.OPERA_FILE);
                            cr.setFileUrl(dict.getValue());
                        }
                    }

//                    沒有質量等級

                }
            }
        }
        return vos;
    }

    public List<CasRsp> listAllPdClass(PdInfoReq pdInfoReq) {
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
    public List<CasRsp> listPdClass(PdInfoReq pdInfoReq) {
        List<SysDict> dicts = dictDao.listByType("打开PDF的产品分类");

        Map<String, SysDict> pdfClz = new HashMap();
        for (SysDict dict : dicts) {
            pdfClz.put(dict.getName(), dict);
        }


        List<PdClass> lev2Clz = pdClassDao.getPdClasses(2);
        //level 2
        Long id1=1L,id2=2L;
        Map<Long, CasRsp> lev2Map = new LinkedHashMap<>();
        for (PdClass clz : lev2Clz) {
            if (clz.getpId()==id1||clz.getpId()==id2) {
            lev2Map.put(clz.getId(), new CasRsp(clz.getShowName(), clz.getId().toString(), true));
            }
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
            if(lev2!=null){
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


    public List<CasRsp> listMaterialPdClass(materialRsp pdInfoReq) {
        List<SysDict> dicts = dictDao.listByType("打开PDF的产品分类");
//        材料器件id
        Long id=3L;
        Map<String, SysDict> pdfClz = new HashMap();
        for (SysDict dict : dicts) {
            pdfClz.put(dict.getName(), dict);
        }

        List<PdClass> lev2Clz = pdClassDao.getPdClasses(2);
        //level 2
        Map<Long, CasRsp> lev2Map = new LinkedHashMap<>();
        for (PdClass clz : lev2Clz) {
            if (clz.getpId()==id) {
            lev2Map.put(clz.getId(), new CasRsp(clz.getShowName(), clz.getId().toString(), true));
            }
        }

        List<PdClass> lev3Clz;
        if (pdInfoReq == null || pdInfoReq.isNull()) {
            lev3Clz = pdClassDao.getPdClasses(3);
        } else {
            lev3Clz = materialDao.getExmaterialMapper().listLev3Class(pdInfoReq);
        }
        Map<String, CasRsp> lev2_2Map = new LinkedHashMap<>();
        for (PdClass lev3 : lev3Clz) {
            CasRsp lev2 = lev2Map.get(lev3.getpId());
            if(lev2!=null){
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

//    public List<CasRsp> listMicrowarePdClass(microwareRsp pdInfoReq) {
//        List<SysDict> dicts = dictDao.listByType("打开PDF的产品分类");
//
//        Map<String, SysDict> pdfClz = new HashMap();
//        for (SysDict dict : dicts) {
//            pdfClz.put(dict.getName(), dict);
//        }
//
////        微波id
//        Long id=4L;
//        List<PdClass> lev2Clz = pdClassDao.getPdClasses(2);
//        //level 2
//        Map<Long, CasRsp> lev2Map = new LinkedHashMap<>();
//        for (PdClass clz : lev2Clz) {
//            if (id==clz.getpId()) {
//            lev2Map.put(clz.getId(), new CasRsp(clz.getShowName(), clz.getId().toString(), true));
//            }
//        }
//
//        List<PdClass> lev3Clz;
//        if (pdInfoReq == null || pdInfoReq.isNull()) {
//            lev3Clz = pdClassDao.getPdClasses(3);
//        } else {
//            lev3Clz = microwareDao.getExtPdInfoMapper().listLev3Class(pdInfoReq);
//        }
//        Map<String, CasRsp> lev2_2Map = new LinkedHashMap<>();
//        for (PdClass lev3 : lev3Clz) {
//            CasRsp lev2 = lev2Map.get(lev3.getpId());
//           if(lev2!=null){
    //            //有2级并列分类的，现放2_2,再放3
//            if (StringUtils.isNotBlank(lev3.getQaGp())) {
//                String key = lev2.getValue() + "_" + lev3.getQaGp();
//                CasRsp lev2_2 = lev2_2Map.get(key);
//                if (lev2 != null) {
//                    if (lev2_2 == null) {
//                        lev2_2 = new CasRsp(lev3.getQaGp(), key, true);
//                        lev2.getChildren().add(lev2_2);
//                        lev2_2Map.put(key, lev2_2);
//                    }
//                    lev2_2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false));
//                }
//            } else {
//                //无2级并列分类, 直接放3级分类
//                if (pdfClz.containsKey(lev3.getName())) {
//                    String file = pdfClz.get(lev3.getName()).getValue();
//                    lev2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false, file));
//                } else {
//                    lev2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false));
//                }
//            }
//           }

//        }
//        //过滤掉没有子分类，或者子分类是打开文件类型的二级类目, 用于搜索页
//        ArrayList<CasRsp> res = new ArrayList<>(lev2Map.values());
//        //pdInfoReq为null，是首页打开，首页打开的不过滤
//        if (pdInfoReq != null) {
//            for (Iterator<CasRsp> i = res.iterator(); i.hasNext(); ) {
//                CasRsp cas = i.next();
//                for (Iterator<CasRsp> j = cas.getChildren().iterator(); j.hasNext(); ) {
//                    CasRsp next = j.next();
//                    if (CasRsp.OPERA_FILE.equals(next.getOpera())) {
//                        j.remove();
//                    }
//                }
//            }
//            for (Iterator<CasRsp> i = res.iterator(); i.hasNext(); ) {
//                CasRsp cas = i.next();
//                if (cas.getChildren().size() == 0) {
//                    i.remove();
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 查询某class下所有的class
     * @param id
     * @return
     */
    public List<PdClass>  listClass(Long id){
        List<PdClass> pdClasses =  this.list(id);
        List<PdClass> resulet =this.list(id);
        for (PdClass pd:pdClasses             ) {
            List<PdClass> chil= this.list2(pd.getId());
            resulet.addAll(chil);
        }
        return resulet;
//
    }
    //    查询一级class所有的子class（页）  (得到三级class)
    public List<PdClass> list(Long id) {
        PdClass Class = pdClassDao.getPdClassMapper().selectByPrimaryKey(id);

        List<PdClass> pdClasses = pdClassDao.getExtClassMapper().list();
        List<PdClass> resulet = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for (PdClass pdClass : pdClasses) {
            if (pdClass.getLevel() == 2&&pdClass.getpId()==id) {
                set.add(pdClass.getId());
            }
        }
        for (PdClass pdClass : pdClasses) {
            if (pdClass.getLevel() == 3&&set.contains(pdClass.getpId())) {
                resulet.add(pdClass);
            }
        }
        return resulet;
    }

    //    查询二级class所有的子class（页）
    public List<PdClass> list2(Long id) {
        PdClass Class = pdClassDao.getPdClassMapper().selectByPrimaryKey(id);
        List<PdClass> pdClasses = pdClassDao.getExtClassMapper().list();
        List<PdClass> resulet = new ArrayList<>();
        Set<Long> set = new HashSet<>();

        for (PdClass pdClass : pdClasses) {
            if (pdClass.getLevel() == 3&&pdClass.getpId()==id) {
                resulet.add(pdClass);
            }
        }
        return resulet;
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



//    v2
    public List<CasRsp> listPdClassV2(PdInfoReq pdInfoReq) {
    List<SysDict> dicts = dictDao.listByType("打开PDF的产品分类");

    Map<String, SysDict> pdfClz = new HashMap();
    for (SysDict dict : dicts) {
        pdfClz.put(dict.getName(), dict);
    }


    List<PdClassVo> clz1 = getClassVo();
    Map<Long, String> lev1Map = new LinkedHashMap<>();
        for(PdClassVo c1: clz1){
            lev1Map.put(Long.valueOf(c1.getId()),c1.getName());
        }
    List<PdClass> lev2Clz = pdClassDao.getPdClasses(2);

    //level 2
    Map<Long, CasRsp> lev2Map = new LinkedHashMap<>();

    for (PdClass c2 : lev2Clz) {

                if(hasNextLevel(c2.getId().toString())|| (c2.getQaGp()!=null && StringUtils.isNotBlank(c2.getQaGp()))){
//                    有三级--或者有--同等
                    lev2Map.put(c2.getId(), new CasRsp(c2.getShowName(), c2.getId().toString(), true));
                }else{
//                    没有
                    lev2Map.put(c2.getId(), new CasRsp(c2.getShowName(), c2.getId().toString(), false,CasRsp.OPERA_dir,lev1Map.get(c2.getpId())));
                }



    }

    List<PdClass> lev3Clz;
    if (pdInfoReq == null || pdInfoReq.isNull()) {
        lev3Clz = pdClassDao.getPdClasses(3);
    } else {
        lev3Clz = infoDao.getExtPdInfoMapper().listLev3Class(pdInfoReq);
    }
    Map<String, CasRsp> lev2_2Map = new LinkedHashMap<>();

//    在第三级找二级
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
        } else  {
            //无2级并列分类, 直接放3级分类  如果第三级在字典中-》放file
            if (pdfClz.containsKey(lev3.getName())) {
                String file = pdfClz.get(lev3.getName()).getValue();
                lev2.getChildren().add(new CasRsp(lev3.getShowName(), lev3.getId().toString(), false, file));
            } else {
//
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
    public List<PdClassRsp> getClzTop2V2() {
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
//
                    PdClassRsp cr = new PdClassRsp(clz);
                    vo.getChildren().add(cr);
                    if(!hasNextLevel(clz.getId().toString())){
                        cr.setOpera(PdClassRsp.OPERA_dir);
                    }
//                   在目錄下打開文件 file
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
    public boolean hasNextLevel(String pid){
        boolean res= false;
       List<PdClass> pdclass= pdClassDao.getExtClassMapper().NextLevel(pid);
       if(pdclass!=null&&pdclass.size()>0){
           res=true;
       }
       return res;
    }

    public    List<PdClassVo> getClassVo(){
        List<PdClass> lev1Clz = pdClassDao.getPdClasses(1);

        //level 1
        List<PdClassVo> res= new ArrayList<>();
        for (PdClass clz : lev1Clz) {
            PdClassVo e=new PdClassVo(clz.getId().toString(),clz.getName());
            res.add(e);
        }
        return res;
    }



}
