/*package com.ai.portalhome.web.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.portalhome.dao.mapper.AuthRoleMapper;
import com.ai.portalhome.dao.model.ComplaintInfo;


@Controller
@RequestMapping(value = "/demo")
public class ActDemoController {

    @Autowired
    private AuthRoleMapper authRoleMapper;
    
    @Autowired
    RepositoryService repositoryService;
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private HistoryService historyService;

    @Autowired
    private TaskService taskService;
	

	*//**
	 * 已部署流程列表
	 *//*
    @RequestMapping("/deployed")
    @ResponseBody
    String deployed() {
    	List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
				.list();
    	String aa="";
    	for(ProcessDefinition processDefinition :list){
    		aa=aa+processDefinition.getId()+","+processDefinition.getName()+";<br>";
    	}
        return "已部署流程列表:<br>"+aa;
    }
    
    *//**
	 * 启动流程
	 *//*
    @RequestMapping("/startProcess")
    @ResponseBody
    String startProcess() {
    	Map<String, Object> variables = new HashMap<String, Object>();
    	variables.put("liuzhuan", "liuzhuan_aa1,liuzhuan_aa2");//工单流转组织
    	variables.put("liuzhu_xietong", "liuzhu_xietong1_f1,liuzhu_xietong1_f2");//工作流转组织1
		variables.put("zuzhiA", "zuzhiA_b1,zuzhiA_b2");//处理组织a
		variables.put("admin", "admin_c1,admin_c2");//管理员
		variables.put("liuzhu_huifutousu", "huifutousu");//回复投诉组织
		variables.put("tousu", "qudaoshang");//处理组织b
		variables.put("zhongcai", "zhongcai_h1,zhongcai_h2");//仲裁组织
	
		ProcessInstance startProcessInstanceById = runtimeService.startProcessInstanceByKey("tousuV2.7", variables);
		String processInstanid  = startProcessInstanceById.getId();//当前创建的示例ID
		System.out.println("processInstanid:"+processInstanid);
		
		
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
    	String aa="";
    	for(ProcessInstance processInstance :list){
    		aa=aa+processInstance.getId()+","+processInstance.getProcessDefinitionId()+";<br>";
    	}
        return "启动成功，返回已启动流程列表:<br>"+aa;
    }
    
    
    @RequestMapping("/usertask")
    @ResponseBody
    String usertask(String  procInstanceId,String userid ) {
    	//首先是根据流程ID获取当前任务：
    	String status = "02";
    	
    	Task task1 = taskService.createTaskQuery().processInstanceId(procInstanceId).taskAssignee(userid).singleResult();  
    	List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstanceId).list();
    	Task task = taskService.createTaskQuery().processInstanceId(procInstanceId).taskCandidateUser(userid).singleResult();
    	
    	//然后根据当前任务获取当前流程的流程定义，然后根据流程定义获得所有的节点：
    	ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl)repositoryService).getDeployedProcessDefinition(task.getProcessDefinitionId());
    	List<ActivityImpl> activitiList = def.getActivities();  //rs是指RepositoryService的实例
    	
    	//根据任务获取当前流程执行ID，执行实例以及当前流程节点的ID：
    	String excId = task.getExecutionId();
    	ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(excId).singleResult();
    	String activitiId = execution.getActivityId();
    	//然后循环activitiList 并判断出当前流程所处节点，然后得到当前节点实例，根据节点实例获取所有从当前节点出发的路径，然后根据路径获得下一个节点实例：
		for (ActivityImpl activityImpl : activitiList) {
			String id = activityImpl.getId();
			if (activitiId.equals(id)) {
				System.out.println("当前任务：" + activityImpl.getProperty("name")); // 输出某个节点的某种属性
				List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();// 获取从某个节点出来的所有线路
				for (PvmTransition tr : outTransitions) {
					PvmActivity ac = tr.getDestination(); // 获取线路的终点节点
					System.out.println("下一步任务任务：" + ac.getProperty("name"));
				}
				break;
			}
		}
    	
    	Map<String, Object> variables = new HashMap<String, Object>();
    	variables.put("status", status);
    	String completeId  = "";
    	if(null!=task){
    		completeId = task.getId();
    	}else{
    		completeId = task1.getId();
    	}
    	taskService.complete(completeId,variables);

    	
    	
        return "所有任务列表:<br>";
    }
    
    
    
    @RequestMapping("/subUsertask")
    @ResponseBody
    String subUsertask(String  procInstanceId  ) {
    	String userid = "liuzhu_xietong1_f1";
    	String status = "02";
    	
    	Task task = taskService.createTaskQuery().processInstanceId(procInstanceId).taskCandidateUser(userid).singleResult();
    	
    	
    	Map<String, Object> variables=new HashMap<String, Object>();//要在启动流程中存的流程变量map
    	List<String> candiateUserList=new ArrayList<String>();//创建多个子流程用的集合
    	candiateUserList.add("xietong_A");
    	candiateUserList.add("xietong_B");
    	candiateUserList.add("xietong_C");
    	candiateUserList.add("admin_c1");
    	variables.put("candiateUserList", candiateUserList);//多个子流程集合
    	
    	List<Task> taskList  = taskService.createTaskQuery().list();
    	
    	taskService.complete(task.getId(),variables);
    	return "启动子流程";
    }
    
    *//**
   	 * 获取用户任务列表
   	 *//*
       @RequestMapping("/getUsertask")
       @ResponseBody
       String getUsertask(String processInstanid,String userid) {
    	   Task currtask = taskService.createTaskQuery()  
    	            .processInstanceId(processInstanid)//使用流程实例ID  
    	            .taskCandidateUser(userid).singleResult(); 
    	    
   		ComplaintInfo mComplaintInfo = new ComplaintInfo();
   		mComplaintInfo.setCreateComplaintId("createstaff");
   		mComplaintInfo.setCreateStaff("createstaff");
   		taskService.setVariable(currtask.getId(), "投诉信息1", "试试看");
   		taskService.setVariableLocal(currtask.getId(), "投诉信息", mComplaintInfo);
          return "所有任务列表:<br>";
       }
    
    
    
   
    
    *//**
	 * 获取用户任务列表
	 *//*
    @RequestMapping("/usertask2")
    @ResponseBody
    String usertask2(String id) {
		//List<Task> list = taskService.createTaskQuery().taskCandidateGroup("management").list();
		List<Task> list = taskService.createTaskQuery().taskAssignee(id).list();// 个人任务的查询

		//List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstanceId).list();
		
		Task currtask = taskService.createTaskQuery()  
	            //使用流程实例ID  
	            .taskAssignee("aa1")//任务办理人  
	            .singleResult();  
		
		
    	String aa="";
    	for(Task task :list){
    		aa=aa+task.getId()+","+task.getTaskDefinitionKey()+","+task.getName()+","+task.getAssignee()+","+task.getProcessDefinitionId()+";<br>";
    	}
    	
    	
        return "所有任务列表:<br>"+aa;
    }
    
    
    *//**
 	 * 完成任务
 	 *//*
     @RequestMapping("/complete")
     @ResponseBody
     ModelAndView complete(String id,String status,String zuzi) {
 
    	Map<String, Object> variables = new HashMap<String, Object>();
    	if(status != null && !status.equals("")){
			variables.put("status", status);
		}
		//协同
		if(xta != null && !xta.equals("")){
			variables.put("xta", xta);
			taskService.setAssignee(id, xta);
		}
		if(xtb != null && !xtb.equals("")){
			taskService.setAssignee(id, xta);
			variables.put("xtb", xtb);
		}
		
		
    	if(zuzi != null && !zuzi.equals("")){
    		Task task = taskService.createTaskQuery().taskId(id).singleResult();
        	//如果等于“工作流转组织1”，则输入选择的组织参数
        	if("usertask15".equals(task.getTaskDefinitionKey())){
        		variables.put("xta", zuzi);
        	}
		}
    	
   	
		taskService.complete(id, variables);
     	
		return new ModelAndView("redirect:task");
     }
     
     *//**
  	 * 根据任务id查询任务信息
  	 *//*
      @RequestMapping("/query")
      @ResponseBody
      String query(String id) {
  
  
     	List<Task> list = taskService.createTaskQuery().taskId(id).list();
     	Task task=list.get(0);
     	
     	Task task = taskService.createTaskQuery().taskId(id).singleResult();
     	
 		
      	
 		return task.getId()+";"+task.getTaskDefinitionKey()+";"+task.getName();
      }
}
*/