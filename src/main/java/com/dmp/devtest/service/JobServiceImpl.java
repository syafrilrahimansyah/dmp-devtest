package com.dmp.devtest.service;

import com.dmp.devtest.DevtestConstant;
import com.dmp.devtest.controller.entity.Response;
import com.dmp.devtest.rest.DmpRestTemplate;
import com.dmp.devtest.service.entity.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobServiceImpl implements JobService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DmpRestTemplate dmpRestTemplate;

    @Override
    public Response jobList() {
        Response response = new Response();
        try {
            response.setMessage(DevtestConstant.GET_SUCCESS);
            response.setData(dmpRestTemplate.getJobList());
            return response;
        }catch (Exception e){
            response.setMessage(DevtestConstant.GET_ERROR);
            response.setData(e.getMessage());
            logger.info(e.getMessage());
            return response;
        }
    }

    @Override
    public Response jobDetail(String id) {
        Response response = new Response();
        try {
            response.setMessage(DevtestConstant.GET_SUCCESS);
            response.setData(dmpRestTemplate.getJobDetail(id));
            return response;
        }catch (Exception e){
            response.setMessage(DevtestConstant.GET_ERROR);
            response.setData(e.getMessage());
            logger.info(e.getMessage());
            return response;
        }
    }
}
