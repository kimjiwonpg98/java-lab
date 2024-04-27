package kr.arch.deal.product.persistence;

import kr.arch.deal.product.domain.Product;
import kr.arch.deal.product.domain.vo.ProductAmount;
import kr.arch.deal.product.domain.vo.ProductId;
import kr.arch.deal.product.domain.vo.ProductOwnerId;
import kr.arch.deal.product.domain.vo.ProductPrice;
import kr.arch.deal.product.infrastructure.ProductRepository;
import kr.arch.deal.product.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryAdapter implements ProductRepository {
    private final ProductEntityRepository<ProductEntity, Long> productEntityRepository;

    public ProductRepositoryAdapter(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    private Product convertProduct (ProductEntity entity) {
        Product product = new Product();
        ProductId id = new ProductId(entity.getId());
        ProductAmount amount = new ProductAmount(entity.getAmount());
        ProductOwnerId userId = new ProductOwnerId(entity.getUser().getId());
        ProductPrice price = new ProductPrice(entity.getPrice().stripTrailingZeros());
        product.setId(id);
        product.setAmount(amount);
        product.setUserId(userId);
        product.setPrice(price);

        return product;
    }

    @Override
    public Product getById(Long id) {
        ProductEntity productEntity = productEntityRepository.getById(id);

        return convertProduct(productEntity);
    }
}
