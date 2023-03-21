package com.arshiya.MyMoviePlan.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.MyMoviePlan.entity.BookingDetailsEntity;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetailsEntity, Integer> {
}
