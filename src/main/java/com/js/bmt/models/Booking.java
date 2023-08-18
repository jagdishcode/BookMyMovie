package com.js.bmt.models;

import jakarta.persistence.*;
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
    @OneToMany
    private List<MovieShowSeat> showSeats;
    @OneToOne
    private MovieShow movieShow;
    private Date bookedAt;
    private Date createdAt;
    @Column(nullable = true)
    private double amount;
}
