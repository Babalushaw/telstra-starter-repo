/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.ServiceImpl;

import au.com.telstra.simcardactivator.Foundation.SimCard;
import au.com.telstra.simcardactivator.model.SimCardEntity;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.SimCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimCardServiceImpl implements SimCardService {
    @Autowired
    private SimCardRepository simCardRepository;

    /**
     *
     * @param simCard
     *
     * Interacting with database to store entity
     */
    @Override
    public void addSimCardDetails(SimCard simCard) {
        log.info(simCard.getCustomerEmail());
        try{
            SimCardEntity simCardEntity= new SimCardEntity();
            simCardEntity.setIccid(simCard.getIccid());
            simCardEntity.setCustomerEmail(simCard.getCustomerEmail());
            simCardEntity.setActive(true);
            simCardRepository.save(simCardEntity);
            log.info(simCardEntity.getSimCardId() +" is added successfully" );
        }catch(Exception e){
            log.info("server not available");
        }
    }
}
