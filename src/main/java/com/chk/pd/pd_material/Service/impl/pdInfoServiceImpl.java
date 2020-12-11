package com.chk.pd.pd_material.Service.impl;

import com.chk.pd.pd.dao.PdClassDao;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Service.pdInfoService;
import com.chk.pd.pd_material.dao.dao.ClassMaterialTypeDao;
import com.chk.pd.pd_material.dao.dao.pdInfoMaterialDao;
import com.chk.pd.pd_material.domain.ClassMaterialType;
import com.chk.pd.pd_material.domain.PdInfoMaterial;
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

    @Override
    public List<PdInfoMaterial> getMaterial() {
        return null;
    }

    @Override
    public List<PdInfoMaterial> List() {
        return materialDao.getExmaterialMapper().List();
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
                TreeRsp cmrsp= new TreeRsp(r1.getClassName(),r1.getClassId().toString(),false);
                res.add(cmrsp);
            }
        }
        for( ClassMaterialType cm:CMT){
            for(TreeRsp pclass:res){
              if( pclass.getTitle().equals(cm.getClassName())){
                  TreeRsp  child= new TreeRsp(cm.getDes(),cm.getMaterialType()+"_"+cm.getMaterialType2(),false);
                  List<TreeRsp> childs=pclass.getChildren();
                 if(childs==null){
                     pclass.setChild(true);
                 }
                 childs=pclass.getChildren();
                 childs.add(child);
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
