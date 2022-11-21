package net.yorksolutions.kabornamarracapstonebe.dto;

import net.yorksolutions.kabornamarracapstonebe.entity.STAGE_TYPE;

import java.util.List;

public class NewFinishedStageRequestDTO {
    public List<String> choiceText;
    public List<String> response;
    public STAGE_TYPE stage_type;
    public Long stageOrder;
    public String question;
}
