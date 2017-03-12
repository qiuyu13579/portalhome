package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TLoColumnData;
import com.ai.portalhome.dao.model.TLoColumnDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoColumnDataMapper {
    int countByExample(TLoColumnDataExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(TLoColumnData record);

    int insertSelective(TLoColumnData record);

    List<TLoColumnData> selectByExample(TLoColumnDataExample example);

    TLoColumnData selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") TLoColumnData record, @Param("example") TLoColumnDataExample example);

    int updateByExample(@Param("record") TLoColumnData record, @Param("example") TLoColumnDataExample example);

    int updateByPrimaryKeySelective(TLoColumnData record);

    int updateByPrimaryKey(TLoColumnData record);
}