package com.dejancodes.healthsystem.repository;

import com.dejancodes.healthsystem.model.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface HealthRepository extends JpaRepository<Health,Integer>
{

}
