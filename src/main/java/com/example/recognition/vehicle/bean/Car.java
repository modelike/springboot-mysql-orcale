package com.example.recognition.vehicle.bean;

import javax.persistence.Column;

public class Car {
    private String XH;
    private String CLPP1;
    private String HPHM1;
    private String SYR;

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
