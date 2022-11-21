package net.yorksolutions.kabornamarracapstonebe.controller;

import net.yorksolutions.kabornamarracapstonebe.dto.NewProcessRequestDTO;
import net.yorksolutions.kabornamarracapstonebe.dto.NewUpdatedProcessDTO;
import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import net.yorksolutions.kabornamarracapstonebe.service.ProcessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/process")
@CrossOrigin
public class ProcessController {

    private ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
    public Process createProcess(@RequestBody NewProcessRequestDTO requestDTO){
        return this.processService.createProcess(requestDTO);
    }

    @GetMapping
    public Iterable<Process> getAllProcesses(){
        return this.processService.getAllProcesses();
    }

    @GetMapping("/oneProcess")
    public Process getProcess(@RequestParam Long id){
        return this.processService.getProcess(id);
    }

    @PutMapping
    public Process updateProcess(@RequestBody NewUpdatedProcessDTO updatedProcessDTO){
        return this.processService.updateProcess(updatedProcessDTO);
    }
}
