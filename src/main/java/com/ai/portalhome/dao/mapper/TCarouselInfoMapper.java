package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TCarouselInfo;
import com.ai.portalhome.dao.model.TCarouselInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCarouselInfoMapper {
    int countByExample(TCarouselInfoExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(TCarouselInfo record);

    int insertSelective(TCarouselInfo record);

    List<TCarouselInfo> selectByExample(TCarouselInfoExample example);

    TCarouselInfo selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") TCarouselInfo record, @Param("example") TCarouselInfoExample example);

    int updateByExample(@Param("record") TCarouselInfo record, @Param("example") TCarouselInfoExample example);

    int updateByPrimaryKeySelective(TCarouselInfo record);

    int updateByPrimaryKey(TCarouselInfo record);
}