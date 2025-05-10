package com.example.userservice.repository;

import com.example.userservice.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    @Query(value = """
            SELECT *
            FROM subscriptions s
            GROUP BY s.
            ORDER BY COUNT(s) DESC
            """, nativeQuery = true)
    List<Subscription> findTopSubscriptionRaw();
}
