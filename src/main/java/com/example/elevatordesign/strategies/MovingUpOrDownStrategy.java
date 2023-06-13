package com.example.elevatordesign.strategies;

import com.example.elevatordesign.Model.Elevator;
import com.example.elevatordesign.Model.ElevatorGoingStatus;

import java.util.List;

public interface MovingUpOrDownStrategy {
    ElevatorGoingStatus elevatorMovingUpOrDownAlgorithm(Elevator elevator);
}
