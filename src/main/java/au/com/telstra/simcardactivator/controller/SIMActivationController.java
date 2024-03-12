package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.dto.SIMCard;
import au.com.telstra.simcardactivator.service.SIMActivationService;
import au.com.telstra.simcardactivator.service.SIMCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SIMActivationController {

    @Autowired
    private SIMActivationService simActivationService;
    @Autowired
    private SIMCardService simCardService;
    @Autowired
    private ActuatorResponse actuatorResponse;

    @PostMapping(value = "/activate")
    public ResponseEntity<ActuatorResponse> activateSimCard(@RequestBody SIMCard simCard) {
        try {
            actuatorResponse = simActivationService.activateSIM(simCard);
            System.out.println("Activation successful: " + actuatorResponse.isSuccess());
            simCardService.save(simCard, actuatorResponse);
            return ResponseEntity.ok(actuatorResponse);
        } catch (Exception e) {
            System.out.println("Activation failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/simcard/{id}")
    public ResponseEntity<SIMCard> getActivationById(@PathVariable Long id) {

        if (simCardService.getSimCardById(id) != null) {
            return ResponseEntity.ok(simCardService.getSimCardById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
