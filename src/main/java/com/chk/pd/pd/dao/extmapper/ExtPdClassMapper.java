package com.chk.pd.pd.dao.extmapper;

import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.vo.PdClassQaVo;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtPdClassMapper {
    @Deprecated
    public List<PdClassQaVo> listClass();
    public List<PdClass> NextLevel(String id);

}
