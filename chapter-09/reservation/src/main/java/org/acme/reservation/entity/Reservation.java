package org.acme.reservation.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Reservation extends PanacheEntity {

    public Long carId;
    public LocalDate startDay;
    public LocalDate endDay;

    public boolean paid = false;

    public boolean isReserved(LocalDate startDay, LocalDate endDay) {
        return (!(this.endDay.isBefore(startDay) || this.startDay.isAfter(endDay)));
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "carId=" + carId +
            ", startDay=" + startDay +
            ", endDay=" + endDay +
            ", paid=" + paid +
            '}';
    }
}
