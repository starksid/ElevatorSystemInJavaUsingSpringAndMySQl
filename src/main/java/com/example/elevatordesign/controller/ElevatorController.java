package com.example.elevatordesign.controller;

import com.example.elevatordesign.Model.Elevator;
import com.example.elevatordesign.Model.ElevatorGoingStatus;
import com.example.elevatordesign.dtos.CreateElevatorDtoRequest;
import com.example.elevatordesign.service.ElevatorService;
import com.example.elevatordesign.service.UserInputsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Scanner;

@Controller
public class ElevatorController {
    UserInputsService userInputsService;
    ElevatorService elevatorService;
    FloorController floorController;
    int floorNumbers;
    Scanner sc = new Scanner(System.in);
    @Autowired
    public ElevatorController(
            UserInputsService userInputsService,
            ElevatorService elevatorService,
            FloorController floorController
    ){
        this.userInputsService = userInputsService;
        this.elevatorService = elevatorService;
        this.floorController = floorController;
    }
    public Elevator createElevator(CreateElevatorDtoRequest request){
        Elevator elevator = elevatorService.createElevator(request.getNumberOfFloors(), request.getFloors(), request.getDoor());
        this.floorNumbers = elevator.getNumberOfFloors();
        return elevator;
    }

    public ElevatorGoingStatus decideToMoveUpOrDown(Elevator elevator){
        return elevatorService.movingElevator(elevator);
    }
    public void elevatorGoingDown(Elevator elevator){

        int Front = elevator.getFront();
        int atFloorNumber = elevator.getAtFloorNumber();
        elevator.setAtFloorNumber(atFloorNumber-1);

        System.out.println("Elevator is at " + elevator.getAtFloorNumber());
        int total = checkElevatorAtFloorNumber(elevator);
        elevator.setFront(Front+total);

    }
    public void elevatorGoingUp(Elevator elevator){

        int Front = elevator.getFront();


        int atFloorNumber = elevator.getAtFloorNumber();
        elevator.setAtFloorNumber(atFloorNumber+1);
        System.out.println("Elevator is at " + elevator.getAtFloorNumber());
        int total = checkElevatorAtFloorNumber(elevator);
        elevator.setFront(Front+total);

    }
    public void movingUpOrDown(Elevator elevator){
        if(decideToMoveUpOrDown(elevator).equals(ElevatorGoingStatus.DOWN)){
            System.out.println("elevator is going Down ");
            elevatorGoingDown(elevator);
        }else {
            System.out.println("Elevator is going Up ");
            elevatorGoingUp(elevator);
        }

    }


    public int checkElevatorAtFloorNumber(Elevator elevator){
        return floorController.OffAllFloorUserStatus(elevator.getAtFloorNumber());
    }





}
