package net.yorksolutions.kabornamarracapstonebe.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;


    @ManyToOne
    private Process process;

    private Boolean yesNo;

    @ElementCollection
    private List<String> textAnswer;

    @ElementCollection
    private List<String> multipleChoice;

    @ElementCollection
    private List<String> multipleCheckBox;

    public Stage() {
    }

    public Stage(Process process, Boolean yesNo, List<String> textAnswer, List<String> multipleChoice, List<String> multipleCheckBox) {
        this.process = process;
        this.yesNo = yesNo;
        this.textAnswer = textAnswer;
        this.multipleChoice = multipleChoice;
        this.multipleCheckBox = multipleCheckBox;
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

    public Boolean getYesNo() {
        return yesNo;
    }

    public void setYesNo(Boolean yesNo) {
        this.yesNo = yesNo;
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

    public List<String> getMultipleCheckBox() {
        return multipleCheckBox;
    }

    public void setMultipleCheckBox(List<String> multipleCheckBox) {
        this.multipleCheckBox = multipleCheckBox;
    }
}
