package net.yorksolutions.kabornamarracapstonebe.dto;

import net.yorksolutions.kabornamarracapstonebe.entity.STAGE_TYPE;

import javax.persistence.ElementCollection;
import java.util.List;

public class NewStageRequestDTO {
    public Long processId;
    public List<String> textAnswer;
    public List<String> multipleChoice;
    public List<String> checkBox;
    public STAGE_TYPE stage_type;
    public Long stageOrder;
    public String question;
}
