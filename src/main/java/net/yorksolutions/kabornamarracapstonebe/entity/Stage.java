package net.yorksolutions.kabornamarracapstonebe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;


    @ManyToOne()
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @JsonBackReference
    private Process process;

//    @OneToMany(cascade = {CascadeType.ALL})
    @ElementCollection
    private List<String> choiceText;

    private STAGE_TYPE stage_type;

    private Long stageOrder;

    private String question;

    public Stage() {
    }

//    public Stage(Process process, String question) {
//        this.process = process;
//        this.question = question;
//    }


    public Stage(Process process, List<String> choiceText, STAGE_TYPE stage_type, Long stageOrder, String question) {
        this.process = process;
        this.choiceText = choiceText;
        this.stage_type = stage_type;
        this.stageOrder = stageOrder;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public List<String> getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(List<String> choiceText) {
        this.choiceText = choiceText;
    }

    public STAGE_TYPE getStage_type() {
        return stage_type;
    }

    public void setStage_type(STAGE_TYPE stage_type) {
        this.stage_type = stage_type;
    }

    public Long getStageOrder() {
        return stageOrder;
    }

    public void setStageOrder(Long stageOrder) {
        this.stageOrder = stageOrder;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
