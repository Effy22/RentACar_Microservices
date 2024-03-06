package com.elif.domain;

import com.elif.utility.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document //For MongoDB
public class User implements Serializable {
    @Id
    String id;
    Long authId;
    String username;
    String email;
    String password;
    String name;
    String surname;
    Double balance;
    String avatar;
    String address;
    String about;
    String phone;
    @Builder.Default
    EStatus status = EStatus.PENDING;

    Long createDate;
    Long updateDate;

    List<String> rentingIds=new ArrayList<>();

}
