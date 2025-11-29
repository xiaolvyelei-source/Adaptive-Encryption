package com.decsec.seclevel.bean;

import java.util.Date;

//自适应加密算法Bean，用于存取数据库
public class AdaptiveEncryption {

    //主键
    private int id;

    /**
     * 使用的加密类型
     * 1 Adaptive-DES
     * 2 Adaptive-3DES
     * 3 Adaptive-AES
     * 4 DES
     * 5 3DES
     * 6 AES
     * 7 Adaptive-ChaCha20
     * 8 ChaCha20
     */
    private int encryptionType;


    //明文长度
    private int srcStrLength;

    //位置系数
    private double positionN;

    //密钥截取位置系数
    private double positionKeyN;

    //加密深度系数
    private int deepN;

    //加密深度
    private int deep;

    //密钥长度
    private int keyLength;

    //录入时间
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

    public int getSrcStrLength() {
        return srcStrLength;
    }

    public void setSrcStrLength(int srcStrLength) {
        this.srcStrLength = srcStrLength;
    }

    public double getPositionN() {
        return positionN;
    }

    public void setPositionN(double positionN) {
        this.positionN = positionN;
    }

    public double getPositionKeyN() {
        return positionKeyN;
    }

    public void setPositionKeyN(double positionKeyN) {
        this.positionKeyN = positionKeyN;
    }

    public int getDeepN() {
        return deepN;
    }

    public void setDeepN(int deepN) {
        this.deepN = deepN;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(int keyLength) {
        this.keyLength = keyLength;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }


}
