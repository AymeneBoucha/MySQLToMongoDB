package com.example.MySqlToMongoDb.Project;

import com.example.MySqlToMongoDb.User.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Project")
@Table(name = "project")
public class Project {

    @Id
    private Long id;

    private String name;

    private Integer participantsNb;

    private Integer durationMonths;

    @ManyToOne
    private User chef;

    public Project() {

    }

    public Project(Long id, String name, Integer participantsNb, Integer durationMonths, User chef) {
        this.id = id;
        this.name = name;
        this.participantsNb = participantsNb;
        this.durationMonths = durationMonths;
        this.chef = chef;
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

    public Integer getParticipantsNb() {
        return participantsNb;
    }

    public void setParticipantsNb(Integer participantsNb) {
        this.participantsNb = participantsNb;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", participantsNb=" + participantsNb +
                ", durationMonths=" + durationMonths +
                ", chef=" + chef +
                '}';
    }
}
