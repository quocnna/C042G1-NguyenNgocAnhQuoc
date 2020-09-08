package com.example.phone_manager.service;

import com.example.phone_manager.model.Smartphone;
import com.example.phone_manager.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Integer id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public void save(Smartphone phone) {
        smartphoneRepository.save(phone);
    }

    @Override
    public void remove(int id) {
        smartphoneRepository.deleteById(id);
    }
}
