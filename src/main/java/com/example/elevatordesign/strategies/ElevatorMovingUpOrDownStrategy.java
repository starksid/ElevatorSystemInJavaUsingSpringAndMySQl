package com.example.elevatordesign.strategies;

import com.example.elevatordesign.Model.*;
import com.example.elevatordesign.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElevatorMovingUpOrDownStrategy implements MovingUpOrDownStrategy {
    FloorRepository floorRepository;
    @Autowired
    public ElevatorMovingUpOrDownStrategy(FloorRepository floorRepository){
        this.floorRepository = floorRepository;
    }
    @Override
    public ElevatorGoingStatus elevatorMovingUpOrDownAlgorithm(Elevator elevator) {
        int elevatorAtFloorNumber = elevator.getAtFloorNumber();
        for(int atFloor = elevatorAtFloorNumber+1 ; atFloor<elevator.getNumberOfFloors(); atFloor++){
            Optional<Floor> optionalFloor = floorRepository.findByFloorNumber(atFloor);
            Floor floor = optionalFloor.get();
            if(floor.front<=floor.rear){
                elevator.setElevatorGoingStatus(ElevatorGoingStatus.UP);
                return elevator.getElevatorGoingStatus();

            }


        }

        for(int atFloor = elevatorAtFloorNumber-1 ; atFloor>=0; atFloor--){
            Optional<Floor> optionalFloor = floorRepository.findByFloorNumber(atFloor);
            Floor floor = optionalFloor.get();
            if(floor.front<=floor.rear){
                elevator.setElevatorGoingStatus(ElevatorGoingStatus.DOWN);
                return elevator.getElevatorGoingStatus();

            }


        }

        elevator.setElevatorGoingStatus(ElevatorGoingStatus.STILL);

        return elevator.getElevatorGoingStatus();


    }
}
