package com.js.bmt.services;


import com.js.bmt.models.*;
import com.js.bmt.repositories.CustomerRepository;
import com.js.bmt.repositories.MovieShowRepository;
import com.js.bmt.repositories.MovieShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.OptionPaneUI;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookingService {
    /*
    1. Get the user with userId
    2. Get the movie show with movieshowId
    3. Get the seat objects from the OB by using seatIds
    4. Check if seats are available? Booking seat status
    5. Mark the seat as reserved. seat.setBookingStatus(Reserved)?
    6. ShowSeatRepository.save()
    7. Create Booking Object
    8. Save that to DB
    9. Return the booking


     */

    private CustomerRepository customerRepository;
    private MovieShowRepository movieShowRepository;
    private MovieShowSeatRepository movieShowSeatRepository;

    public Booking createBooking(Long customerId, Long movieShowId, List<Long> seatIds){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isEmpty()){
            throw new IllegalArgumentException("Customer not found.");
        }

        MovieShow movieShow =
                movieShowRepository.findById(movieShowId)
                        .orElseThrow(() -> new IllegalArgumentException("Movie show not found"));

        List<MovieShowSeat> movieShowSeats =
                movieShowSeatRepository.findAllById(seatIds);
        for(MovieShowSeat movieShowSeat : movieShowSeats){
            if(movieShowSeat.getStatus() != BookingSeatStatus.AVAILABLE){
                throw new IllegalArgumentException("Something went wrong");
            }
        }

        for(MovieShowSeat movieShowSeat : movieShowSeats){
            movieShowSeat.setStatus(BookingSeatStatus.RESERVED);
            movieShowSeatRepository.save((movieShowSeat));
        }

        Booking booking = new Booking();
        booking.setAmount(0);
        booking.setCreatedAt(new Date());
        booking.setShowSeats(movieShowSeats);
        booking.setCustomer(customerOptional.get());
        booking.setMovieShow(movieShow);
        return booking;
    }
}
