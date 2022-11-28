package net.yorksolutions.kabornamarracapstonebe.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String name;

    @OneToMany(mappedBy = "process",cascade = {CascadeType.ALL}, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Stage> stages;

    public Process() {
    }

    public Process(String name) {
        this.name = name;
    }


//    public Process(String name, List<Stage> stages) {
//        this.name = name;
//        this.stages = stages;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }
}
