package com.rishi.Ecommerce.service;

import com.rishi.Ecommerce.model.User;
import com.rishi.Ecommerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){

        try {
            User newUser = userRepository.save(user);
            System.out.println(("User Added to database"));
            return newUser;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public User loginUser(String email,String password){
          User user = userRepository.findByEmail(email);
          if(user!=null && user.getPassword().equals(password))
          {
              return user;
          }
          return null;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
