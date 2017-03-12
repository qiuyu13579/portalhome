package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TSysRole2User;
import com.ai.portalhome.dao.model.TSysRole2UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysRole2UserMapper {
    int countByExample(TSysRole2UserExample example);

    int deleteByPrimaryKey(Integer ruId);

    int insert(TSysRole2User record);

    int insertSelective(TSysRole2User record);

    List<TSysRole2User> selectByExample(TSysRole2UserExample example);

    TSysRole2User selectByPrimaryKey(Integer ruId);

    int updateByExampleSelective(@Param("record") TSysRole2User record, @Param("example") TSysRole2UserExample example);

    int updateByExample(@Param("record") TSysRole2User record, @Param("example") TSysRole2UserExample example);

    int updateByPrimaryKeySelective(TSysRole2User record);

    int updateByPrimaryKey(TSysRole2User record);
}