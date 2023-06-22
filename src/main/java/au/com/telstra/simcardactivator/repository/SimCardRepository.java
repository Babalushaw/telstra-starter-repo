/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.repository;

import au.com.telstra.simcardactivator.model.SimCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimCardRepository extends JpaRepository<SimCardEntity,Long> {
}
