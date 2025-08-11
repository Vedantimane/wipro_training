package com.booking.Uberuser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "uber_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UberUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uberUserid;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "destination_location")
    private String destinationLocation;

    @Column(name = "user_name")
    private String userName;

    
}
