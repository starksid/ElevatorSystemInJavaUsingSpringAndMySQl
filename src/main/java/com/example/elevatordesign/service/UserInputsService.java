package com.example.elevatordesign.service;

import com.example.elevatordesign.Model.*;
import com.example.elevatordesign.repository.ElevatorRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.elevatordesign.repository.FloorRepository;
import com.example.elevatordesign.repository.FloorUserInputsRepository;
import com.example.elevatordesign.repository.UserInputsRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserInputsService {

     UserInputsRepository userInputsRepository;
     FloorUserInputsRepository floorUserInputsRepository;
     FloorRepository floorRepository;
     ElevatorRpository elevatorRpository;
    @Autowired
    public UserInputsService(
            UserInputsRepository userInputsRepository,
            FloorUserInputsRepository floorUserInputsRepository,
            FloorRepository floorRepository,
            ElevatorRpository elevatorRpository
    ){
        this.userInputsRepository= userInputsRepository;
        this.floorUserInputsRepository = floorUserInputsRepository;
        this.floorRepository = floorRepository;
        this.elevatorRpository = elevatorRpository;
    }

    public void createUserInputs(List<Integer> userInputs, Elevator elevator){

        int numberofFloors = (int) floorRepository.count();
        for(int i=0; i<userInputs.size(); i++){
            Optional<Floor> optionalFloor = floorRepository.findByFloorNumber(userInputs.get(i));
            Floor floor = optionalFloor.get();

            if(i>=0 && i<numberofFloors && floor.front>floor.rear){
                UserInputs userInputs1 = new UserInputs();
                userInputs1.setCreatedAt(LocalDateTime.now());
                userInputs1.setUserInput(userInputs.get(i));
                UserInputs userInputs2 = userInputsRepository.save(userInputs1);
                floor.rear+=1;
                int R = elevator.getRear()+1;
                elevator.setRear(R);
                elevatorRpository.save(elevator);


                FloorUser floorUser = new FloorUser();
                floorUser.setUserInputs(userInputs2);
                floorUser.setFloorUserStatus(FloorUserStatus.ON);

                FloorUser savedFloorUser = floorUserInputsRepository.save(floorUser);

                floor.getFloorUsers().add(savedFloorUser);

            }
            floorRepository.save(floor);

        }


    }

}
