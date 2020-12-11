package com.chk.pd.pd_material.utils;

import com.chk.pd.pd_material.domain.PdInfoMaterial;
import com.chk.pd.pd_material.entity.*;
import com.chk.pd.pd_material.Enum.materialTypeEnum;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pdInfoMaterialToMaterialType  {

    Map<String,List<baseMaterialEntiey>> converToMaterialType(List<PdInfoMaterial> Materials){
        Map<String,List< baseMaterialEntiey>>  res= new HashMap<>();

        List<PDCSInfoEntity> cs= new ArrayList<>();
        List<PDHKJBPFInfoEntity> jbpf= new ArrayList<>();
          List<PDHKLLPFInfoEntity> llpf=  new ArrayList<>();
          List<PDJLTCInfoEntity> jltc=  new ArrayList<>();
          List<PDPorcelainInfoEntity> porcelain= new ArrayList<>();
          List<PDRawPorcelainWithInfoEntity> rawPorcelainWith=  new ArrayList<>();
          List<PDSizingMaterialInfoEntity> sizingMaterial=  new ArrayList<>();

        for(PdInfoMaterial Material:Materials){

            if(Material.getMaterialType().equals(materialTypeEnum.LTCC.value())){
                llpf.add(converToHKLLPF(Material));
            }
            else if(Material.getMaterialType().equals(materialTypeEnum.JBPF.value())){
                jbpf.add(converToHKJBPF(Material));
            }
            else if(Material.getMaterialType().equals(materialTypeEnum.CS.value())){
                cs.add(converToCS(Material));
            }
            else if(Material.getMaterialType().equals(materialTypeEnum.Porcelain.value())){
                porcelain.add(converToPorcelain(Material));
            }
            else if(Material.getMaterialType().equals(materialTypeEnum.JLTC.value())){
                jltc.add(converToHKJLTC(Material));
            }
            else if(Material.getMaterialType().equals(materialTypeEnum.RawPorcelainWith.value())){
                rawPorcelainWith.add(converToRawPorcelainWith(Material));
            }
            else if(Material.getMaterialType().equals(materialTypeEnum.SizingMaterial.value())){
                    sizingMaterial.add(converToSizingMaterial(Material));
            }else{

            }
        }


//        buff?
//        res.put(materialTypeEnum.SizingMaterial.title(),sizingMaterial);
//        res.put(materialTypeEnum.CS.title(),cs);
        return  res;
    }
    PDCSInfoEntity converToCS(PdInfoMaterial material){
        PDCSInfoEntity cs= new PDCSInfoEntity();
        try {
            BeanUtils.copyProperties(cs,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  cs;
    }
    PDHKLBPFInfoEntity converToHKLBPF(PdInfoMaterial material){
        PDHKLBPFInfoEntity res= new  PDHKLBPFInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDHKLLPFInfoEntity converToHKLLPF(PdInfoMaterial material){
        PDHKLLPFInfoEntity res= new  PDHKLLPFInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDHKLHPFInfoEntity converToHKLHPF(PdInfoMaterial material){
        PDHKLHPFInfoEntity res= new PDHKLHPFInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDJLTCInfoEntity  converToHKJLTC(PdInfoMaterial material){
        PDJLTCInfoEntity  res= new PDJLTCInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDHKJBPFInfoEntity converToHKJBPF(PdInfoMaterial material){
        PDHKJBPFInfoEntity res= new PDHKJBPFInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDPorcelainInfoEntity  converToPorcelain(PdInfoMaterial material){
        PDPorcelainInfoEntity res= new PDPorcelainInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDRawPorcelainWithInfoEntity converToRawPorcelainWith(PdInfoMaterial material){
        PDRawPorcelainWithInfoEntity res= new PDRawPorcelainWithInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }
    PDSizingMaterialInfoEntity converToSizingMaterial(PdInfoMaterial material){
        PDSizingMaterialInfoEntity res= new PDSizingMaterialInfoEntity();
        try {
            BeanUtils.copyProperties(res,material);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  res;
    }





}
