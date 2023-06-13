package com.example.elevatordesign.controller;

import com.example.elevatordesign.Model.Elevator;
import com.example.elevatordesign.Model.Floor;
import com.example.elevatordesign.Model.FloorUser;
import com.example.elevatordesign.Model.UserInputs;
import com.example.elevatordesign.dtos.CreateUserInputsRequestDto;
import com.example.elevatordesign.dtos.CreateUserInputsResponseDto;
import com.example.elevatordesign.service.UserInputsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class UserInputsController {
    UserInputsService userInputsService;

    Scanner scn = new Scanner(System.in);
    @Autowired
    public UserInputsController(UserInputsService userInputsService){
        this.userInputsService = userInputsService;

    }
    public void createUserInputs(CreateUserInputsRequestDto request, Elevator elevator){
        System.out.println("Number of Inputs to insert");
        int numOfInputs = scn.nextInt();
        request.setNumberOfUserInputs(numOfInputs);
        int numberofUserInputs = request.getNumberOfUserInputs();
        List<Integer> floorNumbers = new ArrayList<>();
        for(int i =0; i<numberofUserInputs; i++){
            System.out.println("Please insert floor number: ");
            int floorNumber = scn.nextInt();
            floorNumbers.add(floorNumber);

        }


        userInputsService.createUserInputs(floorNumbers, elevator);

    }

}
