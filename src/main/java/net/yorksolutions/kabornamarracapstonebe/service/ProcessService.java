package net.yorksolutions.kabornamarracapstonebe.service;

import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import net.yorksolutions.kabornamarracapstonebe.repository.ProcessRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProcessService {

    private ProcessRepository processRepository;

    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    public Process createProcess(Process process){
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
}
