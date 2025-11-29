package com.decsec.seclevel.bean;

import java.util.Date;

public class TimeDiffAdaptive {

    private int id;

    //加密起始时间
    private Date beginTime;

    //加密结束时间
    private Date endTime;

    //加密的执行时间
    private double timeDiff;

    //自适应加密主键
    private int adaptiveEncryptionId;

    //迭代次数
    private int count;

    //加密1 解密2
    private int encryptionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(double timeDiff) {
        this.timeDiff = timeDiff;
    }

    public int getAdaptiveEncryptionId() {
        return adaptiveEncryptionId;
    }

    public void setAdaptiveEncryptionId(int adaptiveEncryptionId) {
        this.adaptiveEncryptionId = adaptiveEncryptionId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(int encryptionType) {
        this.encryptionType = encryptionType;
    }
}
