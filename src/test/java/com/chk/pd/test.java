package com.chk.pd;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.pd.service.PdInfoService;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoReqFuzzyByIn;
import com.chk.pd.pd.vo.PdInfoRsp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class test {


    public static void main(String[] args) {
        PdInfoService infoService = new PdInfoService();
        PageReq page= new PageReq();
        PdInfoReqFuzzyByIn infoReq= new PdInfoReqFuzzyByIn();
        List<String> list=new LinkedList<>();
        list.add("NP");
        list.add("U");

        infoReq.setTemperature(list);
        List<PdInfoRsp>  pdinfos=infoService.getPdInfosByFuzzy(infoReq,page);
        for (PdInfoRsp rsp: pdinfos ) {
            System.out.println(rsp);

        }
    }


}
