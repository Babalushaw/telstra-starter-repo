/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */


package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.foundation.ActuationResult;
import au.com.telstra.simcardactivator.foundation.SimCard;
import au.com.telstra.simcardactivator.service.SimCardService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@JsonIgnoreProperties(ignoreUnknown= true)
@Slf4j
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;
    private static final String URL="http://localhost:8444/actuate";
    @Autowired
    private SimCardService simCardService;
    public SimCardActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /**
     *
     * @return sucess or failure
     *
     * Using restTemplate to make communication bridge to communicate simCard activation microservice
     */
    public String actuateSimCard(SimCard simCard) {
        try{
            boolean result= Objects.requireNonNull(restTemplate.postForObject(URL, simCard, ActuationResult.class)).isSuccess();
            restTemplate.postForObject(URL,simCard, SimCard.class);
            if(result){

                simCardService.addSimCardDetails(simCard);
            }
            log.info(simCard.getIccid()+ " successfully activate");
            return result ? "success" : "failed";
        }catch(Exception exception){
            return "";
        }

    }

}
