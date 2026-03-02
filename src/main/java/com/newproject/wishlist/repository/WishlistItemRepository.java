package com.newproject.wishlist.repository;

import com.newproject.wishlist.domain.WishlistItem;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    List<WishlistItem> findByCustomerIdOrderByCreatedAtDesc(Long customerId);
    Optional<WishlistItem> findByCustomerIdAndProductId(Long customerId, Long productId);
}
