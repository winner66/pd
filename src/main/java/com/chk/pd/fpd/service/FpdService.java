package com.chk.pd.fpd.service;

import com.chk.pd.common.util.StringUtil;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.fpd.dao.FpdDao;
import com.chk.pd.fpd.dao.FpdSeriesDao;
import com.chk.pd.fpd.domain.FpdMap;
import com.chk.pd.fpd.domain.FpdModel;
import com.chk.pd.fpd.domain.FpdSeries;
import com.chk.pd.fpd.vo.FpdModelRsp;
import com.chk.pd.fpd.vo.FpdReq;
import com.chk.pd.fpd.vo.FpdRsp;
import com.chk.pd.common.vo.PageReq;

import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.service.PdInfoService;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.common.util.OrderRuleUtil;
import com.chk.pd.pd.vo.PdInfoReqFuzzyByIn;
import com.chk.pd.pd.vo.TableRsp;
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

    @Autowired
    private FpdSeriesDao fpdSeriesDao;

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
        Map<String, List<String>> maps = new HashMap();
        Map<String, Integer> mapsNum = new HashMap();
        for (FpdMap fpdMap : fpdMaps) {
            String key=fpdMap.getFcode().toUpperCase();
            if(maps.containsKey(key)){
                List<String> list= maps.get(key);
                String code=fpdMap.getCode().toUpperCase();
                list.add(code);
                maps.put(key, list);
                mapsNum.put(key, mapsNum.get(key)+1);
            }else{
                List<String> list= new LinkedList<>();
                String code=fpdMap.getCode().toUpperCase();
                list.add(code);
                maps.put(key, list);
                mapsNum.put(key, 1);
            }
        }

        PdInfoReq pdInfoReq = new PdInfoReq();
        PdInfoReqFuzzyByIn pdInfoReqFuzzyByIn = new PdInfoReqFuzzyByIn();
        String fpdCode = fpdReq.getCode().toUpperCase();
        boolean search = false;
        for (String rule : rules) {
            Integer pos = rp.get(rule);
            Integer bit = rb.get(rule);
            String fcode = getFcode(fpdCode, pos, bit);
            if(mapsNum.get(fcode)>1){
//                模糊查询 in
//                pdInfoReqFuzzyByIn.setTemperature(maps.get(fcode));
               List<String> code= maps.get(fcode);
                if (ParamType.model.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setModelCode(code);
                } else if (ParamType.voltage.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setVoltage(code);
                } else if (ParamType.size.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setSize(code);
                } else if (ParamType.temperature.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setTemperature(code);
                } else if (ParamType.quality.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setQuality(code);
//                    暂时不用 电容大小
                } else if (ParamType.tolerance.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setTolerance(code);
                } else if (ParamType.outlet.value().equals(rule)) {
                    search = true;
                    pdInfoReqFuzzyByIn.setOutlet(code);
                }

            }
            else if(mapsNum.get(fcode)==1){
                String code= maps.get(fcode).get(0);
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

    public List<CasRsp>  getFTree(){
        List<FpdSeries>  fpdSeriesList  = fpdSeriesDao.getSeriesMapper().getList();
        Map<Long,FpdSeries> fpdSeriesMap =new HashMap<>();
        Map<String, CasRsp> lev2Map = new LinkedHashMap<>();

        Map<String,String>  mapLev2= new HashMap<>();
        Map<String,String>  mapLev3= new HashMap<>();

        Set<String> factorySet= new HashSet<>();

        for (FpdSeries series :fpdSeriesList) {
            factorySet.add(series.getfFactorys());
            fpdSeriesMap.put(Long.valueOf(series.getId()),series);
//            有bug(相同的系列可能对于着多个厂家)（多对多模式）
//            mapLev2.put()
        }

        for (String str :factorySet){
            for (FpdSeries series :fpdSeriesList) {
                if(series.getfFactorys().equals(str)){
//                    厂
                    lev2Map.put(series.getfFactorys(),new CasRsp(series.getfFactorys(),series.getId().toString(),true));
                }
            }
        }
//        厂系列
        for (FpdSeries series :fpdSeriesList) {
            String  indexFactorys= series.getfFactorys();
            if(mapLev2.containsKey(series.getfSeries())){
                String  value= mapLev2.get(series.getfSeries());
                if(value.equals(indexFactorys)){
//                    排除同一个系列对应相同的工厂
                    continue;
                }
            }
            CasRsp lev2Factorys = lev2Map.get(indexFactorys);

            mapLev2.put(series.getfSeries(),indexFactorys);
            if(indexFactorys.equals(lev2Factorys.getLabel())){
                lev2Factorys.getChildren().add(new CasRsp(series.getfSeries(),series.getId().toString(), true));
            }
        }
//        放入宏科系列  (必须确保  同一国外系列下面的对应的宏科产品系列不同（HKSeries）)
        for (FpdSeries series :fpdSeriesList) {
            String  fSeries= series.getfSeries();
            String HKSeries= series.getHkSeries();
            String Factorys= series.getfFactorys();
            CasRsp lev2 = lev2Map.get(Factorys);

            List<CasRsp >lev3List = lev2.getChildren();
            for (CasRsp lev3: lev3List){
               if( lev3.getLabel().equals(fSeries)){
                   Map<String,List<TableRsp>> data= new HashMap<>();
//                   封装数据
                  data= buildData(series,data);
                  CasRsp tem= new CasRsp(HKSeries,series.getId().toString(), false,data);
                  StringBuffer str =new StringBuffer("(");

                  if(series.getSize()!=""&&series.getSize()!=null){
                      str=str.append(series.getSize()+" ");
                  }
//                   if(series.getElecCode()!=""&&series.getElecCode()!=null){
//                       str=str.append(series.getElecCode()+" ");
//                   }
                   if(series.getVoltage()!=""&&series.getVoltage()!=null){
                       str=str.append(series.getVoltage()+" ");
                   }
                   if(series.getTolerance()!=""&&series.getTolerance()!=null){
                       str=str.append(series.getTolerance()+" ");
                   }
                   if(series.getOutlet()!=""&&series.getOutlet()!=null){
                       str=str.append(series.getOutlet()+" ");
                   }
                   if(series.getSocStr()!=""&&series.getSocStr()!=null){
                       str=str.append(series.getSocStr()+" ");
                   }
                   if(series.getTemperature()!=""&&series.getTemperature()!=null){
                       str=str.append(series.getTemperature()+" ");
                   }
                   str=str.append(")");
                   if("()".equals(str.toString())){
                       tem.setDes(" ");
                   }else{
                       tem.setDes(str.toString());
                   }
                  tem.setData(data);
                   lev3.getChildren().add(tem);
               }
            }
        }
        ArrayList<CasRsp> res = new ArrayList<>(lev2Map.values());
        return res;
    }


    public  FpdSeries getFpdSeries(Integer id){
         FpdSeries fpdSeries= fpdSeriesDao.getSeriesMapper().selectByPrimaryKey(id);
         return  fpdSeries;
    }

    public   List<FpdSeries>  getAllFpdSeries(){
        List<FpdSeries> fpdSeries= fpdSeriesDao.getSeriesMapper().getList();
        return  fpdSeries;
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

    private Map<String,List<TableRsp>> buildData(FpdSeries  series,Map<String,List<TableRsp>> data){

        data.put("key", buildTableRsp(series.getHkSeries()," "));
        //            引出端形式
        if(series.getOutlet()!=null && series.getOutlet()!=""){

            data.put("outlet",buildTableRsp(series.getOutlet(),";"));
//温度特性
        }
        if(series.getTemperature()!=null&& series.getTemperature()!=""){
            data.put("temperature",buildTableRsp(series.getTemperature(),";"));

        }
        //尺寸
        if(series.getSize()!=null && series.getSize()!=""){
//            System.out.println("size:--------"+series.getSize());
            data.put("size",buildTableRsp(series.getSize(),";"));

        }
        if(series.getTolerance()!=null && series.getTolerance()!=""){
            data.put("tolerance",buildTableRsp(series.getTolerance(),";"));

        }
        //            电压用；分割
        if(series.getVoltage()!=null&& series.getVoltage()!=""){
            data.put("voltage",buildTableRsp(series.getVoltage(),";"));

        }
        if(series.getSocStr()!=null && series.getSocStr()!=""){

            data.put("socStr",buildTableRsp(series.getSocStr(),";"));
        }
        //        电极材料代码  用，分割
        if(series.getElecCode()!=null&&series.getElecCode()!=""){
            data.put("eleCode",buildTableRsp(series.getElecCode(),";"));
        }
        return  data;

    }
     List<TableRsp>buildTableRsp(String str,String spa){
        String strs[]= str.split(spa);
        List<TableRsp> rsp= new ArrayList<>();
         for (String item: strs
              ) {
             TableRsp  table= new TableRsp(item,item);
            rsp.add(table);

         }
        return  rsp;
    }
}
