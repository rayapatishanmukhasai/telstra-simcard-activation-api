package au.com.telstra.simcardactivator.dto;

import org.springframework.stereotype.Component;

@Component
public class ActuatorResponse {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
