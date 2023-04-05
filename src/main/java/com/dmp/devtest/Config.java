package com.dmp.devtest;

import com.dmp.devtest.persistence.UserDaoService;
import com.dmp.devtest.persistence.UserDaoServiceImpl;
import com.dmp.devtest.service.JobService;
import com.dmp.devtest.service.JobServiceImpl;
import com.dmp.devtest.service.UserService;
import com.dmp.devtest.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserDaoService userDaoService(){return new UserDaoServiceImpl();
    }

    @Bean
    public UserService userService(){return new UserServiceImpl();
    }

    @Bean
    public JobService jobService(){return new JobServiceImpl();
    }
}
