package com.chk.pd;


import com.chk.pd.common.vo.PageReq;
import com.chk.pd.fpd.domain.FpdSeries;
import com.chk.pd.fpd.service.FpdService;
import com.chk.pd.pd.domain.PdInfo;
import com.chk.pd.pd.service.PdInfoService;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoReqFuzzyByIn;
import com.chk.pd.pd.vo.PdInfoRsp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PdApplication.class)
public class PdInfoServiceTest {

    @Autowired
    PdInfoService infoService;

    @Autowired
    FpdService fpdService;

    @Test
    public  void inTest(){
        PageReq page= new PageReq();
        PdInfoReq  infoReq= new PdInfoReq();
        List<String> list=new LinkedList<>();
        list.add("NP");
        list.add("U");

//        infoReq.set
         List<PdInfoRsp >  pdinfos=infoService.getPdInfos(infoReq,page);
        for (PdInfoRsp rsp: pdinfos ) {
            System.out.println(rsp);
        }
    }
    @Test
    public  void inTest2(){
        PageReq page= new PageReq();
        PdInfoReqFuzzyByIn infoReq= new PdInfoReqFuzzyByIn();
        List<String> list=new LinkedList<>();
        list.add("NV");
        list.add("E");
        infoReq.setTemperature(list);
        List<String> list2=new LinkedList<>();
        list2.add("100V");
        list2.add("500V");
        infoReq.setVoltage(list2);
        List<PdInfoRsp>  pdinfos=infoService.getPdInfosByFuzzy(infoReq,page);

        for (PdInfoRsp rsp: pdinfos ) {
            System.out.println(rsp);
            System.out.println("   ");
        }

        PdInfoReq pdInfoReq = new PdInfoReq();
        pdInfoReq.setVoltage("500V");
        List<PdInfoRsp>  pdinfos2=infoService.getPdInfos(pdInfoReq,page);

    }

    //    国外产品对应/**/
    @Test
    public  void  getFTree(){
        List<CasRsp>  lists=fpdService.getFTree();
        for (CasRsp cas: lists
             ) {
            System.out.println(cas);

        }
    }
    @Test
    public  void  getF(){
        FpdSeries lists=fpdService.getFpdSeries(30);
        System.out.println(lists);
    }

    @Test
    public  void  getpdInfo(){


    }


}
