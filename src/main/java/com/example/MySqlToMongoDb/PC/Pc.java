package com.example.MySqlToMongoDb.PC;


import com.example.MySqlToMongoDb.Project.Project;
import com.example.MySqlToMongoDb.User.User;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;
import java.util.Set;

/*import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;*/

@Entity(name = "Pc")
@Table(name = "pc")
//@Document
public class Pc {
    @Id
    private Long id;
    private String name;
    private String cpu;
    private Integer ram;
    private Integer stockage;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Project> project;

    public Pc() {

    }

    public Pc(Long id, String name, String cpu, Integer ram, Integer stockage) {
        this.id = id;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.stockage = stockage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStockage() {
        return stockage;
    }

    public void setStockage(Integer stockage) {
        this.stockage = stockage;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", stockage=" + stockage +
                '}';
    }
}
