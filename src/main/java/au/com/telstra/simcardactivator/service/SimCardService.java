/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.foundation.SimCard;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardService {
    void addSimCardDetails(SimCard simCard);

    Object getSimDetails(Long simId);
}
