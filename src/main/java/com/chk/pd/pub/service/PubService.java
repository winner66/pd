package com.chk.pd.pub.service;

import com.chk.pd.pub.dao.SysDictDao;
import com.chk.pd.pub.domain.SysDict;
import com.chk.pd.pub.vo.BannerRsp;
import com.chk.pd.pub.vo.DictVo;
import com.chk.pd.pub.vo.PdfRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PubService {

    @Autowired
    private SysDictDao dictDao;

    public List<BannerRsp> listBanner(){
        List<SysDict> banner = dictDao.listByType("banner");
        List<BannerRsp> rsp = new ArrayList<>();
        for (SysDict dict : banner) {
            rsp.add(new BannerRsp(dict));
        }
        return rsp;
    }

    public PdfRsp getPdf(){
        List<SysDict> pdf = dictDao.listByType("PDF文件");
        PdfRsp rsp = new PdfRsp();
        for (SysDict dict : pdf) {
            if ("公司介绍".equals(dict.getName())){
                rsp.setIntro(dict.getValue());
            }else if ("联系我们".equals(dict.getName())){
                rsp.setContact(dict.getValue());
            }
        }
        return rsp;
    }

    public List<DictVo> getOrderType(){
        List<SysDict> dicts = dictDao.listByType("清单类型");
        List<DictVo> vos = new ArrayList<>();
        for (SysDict dict : dicts) {
            vos.add(new DictVo(dict));
        }
        return vos;
    }

    public List<SysDict> listDict(String type){
        List<SysDict> dicts = dictDao.listByType(type);
        return dicts;
    }
}
