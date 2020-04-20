package com.ztc.springB.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Data
public class ImportAsynInfo {
    //用于存储所有的导入进度信息
    public static Map<String,ImportAsynInfo> allAsynInfo=new HashMap<String,ImportAsynInfo>();

    //提示信息或 异常信息
    private String msg;
    //数据总数
    private Integer totality=0;
    //已处理的数据条数
    private Integer doneSum=0;
    //失败的数据条数
    private Integer errorSum=0;
    //成功的数据条数
    private Integer successSum=0;
    //错误文件的路径
    public String errorFilePath;
    //导入是否结束
    public  Boolean isEnd= false;

    public  Boolean isStop=false;

    /**
     * 创建一个进度信息,并获取对应的uuid
     * @return
     */
    public static String  createAsynInfo(){
        ImportAsynInfo asynInfo=new ImportAsynInfo();
        String uuid=UUID.randomUUID().toString().replace("-","");
        allAsynInfo.put(uuid,asynInfo);
        return uuid;
    }

    /**
     * 通过uuid获取进度信息
     * @param uuid
     * @return
     */
    public static ImportAsynInfo getAsynInfo(String uuid){
        return allAsynInfo.get(uuid);
    }

    /**
     * 通过uuid删除对应的进度信息
     * @param uuid
     * @return
     */
    public static void deleteAsynInfo(String uuid){
        allAsynInfo.remove(uuid);
    }

    /**
     * uuid对应的进度 已处理的数据条数+1
     * @param uuid
     */
    public static void doneSumAddOne(String uuid){
        ImportAsynInfo asynInfo= getAsynInfo(uuid);
        asynInfo.setDoneSum(asynInfo.getDoneSum()+1);
    }

    /**
     * uuid对应的进度 失败的数据条数+1
     * @param uuid
     */
    public static void errorSumAddOne(String uuid){
        ImportAsynInfo asynInfo= getAsynInfo(uuid);
        asynInfo.setErrorSum(asynInfo.getErrorSum()+1);
    }

    /**
     * uuid对应的进度 成功的数据条数+1
     * @param uuid
     */
    public static void successSumAddOne(String uuid){
        ImportAsynInfo asynInfo= getAsynInfo(uuid);
        asynInfo.setSuccessSum(asynInfo.getSuccessSum()+1);
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getTotality() {
        return totality;
    }
    public void setTotality(Integer totality) {
        this.totality = totality;
    }
    public Integer getDoneSum() {
        return doneSum;
    }
    public void setDoneSum(Integer doneSum) {
        this.doneSum = doneSum;
    }
    public Integer getErrorSum() {
        return errorSum;
    }
    public void setErrorSum(Integer errorSum) {
        this.errorSum = errorSum;
    }
    public Integer getSuccessSum() {
        return successSum;
    }
    public void setSuccessSum(Integer successSum) {
        this.successSum = successSum;
    }
    public String getErrorFilePath() {
        return errorFilePath;
    }
    public void setErrorFilePath(String errorFilePath) {
        this.errorFilePath = errorFilePath;
    }
    public Boolean getEnd() {
        return isEnd;
    }
    public void setEnd(Boolean end) {
        isEnd = end;
    }
}
