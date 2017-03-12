package com.ai.portalhome.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.portalhome.dao.mapper.SequenceUtilMapper;

/**
 * 获取序列值工具类
 * @author xuzc
 *
 */
@Repository
@SuppressWarnings("rawtypes")
public class SequenceUtil implements ISequenceUtil {
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private SequenceUtilMapper sequenceUtilMapper;

	/**
	 * 根据SEQ名称获取序列值
	 * 
	 * @param seqName
	 * @return
	 * @author zhangchao
	 */
	public Integer getNewId(String seqName) {
		Integer resNextval = 0 ;
		try {
			Map<String,String> seqNameMap = new HashMap<String,String>();
			seqNameMap.put("seqName", seqName);
			String seqNextval  = sequenceUtilMapper.selectNextval(seqNameMap);
			resNextval =  Integer.valueOf(seqNextval);
//			resNextval =  Long.parseLong(seqNextval);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		} finally {
			
			
		}
		return resNextval;
	}

	/**
	 * 根据SEQ名称获取定长序列值
	 * 
	 * @param seq
	 * @param seqLen
	 * @return
	 * @author zhangchao
	 */
	public String getNewId(String seqName, int seqLen) {
		String seqStr = getNewId(seqName)+"";
		while (seqStr.length() < seqLen) {
			seqStr = "0000000" + seqStr;
		}
		return seqStr.substring(seqStr.length() - seqLen);
	}
	
}
