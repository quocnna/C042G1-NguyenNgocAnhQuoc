package com.example.phone_manager.service;

import com.example.phone_manager.model.Smartphone;

import java.util.Optional;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(Integer id);
    void save(Smartphone phone);
    void remove(int id);
}
