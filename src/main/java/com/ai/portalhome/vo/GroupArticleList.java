package com.ai.portalhome.vo;

import java.util.List;

import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.dao.model.TArticleInfo;

public class GroupArticleList extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8092120222509299162L;
	
    private TArticleGroup group;
    
    private List<TArticleInfo> nextList;

	public TArticleGroup getGroup() {
		return group;
	}

	public void setGroup(TArticleGroup group) {
		this.group = group;
	}

	public List<TArticleInfo> getNextList() {
		return nextList;
	}

	public void setNextList(List<TArticleInfo> nextList) {
		this.nextList = nextList;
	}


    
    
    

}
