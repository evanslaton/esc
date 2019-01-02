package com.esc.message;

import com.esc.user.ApplicationUser;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TextMessage {
    // Instance properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Temporal(TemporalType.DATE)
    public Date date;
    @Temporal(TemporalType.TIME)
    public Date time;
    public String message;
    public Boolean was_sent;

    // Database Relationship(s)
    @ManyToOne
    public ApplicationUser applicationUser;

    // Default constructor
    public TextMessage() {}

    // Constructor
    public TextMessage(Date date, Date time, String message) {
        this.date = date;
        this.time = time;
        this.message = message;
        this.was_sent = false;
    }
}
