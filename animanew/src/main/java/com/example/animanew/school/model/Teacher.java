package com.example.animanew.school.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Table(name = "data001",pk = "t_id")
@Data
public class Teacher extends Model {

    public Teacher(String tName, String tSection) {
        this.tName = tName;
        this.tSection = tSection;
    }

    @Column(name = "t_id")
    String tId;
    @Column(name = "t_name")
    String tName;
    @Column(name = "t_section")
    String tSection;


}
