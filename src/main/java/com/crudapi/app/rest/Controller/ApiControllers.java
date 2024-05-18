package com.crudapi.app.rest.Controller;

import com.crudapi.app.rest.Models.User;
import com.crudapi.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String print(){
        return "print something at endpoint!";
    }

    @GetMapping(value = "/getAll")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/insert")
    public String insertUser(@RequestBody User user){
        userRepo.save(user);
        return "saved!";

    }


    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "deleted user " + id;
    }

}
