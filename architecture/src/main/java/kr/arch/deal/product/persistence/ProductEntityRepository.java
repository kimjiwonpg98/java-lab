package kr.arch.deal.product.persistence;

import kr.arch.deal.product.persistence.entity.ProductEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ProductEntityRepository<T, ID> extends Repository<T, ID> {
    ProductEntity getById(Long id);
}
