package com.example.elevatordesign.repository;

import com.example.elevatordesign.Model.Floor;
import com.example.elevatordesign.Model.FloorUser;
import com.example.elevatordesign.Model.FloorUserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FloorUserInputsRepository extends JpaRepository<FloorUser, Integer> {
    @Override
    FloorUser save(FloorUser entity);

    @Override
    Optional<FloorUser> findById(Integer integer);


}
