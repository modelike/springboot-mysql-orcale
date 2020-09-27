package com.example.recognition.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GSD_JJ_VIO_VEHICLE",schema = "JNODC")
public class Vehicle {
    @Id
    @Column(name="XH")
    private String XH;
    @Column(name="CLPP1")
    private String CLPP1;

    @Column(name="HPHM1")
    private String HPHM1;

    @Column(name="SYR")
    private String SYR;
//没有get和set方法
    public String getXH() {
        return XH;
    }

    public void setXH(String XH) {
        this.XH = XH;
    }

    public String getCLPP1() {
        return CLPP1;
    }

    public void setCLPP1(String CLPP1) {
        this.CLPP1 = CLPP1;
    }

    public String getHPHM1() {
        return HPHM1;
    }

    public void setHPHM1(String HPHM1) {
        this.HPHM1 = HPHM1;
    }

    public String getSYR() {
        return SYR;
    }

    public void setSYR(String SYR) {
        this.SYR = SYR;
    }
}
