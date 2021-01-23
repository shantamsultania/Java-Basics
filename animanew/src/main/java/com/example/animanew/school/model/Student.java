package com.example.animanew.school.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Table(name = "data002",pk = "s_id")
@Data
public class Student extends Model {
    public Student( String sName, String sSection) {
        this.sName = sName;
        this.sSection = sSection;
    }

    @Column(name = "s_id")
    String sId;
    @Column(name = "s_name")
    String sName;
    @Column(name = "s_section")
    String sSection;

}
