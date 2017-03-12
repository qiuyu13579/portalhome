package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.THomeModel;
import com.ai.portalhome.dao.model.THomeModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THomeModelMapper {
    int countByExample(THomeModelExample example);

    int deleteByPrimaryKey(Integer modelId);

    int insert(THomeModel record);

    int insertSelective(THomeModel record);

    List<THomeModel> selectByExample(THomeModelExample example);

    THomeModel selectByPrimaryKey(Integer modelId);

    int updateByExampleSelective(@Param("record") THomeModel record, @Param("example") THomeModelExample example);

    int updateByExample(@Param("record") THomeModel record, @Param("example") THomeModelExample example);

    int updateByPrimaryKeySelective(THomeModel record);

    int updateByPrimaryKey(THomeModel record);
}