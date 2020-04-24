package com.example.demo;

//Import lombok for getter/setter
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

//model class
public class PetStoreModel {
    private String id; // need to be string otherwise cannot dereferenced.
    private String petName;
    private int petAge;
    private String petGender;
    private String petSpecies;

}
