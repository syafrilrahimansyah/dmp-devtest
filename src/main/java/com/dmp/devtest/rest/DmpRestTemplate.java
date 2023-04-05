package com.dmp.devtest.rest;

import com.dmp.devtest.DevtestConstant;
import com.dmp.devtest.service.entity.Job;
import com.dmp.devtest.service.entity.JobList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmpRestTemplate {
    @Value(DevtestConstant.DMP_URL)
    private String url;

    @Value(DevtestConstant.DMP_URL_PATH_JOB_LIST)
    private String pathJobList;

    @Value(DevtestConstant.DMP_URL_PATH_JOB_DETAIL)
    private String pathJobDetail;

    public List<Job> getJobList(){
        RestTemplate restTemplate = new RestTemplate();
        List<Job> jobList = restTemplate
                .exchange(url+pathJobList,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Job>>() {}
                ).getBody();
        return jobList;
    }

    public Job getJobDetail(String id){
        RestTemplate restTemplate = new RestTemplate();
        Job job = restTemplate
                .getForObject(url + pathJobDetail+id, Job.class);
        return job;
    }
}
