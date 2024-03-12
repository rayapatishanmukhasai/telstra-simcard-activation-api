package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.dto.SIMCard;
import au.com.telstra.simcardactivator.service.SIMActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SIMActivationController {

    @Autowired
    private SIMActivationService simActivationService;
    @Autowired
    private ActuatorResponse actuatorResponse;

    @PostMapping(value = "/activate")
    public ResponseEntity<ActuatorResponse> activateSimCard(@RequestBody SIMCard simCard) {
        try {
            actuatorResponse = simActivationService.activateSIM(simCard);
            System.out.println("Activation successful: " + actuatorResponse.isSuccess());
            return ResponseEntity.ok(actuatorResponse);
        } catch (Exception e) {
            System.out.println("Activation failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
