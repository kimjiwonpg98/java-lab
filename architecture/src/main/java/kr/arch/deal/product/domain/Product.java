package kr.arch.deal.product.domain;

import kr.arch.deal.product.domain.vo.ProductAmount;
import kr.arch.deal.product.domain.vo.ProductId;
import kr.arch.deal.product.domain.vo.ProductOwnerId;
import kr.arch.deal.product.persistence.entity.ProductEntity;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class Product {
    private ProductId id;

    private ProductAmount amount;

    private ProductOwnerId userId;
}
