package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysRoleMapper {
    int countByExample(TSysRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(TSysRole record);

    int insertSelective(TSysRole record);

    List<TSysRole> selectByExample(TSysRoleExample example);

    TSysRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") TSysRole record, @Param("example") TSysRoleExample example);

    int updateByExample(@Param("record") TSysRole record, @Param("example") TSysRoleExample example);

    int updateByPrimaryKeySelective(TSysRole record);

    int updateByPrimaryKey(TSysRole record);
}