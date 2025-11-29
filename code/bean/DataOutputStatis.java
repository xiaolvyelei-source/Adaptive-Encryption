package com.decsec.seclevel.bean;

import java.util.Date;

public class DataOutputStatis {

    private int id;

    //DES 1 3DES 2 AES 3 chacha20 4 自适应加密5
    private int encryptionType;

    //均值
    private double avgNum;

    //标准差
    private double standardDeviation;

    //变异系数
    private double CV;

    //最大值
    private double maxNum;
    //最小值
    private double minNum;
    //入库时间
    private Date enterTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(int encryptionType) {
        this.encryptionType = encryptionType;
    }

    public double getAvgNum() {
        return avgNum;
    }

    public void setAvgNum(double avgNum) {
        this.avgNum = avgNum;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public double getCV() {
        return CV;
    }

    public void setCV(double CV) {
        this.CV = CV;
    }

    public double getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(double maxNum) {
        this.maxNum = maxNum;
    }

    public double getMinNum() {
        return minNum;
    }

    public void setMinNum(double minNum) {
        this.minNum = minNum;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }
}
