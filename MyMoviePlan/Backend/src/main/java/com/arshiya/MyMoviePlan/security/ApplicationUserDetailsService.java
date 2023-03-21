package com.arshiya.MyMoviePlan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arshiya.MyMoviePlan.entity.UserEntity;
import com.arshiya.MyMoviePlan.exception.UserNotFoundException;
import com.arshiya.MyMoviePlan.service.UserService;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserEntity userEntity = service.getUser(username);
        return new ApplicationUserDetails(userEntity);
    }
}
