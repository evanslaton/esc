package com.esc.message;

import com.esc.user.ApplicationUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TextMessage {
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
    public TextMessage() {}

    // Constructor
    public TextMessage(Date datetime, String message) {
        this.datetime = datetime;
        this.message = message;
    }
}
