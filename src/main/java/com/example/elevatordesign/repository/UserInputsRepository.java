package com.example.elevatordesign.repository;

import com.example.elevatordesign.Model.Floor;
import com.example.elevatordesign.Model.UserInputs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInputsRepository extends JpaRepository<UserInputs, Integer> {
    @Override
    UserInputs save(UserInputs entity);

    @Override
    Optional<UserInputs> findById(Integer integer);
}
