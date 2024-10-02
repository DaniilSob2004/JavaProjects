package com.example.AutoBase.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "carrying", nullable = false)
    private float carrying;

    @Column(name = "is_free", nullable = false)
    private boolean isFree = true;

    @Column(name = "is_broker", nullable = false)
    private boolean isBroker = false;

    @Column(name = "time_to_repair", nullable = false)
    private int timeToRepair = 0;
}
