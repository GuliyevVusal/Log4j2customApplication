package com.example.log4j2custom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "logs")
@Setter
@Getter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_date", nullable = false)
    private Timestamp eventDate;

    @Column(name = "level")
    private String level;

    @Column(name = "logger")
    private String logger;

    @Column(name = "message")
    private String message;

}
