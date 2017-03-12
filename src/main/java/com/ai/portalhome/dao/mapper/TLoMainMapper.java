package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TLoMain;
import com.ai.portalhome.dao.model.TLoMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoMainMapper {
    int countByExample(TLoMainExample example);

    int deleteByPrimaryKey(Integer olId);

    int insert(TLoMain record);

    int insertSelective(TLoMain record);

    List<TLoMain> selectByExample(TLoMainExample example);

    TLoMain selectByPrimaryKey(Integer olId);

    int updateByExampleSelective(@Param("record") TLoMain record, @Param("example") TLoMainExample example);

    int updateByExample(@Param("record") TLoMain record, @Param("example") TLoMainExample example);

    int updateByPrimaryKeySelective(TLoMain record);

    int updateByPrimaryKey(TLoMain record);
}