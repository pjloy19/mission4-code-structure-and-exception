package com.example.controller;

import com.example.exception.GlobalException;
import com.example.model.PetStoreModel;
import com.example.repository.PetStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RestController
public class PetStoreController {
    @Autowired //Auto wired Bean dependency thru setter
    private PetStoreRepository petStoreRepository;

    //return all
    @GetMapping("/pet")
    public List<PetStoreModel> getPet() {
        return petStoreRepository.findAll();
    }

    //return when passing id
    @GetMapping("/pet/{id}")
    public ResponseEntity<?> getPet(@PathVariable("id") String id) {
        Optional<PetStoreModel> petStoreModel = Optional.ofNullable(petStoreRepository.getPet(id));
          if (petStoreModel.isEmpty()) {
              throw new GlobalException(id);
        } else {
            return ResponseEntity.ok(petStoreModel);
        }
    }

    //POST data
    @PostMapping(value = "/pet")
    public void addPet(@RequestBody PetStoreModel pet) {
        petStoreRepository.insert(pet);
    }

    //PUT data
    @PutMapping(value = "/pet/{id}")
    public void updatePet(@RequestBody PetStoreModel pet, @PathVariable("id") String id) {
        petStoreRepository.update(pet);
    }

    //DEL data
    @DeleteMapping(value = "/pet/{id}")
    public void deletePet(@PathVariable("id") String id) {
        petStoreRepository.deleteById(id);
    }
}