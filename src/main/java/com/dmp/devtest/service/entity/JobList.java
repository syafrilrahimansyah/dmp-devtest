package com.dmp.devtest.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class JobList implements Serializable {
    private List<Job> jobList;
}
