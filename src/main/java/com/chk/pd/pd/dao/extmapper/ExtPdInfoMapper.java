package com.chk.pd.pd.dao.extmapper;

import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.vo.PdClassQaVo;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExtPdInfoMapper {
    public List<PdInfoRsp> getPdInfos(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<PdParam> listQuality(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<PdParam> listSize(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<PdParam> listVoltage(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<PdParam> listTemperature(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<String> listTolerance(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<String> listOutlet(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<Map<Integer, Integer>> listCapacity(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    @Deprecated
    public List<PdClassQaVo> listClass(@Param("pdInfoReq") PdInfoReq pdInfoReq);

    public List<PdClass> listLev3Class(@Param("pdInfoReq") PdInfoReq pdInfoReq);
}