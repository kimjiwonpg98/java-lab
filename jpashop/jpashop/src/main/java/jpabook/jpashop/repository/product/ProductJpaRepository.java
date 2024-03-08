package jpabook.jpashop.repository.product;

import jpabook.jpashop.entity.product.Product;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@NoRepositoryBean
public class ProductJpaRepository implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }
}
