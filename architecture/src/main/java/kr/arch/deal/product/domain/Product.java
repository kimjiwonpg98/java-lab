package kr.arch.deal.product.domain;

import kr.arch.deal.product.adapter.out.GetProductByIdResponse;
import kr.arch.deal.product.domain.vo.ProductAmount;
import kr.arch.deal.product.domain.vo.ProductId;
import kr.arch.deal.product.domain.vo.ProductOwnerId;
import kr.arch.deal.product.domain.vo.ProductPrice;
import kr.arch.deal.product.persistence.entity.ProductEntity;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class Product {
    private ProductId id;

    private ProductAmount amount;

    private ProductOwnerId userId;

    private ProductPrice price;

    public GetProductByIdResponse getByIdResponse() {

        return new GetProductByIdResponse(this.id.id(), this.amount.amount(), this.userId.userId(), this.price.price());
    }
}
