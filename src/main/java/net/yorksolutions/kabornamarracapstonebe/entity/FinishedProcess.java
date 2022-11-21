package net.yorksolutions.kabornamarracapstonebe.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FinishedProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany
    private List<FinishedStage> finishedStages;


    public FinishedProcess() {
    }

    public FinishedProcess(String name, List<FinishedStage> finishedStages) {
        this.name = name;
        this.finishedStages = finishedStages;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FinishedStage> getFinishedStages() {
        return finishedStages;
    }

    public void setFinishedStages(List<FinishedStage> finishedStages) {
        this.finishedStages = finishedStages;
    }
}
