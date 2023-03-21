package com.arshiya.MyMoviePlan.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.arshiya.MyMoviePlan.entity.BookingDetailsEntity;
import com.arshiya.MyMoviePlan.entity.BookingEntity;
import com.arshiya.MyMoviePlan.entity.UserEntity;
import com.arshiya.MyMoviePlan.exception.BookingNotFoundException;
import com.arshiya.MyMoviePlan.model.UserRole;
import com.arshiya.MyMoviePlan.repository.BookingRepository;
import com.arshiya.MyMoviePlan.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingRepository repository;
    private final UserService service;

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('READ')")
    public BookingEntity findById(@PathVariable final int id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id: " + id + " not found."));
    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('READ')")
    public List<BookingEntity> allBookings() {
        final UserEntity user = service.getLoggedInUser();
        if (user.getUserRole().equals(UserRole.ROLE_ADMIN) || user.getUserRole().equals(UserRole.ROLE_SUPER_ADMIN))
            return repository.findAll();
        else return repository.findAllByUserIdOrderByBookedOnAsc(user.getId());
    }

    @GetMapping("{username}/all")
    @PreAuthorize("hasAuthority('READ')")
    public List<BookingEntity> findAllByUserId(@PathVariable String username) {
        if (!(username.contains("-") && username.length() > 10))
            username = service.getUser(username).getId();
        return repository.findAllByUserIdOrderByBookedOnAsc(username);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public void deleteBooking(@PathVariable final int id) {
        repository.deleteById(id);
    }

    @GetMapping("{id}/details")
    @PreAuthorize("hasAuthority('READ')")
    public BookingDetailsEntity findByDetailsId(@PathVariable final int id) {
        return this.findById(id).getBookingDetails();
    }
}
