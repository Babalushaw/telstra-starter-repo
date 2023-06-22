/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.Foundation.SimCard;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface SimCardService {
    void addSimCardDetails(SimCard simCard);
}
