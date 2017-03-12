package com.ai.portalhome.service.impl;

import java.util.ArrayList;
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
import com.ai.portalhome.dao.mapper.TArticleGroup2CarMapper;
import com.ai.portalhome.dao.mapper.TArticleInfoMapper;
import com.ai.portalhome.dao.model.TArticleGroup2Car;
import com.ai.portalhome.dao.model.TArticleGroup2CarExample;
import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.service.interfaces.ITGroup2ArticleSV;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TGroup2ArticleSVImp implements ITGroup2ArticleSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TArticleInfoMapper tArticleInfoMapper;
	@Autowired
	private TArticleGroup2CarMapper tArticleGroup2CarMapper;
	

	@Override
	public PageInfo<ArticleGroupInfo> getList(ArticleGroupInfo articleGroupInfo) throws Exception {
		
		PageInfo<ArticleGroupInfo> page = new PageInfo<ArticleGroupInfo>();
		
		TArticleGroup2CarExample example = new TArticleGroup2CarExample();
		TArticleGroup2CarExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = articleGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//分组编码
		Integer id = articleGroupInfo.getGroupId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无分组编码！");
		}else{
			criteria.andGroupIdEqualTo(id);
		}
		
		//排序
		example.setOrderByClause(" gc_order asc ");
		
		PageHelper.startPage(articleGroupInfo.getPageNo(), articleGroupInfo.getPageSize(),true);
		List<TArticleGroup2Car> qryList = tArticleGroup2CarMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			
			PageInfo<TArticleGroup2Car> pageNew = new PageInfo<TArticleGroup2Car>(qryList);
			
			List<ArticleGroupInfo> qryListNew = new ArrayList<ArticleGroupInfo>();
			for (int i = 0; i < qryList.size(); i++) {
				TArticleGroup2Car vo = qryList.get(i);
				ArticleGroupInfo voNew = new ArticleGroupInfo();
				BeanUtil.copyVO(voNew, vo);
				
				//拼装信息
				Integer artId = vo.getArtId();
				TArticleInfo tArticleInfo = tArticleInfoMapper.selectByPrimaryKey(artId);
				voNew.setArticleInfo(tArticleInfo);
				qryListNew.add(voNew);
			}
			page.setList(qryListNew);
			page.setPageNum(pageNew.getPageNum());
			page.setPageSize(pageNew.getPageSize());
			page.setTotal(pageNew.getTotal());
		}
		
		return page;
	}
	
	@Override
	public List<TArticleGroup2Car> getAllList(ArticleGroupInfo articleGroupInfo) throws Exception {
		
		List<TArticleGroup2Car> list = new ArrayList<TArticleGroup2Car>();
		
		TArticleGroup2CarExample example = new TArticleGroup2CarExample();
		TArticleGroup2CarExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		String status = articleGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//分组编码
		Integer id = articleGroupInfo.getGroupId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无分组编码！");
		}else{
			criteria.andGroupIdEqualTo(id);
		}
		
		//排序
		example.setOrderByClause(" gc_order asc ");
		
		list = tArticleGroup2CarMapper.selectByExample(example);
		
		return list;
	}
	
//	@Override
//	public ArticleGroupInfo get(Integer id) throws Exception {
//		ArticleGroupInfo vo = new ArticleGroupInfo();
//		TArticleGroup2Car queryVO = tArticleGroup2CarMapper.selectByPrimaryKey(id);
//		
//		
//		if(queryVO != null){
//			
//			Integer artId = queryVO.getArtId();
//			TArticleInfo tArticleInfo = tArticleInfoMapper.selectByPrimaryKey(artId);
//			voNew.setArticleInfo(tArticleInfo);
//			
//			vo = queryVO;
//		}
//		return vo;
//	}
	
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TArticleGroup2Car add(ArticleGroupInfo articleGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TArticleGroup2Car obj = new TArticleGroup2Car();
		
		Integer id = seqUtil.getNewId("SEQ_T_ARTICLE_GROUP_2_CAR");//获取序列
		
		BeanUtil.copyVO(obj, articleGroupInfo);//复制基本属性
		obj.setGcId(id);;//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		
		//获取目前最大的序列
		Integer gcOrder = 1;
		List<TArticleGroup2Car> allList = getAllList(articleGroupInfo);
		if(!CollectionUtil.isEmpty(allList)){
			Integer gcOrder_ = allList.get(allList.size()-1).getGcOrder();
			gcOrder = gcOrder_+1;
		}
		obj.setGcOrder(gcOrder);
		
		int insert = tArticleGroup2CarMapper.insert(obj);
		
		return obj;
	}
	
	@Override
	public TArticleGroup2Car edit(ArticleGroupInfo articleGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TArticleGroup2Car obj = new TArticleGroup2Car();
		
		Integer id = articleGroupInfo.getGroupId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, articleGroupInfo);//复制基本属性
		
		//设置不需要更新的字段
		obj.setCreateTime(null);
		obj.setCreateUser(null);
		obj.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tArticleGroup2CarMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TArticleGroup2Car udpateStatus(ArticleGroupInfo articleGroupInfo) throws Exception {
		
		TArticleGroup2Car obj = new TArticleGroup2Car();
		
		Integer id = articleGroupInfo.getGcId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		String updateUser = articleGroupInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = articleGroupInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setGcId(id);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tArticleGroup2CarMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
