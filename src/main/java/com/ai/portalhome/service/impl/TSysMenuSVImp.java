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
import com.ai.portalhome.dao.mapper.TSysMenuMapper;
import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.dao.model.TSysMenuExample;
import com.ai.portalhome.service.interfaces.ITSysMenuSV;
import com.ai.portalhome.vo.MenuInfo;
import com.ai.portalhome.vo.MenuList;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TSysMenuSVImp implements ITSysMenuSV{
	
private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TSysMenuMapper tSysMenuMapper;
	

	@Override
	public PageInfo<TSysMenu> getMenuList(MenuInfo menuInfo) throws Exception {
		
		PageInfo<TSysMenu> page = new PageInfo<TSysMenu>();
		
		TSysMenuExample example = new TSysMenuExample();
		TSysMenuExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = menuInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//菜单名称过滤
		String menuName = menuInfo.getMenuName();
		if(menuName != null && !"".equals(menuName)){
			criteria.andMenuNameLike("%"+menuName+"%");
		}
		//排除菜单列表
		List<Integer> menulist = menuInfo.getMenulist();
		if(menulist != null && menulist.size() >= 1){
			criteria.andMenuIdNotIn(menulist);
		}
		
		//排序
		example.setOrderByClause(" menu_sup asc,menu_Order asc");
		
		PageHelper.startPage(menuInfo.getPageNo(), menuInfo.getPageSize(),true);
		List<TSysMenu> qryList = tSysMenuMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TSysMenu>(qryList);
		}
		
		
		return page;
	}
	
	@Override
	public TSysMenu getMenu(Integer menuId) throws Exception {
		TSysMenu vo = new TSysMenu();
		TSysMenu queryVO = tSysMenuMapper.selectByPrimaryKey(menuId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	@Override
	public PageInfo<TSysMenu> queryMenuList(MenuInfo menuInfo) throws Exception {
		PageInfo<TSysMenu> page = new PageInfo<TSysMenu>();
		
		TSysMenuExample example = new TSysMenuExample();
		TSysMenuExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" menu_sup asc, menu_Order asc");
		
		PageHelper.startPage(menuInfo.getPageNo(), menuInfo.getPageSize(),true);
		List<TSysMenu> qryList = tSysMenuMapper.selectByExample(example);
		
		
		
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			//按照展示格式进行重组
			List<TSysMenu> qryListNew = new ArrayList<TSysMenu>();
			
			List<MenuList> list = new ArrayList<MenuList>();
			
			for_one:
			for (int i = 0; i < qryList.size(); i++) {
				TSysMenu menu = qryList.get(i);
				Integer menuSup = menu.getMenuSup();
				Integer menuId = menu.getMenuId();
				//判断一级菜单
				if(menuSup == null || menuSup == 0){
					MenuList one = new MenuList();
					one.setMenu(menu);
					addNextList(menuId, qryList, one);
					
					list.add(one);
					
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				MenuList menuList = list.get(i);
				
				getNextList(qryListNew, menuList);
				
			}
			
			page = new PageInfo<TSysMenu>(qryListNew);
		}
		
		
		return page;
	}
	
	/**
	 * 递归拼装树状菜单
	 * @param supId
	 * @param oldList
	 * @param menuList
	 */
	private void addNextList(Integer supId,List<TSysMenu> oldList,MenuList menuList){
		
		//获取下级菜单
		for (int j = 0; j < oldList.size(); j++) {
			TSysMenu menuNext = oldList.get(j);
			Integer menuSup = menuNext.getMenuSup();
			Integer menuId = menuNext.getMenuId();
			if(menuSup == supId){//匹配到下级菜单
				
				List<MenuList> nextList = menuList.getNextList();
				if(nextList == null){
					nextList = new ArrayList<MenuList>();
					menuList.setNextList(nextList);
				}
				
				MenuList menuListNext = new MenuList();
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
	private void getNextList(List<TSysMenu> newList,MenuList menuList){
		
		TSysMenu next1 = menuList.getMenu();
		List<MenuList> nextList1 = menuList.getNextList();
		
		newList.add(next1);//父级
		
		//获取下级菜单
		if(nextList1 != null && nextList1.size() >= 1){
			for (int j = 0; j < nextList1.size(); j++) {
				MenuList menuNext2 = nextList1.get(j);
				
				getNextList(newList, menuNext2);
			}
		}
	}
	
	
	private List<TSysMenu> bubbleSort(List<TSysMenu> qryList) {  
		
		TSysMenu[] menus = (TSysMenu[])qryList.toArray(new TSysMenu[qryList.size()]);
		
//		String[] arr = (String[])list.toArray(new String[size]);
		
		TSysMenu temp; // 记录临时中间值   
//	    int temp; // 记录临时中间值   
	    int size = menus.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {   
	    	
	    	Integer ord_i = menus[i].getMenuOrder();
	    	
	        for (int j = i + 1; j < size; j++) {   
	        	
	        	Integer ord_j = menus[j].getMenuOrder();
	        	
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
	public TSysMenu addMenu(MenuInfo menuInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TSysMenu obj = new TSysMenu();
		
		TSysMenuExample example = new TSysMenuExample();
		TSysMenuExample.Criteria criteria = example.createCriteria();
		
		
		Integer seqId = seqUtil.getNewId("SEQ_T_SYS_NEMU");//获取序列
		
		
		BeanUtil.copyVO(obj, menuInfo);//复制基本属性
		obj.setMenuId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tSysMenuMapper.insert(obj);
		return obj;
	}
	
	@Override
	public TSysMenu editMenu(MenuInfo menuInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TSysMenu obj = new TSysMenu();
		
		Integer menuId = menuInfo.getMenuId();
		if(menuId == null || menuId == 0){
			throw new BusinessException("非法操作：无菜单编码！");
		}
		
		//设置不需要更新的字段
		menuInfo.setCreateTime(null);
		menuInfo.setCreateUser(null);
		menuInfo.setStatus(null);
		
		BeanUtil.copyVO(obj, menuInfo);//复制基本属性
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tSysMenuMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新菜单状态
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysMenu udpateStatus(MenuInfo menuInfo) throws Exception {
		
		TSysMenu obj = new TSysMenu();
		
		Integer menuId = menuInfo.getMenuId();
		if(menuId == null || menuId == 0){
			throw new BusinessException("非法操作：无菜单编码！");
		}
		String updateUser = menuInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = menuInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setMenuId(menuId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tSysMenuMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
