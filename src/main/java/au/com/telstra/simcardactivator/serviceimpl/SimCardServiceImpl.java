/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.serviceimpl;

import au.com.telstra.simcardactivator.foundation.SimCard;
import au.com.telstra.simcardactivator.model.SimCardEntity;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.SimCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    /**
     *
     * @param simId
     * @return simcard
     */
    @Override
    public Object getSimDetails(Long simId) {
        try{
            Optional<SimCardEntity> simCard=simCardRepository.findById(simId);
            if(!simCard.isEmpty()){
                SimCardEntity simCardEntity=simCard.get();
                SimCard simCard1=new SimCard();
                simCard1.setIccid(simCardEntity.getIccid());
                simCard1.setCustomerEmail(simCardEntity.getCustomerEmail());
                simCard1.setActive(simCard1.isActive());
                return simCard1;
            }
            return "sim card details not found";
        }catch(Exception e){
            return "server not available";
        }
    }
}
