package kr.arch.deal.product.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity(name = "product")
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
    @JoinColumn(name = "user_id")
    private kr.arch.deal.account.persistence.User User;
}
