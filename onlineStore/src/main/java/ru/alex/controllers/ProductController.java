package ru.alex.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.alex.data.Product;
import ru.alex.services.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> showProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/change_cost")
    public void changeCostById(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCostById(productId, delta);
    }

    @PostMapping(value = "/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/find_min")
    public List<Product> findByMinCost(@RequestParam(name = "min") Integer min) {
        return productService.moreThanMinCost(min);
    }

    @GetMapping("/find_max")
    public List<Product> findByMaxCost(@RequestParam(name = "max") Integer max) {
        return productService.lessThanMaxCost(max);
    }

    @GetMapping("/between_cost")
    public List<Product> findByBetweenCost(@RequestParam(name = "min") Integer min, @RequestParam(name = "max") Integer max) {
        return productService.findAllByCostBetween(min, max);
    }
}