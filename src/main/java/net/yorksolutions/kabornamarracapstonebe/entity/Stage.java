package net.yorksolutions.kabornamarracapstonebe.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;


    @ManyToOne
    private Process process;

    @ElementCollection
    private List<String> textAnswer;

    @ElementCollection
    private List<String> multipleChoice;

    @ElementCollection
    private List<String> checkBox;

    private STAGE_TYPE stage_type;

    private Long stageOrder;

    private String question;

    public Stage() {
    }

    public Stage(Process process, List<String> textAnswer, List<String> multipleChoice, List<String> checkBox, STAGE_TYPE stage_type, Long stageOrder, String question) {
        this.process = process;
        this.textAnswer = textAnswer;
        this.multipleChoice = multipleChoice;
        this.checkBox = checkBox;
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

    public List<String> getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(List<String> textAnswer) {
        this.textAnswer = textAnswer;
    }

    public List<String> getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(List<String> multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public List<String> getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(List<String> checkBox) {
        this.checkBox = checkBox;
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
