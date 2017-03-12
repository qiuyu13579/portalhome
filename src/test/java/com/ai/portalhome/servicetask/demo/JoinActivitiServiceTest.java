/*package com.ai.portalhome.servicetask.demo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.ai.portalhome.test.util.ReflectUtil;

*//**
 * @author yafei
 * @since 2016/10/10
 *//*
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {ActivitiApp.class})
//@WebAppConfiguration
public class JoinActivitiServiceTest {

    *//**这是我们要进行单元测试的service*//*
    private JoinActivitiService joinActivitiService=null;
    
    //这两个是joinActivitiService中的两个属性。我们要模拟这两个对象
    private RuntimeService runtimeServiceMock;
    private TaskService taskServiceMock;
    
    *//**
     * 带@Before标签的方法：在跑单元测试时，执行该单元测试类的所有@Test方法前，会先执行这个before方法。
     * 所以before方法适合对一些对象进行初始化之类的。
     * 
     * @author liangyi
     *//*
    @Before
    public void before() throws Exception{
        
        //new一个要测试的joinActivitiService
        joinActivitiService=new JoinActivitiService();
        
        //用Mockito模拟出这两个对象
        runtimeServiceMock = Mockito.mock(RuntimeService.class);
        taskServiceMock = Mockito.mock(TaskService.class);
        
        //把上面两个mock（模拟）出来的对象赋值给joinActivitiService。
        //因为joinActivitiService没有对应的set方法，所以使用反射赋值：使用ReflectUtil
        ReflectUtil.setValue(joinActivitiService, "runtimeService", runtimeServiceMock);
        ReflectUtil.setValue(joinActivitiService, "taskService", taskServiceMock);
        
    }

    *//**
     * 测试startProcess方法。该方法是一个void，无返回值。那么我们不用验证方法最终的返回，只需验证方法内部的代码逻辑。<br>
     * 在startProcess()方法中，最终调用了runtimeService.startProcessInstanceByKey("joinProcess", variables)。
     * 我们要验证的是，是不是正确调用了runtimeService，且传入的参数是正确的。
     * @throws Exception
     * @author liangyi
     *//*
    @Test
    public void testStartProcess() throws Exception {
        
        //方法入参
        Long personId=100L;
        Long compId=200L;
        
        //创建两个参数捕获器，用于捕获调用runtimeService.startProcessInstanceByKey()方法时传入的值
        
        //captorOfStr对应startProcessInstanceByKey()的第一个参数
        ArgumentCaptor<String> captorOfStr=ArgumentCaptor.forClass(String.class);
        //captorOfMap对应startProcessInstanceByKey()的第二个参数
        ArgumentCaptor<Map> captorOfMap=ArgumentCaptor.forClass(Map.class);
        
        //调用joinActivitiService.startProcess()方法，对该方法进行测试
        joinActivitiService.startProcess(personId, compId);
        
        //开始验证----------------------
        //验证runtimeService.startProcessInstanceByKey()方法调用次数并捕获参数值
        Mockito.verify(runtimeServiceMock,Mockito.times(1))
            .startProcessInstanceByKey(captorOfStr.capture(), captorOfMap.capture());
        
        //获取入参的值
        String arg1=captorOfStr.getValue();
        Map arg2=captorOfMap.getValue();
        
        //对第一个参数进行验证
        assertTrue("joinProcess".equals(arg1));//断言第一个参数是"joinProcess"
        
        //对第二个参数进行验证
        assertNotNull(arg2);//断言不是null
        assertTrue(arg2.size()==2);//断言参数（Map对象）中只有2个value
        assertNotNull(arg2.get("personId"));
        assertTrue(100==Long.valueOf(arg2.get("personId").toString()));//断言map中key为"personId"对应的value是100
        assertNotNull(arg2.get("compId"));
        assertTrue(200==Long.valueOf(arg2.get("compId").toString()));//断言map中key为"compId"对应的value是200
    }

    *//**
     * 
     * @throws Exception
     * @author liangyi
     *//*
    @Test
    public void testGetTasks() throws Exception {
        
        //入参
        String assignee="assignee";
        
        //开始模拟数据-----------
        //模拟taskService.createTaskQuery().taskCandidateUser(assignee).list()最终返回是我们创建出来的taskList
        List<Task> taskList=new ArrayList<Task>();
        
        TaskQuery taskQuery=Mockito.mock(TaskQuery.class);
        
        //模拟：当入参是字符串"assignee"时，返回taskList。
        Mockito.when(taskServiceMock.createTaskQuery()).thenReturn(taskQuery);
        Mockito.when(taskQuery.taskCandidateUser(assignee)).thenReturn(taskQuery);
        Mockito.when(taskQuery.list()).thenReturn(taskList);
        
        //调用要测试的方法getTasks()
        List<Task> result=joinActivitiService.getTasks(assignee);
        
        //验证结果
        assertTrue(result==taskList);
        
        
    }

    *//**
     * 测试completeTasks()方法。该方法也是void，测试方式与testStartProcess()一样
     * @throws Exception
     * @author liangyi
     *//*
    @Test
    public void testCompleteTasks() throws Exception {

        Boolean joinApproved=true;
        String taskId="taskId100";
        
        ArgumentCaptor<String> captorOfStr=ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Map> captorOfMap=ArgumentCaptor.forClass(Map.class);
        
        joinActivitiService.completeTasks(joinApproved, taskId);
        
        //开始验证---------------
        //验证complete方法调用次数，并捕获入参值
        Mockito.verify(taskServiceMock,Mockito.times(1)).complete(captorOfStr.capture(), captorOfMap.capture());
        
        //获取入参的值
        String arg1=captorOfStr.getValue();
        Map arg2=captorOfMap.getValue();
        
        assertTrue("taskId100".equals(arg1));
        
        assertNotNull(arg2);
        assertTrue(arg2.size()==1);
        assertNotNull(arg2.get("joinApproved"));
        assertTrue(Boolean.valueOf(arg2.get("joinApproved").toString())==joinApproved);
        
    }

}*/