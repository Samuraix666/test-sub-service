package com.example.userservice.dto;

import java.time.LocalDate;
import java.util.StringJoiner;

public class SubscriptionResponseDTO {
    private Long id;

    private String serviceName;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isActive;

    private Long monthlyPayment;

    public Long getMonthlyPayment() {
        return monthlyPayment;
    }

    public SubscriptionResponseDTO setMonthlyPayment(Long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SubscriptionResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public SubscriptionResponseDTO setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SubscriptionResponseDTO setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SubscriptionResponseDTO setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public SubscriptionResponseDTO setActive(boolean active) {
        isActive = active;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SubscriptionResponseDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("serviceName='" + serviceName + "'")
                .add("startDate=" + startDate)
                .add("endDate=" + endDate)
                .add("isActive=" + isActive)
                .toString();
    }
}
