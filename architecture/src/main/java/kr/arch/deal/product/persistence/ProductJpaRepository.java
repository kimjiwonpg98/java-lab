package kr.arch.deal.product.persistence;

import kr.arch.deal.product.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends ProductEntityRepository<ProductEntity, Long> {
    @Query("SELECT p FROM product p WHERE p.id = :id")
    ProductEntity getById(Long id);
}
