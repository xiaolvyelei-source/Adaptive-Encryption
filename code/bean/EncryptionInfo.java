package com.decsec.seclevel.bean;

import java.util.Date;

/**
 * 加密bean
 */
public class EncryptionInfo {

    //主键
    private int id;

    //加密名称
    private String encryptionName;

    //加密类型 1加密 2解密
    private int encryptionType;

    //加密等级
    private int encryptionLevel;

    //明文长度
    private int plainLength;

    //混沌串长度
    private int confusionLength;

    //原文长度 等于 明文长度+混沌串长度
    private int originalLength;

    //录入时间
    private Date enterTime;

    //秘钥迭代次数
    private int cycleNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEncryptionName() {
        return encryptionName;
    }

    public void setEncryptionName(String encryptionName) {
        this.encryptionName = encryptionName;
    }

    public int getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(int encryptionType) {
        this.encryptionType = encryptionType;
    }

    public int getPlainLength() {
        return plainLength;
    }

    public void setPlainLength(int plainLength) {
        this.plainLength = plainLength;
    }

    public int getConfusionLength() {
        return confusionLength;
    }

    public void setConfusionLength(int confusionLength) {
        this.confusionLength = confusionLength;
    }

    public int getOriginalLength() {
        return originalLength;
    }

    public void setOriginalLength(int originalLength) {
        this.originalLength = originalLength;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public int getEncryptionLevel() {
        return encryptionLevel;
    }

    public void setEncryptionLevel(int encryptionLevel) {
        this.encryptionLevel = encryptionLevel;
    }

    public int getCycleNum() {
        return cycleNum;
    }

    public void setCycleNum(int cycleNum) {
        this.cycleNum = cycleNum;
    }
}
