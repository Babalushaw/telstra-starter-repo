/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */


package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.Foundation.ActuationResult;
import au.com.telstra.simcardactivator.Foundation.SimCard;
import au.com.telstra.simcardactivator.service.SimCardService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@JsonIgnoreProperties(ignoreUnknown= true)
@Slf4j
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;
    private final String activationUrl="http://localhost:8444/actuate";
    @Autowired
    private SimCardService simCardService;
    public SimCardActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /**
     *
     * @param simCard
     * @return sucess or failure
     *
     * Using restTemplate to make communication bridge to communicate simCard activation microservice
     */
    public String actuateSimCard(SimCard simCard){
        try{

            Boolean result=restTemplate.postForObject(activationUrl,simCard, ActuationResult.class).isSuccess();
            if(result==true){
                simCardService.addSimCardDetails(simCard);
            }
            log.info(simCard.getIccid()+ " successfully activate");
            return result==true? "success" : "failed";
        }catch(Exception e){
            return "server not available";
        }

    }

}
