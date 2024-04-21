package kr.arch.deal.product.application.useCase;

import kr.arch.deal.product.application.command.GetByProductIdCommand;
import kr.arch.deal.product.domain.Product;

public interface GetProductUseCase {
    Product getById(GetByProductIdCommand command);
}
