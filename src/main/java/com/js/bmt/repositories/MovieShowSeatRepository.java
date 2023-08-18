package com.js.bmt.repositories;

import com.js.bmt.models.MovieShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowSeatRepository extends JpaRepository<MovieShowSeat, Long> {
}
