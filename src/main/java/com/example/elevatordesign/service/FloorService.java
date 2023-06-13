package com.example.elevatordesign.service;

import com.example.elevatordesign.Model.Floor;
import com.example.elevatordesign.Model.FloorUser;
import com.example.elevatordesign.Model.FloorUserStatus;
import com.example.elevatordesign.Model.UserInputs;
import com.example.elevatordesign.repository.FloorRepository;
import com.example.elevatordesign.repository.FloorUserInputsRepository;
import com.example.elevatordesign.repository.UserInputsRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FloorService {
    FloorRepository floorRepository;
    UserInputsRepository userInputsRepository;
    FloorUserInputsRepository floorUserInputsRepository;
    @Autowired
    public FloorService(
            FloorRepository floorRepository,
            UserInputsRepository userInputsRepository,
            FloorUserInputsRepository floorUserInputsRepository

    ){
        this.floorRepository = floorRepository;
        this.userInputsRepository = userInputsRepository;
        this.floorUserInputsRepository = floorUserInputsRepository;
    }

    public List<Floor> createFloors(List<Floor> floors){
        List<Floor> floors1 = new ArrayList<>();
        for(Floor floor : floors){
            Floor floor1 = floorRepository.save(floor);
            floors1.add(floor1);
        }
        return floors1;
    }
    public int OffAllFloorUserStatus(int floorNumber){
        Optional<Floor> optionalFloor = floorRepository.findByFloorNumber(floorNumber);
        Floor floor = optionalFloor.get();
        int front = floor.getFront();
        int Rear = floor.getRear();
        int total = 0;
        while(front<=Rear){
            FloorUser floorUser = floor.getFloorUsers().get(front);
            floorUser.setFloorUserStatus(FloorUserStatus.OFF);
            UserInputs userInputs = floorUser.getUserInputs();
            userInputs.setCompletedAt(LocalDateTime.now());
            UserInputs userInputs1 = userInputsRepository.save(userInputs);
            floorUser.setUserInputs(userInputs1);
            floorUserInputsRepository.save(floorUser);
            total++;
            front+=1;
        }
        floor.setFront(front);
        floorRepository.save(floor);

        return  total;
    }
}
