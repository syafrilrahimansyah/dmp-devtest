package com.dmp.devtest.service;

import com.dmp.devtest.controller.entity.LoginReq;
import com.dmp.devtest.controller.entity.Response;

public interface UserService {
    Response login(String authBasic, LoginReq loginReq) throws Exception;
}
