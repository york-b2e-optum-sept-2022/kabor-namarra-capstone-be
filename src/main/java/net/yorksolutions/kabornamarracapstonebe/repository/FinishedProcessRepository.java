package net.yorksolutions.kabornamarracapstonebe.repository;

import net.yorksolutions.kabornamarracapstonebe.entity.FinishedProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinishedProcessRepository extends CrudRepository<FinishedProcess,Long> {
}
