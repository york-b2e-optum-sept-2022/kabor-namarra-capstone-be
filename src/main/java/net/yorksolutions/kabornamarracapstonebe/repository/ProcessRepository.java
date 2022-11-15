package net.yorksolutions.kabornamarracapstonebe.repository;

import net.yorksolutions.kabornamarracapstonebe.entity.Process;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends CrudRepository<Process,Long> {
}
