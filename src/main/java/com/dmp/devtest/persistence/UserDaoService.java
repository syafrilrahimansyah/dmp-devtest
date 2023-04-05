package com.dmp.devtest.persistence;

import com.dmp.devtest.persistence.entity.User;

public interface UserDaoService {
    String getPassword(String username);
    User getUser(String username);
}
