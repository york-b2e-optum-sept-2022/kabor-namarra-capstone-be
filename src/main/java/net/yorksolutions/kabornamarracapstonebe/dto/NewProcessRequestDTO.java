package net.yorksolutions.kabornamarracapstonebe.dto;

import net.yorksolutions.kabornamarracapstonebe.entity.Stage;

import java.util.List;

public class NewProcessRequestDTO {
    public String name;
    public List<NewStageRequestDTO> stages;
}
