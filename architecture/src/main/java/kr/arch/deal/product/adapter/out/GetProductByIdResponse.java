package kr.arch.deal.product.adapter.out;

import java.math.BigDecimal;

public record GetProductByIdResponse(
        Long id,
        Long amount,
        Long userId,
        BigDecimal price
) {}
