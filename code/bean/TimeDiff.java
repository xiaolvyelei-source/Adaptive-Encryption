package com.decsec.seclevel.bean;

/**
 * 时间差
 */
public class TimeDiff {

    //主键id
    private int id;

    //加密bean id
    private int encryptionId;

    //时间差
    private long timeDiff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEncryptionId() {
        return encryptionId;
    }

    public void setEncryptionId(int encryptionId) {
        this.encryptionId = encryptionId;
    }

    public long getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(long timeDiff) {
        this.timeDiff = timeDiff;
    }
}
