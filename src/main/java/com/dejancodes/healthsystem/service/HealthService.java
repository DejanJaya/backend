package com.dejancodes.healthsystem.service;

import com.dejancodes.healthsystem.model.Health;

import java.util.List;

public interface HealthService {
    public Health saveHealth(Health health);
    public List<Health> getAllHealths();
}
