package com.ai.portalhome.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.ai.portalhome.dao.mapper.TArticleGroupMapper;
import com.ai.portalhome.dao.mapper.TArticleInfoMapper;
import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.dao.model.TArticleGroup2Car;
import com.ai.portalhome.dao.model.TArticleGroupExample;
import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.service.interfaces.ITArticleGroupSV;
import com.ai.portalhome.service.interfaces.ITGroup2ArticleSV;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.ai.portalhome.vo.GroupArticleList;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TArticleGroupSVImp implements ITArticleGroupSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TArticleInfoMapper tArticleInfoMapper;
	@Autowired
	private TArticleGroupMapper tArticleGroupMapper;
	@Autowired
	private TArticleGroup2CarMapper tArticleGroup2CarMapper;
	@Autowired
	private ITGroup2ArticleSV iTGroup2ArticleSV;
	

	@Override
	public PageInfo<TArticleGroup> getList(ArticleGroupInfo articleGroupInfo) throws Exception {
		
		PageInfo<TArticleGroup> page = new PageInfo<TArticleGroup>();
		
		TArticleGroupExample example = new TArticleGroupExample();
		TArticleGroupExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = articleGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//栏目标题
		String groupName = articleGroupInfo.getGroupName();
		if(groupName != null && !"".equals(groupName)){
			criteria.andGroupNameLike("%"+groupName+"%");
		}
		
		//排序
		example.setOrderByClause(" update_time desc ");
		
		PageHelper.startPage(articleGroupInfo.getPageNo(), articleGroupInfo.getPageSize(),true);
		List<TArticleGroup> qryList = tArticleGroupMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TArticleGroup>(qryList);
		}
		
		return page;
	}
	
	@Override
	public List<GroupArticleList> getShowList(ArticleGroupInfo articleGroupInfo) throws Exception {
		
		List<GroupArticleList> list = new ArrayList<GroupArticleList>();
		
		TArticleGroupExample example = new TArticleGroupExample();
		TArticleGroupExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = articleGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//栏目标题
		String groupName = articleGroupInfo.getGroupName();
		if(groupName != null && !"".equals(groupName)){
			criteria.andGroupNameLike("%"+groupName+"%");
		}
		List<Integer> ids = articleGroupInfo.getIds();
		if(ids != null && ids.size() >= 1){
			for (int i = 0; i < ids.size(); i++) {
				
				Integer groupId = ids.get(i);
				TArticleGroup articleGroup = get(groupId);
				
				GroupArticleList listVO = new GroupArticleList();
				listVO.setGroup(articleGroup);
				
				//获取分组文章列表
				ArticleGroupInfo info = new ArticleGroupInfo();
				info.setGroupId(groupId);
				List<TArticleGroup2Car> allList = iTGroup2ArticleSV.getAllList(info);
				if(!CollectionUtil.isEmpty(allList)){
					
					List<TArticleInfo> nextList = new ArrayList<TArticleInfo>();
					
					for (int j = 0; j < allList.size(); j++) {
						TArticleGroup2Car group2Car = allList.get(j);
						//拼装信息
						Integer artId = group2Car.getArtId();
						TArticleInfo tArticleInfo = tArticleInfoMapper.selectByPrimaryKey(artId);
						if(tArticleInfo != null){
							//处理时间
							Date createTime = tArticleInfo.getCreateTime();
							int month = createTime.getMonth();
							int day = createTime.getDay();
							tArticleInfo.setCreateUser("["+(month+1)+"."+day+"]");
							nextList.add(tArticleInfo);
						}
					}
					listVO.setNextList(nextList);
				}
				
				list.add(listVO);
			}
		}
		return list;
	}
	
	@Override
	public TArticleGroup get(Integer carId) throws Exception {
		TArticleGroup vo = new TArticleGroup();
		TArticleGroup queryVO = tArticleGroupMapper.selectByPrimaryKey(carId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TArticleGroup add(ArticleGroupInfo articleGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TArticleGroup obj = new TArticleGroup();
		
		Integer id = seqUtil.getNewId("SEQ_T_ARTICLE_GROUP");//获取序列
		
		BeanUtil.copyVO(obj, articleGroupInfo);//复制基本属性
		obj.setGroupId(id);;//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		
		int insert = tArticleGroupMapper.insert(obj);
		
		return obj;
	}
	
	@Override
	public TArticleGroup edit(ArticleGroupInfo articleGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TArticleGroup obj = new TArticleGroup();
		
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
		
		int updateByPrimaryKeySelective = tArticleGroupMapper.updateByPrimaryKeySelective(obj);
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
	public TArticleGroup udpateStatus(ArticleGroupInfo articleGroupInfo) throws Exception {
		
		TArticleGroup obj = new TArticleGroup();
		
		Integer id = articleGroupInfo.getGroupId();
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
		
		obj.setGroupId(id);
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
