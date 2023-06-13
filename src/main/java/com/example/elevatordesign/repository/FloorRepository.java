package com.example.elevatordesign.repository;

import com.example.elevatordesign.Model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {
    @Override
    Floor save(Floor entity);

    @Override
    long count();

    Optional<Floor> findByFloorNumber(Integer integer);
}
