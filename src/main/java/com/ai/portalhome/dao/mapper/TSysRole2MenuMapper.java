package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TSysRole2Menu;
import com.ai.portalhome.dao.model.TSysRole2MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysRole2MenuMapper {
    int countByExample(TSysRole2MenuExample example);

    int deleteByPrimaryKey(Integer rmId);

    int insert(TSysRole2Menu record);

    int insertSelective(TSysRole2Menu record);

    List<TSysRole2Menu> selectByExample(TSysRole2MenuExample example);

    TSysRole2Menu selectByPrimaryKey(Integer rmId);

    int updateByExampleSelective(@Param("record") TSysRole2Menu record, @Param("example") TSysRole2MenuExample example);

    int updateByExample(@Param("record") TSysRole2Menu record, @Param("example") TSysRole2MenuExample example);

    int updateByPrimaryKeySelective(TSysRole2Menu record);

    int updateByPrimaryKey(TSysRole2Menu record);
}