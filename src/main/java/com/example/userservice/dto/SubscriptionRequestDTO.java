package com.example.userservice.dto;

import java.time.LocalDate;
import java.util.StringJoiner;

public class SubscriptionRequestDTO {

    private Long userId;

    private String serviceName;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long monthlyRepayment;

    public Long getUserId() {
        return userId;
    }

    public SubscriptionRequestDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public SubscriptionRequestDTO setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SubscriptionRequestDTO setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SubscriptionRequestDTO setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Long getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public SubscriptionRequestDTO setMonthlyRepayment(Long monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SubscriptionRequestDTO.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("serviceName='" + serviceName + "'")
                .add("startDate=" + startDate)
                .add("endDate=" + endDate)
                .add("monthlyRepayment=" + monthlyRepayment)
                .toString();
    }
}
