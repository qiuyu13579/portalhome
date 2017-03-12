package com.ai.portalhome.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.ai.portalhome.dao.mapper.THomeMenuMapper;
import com.ai.portalhome.dao.model.THomeMenu;
import com.ai.portalhome.dao.model.THomeMenuExample;
import com.ai.portalhome.service.interfaces.ITHomeMenuSV;
import com.ai.portalhome.vo.HomeMenuInfo;
import com.ai.portalhome.vo.HomeMenuList;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class THomeMenuSVImp implements ITHomeMenuSV{
	
private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private THomeMenuMapper tHomeMenuMapper;
	

	@Override
	public PageInfo<THomeMenu> getHomeMenuList(HomeMenuInfo homeMenuInfo) throws Exception {
		
		PageInfo<THomeMenu> page = new PageInfo<THomeMenu>();
		
		THomeMenuExample example = new THomeMenuExample();
		THomeMenuExample.Criteria criteria = example.createCriteria();
		
		
		//模块过滤
		Integer modelId = homeMenuInfo.getModelId();
		if(modelId == null || "".equals(modelId)){
			throw new BusinessException("模块编码为空");
		}else{
			criteria.andModelIdEqualTo(modelId);
		}
		//状态过滤
		String status = homeMenuInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//菜单名称过滤
		String menuName = homeMenuInfo.getMenuName();
		if(menuName != null && !"".equals(menuName)){
			criteria.andMenuNameLike("%"+menuName+"%");
		}
		//排除菜单列表
		List<Integer> menulist = homeMenuInfo.getMenulist();
		if(menulist != null && menulist.size() >= 1){
			criteria.andMenuIdNotIn(menulist);
		}
		
		//排序
		example.setOrderByClause(" menu_sup asc,menu_Order asc");
		
		PageHelper.startPage(homeMenuInfo.getPageNo(), homeMenuInfo.getPageSize(),true);
		List<THomeMenu> qryList = tHomeMenuMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<THomeMenu>(qryList);
		}
		
		
		return page;
	}
	
	@Override
	public THomeMenu getHomeMenu(Integer menuId) throws Exception {
		THomeMenu vo = new THomeMenu();
		THomeMenu queryVO = tHomeMenuMapper.selectByPrimaryKey(menuId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	@Override
	public PageInfo<HomeMenuList> queryHomeMenuList(HomeMenuInfo homeMenuInfo) throws Exception {
		
		PageInfo<HomeMenuList> page = new PageInfo<HomeMenuList>();
		
		THomeMenuExample example = new THomeMenuExample();
		THomeMenuExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		//模块过滤
		Integer modelId = homeMenuInfo.getModelId();
		if(modelId == null || "".equals(modelId)){
			throw new BusinessException("模块编码为空");
		}else{
			criteria.andModelIdEqualTo(modelId);
		}
		
		//排序
		example.setOrderByClause(" menu_sup asc, menu_Order asc");
		
		PageHelper.startPage(homeMenuInfo.getPageNo(), homeMenuInfo.getPageSize(),true);
		List<THomeMenu> qryList = tHomeMenuMapper.selectByExample(example);
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			//按照展示格式进行重组
//			List<THomeMenu> qryListNew = new ArrayList<THomeMenu>();
			
			List<HomeMenuList> list = new ArrayList<HomeMenuList>();
			
			for_one:
			for (int i = 0; i < qryList.size(); i++) {
				THomeMenu menu = qryList.get(i);
				Integer menuSup = menu.getMenuSup();
				Integer menuId = menu.getMenuId();
				//判断一级菜单
				if(menuSup == null || menuSup == 0){
					HomeMenuList one = new HomeMenuList();
					one.setMenu(menu);
					addNextList(menuId, qryList, one);
					
					list.add(one);
					
				}
			}
			
			//重新排序一级菜单
			list = bubbleSort(list);
			
			
			for (int i = 0; i < list.size(); i++) {
				HomeMenuList menuList = list.get(i);
				getNextList(menuList);
//				getNextList(qryListNew, menuList);
			}
			
			page = new PageInfo<HomeMenuList>(list);
		}
		return page;
	}
	
	/**
	 * 递归拼装树状菜单
	 * @param supId
	 * @param oldList
	 * @param menuList
	 */
	private void addNextList(Integer supId,List<THomeMenu> oldList,HomeMenuList menuList){
		
		//获取下级菜单
		for (int j = 0; j < oldList.size(); j++) {
			THomeMenu menuNext = oldList.get(j);
			Integer menuSup = menuNext.getMenuSup();
			Integer menuId = menuNext.getMenuId();
			if(menuSup == supId){//匹配到下级菜单
				
				List<HomeMenuList> nextList = menuList.getNextList();
				if(nextList == null){
					nextList = new ArrayList<HomeMenuList>();
					menuList.setNextList(nextList);
				}
				
				HomeMenuList menuListNext = new HomeMenuList();
				menuListNext.setMenu(menuNext);
				nextList.add(menuListNext);
				
				addNextList(menuId, oldList, menuListNext);//继续获取下级菜单
				
			}
		}
	}
	
	/**
	 * 递归获取下级所有菜单列表
	 * @param newList
	 * @param menuList
	 */
	private void getNextList(HomeMenuList menuList){
		
		THomeMenu next1 = menuList.getMenu();
		List<HomeMenuList> nextList1 = menuList.getNextList();
		
//		newList.add(next1);//父级
		
		//获取下级菜单
		if(nextList1 != null && nextList1.size() >= 1){
			//排序
			nextList1 = bubbleSort(nextList1);
			for (int j = 0; j < nextList1.size(); j++) {
				HomeMenuList menuNext2 = nextList1.get(j);
				
				getNextList(menuNext2);
//				getNextList(newList, menuNext2);
			}
		}
	}
	
	
		
	private List<HomeMenuList> bubbleSort(List<HomeMenuList> qryList) {  
		HomeMenuList[] menus = (HomeMenuList[])qryList.toArray(new HomeMenuList[qryList.size()]);
		
//		String[] arr = (String[])list.toArray(new String[size]);
		
		HomeMenuList temp; // 记录临时中间值   
//	    int temp; // 记录临时中间值   
	    int size = menus.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {   
	    	
	    	Integer ord_i = menus[i].getMenu().getMenuOrder();
	    	
	        for (int j = i + 1; j < size; j++) {   
	        	
	        	Integer ord_j = menus[j].getMenu().getMenuOrder();
	        	
	            if (ord_i < ord_j) { // 交换两数的位置   
	                temp = menus[i];   
	                menus[i] = menus[j];   
	                menus[j] = temp;   
	            }   
//	            if (numbers[i] < numbers[j]) { // 交换两数的位置   
//	            	temp = numbers[i];   
//	            	numbers[i] = numbers[j];   
//	            	numbers[j] = temp;   
//	            }   
	        }   
	    }   
	    qryList = Arrays.asList(menus);
	    
	    return qryList;
	}
	

	/**
	 * 新增菜单
	 */
	@Override
	public THomeMenu addHomeMenu(HomeMenuInfo homeMenuInfo) throws Exception {
		// TODO Auto-generated method stub
		
		THomeMenu obj = new THomeMenu();
		
		THomeMenuExample example = new THomeMenuExample();
		THomeMenuExample.Criteria criteria = example.createCriteria();
		
		
		Integer seqId = seqUtil.getNewId("SEQ_T_HOME_MENU");//获取序列
		
		
		BeanUtil.copyVO(obj, homeMenuInfo);//复制基本属性
		obj.setMenuId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tHomeMenuMapper.insert(obj);
		return obj;
	}
	
	@Override
	public THomeMenu editHomeMenu(HomeMenuInfo homeMenuInfo) throws Exception {
		// TODO Auto-generated method stub
		
		THomeMenu obj = new THomeMenu();
		
		Integer menuId = homeMenuInfo.getMenuId();
		if(menuId == null || menuId == 0){
			throw new BusinessException("非法操作：无菜单编码！");
		}
		
		//设置不需要更新的字段
		homeMenuInfo.setCreateTime(null);
		homeMenuInfo.setCreateUser(null);
		homeMenuInfo.setStatus(null);
		
		BeanUtil.copyVO(obj, homeMenuInfo);//复制基本属性
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tHomeMenuMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新菜单状态
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	public THomeMenu udpateStatus(HomeMenuInfo homeMenuInfo) throws Exception {
		
		THomeMenu obj = new THomeMenu();
		
		Integer menuId = homeMenuInfo.getMenuId();
		if(menuId == null || menuId == 0){
			throw new BusinessException("非法操作：无菜单编码！");
		}
		String updateUser = homeMenuInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = homeMenuInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setMenuId(menuId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tHomeMenuMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
