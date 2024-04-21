package kr.arch.deal.account.persistence;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "user")
@Getter
public class UserEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false, name = "is_seller")
    private Boolean isSeller;
}
