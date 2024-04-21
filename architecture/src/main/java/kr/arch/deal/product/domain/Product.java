package kr.arch.deal.product.domain;

import kr.arch.deal.product.domain.vo.ProductAmount;
import kr.arch.deal.product.domain.vo.ProductId;
import kr.arch.deal.product.domain.vo.ProductOwnerId;
import lombok.Value;

@Value
public class Product {
    ProductId id;

    ProductAmount amount;

    ProductOwnerId userId;
}
