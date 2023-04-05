package com.dmp.devtest.controller;

import com.dmp.devtest.DevtestConstant;
import com.dmp.devtest.controller.entity.LoginReq;
import com.dmp.devtest.controller.entity.Response;
import com.dmp.devtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@CrossOrigin
@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll() {
        return DevtestConstant.SUCCESS_READ;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestHeader(name = "auth") String authBasic,
                                   @RequestBody LoginReq loginReq) throws Exception {
        Response response = service.login(authBasic, loginReq);
        return ResponseEntity.ok(response);
    }
}
