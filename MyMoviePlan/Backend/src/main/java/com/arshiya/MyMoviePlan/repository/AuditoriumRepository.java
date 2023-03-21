package com.arshiya.MyMoviePlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.MyMoviePlan.entity.AuditoriumEntity;

@Repository
public interface AuditoriumRepository extends JpaRepository<AuditoriumEntity, Integer> {
}
