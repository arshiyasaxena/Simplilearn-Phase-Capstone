package com.arshiya.MyMoviePlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.MyMoviePlan.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(final String email);

    Optional<UserEntity> findByMobile(final String mobile);
}
