package com.example.elevatordesign.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FloorUser extends BaseModel{

    @OneToOne
    private UserInputs userInputs;
    @Enumerated(EnumType.ORDINAL)
    private FloorUserStatus floorUserStatus;

}
