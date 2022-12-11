package com.alex.controllers;

import com.alex.data.Product;
import com.alex.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCostById(@RequestParam Long productId, @RequestParam Float delta){
       productService.changeCostById(productId,delta);
    }

}
