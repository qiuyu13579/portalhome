package com.ai.portalhome.service.interfaces;

import java.util.List;

import com.ai.portalhome.dao.model.TArticleGroup2Car;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.github.pagehelper.PageInfo;


public interface ITGroup2ArticleSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<ArticleGroupInfo> getList(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	/**
	 * 获取所有列表
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public List<TArticleGroup2Car> getAllList(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	/**
	 * 新增
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup2Car add(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
//	public ArticleGroupInfo get(Integer id) throws Exception;
	
	/**
	 * 编辑
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup2Car edit(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup2Car udpateStatus(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	
}
