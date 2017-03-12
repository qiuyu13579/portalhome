var ZTree = {
		
};

ZTree.searchNodesByParamFuzzy = function(treeObj, value) {
	treeObj.expandAll(false);
	var nodeList = treeObj.transformToArray(treeObj.getNodes());
	ZTree.updateNodes(treeObj, nodeList, false);
	nodeList = treeObj.getNodesByParamFuzzy("nodeName", value);
	ZTree.updateNodes(treeObj, nodeList, true);
	return nodeList;
}

ZTree.updateNodes = function(treeObj, nodeList, highlight) {
	for(var i=0; i<nodeList.length; i++) {
		nodeList[i].highlight = highlight;
		treeObj.updateNode(nodeList[i]);
		if(highlight) {
			ZTree.expandSearchNodes(nodeList[i]);
		}
	}
	if(highlight && nodeList.length>0) {
		treeObj.selectNode(nodeList[0]);
	}
}

ZTree.expandSearchNodes = function(node) {
	var parentNode = node.getParentNode();
	if(parentNode!=null) {
		ZTree.expandSearchNodes(parentNode);
		if(!parentNode.open) {
			treeObj.expandNode(parentNode);
		}
	}
}

ZTree.getFontCss = function(treeId, treeNode) {
	return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
}