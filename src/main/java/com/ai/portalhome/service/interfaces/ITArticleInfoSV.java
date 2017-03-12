package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.vo.ArticleInfo;
import com.github.pagehelper.PageInfo;


public interface ITArticleInfoSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TArticleInfo> getList(ArticleInfo articleInfo) throws Exception;
	
	/**
	 * 新增
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleInfo add(ArticleInfo articleInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TArticleInfo get(Integer id) throws Exception;
	
	/**
	 * 编辑
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleInfo edit(ArticleInfo articleInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleInfo udpateStatus(ArticleInfo articleInfo) throws Exception;
	
	
}
