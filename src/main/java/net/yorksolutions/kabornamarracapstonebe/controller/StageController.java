package net.yorksolutions.kabornamarracapstonebe.controller;

import net.yorksolutions.kabornamarracapstonebe.dto.NewAddStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewUpdateStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.Stage;
import net.yorksolutions.kabornamarracapstonebe.service.StageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stage")
@CrossOrigin
public class StageController {

    private StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @PostMapping
    public Stage createStage(@RequestBody NewAddStageRequestDTO addStageRequestDTO){
        return this.stageService.createStage(addStageRequestDTO);
    }

    @GetMapping
    public Iterable<Stage> getAllStages(@RequestParam Long processId){
        return this.stageService.getAllStages(processId);
    }

//    @GetMapping("/oneStage")
//    public Stage getStage(@RequestParam Long id){
//        return this.stageService.getStage(id);
//    }

    @PutMapping
    public Stage updateStage(@RequestBody NewUpdateStageRequestDTO stageRequestDTO){
        return this.stageService.updateStage(stageRequestDTO);
    }
}
