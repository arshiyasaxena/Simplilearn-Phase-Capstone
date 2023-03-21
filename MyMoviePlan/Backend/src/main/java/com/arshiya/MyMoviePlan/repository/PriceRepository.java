package com.arshiya.MyMoviePlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.MyMoviePlan.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
}
