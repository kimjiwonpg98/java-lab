package kr.arch.deal.product.adapter.in;

import kr.arch.deal.product.application.ProductService;
import kr.arch.deal.product.application.command.GetByProductIdCommand;
import kr.arch.deal.product.domain.Product;
import kr.arch.deal.product.domain.vo.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId) {
        ProductId id = new ProductId(Long.parseLong(productId));
        GetByProductIdCommand command = new GetByProductIdCommand(id);
        Product product = productService.getById(command);
        return ResponseEntity.status(200).body(product);
    }
}
