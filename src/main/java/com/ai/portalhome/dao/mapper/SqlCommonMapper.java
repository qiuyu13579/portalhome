package com.ai.portalhome.dao.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SqlCommonMapper {
	
	public List<LinkedHashMap<String,Object>> selectSqlListMap(@Param(value="doSql") String doSql)throws Exception;
}
