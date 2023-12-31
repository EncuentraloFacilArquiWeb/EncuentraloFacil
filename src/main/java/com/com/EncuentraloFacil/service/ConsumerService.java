package com.com.EncuentraloFacil.service;

import com.com.EncuentraloFacil.model.Consumer;
import com.com.EncuentraloFacil.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsumerService {
    private final ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public Consumer addConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }
    public List<Consumer> lista() {
        return consumerRepository.findAll();
    }
}
