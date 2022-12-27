package ru.alex.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.alex.data.Product;
import ru.alex.dto.ProductDto;
import ru.alex.services.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public Page<ProductDto> showProducts(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "part_title", required = false) String partTitle
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minCost, maxCost, partTitle, page).map(ProductDto::new);
    }

    @DeleteMapping()
    public void deleteProductById(@RequestParam Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id).map(ProductDto::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/change_cost")
    public void changeCostById(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCostById(productId, delta);
    }

    @PostMapping()
    public ProductDto addProduct(@RequestBody Product product) {
        product.setId(null);
        return new ProductDto(productService.saveProduct(product));
    }

    @PutMapping()
    public ProductDto updateProduct(@RequestBody Product product) {
        return new ProductDto(productService.saveProduct(product));
    }
}