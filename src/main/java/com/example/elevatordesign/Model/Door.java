package com.example.elevatordesign.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Door extends BaseModel{
    private DoorStatus doorStatus;
    private int doorNumber;
    public Door(){
        this.doorStatus = DoorStatus.CLOSED;
        this.doorNumber = 1;
    }
}
