package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.dto.SIMCard;
import au.com.telstra.simcardactivator.dto.SIMCardEntity;
import au.com.telstra.simcardactivator.repo.SIMCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SIMCardService {
    @Autowired
    private SIMCardRepository simCardRepository;

    public SIMCard getSimCardById(Long id) {

        SIMCard simCard = new SIMCard();

        simCard.setIccid(Objects.requireNonNull(simCardRepository.findById(id).orElse(null)).getIccid());
        simCard.setCustomerEmail(Objects.requireNonNull(simCardRepository.findById(id).orElse(null)).getCustomerEmail());
        simCard.setActive(Objects.requireNonNull(simCardRepository.findById(id).orElse(null)).isActive());

        return simCard;
    }

    public void save(SIMCard simCard, ActuatorResponse actuatorResponse) {
        SIMCardEntity simCardEntity = new SIMCardEntity();

        simCardEntity.setIccid(simCard.getIccid());
        simCardEntity.setCustomerEmail(simCard.getCustomerEmail());
        simCardEntity.setActive(actuatorResponse.isSuccess());

        simCardRepository.save(simCardEntity);
    }


}
