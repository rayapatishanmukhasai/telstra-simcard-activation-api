package au.com.telstra.simcardactivator.client;

import au.com.telstra.simcardactivator.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.dto.SIMCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SIMCardActivationClient {

    @Autowired
    private RestTemplate restTemplate;
    private final String actuatorUrl = "http://localhost:8444/actuate";


    public ActuatorResponse actuate(SIMCard simCard) {
        return restTemplate.postForObject(actuatorUrl, simCard, ActuatorResponse.class);
    }

}
