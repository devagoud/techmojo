package com.tech.mojo.service;

import com.tech.mojo.controller.dto.UserDTO;
import com.tech.mojo.domain.User;

public interface MojoService {
    User createUser(UserDTO userDTO);

    User getUser(String userid, String accesskey);
}
