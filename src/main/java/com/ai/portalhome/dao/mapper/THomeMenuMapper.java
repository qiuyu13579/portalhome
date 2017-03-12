package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.THomeMenu;
import com.ai.portalhome.dao.model.THomeMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THomeMenuMapper {
    int countByExample(THomeMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(THomeMenu record);

    int insertSelective(THomeMenu record);

    List<THomeMenu> selectByExample(THomeMenuExample example);

    THomeMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") THomeMenu record, @Param("example") THomeMenuExample example);

    int updateByExample(@Param("record") THomeMenu record, @Param("example") THomeMenuExample example);

    int updateByPrimaryKeySelective(THomeMenu record);

    int updateByPrimaryKey(THomeMenu record);
}