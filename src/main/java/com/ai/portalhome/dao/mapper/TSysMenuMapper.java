package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.dao.model.TSysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysMenuMapper {
    int countByExample(TSysMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(TSysMenu record);

    int insertSelective(TSysMenu record);

    List<TSysMenu> selectByExample(TSysMenuExample example);

    TSysMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") TSysMenu record, @Param("example") TSysMenuExample example);

    int updateByExample(@Param("record") TSysMenu record, @Param("example") TSysMenuExample example);

    int updateByPrimaryKeySelective(TSysMenu record);

    int updateByPrimaryKey(TSysMenu record);
}