package com.ecommerce.mufid.service;

import com.ecommerce.mufid.entity.Logistic;
import com.ecommerce.mufid.repository.LogisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogisticServiceImpl implements LogisticService{

    @Autowired
    private LogisticRepository logisticRepository;

    @Override
    public Logistic saveLogistic(Logistic logistic) {
        return logisticRepository.save(logistic);
    }

    @Override
    public Logistic updateLogistic(Logistic logistic) {
        return logisticRepository.save(logistic);
    }

    @Override
    public void deleteLogistic(Long id) {
        logisticRepository.deleteById(id);
    }

    @Override
    public Logistic getLogisticById(Long id) {
        Optional<Logistic> optionalLogistic = logisticRepository.findById(id);
        return optionalLogistic.orElse(null);  // Return the found logistic or null if not found
    }

    @Override
    public List<Logistic> getAllLogistics() {
        return logisticRepository.findAll();
    }

}
