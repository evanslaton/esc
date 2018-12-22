package com.esc.esc.message;

import com.esc.esc.user.ApplicationUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    // Instance properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public Date datetime;
    public String message;

    // Database Relationship(s)
    @ManyToOne
    public ApplicationUser applicationUser;

    // Default constructor
    public Message() {}

    // Constructor
    public Message(Date datetime, String message) {
        this.datetime = datetime;
        this.message = message;
    }
}
