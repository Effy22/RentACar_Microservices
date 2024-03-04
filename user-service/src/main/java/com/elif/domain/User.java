package com.elif.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document //For MongoDB
public class User implements Serializable {
    String id;
    Long authId;
    String username;
    String email;
    String password;
    String name;
    String surname;
    String avatar;
    String adress;
    String about;
    String phone;

}
