package jpabook.jpashop.entity.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Getter @Setter
public class Product {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false, precision = 38, scale = 18)
    private BigDecimal discountRate;

    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;
}
