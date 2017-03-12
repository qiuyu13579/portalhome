package com.ai.portalhome.vo;

import java.util.List;

import com.ai.portalhome.dao.model.TSysMenu;

public class MenuList extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8092120222509299162L;
	
    private TSysMenu menu;
    
    private List<MenuList> nextList;

	public TSysMenu getMenu() {
		return menu;
	}

	public void setMenu(TSysMenu menu) {
		this.menu = menu;
	}

	public List<MenuList> getNextList() {
		return nextList;
	}

	public void setNextList(List<MenuList> nextList) {
		this.nextList = nextList;
	}

    
    
    
    

}
