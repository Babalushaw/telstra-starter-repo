/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 21, 2023
 */

package au.com.telstra.simcardactivator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimCardActivationController {
    @RequestMapping("/activate")
    public ResponseEntity<Object> activateSimCard(@RequestBody Object obj){
        RestTemplate restTemplate=new RestTemplate();
        String url="http://localhost:8444/actuate";
        return ResponseEntity.status(HttpStatus.CREATED).body(restTemplate.postForObject(url,obj,obj.getClass()));
    }

}
