package com.ai.portalhome.dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SequenceUtilMapper {
	
	String selectNextval(@Param("seqname") Map seqName);

}
