package com.chk.pd.pd_material.Service.impl;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.dao.PdClassDao;
import com.chk.pd.pd.dao.PdModelDao;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdInfo;
import com.chk.pd.pd.domain.PdModel;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.vo.PdDetailReq;
import com.chk.pd.pd.vo.PdDetailRsp;
import com.chk.pd.pd.vo.PdInfoRsp;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Dto.PdMaterialDetailRsp;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Dto.pdMaterialInfoVo;
import com.chk.pd.pd_material.Service.pdInfoService;
import com.chk.pd.pd_material.dao.ClassMaterialTypeDao;
import com.chk.pd.pd_material.dao.pdInfoMaterialDao;
import com.chk.pd.pd_material.domain.ClassMaterialType;
import com.chk.pd.pd_material.domain.PdInfoMaterial;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("pdMaterialInfoServiceImpl")
@SuppressWarnings("all")
public class pdInfoServiceImpl  implements pdInfoService {


    @Autowired
    public pdInfoMaterialDao materialDao;
    @Autowired
    private PdClassDao pdClassDao;

    @Autowired
    private ClassMaterialTypeDao classMaterialTypeDao;
    @Autowired
    private PdModelDao pdModelDao;

    @Autowired
    private PdParamDao pdParamDao;


    @Override
    public List<PdInfoMaterial> getMaterial() {
        return null;
    }

    @Override
    public List<PdInfoMaterial> List() {
        return materialDao.getExmaterialMapper().List();
    }

    @Override
    public List<pdMaterialInfoVo> getPdMaterialInfos(materialRsp pdInfoReq, PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());

        List<pdMaterialInfoVo> pdInfos = materialDao.getExmaterialMapper().getPdMaterialInfos(pdInfoReq);
//        for (pdMaterialInfoVo  pdInfo : pdInfos) {
//            pdInfo.setDesc(pdInfo.getPdInfoDesc());
//        }
        return pdInfos;
    }
    @Override
    public PdMaterialDetailRsp getPdMaterialDetail(PdDetailReq req){
        PdInfoMaterial    pdInfo = materialDao.getMaterialMapper().selectByPrimaryKey(Integer.valueOf(req.getId().toString()));

        PdModel pdModel = pdModelDao.getPdModelMapper().selectByPrimaryKey(Long.valueOf(pdInfo.getPdModelId()));
        PdClass pdClass = pdClassDao.getPdClassMapper().selectByPrimaryKey(pdModel.getPdClassId());
        PdParam size = pdParamDao.getSize(pdInfo.getStd(), pdInfo.getSize());
        PdParam quality = pdParamDao.getPdParam(ParamType.quality.value(), pdInfo.getQuality());

        PdMaterialDetailRsp detail = new PdMaterialDetailRsp(pdClass, pdModel, pdInfo, size, quality, req);
        return detail;

    }
//    LTCC class 下的所有的分类
    @Override
    public List<TreeRsp> getclz(){
        List<TreeRsp> res= new ArrayList<>();
        List<ClassMaterialType> CMT=classMaterialTypeDao.getExClassMaterialmapper().List();
        Set<String> setClass=new HashSet<>();

        for(ClassMaterialType r1: CMT){
            if(!setClass.contains(r1.getClassName())){
                setClass.add(r1.getClassName());
                TreeRsp cmrsp= new TreeRsp(r1.getClassName(),r1.getClassId().toString());
                res.add(cmrsp);
            }
        }
        for( ClassMaterialType cm:CMT){
            for(TreeRsp pclass:res){
              if( pclass.getLabel().equals(cm.getClassName())&&!"".equals(cm.getMaterialType2())&&cm.getMaterialType2()!=null){
                  TreeRsp  child= new TreeRsp(cm.getDes(),cm.getMaterialType()+"_"+cm.getMaterialType2(),false);
                  List<TreeRsp> childs=pclass.getChildren();
                 if(childs==null){
                     pclass.setChild(true);
                 }
                 childs=pclass.getChildren();
                 childs.add(child);
              }else if("".equals(cm.getMaterialType2())){

              }else{
//                  pclass.setHasChildren(false);
                }
            }

        }

        return  res;
    }


    public Map<Long,List<PdInfoMaterial>> get(){
        Map<Long,List<PdInfoMaterial>> res= new HashMap<>();
        List<ClassMaterialType> CMT=classMaterialTypeDao.getExClassMaterialmapper().List();
        return res;
    }


}
