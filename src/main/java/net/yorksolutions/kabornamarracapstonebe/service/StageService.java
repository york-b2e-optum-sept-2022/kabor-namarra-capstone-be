package net.yorksolutions.kabornamarracapstonebe.service;

import net.yorksolutions.kabornamarracapstonebe.dto.NewStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewUpdateStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import net.yorksolutions.kabornamarracapstonebe.entity.Stage;
import net.yorksolutions.kabornamarracapstonebe.repository.ProcessRepository;
import net.yorksolutions.kabornamarracapstonebe.repository.StageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StageService {

    private StageRepository stageRepository;
    private ProcessRepository processRepository;

    public StageService(StageRepository stageRepository, ProcessRepository processRepository) {
        this.stageRepository = stageRepository;
        this.processRepository = processRepository;
    }

    public Stage createStage(NewStageRequestDTO stageRequestDTO){
        Optional<Process> processOpt = this.processRepository.findById(stageRequestDTO.processId);
        if (processOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return this.stageRepository.save(
                new Stage(processOpt.get(), stageRequestDTO.textAnswer, stageRequestDTO.multipleChoice,stageRequestDTO.checkBox, stageRequestDTO.stage_type, stageRequestDTO.stageOrder, stageRequestDTO.question)
        );
    }

    public Stage updateStage(NewUpdateStageRequestDTO stageRequestDTO){
        Optional<Stage> stageOpt = this.stageRepository.findById(stageRequestDTO.id);
        if (stageOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Stage stage = stageOpt.get();
        stage.setTextAnswer(stageRequestDTO.textAnswer);
        stage.setMultipleChoice(stageRequestDTO.multipleChoice);
        stage.setCheckBox(stageRequestDTO.checkBox);
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

    public Stage getStage(Long id){
        Optional<Stage> stageOpt = this.stageRepository.findById(id);
        if (stageOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return stageOpt.get();
    }
}
