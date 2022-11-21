package net.yorksolutions.kabornamarracapstonebe.service;

import net.yorksolutions.kabornamarracapstonebe.dto.NewProcessRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewUpdateStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewUpdatedProcessDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import net.yorksolutions.kabornamarracapstonebe.entity.Stage;
import net.yorksolutions.kabornamarracapstonebe.repository.ProcessRepository;
import net.yorksolutions.kabornamarracapstonebe.repository.StageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessService {

    private ProcessRepository processRepository;
    private StageRepository stageRepository;

    public ProcessService(ProcessRepository processRepository, StageRepository stageRepository) {
        this.processRepository = processRepository;
        this.stageRepository = stageRepository;
    }

    public Process createProcess(NewProcessRequestDTO requestDTO){

        Process process = new Process(requestDTO.name);
        List<Stage> stageList = new ArrayList<Stage>();
        for (NewStageRequestDTO stage: requestDTO.stages){
            Stage stage1 = new Stage(process,stage.choiceText,stage.stage_type,stage.stageOrder,stage.question);
            stageList.add(stage1);
        }
        process.setStages(stageList);
//        this.stageRepository.saveAll(stageList);

        return this.processRepository.save(process);
    }

    public Iterable<Process> getAllProcesses(){
        return this.processRepository.findAll();
    }

    public Process getProcess(Long id){
        Optional<Process> processOpt = this.processRepository.findById(id);
        if (processOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return processOpt.get();
    }

    public Process updateProcess(NewUpdatedProcessDTO updatedProcessDTO){
        Optional<Process> processOpt = this.processRepository.findById(updatedProcessDTO.id);
        if (processOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        List<Stage> stageList = new ArrayList<Stage>();
        for (NewStageRequestDTO stage: updatedProcessDTO.newStages){
            Stage stage1 = new Stage(processOpt.get(),stage.choiceText,stage.stage_type,stage.stageOrder,stage.question);
            stageList.add(stage1);
        }
        for(NewUpdateStageRequestDTO stage: updatedProcessDTO.updateStages){
            Optional<Stage> stageOpt = this.stageRepository.findById(stage.id);
            if (stageOpt.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            Stage stageUp = stageOpt.get();
            stageUp.setChoiceText(stage.choiceText);
            stageUp.setStage_type(stage.stage_type);
            stageUp.setStageOrder(stage.stageOrder);
            stageUp.setQuestion(stage.question);

            stageList.add(stageUp);
        }
        stageList.sort(Comparator.comparing(Stage::getStageOrder));

        Process process = processOpt.get();
        process.setStages(stageList);
        process.setName(updatedProcessDTO.name);


        this.stageRepository.saveAll(stageList);
        return this.processRepository.save(process);
    }
}
