package ru.alex.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.alex.bean.Cart;
import ru.alex.dto.ProductDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/carts")
public class CartController {
    private final Cart cart;

    @GetMapping()
    public List<ProductDto> showCart() {
        return cart.getProducts();
    }

    @GetMapping("/add")
    public List<ProductDto> addProductToCart(@RequestParam Long productId) {
        return cart.addProductCartById(productId);
    }

    @GetMapping("/remove/{productId}")
    public List<ProductDto> removeProductFromCart(@PathVariable Long productId) {
        return cart.removeProductFromCartById(productId);
    }
}
