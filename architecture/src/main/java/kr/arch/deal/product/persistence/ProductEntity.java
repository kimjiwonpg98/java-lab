package kr.arch.deal.product.persistence;

import jakarta.persistence.*;
import kr.arch.deal.account.persistence.UserEntity;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
public class ProductEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false, precision = 38, scale = 18)
    private BigDecimal price;

    @ManyToOne
    @Column(nullable = false, name = "user_id")
    @JoinColumn(name = "user_id")
    private UserEntity User;
}
