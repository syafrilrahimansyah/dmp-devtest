package com.dmp.devtest.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginRes {
    private final String access_token;
    private final String id;
    private final String username;
    private final String name;
    private final String token_type;
}
