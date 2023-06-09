package com.arshiya.MyMoviePlan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.arshiya.MyMoviePlan.model.UserPermission.*;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum UserRole {

    ROLE_USER(Arrays.asList(READ)),
    ROLE_MANAGER(Arrays.asList(READ, WRITE)),
    ROLE_ADMIN(Arrays.asList(READ, WRITE, UPDATE)),
    ROLE_SUPER_ADMIN(Arrays.asList(READ, WRITE, UPDATE, DELETE));

    private final List<UserPermission> permissions;
}
