package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TArticleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleInfoMapper {
    int countByExample(TArticleInfoExample example);

    int deleteByPrimaryKey(Integer artId);

    int insert(TArticleInfo record);

    int insertSelective(TArticleInfo record);

    List<TArticleInfo> selectByExample(TArticleInfoExample example);

    TArticleInfo selectByPrimaryKey(Integer artId);

    int updateByExampleSelective(@Param("record") TArticleInfo record, @Param("example") TArticleInfoExample example);

    int updateByExample(@Param("record") TArticleInfo record, @Param("example") TArticleInfoExample example);

    int updateByPrimaryKeySelective(TArticleInfo record);

    int updateByPrimaryKey(TArticleInfo record);
}