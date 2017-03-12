package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TArticleGroup2Car;
import com.ai.portalhome.dao.model.TArticleGroup2CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleGroup2CarMapper {
    int countByExample(TArticleGroup2CarExample example);

    int deleteByPrimaryKey(Integer gcId);

    int insert(TArticleGroup2Car record);

    int insertSelective(TArticleGroup2Car record);

    List<TArticleGroup2Car> selectByExample(TArticleGroup2CarExample example);

    TArticleGroup2Car selectByPrimaryKey(Integer gcId);

    int updateByExampleSelective(@Param("record") TArticleGroup2Car record, @Param("example") TArticleGroup2CarExample example);

    int updateByExample(@Param("record") TArticleGroup2Car record, @Param("example") TArticleGroup2CarExample example);

    int updateByPrimaryKeySelective(TArticleGroup2Car record);

    int updateByPrimaryKey(TArticleGroup2Car record);
}