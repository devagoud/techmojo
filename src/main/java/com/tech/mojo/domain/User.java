package com.tech.mojo.domain;

import com.tech.mojo.controller.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String accessKey;
    private LocalTime enableTime;
    private int requestCount;

    public User(UserDTO userDTO) {
        this.id=UUID.randomUUID().toString();
        this.name=userDTO.getName();
        this.accessKey=userDTO.getAccessKey();
        this.enableTime=LocalTime.now();
        this.requestCount=0;
    }

}
