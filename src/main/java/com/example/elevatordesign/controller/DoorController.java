package com.example.elevatordesign.controller;

import com.example.elevatordesign.repository.DoorRepository;
import com.example.elevatordesign.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.example.elevatordesign.Model.Door;

@Controller
public class DoorController {
    DoorService doorService;
    @Autowired
    public DoorController(DoorService doorService){
        this.doorService =  doorService;
    }
    public Door createDoor(){
        return doorService.createDoor();
    }
}
