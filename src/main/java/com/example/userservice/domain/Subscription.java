package com.example.userservice.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service_name", nullable = false, length = 100)
    private String serviceName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "monthly_payment")
    private Long monthlyRepayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public Subscription setId(Long id) {
        this.id = id;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Subscription setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Subscription setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Subscription setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Subscription setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Subscription setUser(User user) {
        this.user = user;
        return this;
    }

    public Long getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public Subscription setMonthlyRepayment(Long monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

