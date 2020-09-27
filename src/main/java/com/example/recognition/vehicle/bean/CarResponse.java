package com.example.recognition.vehicle.bean;

import com.example.recognition.face.bean.PersonPage;

public class CarResponse {
    private String code;
    private String msg;
    private Car car;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Car getData() {
        return car;
    }

    public void setData(Car car) {
        this.car = car;
    }
}
