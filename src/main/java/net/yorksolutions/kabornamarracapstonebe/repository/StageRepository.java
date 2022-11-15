package net.yorksolutions.kabornamarracapstonebe.repository;

import net.yorksolutions.kabornamarracapstonebe.entity.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends CrudRepository<Stage,Long> {
}
