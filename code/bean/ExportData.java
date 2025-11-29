package com.decsec.seclevel.bean;

public class ExportData {

    private int id;

    private String sensorID;

    private String PV;

    private String PT;

    private String PTDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getPV() {
        return PV;
    }

    public void setPV(String PV) {
        this.PV = PV;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }

    public String getPTDate() {
        return PTDate;
    }

    public void setPTDate(String PTDate) {
        this.PTDate = PTDate;
    }
}
