package net.yorksolutions.kabornamarracapstonebe.entity;

import javax.persistence.*;
import java.util.List;

public class stageAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Stage stage;

    @ManyToOne
    private Process process;

    @ElementCollection
    private List<String> choice;


}
