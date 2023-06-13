package com.example.elevatordesign.controller;

import com.example.elevatordesign.Model.Floor;
import com.example.elevatordesign.Model.FloorStatus;
import com.example.elevatordesign.dtos.FloorRequestDto;
import com.example.elevatordesign.dtos.FloorResponseDto;
import com.example.elevatordesign.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
public class FloorController {
    FloorService floorService;
    @Autowired
    public FloorController(FloorService floorService){
        this.floorService = floorService;
    }
    public FloorResponseDto createFloors(FloorRequestDto requestDto){
        FloorResponseDto response = new FloorResponseDto();
        int numberOfFloors = requestDto.getNumberOfFloors();
        List<Floor> floors = new ArrayList<>();
        for(int i=0; i<numberOfFloors; i++){
            Floor floor = new Floor(i, FloorStatus.ON);
            floors.add(floor);
        }
        List<Floor> floors1 = floorService.createFloors(floors);
        response.setFloors(floors1);
        return response;
    }
    public int OffAllFloorUserStatus(int floorNumber){
        return floorService.OffAllFloorUserStatus(floorNumber);
    }
}
