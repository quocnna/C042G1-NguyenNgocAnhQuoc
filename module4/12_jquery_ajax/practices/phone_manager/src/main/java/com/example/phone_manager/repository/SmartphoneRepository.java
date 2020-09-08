package com.example.phone_manager.repository;

import com.example.phone_manager.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
