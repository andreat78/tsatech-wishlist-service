package com.newproject.wishlist.controller;

import com.newproject.wishlist.dto.WishlistItemRequest;
import com.newproject.wishlist.dto.WishlistItemResponse;
import com.newproject.wishlist.service.WishlistService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers/{customerId}/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping
    public List<WishlistItemResponse> list(@PathVariable Long customerId) {
        return wishlistService.listByCustomer(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WishlistItemResponse add(@PathVariable Long customerId, @Valid @RequestBody WishlistItemRequest request) {
        return wishlistService.add(customerId, request);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long customerId, @PathVariable Long productId) {
        wishlistService.remove(customerId, productId);
    }
}
