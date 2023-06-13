package com.example.elevatordesign.repository;

import com.example.elevatordesign.Model.Door;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoorRepository extends JpaRepository<Door, Integer> {
    @Override
    Door save(Door entity);


    Door findAllByDoorNumber(Integer integers);
}
