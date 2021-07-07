package com.tech.mojo.service.impl;

import com.tech.mojo.controller.dto.UserDTO;
import com.tech.mojo.domain.User;
import com.tech.mojo.repository.UserRepository;
import com.tech.mojo.service.MojoService;
import com.tech.mojo.usecase.UserUsecase;
import com.tech.mojo.utils.MojoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MojoServiceImpl implements MojoService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUsecase userUsecase;

    @Override
    public User createUser(UserDTO userDTO) {

        return userRepository.save(new User(userDTO));
    }

    @Override
    public User getUser(String userid, String accesskey) {
        Optional<User> optionalUser = userRepository.findById(userid);
        User save=null;
        if (optionalUser.isPresent()){
            User user = userUsecase.isAccessable(optionalUser.get());
             save = userRepository.save(user);
        }else {
            throw new MojoException("User does not exist");
        }
        return save;
    }
}
