package com.arshiya.MyMoviePlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.MyMoviePlan.entity.ActorEntity;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
}
