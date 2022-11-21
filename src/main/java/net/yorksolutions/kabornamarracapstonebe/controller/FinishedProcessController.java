package net.yorksolutions.kabornamarracapstonebe.controller;

import net.yorksolutions.kabornamarracapstonebe.dto.NewFinishedProcessRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.FinishedProcess;
import net.yorksolutions.kabornamarracapstonebe.service.FinishedProcessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/finishedProcess")
@CrossOrigin
public class FinishedProcessController {


    public FinishedProcessService finishedProcessService;

    public FinishedProcessController(FinishedProcessService finishedProcessService) {
        this.finishedProcessService = finishedProcessService;
    }


    @PostMapping
    public FinishedProcess createFinishedProcess(@RequestBody NewFinishedProcessRequestDTO finishedProcessRequestDTO){
        return this.finishedProcessService.createFinishedProcess(finishedProcessRequestDTO);
    }

    @GetMapping
    public Iterable<FinishedProcess> getAllFinishedProcesses(){
        return this.finishedProcessService.getAllFinishedProcesses();
    }
}
