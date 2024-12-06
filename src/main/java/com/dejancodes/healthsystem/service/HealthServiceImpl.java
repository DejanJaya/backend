package com.dejancodes.healthsystem.service;

import com.dejancodes.healthsystem.model.Health;
import com.dejancodes.healthsystem.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthService{

    @Autowired
    private HealthRepository healthRepository;

    @Override
    public Health saveHealth(Health health) {
        return healthRepository.save(health);
    }

    @Override
    public List<Health> getAllHealths() {
        return healthRepository.findAll();
    }
}
