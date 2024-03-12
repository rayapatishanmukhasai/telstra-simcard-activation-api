package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.client.SIMCardActivationClient;
import au.com.telstra.simcardactivator.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.dto.SIMCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SIMActivationService {
    @Autowired
    private SIMCardActivationClient simCardActivationClient;

    public ActuatorResponse activateSIM(SIMCard simCard) {
        return simCardActivationClient.actuate(simCard);
    }
}

