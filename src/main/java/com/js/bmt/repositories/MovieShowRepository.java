package com.js.bmt.repositories;

import com.js.bmt.models.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieShowRepository extends     JpaRepository<MovieShow, Long> {

    @Override
    Optional<MovieShow> findById(Long along);
}
