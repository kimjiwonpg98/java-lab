package kr.arch.deal.product.application.command;

import jakarta.validation.constraints.NotNull;
import kr.arch.deal.common.SelfValidating;
import kr.arch.deal.product.domain.vo.ProductId;
import lombok.Getter;

@Getter
public class GetByProductIdCommand extends SelfValidating<GetByProductIdCommand> {
    @NotNull
    private ProductId productId;

    public GetByProductIdCommand(ProductId productId) {
        this.productId = productId;
        this.validateSelf();
    }
}
