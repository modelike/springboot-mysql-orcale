package com.example.recognition.face.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="vehicle")
public class VeInfo implements Serializable,Cloneable {

    private static final long serialVersionUID = 6220944581578623224L;
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="id")
    private String Id;
    @Column(name="name")
    private String name;
    @Column(name="license")
    private String license;
    @Column(name="type")
    private String type;

    @Override
    public String toString() {
        return "VeInfo{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", license='" + license + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
