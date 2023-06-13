package com.example.elevatordesign.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class CreateUserInputsRequestDto {
    private int numberOfUserInputs;
    private int elevatorId;

}
