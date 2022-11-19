package net.yorksolutions.kabornamarracapstonebe.service;

import net.yorksolutions.kabornamarracapstonebe.dto.NewAddStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewUpdateStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import net.yorksolutions.kabornamarracapstonebe.entity.Stage;
import net.yorksolutions.kabornamarracapstonebe.repository.ProcessRepository;
import net.yorksolutions.kabornamarracapstonebe.repository.StageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private StageRepository stageRepository;
    private ProcessRepository processRepository;

    public StageService(StageRepository stageRepository, ProcessRepository processRepository) {
        this.stageRepository = stageRepository;
        this.processRepository = processRepository;
    }

    public Stage createStage(NewAddStageRequestDTO addStageRequestDTO){
        Optional<Process> processOpt = this.processRepository.findById(addStageRequestDTO.processId);
        if (processOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Stage stage = new Stage(processOpt.get(),addStageRequestDTO.choiceText,addStageRequestDTO.stage_type,addStageRequestDTO.stageOrder, addStageRequestDTO.question);

//        Stage stage = new Stage(processOpt.get(), stageRequestDTO.choiceText, stageRequestDTO.stage_type, stageRequestDTO.stageOrder, stageRequestDTO.question);
        processOpt.get().getStages().add(stage);
        processOpt.get().setStages(processOpt.get().getStages());

        return this.stageRepository.save(stage);
    }

    public Stage updateStage(NewUpdateStageRequestDTO stageRequestDTO){
        Optional<Stage> stageOpt = this.stageRepository.findById(stageRequestDTO.id);
        if (stageOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Stage stage = stageOpt.get();
        stage.setChoiceText(stageRequestDTO.choiceText);
        stage.setStage_type(stageRequestDTO.stage_type);
        stage.setStageOrder(stageRequestDTO.stageOrder);
        stage.setQuestion(stageRequestDTO.question);


        return this.stageRepository.save(stage);

    }

    public Iterable<Stage> getAllStages(Long processId){
        Optional<Process> processOpt = this.processRepository.findById(processId);
        if (processOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return this.stageRepository.findAllByProcess(processOpt.get());
    }
//
//    public Stage getStage(Long id){
//        Optional<Stage> stageOpt = this.stageRepository.findById(id);
//        if (stageOpt.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        return stageOpt.get();
//    }
}
