/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.Foundation.SimCard;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@JsonIgnoreProperties(ignoreUnknown= true)
public class SimCardActivationRestController {
    @Autowired
   private  SimCardActuationHandler simCardActuationHandler;
    @PostMapping("/activate")
    public ResponseEntity<Object> activateSimCard(@RequestBody SimCard simCard){
        return ResponseEntity.status(HttpStatus.CREATED).body(simCardActuationHandler.actuateSimCard(simCard));
    }

}
