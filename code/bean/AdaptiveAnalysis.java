package com.decsec.seclevel.bean;

import java.util.Date;

//数据分析Bean
public class AdaptiveAnalysis {
    //主键id
    private int id;
    /**
     * 使用的加密类型
     * 1 Adaptive-DES
     * 2 Adaptive-3DES
     * 3 Adaptive-AES
     */
    private int encryptionType;
    //明文长度
    private int srcStrLength;
    //混淆字符串插入位置系数
    private double positionKeyN;
    //加密深度系数
    private int deepN;
    //加密深度
    private int deep;
    //密钥长度
    private int keyLength;
    //入库时间
    private Date enterTime;


    //自适应加密算法平均时间
    private double timeDiffAvgAdaptive;
    //自适应加密算法变化系数
    private double cvAdaptive;
    //DES平均时间
    private double timeDiffAvgDES;
    //DES变化系数
    private double cvDES;
    //自适应加密算法VS DES的平均时间百分比
    private double timeVSDES;
    //自适应加密算法VS DES的变化系数百分比
    private double cvVSDES;
    //DES3平均时间
    private double timeDiffAvgDES3;
    //DES变化系数
    private double cvDES3;
    //自适应加密算法VS DES3的平均时间百分比
    private double timeVSDES3;
    //自适应加密算法VS DES3的变化系数百分比
    private double cvVSDES3;
    //AES平均时间
    private double timeDiffAvgAES;
    //AES变化系数
    private double cvAES;
    //自适应加密算法VS AES的平均时间百分比
    private double timeVSAES;
    //自适应加密算法VS AES的变化系数百分比
    private double cvVSAES;
    //加解密类型 1加密 2解密
    private int type;
    //除数为0信息错误表示 其中1表示错误，即除数为0。自适应加密算法
    private int adaptiveError;
    //除数为0信息错误表示，其中1表示错误，即除数为0。其他算法
    private int encError;

    //ChaCha20平均时间
    private double timeDiffAvgCha;
    //ChaCha20变化系数
    private double cvCha;
    //自适应加密算法VS ChaCha20的平均时间百分比
    private double timeVSCha;
    //自适应加密算法VS ChaCha20的变化系数百分比
    private double cvVSCha;


    public double getTimeDiffAvgCha() {
        return timeDiffAvgCha;
    }

    public void setTimeDiffAvgCha(double timeDiffAvgCha) {
        this.timeDiffAvgCha = timeDiffAvgCha;
    }

    public double getCvCha() {
        return cvCha;
    }

    public void setCvCha(double cvCha) {
        this.cvCha = cvCha;
    }

    public double getTimeVSCha() {
        return timeVSCha;
    }

    public void setTimeVSCha(double timeVSCha) {
        this.timeVSCha = timeVSCha;
    }

    public double getCvVSCha() {
        return cvVSCha;
    }

    public void setCvVSCha(double cvVSCha) {
        this.cvVSCha = cvVSCha;
    }

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

    public double getTimeDiffAvgAdaptive() {
        return timeDiffAvgAdaptive;
    }

    public void setTimeDiffAvgAdaptive(double timeDiffAvgAdaptive) {
        this.timeDiffAvgAdaptive = timeDiffAvgAdaptive;
    }

    public double getCvAdaptive() {
        return cvAdaptive;
    }

    public void setCvAdaptive(double cvAdaptive) {
        this.cvAdaptive = cvAdaptive;
    }

    public double getTimeDiffAvgDES() {
        return timeDiffAvgDES;
    }

    public void setTimeDiffAvgDES(double timeDiffAvgDES) {
        this.timeDiffAvgDES = timeDiffAvgDES;
    }

    public double getCvDES() {
        return cvDES;
    }

    public void setCvDES(double cvDES) {
        this.cvDES = cvDES;
    }

    public double getTimeVSDES() {
        return timeVSDES;
    }

    public void setTimeVSDES(double timeVSDES) {
        this.timeVSDES = timeVSDES;
    }

    public double getCvVSDES() {
        return cvVSDES;
    }

    public void setCvVSDES(double cvVSDES) {
        this.cvVSDES = cvVSDES;
    }

    public double getTimeDiffAvgDES3() {
        return timeDiffAvgDES3;
    }

    public void setTimeDiffAvgDES3(double timeDiffAvgDES3) {
        this.timeDiffAvgDES3 = timeDiffAvgDES3;
    }

    public double getCvDES3() {
        return cvDES3;
    }

    public void setCvDES3(double cvDES3) {
        this.cvDES3 = cvDES3;
    }

    public double getTimeVSDES3() {
        return timeVSDES3;
    }

    public void setTimeVSDES3(double timeVSDES3) {
        this.timeVSDES3 = timeVSDES3;
    }

    public double getCvVSDES3() {
        return cvVSDES3;
    }

    public void setCvVSDES3(double cvVSDES3) {
        this.cvVSDES3 = cvVSDES3;
    }

    public double getTimeDiffAvgAES() {
        return timeDiffAvgAES;
    }

    public void setTimeDiffAvgAES(double timeDiffAvgAES) {
        this.timeDiffAvgAES = timeDiffAvgAES;
    }

    public double getCvAES() {
        return cvAES;
    }

    public void setCvAES(double cvAES) {
        this.cvAES = cvAES;
    }

    public double getTimeVSAES() {
        return timeVSAES;
    }

    public void setTimeVSAES(double timeVSAES) {
        this.timeVSAES = timeVSAES;
    }

    public double getCvVSAES() {
        return cvVSAES;
    }

    public void setCvVSAES(double cvVSAES) {
        this.cvVSAES = cvVSAES;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAdaptiveError() {
        return adaptiveError;
    }

    public void setAdaptiveError(int adaptiveError) {
        this.adaptiveError = adaptiveError;
    }

    public int getEncError() {
        return encError;
    }

    public void setEncError(int encError) {
        this.encError = encError;
    }
}
