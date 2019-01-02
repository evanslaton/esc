package com.esc.message;

import com.esc.user.ApplicationUser;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class TextMessage {
    // Instance properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Temporal(TemporalType.TIMESTAMP)
    public Date sendTimestamp;
    public String message;
    public Boolean wasSent;

    // Database Relationship(s)
    @ManyToOne
    public ApplicationUser applicationUser;

    // Default constructor
    public TextMessage() {}

    // Constructor
    public TextMessage(Date sendTimestamp, String message) {
        this.sendTimestamp = sendTimestamp;
        this.message = message;
        this.wasSent = false;
    }
}
