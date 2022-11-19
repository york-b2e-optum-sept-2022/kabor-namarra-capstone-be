package net.yorksolutions.kabornamarracapstonebe.dto;

import net.yorksolutions.kabornamarracapstonebe.entity.STAGE_TYPE;

import java.util.List;

public class NewStageRequestDTO {
//    public Long processId;
    public List<String> choiceText;
    public STAGE_TYPE stage_type;
    public Long stageOrder;
    public String question;
}
