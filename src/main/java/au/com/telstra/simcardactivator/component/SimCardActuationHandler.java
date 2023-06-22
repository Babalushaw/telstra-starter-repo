/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */


package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.Foundation.ActuationResult;
import au.com.telstra.simcardactivator.Foundation.SimCard;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@JsonIgnoreProperties(ignoreUnknown= true)
@Slf4j
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;
    private final String activationUrl="http://localhost:8444/actuate";

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
            String result=restTemplate.postForObject(activationUrl,simCard, ActuationResult.class).isSuccess()==true ?"sucess":"failed";
            log.info(simCard.getIccid()+ " successfully activate");
            return result;
        }catch(Exception e){
            return "server not available";
        }

    }

}
