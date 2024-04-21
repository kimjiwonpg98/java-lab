package kr.arch.deal.product.infrastructure;

import kr.arch.deal.product.domain.Product;

public interface ProductRepository {
    Product getById(Long id);
}
