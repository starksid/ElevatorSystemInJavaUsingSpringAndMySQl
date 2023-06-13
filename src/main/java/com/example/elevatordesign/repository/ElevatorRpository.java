package com.example.elevatordesign.repository;

import com.example.elevatordesign.Model.Elevator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorRpository extends JpaRepository<Elevator, Integer> {
    @Override
    Elevator save(Elevator entity);
}
