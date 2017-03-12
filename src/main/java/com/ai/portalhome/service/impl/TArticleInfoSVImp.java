package com.ai.portalhome.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.utils.CollectionUtil;
import com.ai.portalhome.common.utils.BeanUtil;
import com.ai.portalhome.common.utils.DateUtil;
import com.ai.portalhome.common.utils.ISequenceUtil;
import com.ai.portalhome.dao.mapper.TArticleFileMapper;
import com.ai.portalhome.dao.mapper.TArticleInfoMapper;
import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TArticleInfoExample;
import com.ai.portalhome.service.interfaces.ITArticleInfoSV;
import com.ai.portalhome.vo.ArticleInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TArticleInfoSVImp implements ITArticleInfoSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TArticleInfoMapper tArticleGroupMapper;
	@Autowired
	private TArticleFileMapper tArticleFileMapper;
	

	@Override
	public PageInfo<TArticleInfo> getList(ArticleInfo articleInfo) throws Exception {
		
		PageInfo<TArticleInfo> page = new PageInfo<TArticleInfo>();
		
		TArticleInfoExample example = new TArticleInfoExample();
		TArticleInfoExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = articleInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//栏目标题
		String artName = articleInfo.getArtName();
		if(artName != null && !"".equals(artName)){
			criteria.andArtNameLike("%"+artName+"%");
		}
		//排除
		List<Integer> ids = articleInfo.getIds();
		if(!CollectionUtil.isEmpty(ids)){
			criteria.andArtIdNotIn(ids);
			
		}
		
		
		//排序
		example.setOrderByClause(" update_time desc ");
		
		PageHelper.startPage(articleInfo.getPageNo(), articleInfo.getPageSize(),true);
		List<TArticleInfo> qryList = tArticleGroupMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TArticleInfo>(qryList);
		}
		
		return page;
	}
	
	@Override
	public TArticleInfo get(Integer carId) throws Exception {
		TArticleInfo vo = new TArticleInfo();
		TArticleInfo queryVO = tArticleGroupMapper.selectByPrimaryKey(carId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TArticleInfo add(ArticleInfo articleInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TArticleInfo obj = new TArticleInfo();
		
		Integer id = seqUtil.getNewId("SEQ_T_ARTICLE_INFO");//获取序列
		
		BeanUtil.copyVO(obj, articleInfo);//复制基本属性
		obj.setArtId(id);;//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		
		int insert = tArticleGroupMapper.insert(obj);
		
		return obj;
	}
	
	@Override
	public TArticleInfo edit(ArticleInfo articleInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TArticleInfo obj = new TArticleInfo();
		
		Integer id = articleInfo.getArtId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, articleInfo);//复制基本属性
		
		//设置不需要更新的字段
		obj.setCreateTime(null);
		obj.setCreateUser(null);
		obj.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tArticleGroupMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param articleInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleInfo udpateStatus(ArticleInfo articleInfo) throws Exception {
		
		TArticleInfo obj = new TArticleInfo();
		
		Integer id = articleInfo.getArtId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		String updateUser = articleInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = articleInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setArtId(id);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tArticleGroupMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
