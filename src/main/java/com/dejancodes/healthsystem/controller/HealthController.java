package com.dejancodes.healthsystem.controller;

import com.dejancodes.healthsystem.exception.HealthNotFoundException;
import com.dejancodes.healthsystem.model.Health;
import com.dejancodes.healthsystem.repository.HealthRepository;
import com.dejancodes.healthsystem.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
@CrossOrigin("http://localhost:3000")
public class HealthController {
    @Autowired
    private HealthService healthService;
    private HealthRepository healthRepository;

    @PostMapping("/add")
    public String add(@RequestBody Health health){
        healthService.saveHealth(health);
        return "New health is added";
    }

    @GetMapping("/getAll")
    public List<Health> getAllHealths(){
        return healthService.getAllHealths();
    }

    @GetMapping("/get/{id}")
    Health getHealthById(@PathVariable int id) {
        return healthRepository.findById(id)
                .orElseThrow(() -> new HealthNotFoundException(id));
    }

    @PutMapping("/update/{id}")
    Health updateUser(@RequestBody Health newHealth, @PathVariable int id) {
        return healthRepository.findById(id)
                .map(health -> {
                    health.setName(newHealth.getName());
                    health.setAddress(newHealth.getAddress());
                    return healthRepository.save(health);
                }).orElseThrow(() -> new HealthNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable int id){
        if(!healthRepository.existsById(id)){
            throw new HealthNotFoundException(id);
        }
        healthRepository.deleteById(id);
        return  "Health with id "+id+" has been deleted success.";
    }

}
