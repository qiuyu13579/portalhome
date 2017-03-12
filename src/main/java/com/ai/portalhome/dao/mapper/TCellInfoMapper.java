package com.ai.portalhome.dao.mapper;

import com.ai.portalhome.dao.model.TCellInfo;
import com.ai.portalhome.dao.model.TCellInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCellInfoMapper {
    int countByExample(TCellInfoExample example);

    int deleteByPrimaryKey(Integer celId);

    int insert(TCellInfo record);

    int insertSelective(TCellInfo record);

    List<TCellInfo> selectByExample(TCellInfoExample example);

    TCellInfo selectByPrimaryKey(Integer celId);

    int updateByExampleSelective(@Param("record") TCellInfo record, @Param("example") TCellInfoExample example);

    int updateByExample(@Param("record") TCellInfo record, @Param("example") TCellInfoExample example);

    int updateByPrimaryKeySelective(TCellInfo record);

    int updateByPrimaryKey(TCellInfo record);
}