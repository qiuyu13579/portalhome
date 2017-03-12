package com.ai.portalhome.common.constants;

/**
 * @author yafei
 * @since 2016/10/9
 */
public class ActConstant {
    static final String USERNAME_ERROR = "用户名错误";
    static final String NO_PERMISSIONS = "没有权限";
    
    public static final String Test_Online_StaffId = "59b0bej";
    
    //我发起的投诉工单
    public static final String TABPAGE_RECEIVECOMPLAINT  = "receiveComplaintTabPage";
    //我收到的投诉工单
    public static final String TABPAGE_SPONSORCOMPLAINT  = "sponsorComplaintTabPage";
    
    //流程模版文件名称
    public static final String PROCESSINSTANCEKEY = "tousuV2.3";
    
    
    public static final String DEAL_ACTION_TIJIAOHUIFU = "TIJIAOHUIFU"; //提交回复
    public static final String DEAL_ACTION_ZHUANPAI = "ZHUANPAI"; //转派
    public static final String DEAL_ACTION_XIEBAN = "XIEBAN"; //协办
    public static final String DEAL_ACTION_JIEDUANHUIFU = "JIEDUANHUIFU"; //阶段回复
    
    
    //00提交    
    public static final String TASK_PROCESS_STATUS_SUBMIT = "00";//提交
    
    // 01追加
    public static final String TASK_PROCESS_STATUS_ADDITIONAL = "01";//追加意见
    
    //02升级投诉
    public static final String TASK_PROCESS_STATUS_UPGRADECOMPLAINT = "02";//升级投诉
    
    // 03投诉工单完结
    public static final String TASK_PROCESS_STATUS_FINISH = "03";//投诉工单完结
    
    //04转派
    public static final String TASK_PROCESS_STATUS_TURNTOSEND = "04";//转派
    
    //05协办 
    public static final String TASK_PROCESS_STATUS_TEAMDO = "05";//协办
    
    //06阶段回复
    public static final String TASK_PROCESS_STATUS_STAGEREPLY = "06";//阶段回复
    
    //99撤销
    public static final String TASK_PROCESS_STATUS_CANCEL = "99";//撤销
    
    
}
