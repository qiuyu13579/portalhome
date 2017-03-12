/*package com.ai.portalhome.web.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.portalhome.dao.mapper.AuthRoleMapper;
import com.ai.portalhome.dao.model.AuthRole;
import com.ai.portalhome.dao.model.AuthRoleExample;
import com.ai.portalhome.dao.model.ComplaintInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping(value = "/sample")
public class ActSampleController {

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
	
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
    	ObjectMapper mapper = new ObjectMapper(); // create once, reuse
    	//AuthRole a=authRoleMapper.selectByPrimaryKey(Short.valueOf("1"));
    	AuthRoleExample example=new AuthRoleExample();
    	example.createCriteria().andRoleIdLessThan(Short.valueOf("5"));
    	List<AuthRole> a= authRoleMapper.selectByExample(example);
    	String aa="";
    	try {
			aa=mapper.writeValueAsString(a);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "Hello World!"+aa;
    }

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
    @RequestMapping("/start")
    @ResponseBody
    String start() {
    	Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("START_USER_ID_", "当前登录人工号");
//		variables.put("assignee", "当前登录人工号");
		
//		activiti:assignee="${creater}"
		
		ProcessInstance startProcessInstanceById = runtimeService.startProcessInstanceByKey("myProcess", variables);
		String id_ = startProcessInstanceById.getId();//当前创建的示例ID
		
		
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery()
				.list();
    	
    	String aa="";
    	for(ProcessInstance processInstance :list){
    		aa=aa+processInstance.getId()+","+processInstance.getProcessDefinitionId()+";<br>";
    	}
    	
    	
        return "启动成功，返回已启动流程列表:<br>"+aa;
    }
    
    
    *//**
	 * 启动流程
	 *//*
    @RequestMapping("/start2")
    @ResponseBody
    String start2() {
    	Map<String, Object> variables = new HashMap<String, Object>();
    	//TODO 赋值组织候选人，从数据库查
		variables.put("liuzhuan", "aa3,aa4");//工单流转组织
		variables.put("zuzhiA", "b1,b2,aa3");//处理组织a
		variables.put("liuzhu_xietong", "f1,f2");//工作流转组织1
		variables.put("admin", "c1,c2");//管理员
//		variables.put("zuzhib", "d1,d2");//处理组织b
//		variables.put("liuzhu_xietong2", "e1,e2");//回复投诉组织
//		variables.put("tousu", "g1,g2");//投诉组织
//		variables.put("zhongcai", "h1,h2");//仲裁组织
	
		ProcessInstance startProcessInstanceById = runtimeService.startProcessInstanceByKey("tousuV2.3", variables);
		String processInstanid  = startProcessInstanceById.getId();//当前创建的示例ID
		
		
		List currtask = taskService.createTaskQuery()  
	            .processInstanceId(processInstanid)//使用流程实例ID  
	            .taskCandidateUser("aa3")
	            .list();  
		
		ComplaintInfo mComplaintInfo = new ComplaintInfo();
		mComplaintInfo.setCreateComplaintId("createstaff");
		mComplaintInfo.setCreateStaff("createstaff");
		taskService.setVariableLocal(currtask.getId(), "投诉信息", mComplaintInfo);
		
		
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
		List listaa3  = taskService.createTaskQuery().taskAssignee("aa3").list();
    	String aa="";
    	for(ProcessInstance processInstance :list){
    		aa=aa+processInstance.getId()+","+processInstance.getProcessDefinitionId()+";<br>";
    	}
    	
    	
        return "启动成功，返回已启动流程列表:<br>"+aa;
    }
    
    *//**
	 * 所有已启动流程实例
	 *//*
    @RequestMapping("/started")
    @ResponseBody
    String started() {

		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery()
				.list();
    	
    	String aa="";
    	for(ProcessInstance processInstance :list){
    		aa=aa+processInstance.getId()+","+processInstance.getProcessDefinitionId()+";<br>";
    	}
    	
    	
        return "启动流程列表:<br>"+aa;
    }
    
    
    *//**
	 * 所有任务列表
	 *//*
    @RequestMapping("/task")
    @ResponseBody
    String task() {
		//List<Task> tasks = service.createTaskQuery().taskCandidateGroup("management").list();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("aaa").list();
		System.out.println();
		TaskQuery taskQuery = taskService.createTaskQuery();
		//设置查询条件
		//    			taskQuery.taskAssignee(assignee);//设置当前账号
		
		//String task_def_key_ = "";
		//taskQuery.taskVariableValueEquals("TASK_DEF_KEY_", task_def_key_);//设置节点ID过滤
		
		List<Task> list=taskQuery.listPage(0, 10);//分页查询
	
    	
    	String aa="";
    	for(Task task :list){
    		aa=aa+task.getId()+","+task.getTaskDefinitionKey()+","+task.getName()+","+task.getAssignee()+","+task.getProcessDefinitionId()+";<br>";
    	}
    	
    	historyService.createHistoricActivityInstanceQuery().processInstanceId("").listPage(0, 10);
    	 List<HistoricVariableInstance> listaa = null;
//    			 taskService.getHistoryService()  
//    	            .createHistoricVariableInstanceQuery()  
//    	            .processInstanceId("")  
//    	            .list(); 
    	
        return "所有任务列表:<br>"+aa;
    }
    
    *//**
	 * 获取用户任务列表
	 *//*
    @RequestMapping("/usertask")
    @ResponseBody
    String usertask( ) {
    	//首先是根据流程ID获取当前任务：
    	String  procInstanceId = "107501";
    	String userid = "liuzhu_xietong_C";
    	String status = "02";
    	
    	//List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstanceId).taskCandidateUser(userid).list();
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
//    	variables.put("status", status);
//    	variables.put("liuzhu_xietong2", "liuzhu_xietong2_HuiFu");
//    	variables.put("tousu", "Chnl_TouSu");
    	taskService.complete(task.getId(),variables);
    	
        return "所有任务列表:<br>";
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