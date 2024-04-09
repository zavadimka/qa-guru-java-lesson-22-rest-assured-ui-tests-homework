package com.zavadimka.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSuccessfulLoginRequestModel {

    private String userName;
    private String password;
}
