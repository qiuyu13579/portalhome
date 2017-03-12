/*package com.ai.portalhome.rest.demo.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.ai.portalhome.rest.demo.dto.TaskRepresentation;
import com.ai.portalhome.servicetask.demo.JoinActivitiService;
import com.ai.portalhome.test.util.ReflectUtil;


public class JoinProcessRestControllerTest {
    
    *//**我们要测试的类*//*
    JoinProcessRestController joinProcessRestController;
    
    *//**joinProcessRestController的属性*//*
    JoinActivitiService myServiceMock;

    @Before
    public void before() throws Exception {
        //创建对象
        joinProcessRestController=new JoinProcessRestController();
        
        //模拟service
        myServiceMock=mock(JoinActivitiService.class);
        
        //赋值
        ReflectUtil.setValue(joinProcessRestController, "myService", myServiceMock);
        
//      PowerMockito.mockStatic(ReflectUtil.class);
//      PowerMockito.doThrow(new IllegalArgumentException())
//          .when(ReflectUtil.class, "setValue", anyObject(), anyString(),any(JoinActivitiService.class));
    }


    *//**
     * startProcessInstance()方法太简单了，就一句代码。我们只要验证正确调用了myService.startProcess(personId,compId);
     * 
     * @author liangyi
     *//*
    @Test
    public void testStartProcessInstance() {
        
        //准备入参
        Long personId=100L;
        Long compId=200L;
        
        //创建参数捕获器
        ArgumentCaptor<Long> captor1=ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> captor2=ArgumentCaptor.forClass(Long.class);
        
        //模拟myServiceMock.startProcess()的行为。也可以不模拟：因为mock出来的对象，void方法默认就是doNothing
        //doNothing().when(myServiceMock).startProcess(captor1.capture(), captor2.capture());
        
        //调用方法进行测试
        joinProcessRestController.startProcessInstance(personId, compId);
        
        //开始验证--------------
        //验证startProcess()方法调用次数并捕获入参值
        verify(myServiceMock,times(1)).startProcess(captor1.capture(), captor2.capture());
        
        //获取参数1并验证
        Long arg1=captor1.getValue();
        assertTrue(100==arg1);
        
        //获取参数2并验证
        Long arg2=captor2.getValue();
        assertTrue(200==arg2);
    }

    *//**
     * 测试GetTasks方法。
     * @author liangyi
     *//*
    @Test
    public void testGetTasks() {
        
        //准备入参数据
        String assignee="assignee";
        
        //准备模拟数据
        Task task1=mock(Task.class);
        when(task1.getId()).thenReturn("id1");
        when(task1.getName()).thenReturn("name1");
        
        Task task2=mock(Task.class);
        when(task2.getId()).thenReturn("id2");
        when(task2.getName()).thenReturn("name2");
        
        List<Task> taskList=new ArrayList<Task>(2);
        taskList.add(task1);
        taskList.add(task2);
        
        //进行模拟，定义myServiceMock.getTasks(assignee)的行为。
        when(myServiceMock.getTasks(assignee)).thenReturn(taskList);
        
        //调用方法进行测试-----------------------------
        
        //验证myServiceMock.getTasks()返回null的情况。注：上面定义了getTasks()方法，传入参数为"assignee"时才返回taskList。
        //这里入参是"otherString"，非"assignee"，所以getTasks()方法返回null。
        List<TaskRepresentation> result=joinProcessRestController.getTasks("otherString");
        assertNotNull(result);
        assertTrue(result.size()==0);
        
        //验证myServiceMock.getTasks()返回taskList的情况
        result=null;
        result=joinProcessRestController.getTasks("assignee");
        assertTrue(result!=null&&result.size()==2);
        //验证数据
        assertTrue("id1".equals(result.get(0).getId()));
        assertTrue("name1".equals(result.get(0).getName()));
        
        assertTrue("id2".equals(result.get(1).getId()));
        assertTrue("name2".equals(result.get(1).getName()));
        
    }

    *//**
     * 测试complete()
     * 
     * @author liangyi
     *//*
    @Test
    public void testComplete() {
        
        //入参准备
        Boolean joinApproved=true;
        String taskId="100";
        
        String result=joinProcessRestController.complete(joinApproved, taskId);
        
        //开始验证
        assertTrue("ok".equals(result));
        
        //验证myService.completeTasks(joinApproved,taskId)调用次数
        verify(myServiceMock,times(1)).completeTasks(joinApproved, taskId);
        
        //验证myService.completeTasks(false,"200")调用次数
        verify(myServiceMock,times(0)).completeTasks(false, "200");
        
    }
    
}
*/