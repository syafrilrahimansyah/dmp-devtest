package com.dmp.devtest.service;

import com.dmp.devtest.persistence.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDaoService userDaoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        byte[] decodedBytes = Base64.getDecoder().decode(userDaoService.getPassword(username));
        String pass = new String(decodedBytes);
        return new User(username, pass.trim(), new ArrayList<>());
    }
}
