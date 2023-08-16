package com.js.bmt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Customer customer;
//    private List<MovieShowSeat> movieShowSeats;
//    private MovieShow movieShow;
    private Date bookedAt;
    @Column(nullable = true)
    private double amount;
}
