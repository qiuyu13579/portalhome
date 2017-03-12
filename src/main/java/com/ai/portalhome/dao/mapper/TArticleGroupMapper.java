package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.dao.model.TArticleGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleGroupMapper {
    int countByExample(TArticleGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(TArticleGroup record);

    int insertSelective(TArticleGroup record);

    List<TArticleGroup> selectByExample(TArticleGroupExample example);

    TArticleGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") TArticleGroup record, @Param("example") TArticleGroupExample example);

    int updateByExample(@Param("record") TArticleGroup record, @Param("example") TArticleGroupExample example);

    int updateByPrimaryKeySelective(TArticleGroup record);

    int updateByPrimaryKey(TArticleGroup record);
}