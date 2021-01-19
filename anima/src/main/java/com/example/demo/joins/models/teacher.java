package com.example.demo.joins.models;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Table(name = "data001",pk = "tid")
@Data
public class teacher extends Model {
    @Column(name = "tid")
    String tId;
    @Column(name = "tName")
    String tName;
    @Column(name = "section")
    String tSection;

    public teacher(String tName, String tSection) {
        this.tName = tName;
        this.tSection = tSection;
    }
}
