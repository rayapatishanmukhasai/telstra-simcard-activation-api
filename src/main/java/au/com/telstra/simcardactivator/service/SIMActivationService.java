package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.dto.SIMCard;
import org.springframework.stereotype.Service;

@Service
public interface SIMActivationService {
    ActuatorResponse activateSIM(SIMCard simCard);
}

