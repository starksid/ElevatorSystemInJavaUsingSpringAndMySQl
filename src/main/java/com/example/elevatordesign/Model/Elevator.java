package com.example.elevatordesign.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Entity
public class Elevator extends BaseModel{
    @OneToMany
    private List<Floor> floors;
    @Enumerated(EnumType.ORDINAL)
    private ElevatorStatus elevatorStatus;
    @Enumerated(EnumType.ORDINAL)
    private ElevatorGoingStatus elevatorGoingStatus;
    private int atFloorNumber;
    private int numberOfFloors;
    @OneToOne
    private Door door;

    int front;
    int rear;
    public Elevator(){}


    public static Builder getBuilder(){
        return new Builder();
    }

    @Getter

    public static class Builder{
        private int numberOfFloors;
        List<Floor> floors;
        Door door;


        public Elevator build(){
            Elevator elevator = new Elevator();
            elevator.setAtFloorNumber(0);
            elevator.setElevatorStatus(ElevatorStatus.ON);
            elevator.setElevatorGoingStatus(ElevatorGoingStatus.STILL);
            elevator.setDoor(door);
            elevator.setFloors(floors);
            elevator.setNumberOfFloors(numberOfFloors);
            elevator.setFront(0);
            elevator.setRear(-1);
            return elevator;



        }
        public Builder setFloors(List<Floor> floors){
            this.floors = floors;
            return this;
        }

        public Builder setDoor(Door door){
            this.door = door;
            return this;
        }

        public Builder setNumberOfFloors(int numberOfFloors) {

            this.numberOfFloors = numberOfFloors;
            return this;
        }
    }
}
