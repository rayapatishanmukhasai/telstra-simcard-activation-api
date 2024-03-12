package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.dto.SIMCard;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private SIMCard simCard;

    @Given("a functional sim card")
    public void aFunctionalSimCard() {
        simCard = new SIMCard();
        simCard.setIccid("1255789453849037777");
        simCard.setCustomerEmail("horatio.yakima@groovemail.com");
        simCard.setActive(false);
    }

    @Given("a broken sim card")
    public void aBrokenSimCard() {
        simCard = new SIMCard();
        simCard.setIccid("8944500102198304826");
        simCard.setCustomerEmail("notorious.criminal@gonepostal.com");
        simCard.setActive(false);
    }

    @When("a request to activate the sim card is submitted")
    public void aRequestToActivateTheSimCardIsSubmitted() {
        ResponseEntity<String> response = restTemplate.postForEntity("/activate", simCard, String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Then("the sim card is activated and its state is recorded to the database")
    public void theSimCardIsActivatedAndItsStateIsRecordedToTheDatabase() {
        ResponseEntity<SIMCard> response = restTemplate.getForEntity("/simcard/1", SIMCard.class);
        assertTrue(response.getBody().isActive());
    }

    @Then("the sim card fails to activate and its state is recorded to the database")
    public void theSimCardFailsToActivateAndItsStateIsRecordedToTheDatabase() {
        ResponseEntity<SIMCard> response = restTemplate.getForEntity("/simcard/2", SIMCard.class);
        assertFalse(response.getBody().isActive());
    }
}