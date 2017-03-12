/*package com.ai.portalhome.rest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.portalhome.rest.demo.dto.TaskRepresentation;
import com.ai.portalhome.servicetask.demo.JoinActivitiService;

*//**
 * @author yafei
 * @since 2016/10/9
 *//*
@RestController
public class JoinProcessRestController {

    @Autowired
    private JoinActivitiService myService;

    //开启流程实例
    @RequestMapping(value="/process/{personId}/{compId}", method= RequestMethod.GET)
    public void startProcessInstance(@PathVariable Long personId, @PathVariable Long compId) {
        myService.startProcess(personId,compId);
    }

    //获取当前人的任务
    @RequestMapping(value="/tasks", method= RequestMethod.GET)
    public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
        List<Task> tasks = myService.getTasks(assignee);
        
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        if (tasks==null||tasks.size()<=0) {
            return dtos;
        }
        
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    //完成任务
    @RequestMapping(value="/complete/{joinApproved}/{taskId}", method= RequestMethod.GET)
    public String complete(@PathVariable Boolean joinApproved,@PathVariable String taskId){
        myService.completeTasks(joinApproved,taskId);
        return "ok";

    }
    
}
*/