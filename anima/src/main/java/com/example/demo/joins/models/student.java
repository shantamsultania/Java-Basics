package com.example.demo.joins.models;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Table(name = "data002",pk = "sid")
@Data
public class student extends Model {
    public student( String sName, String sSection) {
        this.sName = sName;
        this.sSection = sSection;
    }

    @Column(name = "sid")
    String sId;
    @Column(name = "sName")
    String sName;
    @Column(name = "section")
    String sSection;

}
