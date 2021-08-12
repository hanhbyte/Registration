package com.app.registration.controller;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmaiId();
        if (tempEmailId != null && !"".equals(tempEmailId)){
            User userObj = service.fetchUserByEmailId(tempEmailId);
            if (userObj != null){
                throw new Exception("user witch"+tempEmailId+ "is already exits");
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmaiId();
        String tempPass = user.getPassword();
        User userObj = null;
        if (tempEmailId != null && tempPass != null){
            service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
        }
        if (userObj == null){
            throw new Exception("Bad credentials");
        }
        return userObj;
    }
}
