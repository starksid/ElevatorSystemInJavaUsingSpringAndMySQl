package com.example.elevatordesign.service;

import com.example.elevatordesign.repository.DoorRepository;
import com.example.elevatordesign.Model.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoorService {
    DoorRepository doorRepository;
    @Autowired
    public DoorService(DoorRepository doorRepository){
        this.doorRepository = doorRepository;
    }
    public Door createDoor(){
        Door door = new Door();
        Door door1 = doorRepository.save(door);
        return door1;
    }
}
