package com.dmp.devtest.controller;

import com.dmp.devtest.DevtestConstant;
import com.dmp.devtest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@CrossOrigin
@RestController
@RequestMapping(path = "job")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getJobList() {
        return ResponseEntity.ok(service.jobList());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getJobDetail(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.jobDetail(id));
    }
}
