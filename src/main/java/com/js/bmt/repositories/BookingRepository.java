package com.js.bmt.repositories;

import com.js.bmt.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Override
    Optional<Booking> findById(Long id);
    @Override
    Booking save(Booking booking);
}
