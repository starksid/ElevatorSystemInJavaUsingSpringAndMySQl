package com.example.elevatordesign.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Floor extends BaseModel{
    private int floorNumber;
    @Enumerated(EnumType.ORDINAL)
    private FloorStatus floorStatus;
    @OneToMany(fetch = FetchType.EAGER)
    private List<FloorUser> floorUsers;
    public int front;
    public int rear;
    public Floor(int floorNumber, FloorStatus floorStatus){
        this.floorNumber = floorNumber;
        this.floorStatus = floorStatus;
        this.floorUsers = new ArrayList<>();
        this.front = 0;
        this.rear = -1;
    }
    @PrePersist
    public void prePersist() {
        // Logic to execute before the entity is persisted (inserted)
        System.out.println("A new row is being inserted!");
    }

    public Floor() {

    }
}
