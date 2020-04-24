package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PetStoreContoller {
    @Autowired //Auto wired Bean dependency thru setter
    private PetStoreRepository petStoreRepository;

    //return all
    @RequestMapping("/pet")
    public List<PetStoreModel> getPetStore() {
        return petStoreRepository.findAll();
    }

    //return when passing id
    @RequestMapping("/pet/{id}")
    public Optional<PetStoreModel> getPet(@PathVariable("id") String id) {
        return petStoreRepository.findById(id);
    }

    //POST data
    @RequestMapping(method = RequestMethod.POST, value = "/pet")
    public void addPet(@RequestBody PetStoreModel pet) {
        petStoreRepository.insert(pet);
    }

    //PUT data
    @RequestMapping(method = RequestMethod.PUT, value = "/pet/{id}")
    public void updatePet(@RequestBody PetStoreModel pet, @PathVariable("id") String id) {
        petStoreRepository.update(pet);
    }

    //DEL data
    @RequestMapping(method = RequestMethod.DELETE, value = "/pet/{id}")
    public void deletePet(@PathVariable("id") String id) {
        petStoreRepository.deleteById(id);
    }
}


