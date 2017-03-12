package com.ai.portalhome.vo;

import java.util.List;

import com.ai.portalhome.dao.model.THomeMenu;

public class HomeMenuList extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8092120222509299162L;
	
    private THomeMenu menu;
    
    private List<HomeMenuList> nextList;

	public THomeMenu getMenu() {
		return menu;
	}

	public void setMenu(THomeMenu menu) {
		this.menu = menu;
	}

	public List<HomeMenuList> getNextList() {
		return nextList;
	}

	public void setNextList(List<HomeMenuList> nextList) {
		this.nextList = nextList;
	}

    
    

}
