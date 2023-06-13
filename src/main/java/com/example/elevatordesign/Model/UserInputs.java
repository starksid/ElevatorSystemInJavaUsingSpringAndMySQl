package com.example.elevatordesign.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@Entity
public class UserInputs extends BaseModel{
    private int userInput;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;


}
