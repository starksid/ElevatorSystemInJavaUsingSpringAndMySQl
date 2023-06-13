package com.example.elevatordesign.dtos;

import com.example.elevatordesign.Model.Floor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class FloorResponseDto {
    List<Floor> floors;
}
