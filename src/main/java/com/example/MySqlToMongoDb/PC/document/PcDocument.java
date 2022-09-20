package com.example.MySqlToMongoDb.PC.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PcDocument {
    @Id
    private Long id;
    private String name;
    private String cpu;
    private Integer ram;
    private Integer stockage;

    public PcDocument() {

    }

    public PcDocument(Long id, String name, String cpu, Integer ram, Integer stockage) {
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
        return "PcDocument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", stockage=" + stockage +
                '}';
    }
}
