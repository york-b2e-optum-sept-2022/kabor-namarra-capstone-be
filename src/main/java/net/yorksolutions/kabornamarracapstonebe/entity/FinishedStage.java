package net.yorksolutions.kabornamarracapstonebe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class FinishedStage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ElementCollection
    private List<String> choiceText;

    @ElementCollection
    private List<String> response;

    private STAGE_TYPE stage_type;

    private Long stageOrder;

    private String question;

    public FinishedStage() {
    }

    public FinishedStage(List<String> choiceText, List<String> response, STAGE_TYPE stage_type, Long stageOrder, String question) {
        this.choiceText = choiceText;
        this.response = response;
        this.stage_type = stage_type;
        this.stageOrder = stageOrder;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public List<String> getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(List<String> choiceText) {
        this.choiceText = choiceText;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
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
