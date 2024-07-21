package com.ecommerce.mufid.service;

import com.ecommerce.mufid.entity.Logistic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogisticService {

    Logistic saveLogistic(Logistic logistic);
    Logistic updateLogistic(Logistic logistic);
    void deleteLogistic(Long id);
    Logistic getLogisticById(Long id);
    List<Logistic> getAllLogistics();

}
