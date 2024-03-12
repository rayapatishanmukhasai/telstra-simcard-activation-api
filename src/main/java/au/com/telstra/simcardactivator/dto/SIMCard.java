package au.com.telstra.simcardactivator.dto;

import org.springframework.stereotype.Repository;

@Repository
public class SIMCard {

    private String iccid;
    private String customerEmail;
    private boolean active;

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
