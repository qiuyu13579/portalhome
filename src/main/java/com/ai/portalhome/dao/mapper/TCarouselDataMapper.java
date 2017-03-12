package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TCarouselData;
import com.ai.portalhome.dao.model.TCarouselDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCarouselDataMapper {
    int countByExample(TCarouselDataExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(TCarouselData record);

    int insertSelective(TCarouselData record);

    List<TCarouselData> selectByExample(TCarouselDataExample example);

    TCarouselData selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") TCarouselData record, @Param("example") TCarouselDataExample example);

    int updateByExample(@Param("record") TCarouselData record, @Param("example") TCarouselDataExample example);

    int updateByPrimaryKeySelective(TCarouselData record);

    int updateByPrimaryKey(TCarouselData record);
}