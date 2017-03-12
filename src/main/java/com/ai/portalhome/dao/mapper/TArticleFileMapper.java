package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TArticleFile;
import com.ai.portalhome.dao.model.TArticleFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleFileMapper {
    int countByExample(TArticleFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(TArticleFile record);

    int insertSelective(TArticleFile record);

    List<TArticleFile> selectByExample(TArticleFileExample example);

    TArticleFile selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") TArticleFile record, @Param("example") TArticleFileExample example);

    int updateByExample(@Param("record") TArticleFile record, @Param("example") TArticleFileExample example);

    int updateByPrimaryKeySelective(TArticleFile record);

    int updateByPrimaryKey(TArticleFile record);
}