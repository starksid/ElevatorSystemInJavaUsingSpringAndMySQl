package com.example.elevatordesign;

import com.example.elevatordesign.Model.Elevator;
import com.example.elevatordesign.Model.ElevatorGoingStatus;
import com.example.elevatordesign.Model.ElevatorStatus;
import com.example.elevatordesign.controller.DoorController;
import com.example.elevatordesign.controller.ElevatorController;
import com.example.elevatordesign.controller.FloorController;
import com.example.elevatordesign.controller.UserInputsController;
import com.example.elevatordesign.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.example.elevatordesign.Model.Door;


import java.util.Scanner;
@EnableJpaAuditing
@SpringBootApplication
public class ElevatorDesignApplication implements CommandLineRunner {


    @Autowired
    ElevatorController eelevatorController;
    @Autowired
    UserInputsController userInputsController;
    @Autowired
    FloorController floorController;
    @Autowired
    DoorController doorController;
    @Override
    public void run(String... args) throws Exception {


        System.out.println("Please Give Number of floors for your elevator");
        Scanner sc = new Scanner(System.in);
        int numberOfFloors = sc.nextInt();
        FloorRequestDto request = new FloorRequestDto();
        request.setNumberOfFloors(numberOfFloors);
        FloorResponseDto responseDto = floorController.createFloors(request);
        CreateElevatorDtoRequest requestElevator = new CreateElevatorDtoRequest();
        requestElevator.setFloors(responseDto.getFloors());
        requestElevator.setNumberOfFloors(numberOfFloors);
        Door door = doorController.createDoor();
        requestElevator.setDoor(door);

        Elevator elevator = eelevatorController.createElevator(requestElevator);
        CreateUserInputsRequestDto requestDto = new CreateUserInputsRequestDto();
        while (elevator.getElevatorStatus().equals(ElevatorStatus.ON)){
            userInputsController.createUserInputs(requestDto, elevator);
            while(elevator.getFront()<=elevator.getRear()){
                eelevatorController.movingUpOrDown(elevator);
                userInputsController.createUserInputs(requestDto, elevator);
            }
            if(elevator.getElevatorGoingStatus().equals(ElevatorGoingStatus.STILL)){
                System.out.println("Elevator is at " + elevator.getAtFloorNumber() + " floor number");
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ElevatorDesignApplication.class, args);
    }

}
