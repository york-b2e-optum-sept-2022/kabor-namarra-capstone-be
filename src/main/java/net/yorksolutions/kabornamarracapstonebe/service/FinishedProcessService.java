package net.yorksolutions.kabornamarracapstonebe.service;

import net.yorksolutions.kabornamarracapstonebe.dto.NewFinishedProcessRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewFinishedStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewProcessRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewStageRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.FinishedProcess;
import net.yorksolutions.kabornamarracapstonebe.entity.FinishedStage;
import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import net.yorksolutions.kabornamarracapstonebe.entity.Stage;
import net.yorksolutions.kabornamarracapstonebe.repository.FinishedProcessRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FinishedProcessService {

    public FinishedProcessRepository finishedProcessRepository;

    public FinishedProcessService(FinishedProcessRepository finishedProcessRepository) {
        this.finishedProcessRepository = finishedProcessRepository;
    }

    public FinishedProcess createFinishedProcess(NewFinishedProcessRequestDTO finishedProcessRequestDTO){
//        Optional<Process> processOpt = this.processRepository.findById(id);
//        if (processOpt.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
        List<FinishedStage> finishedStageList = new ArrayList<FinishedStage>();
        for (NewFinishedStageRequestDTO finishedStageRequestDTO: finishedProcessRequestDTO.stages){
            FinishedStage finishedStage = new FinishedStage(finishedStageRequestDTO.choiceText,finishedStageRequestDTO.response,finishedStageRequestDTO.stage_type,finishedStageRequestDTO.stageOrder,finishedStageRequestDTO.question);
            finishedStageList.add(finishedStage);
        }
        FinishedProcess finishedProcess = new FinishedProcess(finishedProcessRequestDTO.name,finishedStageList);

//        this.stageRepository.saveAll(stageList);

        return this.finishedProcessRepository.save(finishedProcess);
    }

    public Iterable<FinishedProcess> getAllFinishedProcesses(){
        return this.finishedProcessRepository.findAll();
    }
}
