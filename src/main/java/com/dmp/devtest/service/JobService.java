package com.dmp.devtest.service;


import com.dmp.devtest.controller.entity.Response;
import com.dmp.devtest.service.entity.Job;

import java.util.List;

public interface JobService {
    Response jobList();
    Response jobDetail(String id);
}
