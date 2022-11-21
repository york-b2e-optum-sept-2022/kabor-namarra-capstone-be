package net.yorksolutions.kabornamarracapstonebe.dto;

import net.yorksolutions.kabornamarracapstonebe.entity.Process;

import java.util.List;

public class NewFinishedProcessRequestDTO {
    public String name;
    public List<NewFinishedStageRequestDTO> stages;
}
