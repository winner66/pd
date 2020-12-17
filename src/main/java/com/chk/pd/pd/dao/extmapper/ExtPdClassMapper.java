package com.chk.pd.pd.dao.extmapper;

import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.vo.PdClassQaVo;
import java.util.List;

public interface ExtPdClassMapper {
    @Deprecated
    public List<PdClassQaVo> listClass();
    List<PdClass> list();
    public List<PdClass> NextLevel(String id);
    PdClass   getClassById(String id);

}
