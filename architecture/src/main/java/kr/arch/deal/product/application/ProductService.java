package kr.arch.deal.product.application;

import kr.arch.deal.product.application.command.GetByProductIdCommand;
import kr.arch.deal.product.application.useCase.GetProductUseCase;
import kr.arch.deal.product.domain.Product;
import kr.arch.deal.product.persistence.ProductRepositoryAdapter;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements GetProductUseCase {
    private final ProductRepositoryAdapter productRepositoryAdapter;

    @Override
    public Product getById(GetByProductIdCommand command) {
        Long productId = command.getProductId().id();
        return productRepositoryAdapter.getById(productId);
    }

    public ProductService(ProductRepositoryAdapter productRepositoryAdapter) {
        this.productRepositoryAdapter = productRepositoryAdapter;
    }
}
