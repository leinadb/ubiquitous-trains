package com.leinadb.trains.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class TrainData {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String destination;
    private Float speed;
    private BigDecimal[] coordinates;

    public TrainData(String name, String destination, Float speed, BigDecimal[] coordinates) {
        this.name = name;
        this.destination = destination;
        this.speed = speed;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public BigDecimal[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(BigDecimal[] coordinates) {
        this.coordinates = coordinates;
    }
}
