package com.decsec.seclevel.bean;

import java.util.Date;

public class DataOutput {

    private int id;

    //DES 1 3DES 2 AES 3 chacha20 4 自适应加密5
    private int encryptionType;

    //加密深度定义为10
    private int deepN;

    //16进制 1-255
    private String keyHex;

    //值
    private double valueDouble;

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

    public int getDeepN() {
        return deepN;
    }

    public void setDeepN(int deepN) {
        this.deepN = deepN;
    }

    public String getKeyHex() {
        return keyHex;
    }

    public void setKeyHex(String keyHex) {
        this.keyHex = keyHex;
    }

    public double getValueDouble() {
        return valueDouble;
    }

    public void setValueDouble(double valueDouble) {
        this.valueDouble = valueDouble;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }
}
