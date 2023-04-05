package com.dmp.devtest.persistence;

import com.dmp.devtest.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoServiceImpl implements UserDaoService{
    @Autowired
    private UserRepository repository;
    @Override
    public String getPassword(String username) {
        return repository.getPassword(username);
    }

    @Override
    public User getUser(String username) {
        return repository.getUserByUsername(username);
    }

}
