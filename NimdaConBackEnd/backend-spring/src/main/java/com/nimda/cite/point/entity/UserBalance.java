package com.nimda.cite.point.entity;

import com.nimda.cup.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "user_balance")
@Entity
@Builder
@Getter
public class UserBalance {
    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userBalance", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointDetail> pointDetails;

    @Column(name = "total_amount")
    private Long totalAmount;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
