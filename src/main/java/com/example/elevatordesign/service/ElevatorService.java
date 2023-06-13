package com.example.elevatordesign.service;

import com.example.elevatordesign.Model.*;
import com.example.elevatordesign.repository.ElevatorRpository;
import com.example.elevatordesign.repository.FloorUserInputsRepository;
import com.example.elevatordesign.strategies.MovingUpOrDownStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevatorService {
    MovingUpOrDownStrategy elevatorMoving;
    FloorUserInputsRepository floorUserInputsRepository;
    ElevatorRpository elevatorRpository;
    @Autowired
    public ElevatorService(MovingUpOrDownStrategy elevatorMoving, FloorUserInputsRepository floorUserInputsRepository, ElevatorRpository elevatorRpository){
        this.elevatorMoving = elevatorMoving;
        this.floorUserInputsRepository = floorUserInputsRepository;
        this.elevatorRpository = elevatorRpository;
    }
    public Elevator createElevator(int numberOfFloors, List<Floor> floors, Door door){
        Elevator elevator = Elevator.getBuilder().setNumberOfFloors(numberOfFloors).setFloors(floors).setDoor(door).build();
        Elevator savedElevator = elevatorRpository.save(elevator);
        return savedElevator;
    }
    public ElevatorGoingStatus movingElevator(Elevator elevator){
        return elevatorMoving.elevatorMovingUpOrDownAlgorithm(elevator);
    }
}
