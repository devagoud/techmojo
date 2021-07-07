package com.tech.mojo.controller;

import com.tech.mojo.controller.dto.UserDTO;
import com.tech.mojo.service.MojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MojoController {

    @Autowired
    private MojoService mojoService;

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(mojoService.createUser(userDTO));
    }

    @GetMapping("/tenant/access/{userid}/{accesskey}")
    public ResponseEntity getUser(@PathVariable String userid,@PathVariable String accesskey){
        return ResponseEntity.ok(mojoService.getUser(userid,accesskey));
    }
}
