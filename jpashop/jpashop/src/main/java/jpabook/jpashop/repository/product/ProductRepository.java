package jpabook.jpashop.repository.product;

import jpabook.jpashop.entity.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
    public Product findById(Long id);
}
