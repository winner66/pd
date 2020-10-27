package com.chk.pd.cm.dao.mapper;

import com.chk.pd.cm.domain.CmContact;
import com.chk.pd.cm.domain.CmContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CmContactMapper {
    long countByExample(CmContactExample example);

    int deleteByExample(CmContactExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmContact record);

    int insertSelective(CmContact record);

    List<CmContact> selectByExampleWithRowbounds(CmContactExample example, RowBounds rowBounds);

    List<CmContact> selectByExample(CmContactExample example);

    CmContact selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmContact record, @Param("example") CmContactExample example);

    int updateByExample(@Param("record") CmContact record, @Param("example") CmContactExample example);

    int updateByPrimaryKeySelective(CmContact record);

    int updateByPrimaryKey(CmContact record);
}