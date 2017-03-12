package com.ai.portalhome.vo;

import java.util.List;

import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TCellGroup;
import com.ai.portalhome.dao.model.TCellInfo;

public class CellGroupList extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8092120222509299162L;
	
    private TCellGroup group;
    
    private List<TCellInfo> nextList;

	public TCellGroup getGroup() {
		return group;
	}

	public void setGroup(TCellGroup group) {
		this.group = group;
	}

	public List<TCellInfo> getNextList() {
		return nextList;
	}

	public void setNextList(List<TCellInfo> nextList) {
		this.nextList = nextList;
	}


    
    
    

}
