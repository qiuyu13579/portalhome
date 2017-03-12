package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.dao.model.TLoColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoColumnMapper {
    int countByExample(TLoColumnExample example);

    int deleteByPrimaryKey(Integer colId);

    int insert(TLoColumn record);

    int insertSelective(TLoColumn record);

    List<TLoColumn> selectByExample(TLoColumnExample example);

    TLoColumn selectByPrimaryKey(Integer colId);

    int updateByExampleSelective(@Param("record") TLoColumn record, @Param("example") TLoColumnExample example);

    int updateByExample(@Param("record") TLoColumn record, @Param("example") TLoColumnExample example);

    int updateByPrimaryKeySelective(TLoColumn record);

    int updateByPrimaryKey(TLoColumn record);
}