/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package stepDefinitions;

import au.com.telstra.simcardactivator.Foundation.SimCard;
import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.model.SimCardEntity;
import au.com.telstra.simcardactivator.service.SimCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
@Slf4j
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private static SimCard simCard;
    private static String result;
    @Autowired
    private SimCardService simCardService;
    private static final String url="http://localhost:3000/telstra/activate";
    @Given("Activate sim card")
    public void activate_sim_card() {
        simCard=new SimCard();
        log.info("sim card ready activation initiated");
    }
    @When("iccid equal {string}")
    public void iccid_equal(String string) {
        simCard.setIccid(string);
        simCard.setCustomerEmail("acb@gmail.com");
        result=restTemplate.postForObject(url,simCard,String.class);
    }
    @Then("result success")
    public void result_success() {

        Assert.assertEquals("success",result);
    }
    @Then("result failed")
    public void result_failed() {
        Assert.assertEquals("failed" ,result);
    }
    @Then("store into database")
    public void store_into_database() {
        simCardService.addSimCardDetails(simCard);
    }
    @Then("get details of sim card")
    public void get_details_of_sim_card() {
        ObjectMapper objectMapper=new ObjectMapper();
        Object sim=simCardService.getSimDetails(1L);
        SimCardEntity simCardEntity=objectMapper.convertValue(sim,SimCardEntity.class);
        Assert.assertEquals(simCardEntity.getIccid(), "1255789453849037777");
    }

}