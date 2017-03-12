package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TCellGroup;
import com.ai.portalhome.dao.model.TCellGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCellGroupMapper {
    int countByExample(TCellGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(TCellGroup record);

    int insertSelective(TCellGroup record);

    List<TCellGroup> selectByExample(TCellGroupExample example);

    TCellGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") TCellGroup record, @Param("example") TCellGroupExample example);

    int updateByExample(@Param("record") TCellGroup record, @Param("example") TCellGroupExample example);

    int updateByPrimaryKeySelective(TCellGroup record);

    int updateByPrimaryKey(TCellGroup record);
}