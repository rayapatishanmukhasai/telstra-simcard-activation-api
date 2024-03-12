package au.com.telstra.simcardactivator.repo;

import au.com.telstra.simcardactivator.dto.SIMCardEntity;
import org.springframework.data.repository.CrudRepository;

public interface SIMCardRepository extends CrudRepository<SIMCardEntity, Long> {
}
