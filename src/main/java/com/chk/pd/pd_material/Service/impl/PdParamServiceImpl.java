package com.chk.pd.pd_material.Service.impl;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.dao.PdParamDao;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.service.PdClassService;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoRsp;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Dto.pdMaterialInfoVo;
import com.chk.pd.pd_material.dao.pdInfoMaterialDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("MaterialParamInfoService")
public class PdParamServiceImpl {

    @Autowired
    private pdInfoMaterialDao materialDao;

    @Autowired
    private PdParamDao paramDao;

    @Autowired
    private PdClassService classService;

    @Autowired
    private pdInfoServiceImpl  materialService;



    public List<CasRsp> listQuality(materialRsp materRsp) {


        List<PdParam> params =  materialDao.getExmaterialMapper().listQuality(materRsp);

        List<CasRsp> rsp = new ArrayList<>();

        for (PdParam param : params) {
            if ("GJB".equals(param.getCode())){

                rsp.add(new CasRsp(param.getName() == null ? param.getCode() : param.getName(), param.getCode(), false));
            }else {
                rsp.add(new CasRsp(param.getName() == null ? "" + param.getCode() : param.getName() + " - " + param.getCode(), param.getCode(), false));
            }
        }
        return rsp;
    }

    public List<CasRsp> listSize(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listSize(materRsp);
//        Map<String, CasRsp> map = new LinkedHashMap<>();
//        for (PdParam param : params) {
//            CasRsp cas = map.get(param.getGp());
//            if (cas == null) {
//                cas = new CasRsp(param.getGp(), param.getGp(), true);
//                map.put(param.getGp(), cas);
//            }
//            cas.getChildren().add(new CasRsp(param.getCode(), param.getCode(), false));
//        }
//        return new ArrayList<>(map.values());
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
//            0805[长宽高] ：0805_12345
            cas.add(new CasRsp(param.getCode() + " [" + (param.getName() == null ? "" : param.getName()) + "]", param.getCode() + "_" + param.getId(), false));
        }
        return cas;
    }



    public List<CasRsp> listOutlet(materialRsp materRsp) {
        List<CasRsp> cas = new ArrayList<>();
        List<String> outlets =  materialDao.getExmaterialMapper().listOutlet(materRsp);
        Set<String> set = new HashSet<>();
        for (String outlet : outlets) {
            String[] ss = StringUtils.split(outlet, ";");
            for (String s : ss) {
                set.add(s);
            }
        }

        List<PdParam> params = paramDao.getPdParam(ParamType.outlet.value());
        for (PdParam param : params) {
            if (set.contains(param.getCode())) {
                String label = param.getCode() + " [" + (param.getName() == null ? "" :param.getName()) + "]";
                cas.add(new CasRsp(label, param.getCode(), false));
            }
        }
        return cas;
    }




    public List<CasRsp> listLengthWidthCode(materialRsp materRsp) {
        List<PdParam> params = materialDao.getExmaterialMapper().listLengthWidthCode(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listBandwidth(materialRsp materRsp) {
        List<PdParam> params = materialDao.getExmaterialMapper().listBandwidth(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listFrequencyRange(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listFrequencyRange(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listThicknessCode(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listThicknessCode(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listMaterialCode(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listMaterialCode(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
    public List<CasRsp> listSurfaceCode(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listSurfaceCode(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }   public List<CasRsp> listCenterFrequency(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listCenterFrequency(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }   public List<CasRsp> listCutOffFrequency(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listCutOffFrequency(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }   public List<CasRsp> listPassBandRange(materialRsp materRsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listPassBandRange(materRsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }


    public List<CasRsp> listPowerCapacity(materialRsp rsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listPowerCapacity(rsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listRipple(materialRsp rsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listRipple(rsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listPadMetallurgy(materialRsp rsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listPadMetallurgy(rsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }

    public List<CasRsp> listStd(materialRsp rsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listStd(rsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }

    public List<TreeRsp> listClass(materialRsp rsp) {
       return this.materialService.getclz();
    }

    public List<CasRsp> listModel(materialRsp rsp) {
        List<PdParam> params =  materialDao.getExmaterialMapper().listModel(rsp);
        List<CasRsp> cas = new ArrayList<>();
        for (PdParam param : params) {
            cas.add(new CasRsp(param.getName(), param.getCode(), false));
        }
        return cas;
    }
}
