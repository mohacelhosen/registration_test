package com.mohacel.userloginservice.controller;

import com.mohacel.userloginservice.dto.RegistrationDto;
import com.mohacel.userloginservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    @Autowired
    private IUserService service;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody RegistrationDto registrationInfo){
        RegistrationDto saveUser = service.saveUser(registrationInfo);
        if (saveUser !=null){
            return  new ResponseEntity<>(saveUser, HttpStatus.OK);
        }
        return new ResponseEntity<>("Already Registered", HttpStatus.CONFLICT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<RegistrationDto>> getAllUserInfo(){
        List<RegistrationDto> allUser = service.getAllUser();
        return  new ResponseEntity<>(allUser, HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserInfo(@PathVariable Integer userId){
        RegistrationDto user = service.getUser(userId);
        if (user !=null){
            return  new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid UserId", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public  ResponseEntity<RegistrationDto> updateUserInfo(@RequestBody RegistrationDto registrationDto){
        RegistrationDto updateUser = service.updateUser(registrationDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        Boolean isDeleted = service.deleteUserInfo(userId);
        if (isDeleted){
            return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid UserId", HttpStatus.NOT_FOUND);
    }

}
