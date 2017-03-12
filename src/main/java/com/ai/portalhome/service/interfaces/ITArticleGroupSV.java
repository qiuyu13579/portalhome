package com.ai.portalhome.service.interfaces;

import java.util.List;

import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.ai.portalhome.vo.GroupArticleList;
import com.github.pagehelper.PageInfo;


public interface ITArticleGroupSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TArticleGroup> getList(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	/**
	 * 获取展示列表
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public List<GroupArticleList> getShowList(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	/**
	 * 新增
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup add(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup get(Integer id) throws Exception;
	
	/**
	 * 编辑
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup edit(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup udpateStatus(ArticleGroupInfo articleGroupInfo) throws Exception;
	
	
}
