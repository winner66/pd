package com.chk.pd.pd.dao;


import com.chk.pd.pd.domain.PdModel;
import com.chk.pd.pd.domain.PdModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.chk.pd.pd.dao.mapper.PdModelMapper;
import java.util.List;

@Repository
public class PdModelDao {

    @Autowired
    private  PdModelMapper pdModelMapper;

    public PdModelMapper getPdModelMapper() {
        return pdModelMapper;
    }

    public List<PdModel> getAll(){
        PdModelExample exp = new PdModelExample();
        exp.setOrderByClause("idx asc limit 0, 1000");
        return pdModelMapper.selectByExample(exp);
    }
}
