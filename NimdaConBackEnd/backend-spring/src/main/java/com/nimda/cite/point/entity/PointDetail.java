package com.nimda.cite.point.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Table(name = "point_details")
@Entity
@Getter
@Builder
public class PointDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_balance_id")
    private UserBalance userBalance;

    private Long amount;
    @Column(name = "remaining_amount")
    private Long remainingAmount;
    @Column(name = "expired_at")
    private LocalDateTime expiredAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
