package com.dotcipher.explorecali.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class TourRatingPk implements Serializable {

    @ManyToOne
    private Tour tour;

    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    public TourRatingPk(){}

    public TourRatingPk(Tour tour, Integer customerId) {
        this.tour = tour;
        this.customerId = customerId;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
