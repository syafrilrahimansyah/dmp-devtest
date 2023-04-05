package com.dmp.devtest.service;

import com.dmp.devtest.DevtestConstant;
import com.dmp.devtest.controller.entity.LoginReq;
import com.dmp.devtest.controller.entity.LoginRes;
import com.dmp.devtest.controller.entity.Response;
import com.dmp.devtest.persistence.UserDaoService;
import com.dmp.devtest.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Base64;

public class UserServiceImpl implements UserService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDaoService userDaoService;
    @Override
    public Response login(String authBasic, LoginReq loginReq) throws Exception {
        Response response = new Response();
        String authOriginal = loginReq.getUsername() + DevtestConstant.SECRET_AUTH + loginReq.getPassword();
        String auth = Base64.getEncoder().encodeToString(authOriginal.getBytes());
        if (authBasic.equals(auth)) {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
            } catch (BadCredentialsException e) {
                throw new Exception(DevtestConstant.ERRCODE_A01, e);
            }
            final UserDetails userDetails = myUserDetailService.loadUserByUsername(loginReq.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            User user = userDaoService.getUser(loginReq.getUsername());
            response.setMessage(DevtestConstant.MSG_A01);
            response.setData(
                    new LoginRes(jwt, user.getId(), user.getUsername(), user.getName(), DevtestConstant.BEARER_STR)
            );
            return response;
        } else {
            response.setMessage(DevtestConstant.MSG_A02);
            return response;
        }
    }
}
