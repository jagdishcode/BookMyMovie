package com.js.bmt.controller;

import com.js.bmt.dtos.CreateBookingRequest;
import com.js.bmt.dtos.CreateBookingResponse;
import com.js.bmt.dtos.CreateCustomerResponse;
import com.js.bmt.models.Booking;
import com.js.bmt.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bmt/v1")
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;

    @PostMapping(path = "/bookings")
    public CreateBookingResponse createBooking(@RequestBody CreateBookingRequest request){
        //Add validations to ensure all the fields are present in the request
        System.out.println(request.toString());
        Booking booking = bookingService.createBooking(
                request.getUserId(), request.getShowId(), request.getSeatIds());

        return new CreateBookingResponse("SUCCESS");
    }
}
