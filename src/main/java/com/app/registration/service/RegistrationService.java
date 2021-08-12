package com.app.registration.service;

import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user){

        return repo.save(user);

    }

    public User fetchUserByEmailId(String email){
        return repo.findByEmaiId(email);
    }

    public User fetchUserByEmailIdAndPassword(String email, String password){
        return repo.findByEmaiIdAndPassword(email, password);
    }
}
