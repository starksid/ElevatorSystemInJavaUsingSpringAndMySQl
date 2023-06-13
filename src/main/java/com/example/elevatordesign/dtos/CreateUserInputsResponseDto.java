package com.example.elevatordesign.dtos;

import com.example.elevatordesign.Model.FloorUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CreateUserInputsResponseDto {
    private List<FloorUser> floorUsers;
}
