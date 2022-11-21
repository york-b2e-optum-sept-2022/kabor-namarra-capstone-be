package net.yorksolutions.kabornamarracapstonebe.dto;

import net.yorksolutions.kabornamarracapstonebe.entity.Stage;

import java.util.List;

public class NewUpdatedProcessDTO {
    public Long id;
    public String name;
    public List<NewUpdateStageRequestDTO> updateStages;
    public List<NewStageRequestDTO> newStages;
}
