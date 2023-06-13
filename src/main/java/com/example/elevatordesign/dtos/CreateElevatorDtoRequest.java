package com.example.elevatordesign.dtos;

import com.example.elevatordesign.Model.Floor;
import lombok.Getter;
import lombok.Setter;
import com.example.elevatordesign.Model.Door;

import java.util.List;
@Getter
@Setter
public class CreateElevatorDtoRequest {
    int numberOfFloors;
    List<Floor> floors;
    Door door;
}
