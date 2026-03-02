CREATE TABLE wishlist_item (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    CONSTRAINT uq_wishlist_item UNIQUE (customer_id, product_id)
);

CREATE INDEX idx_wishlist_item_customer ON wishlist_item(customer_id);
CREATE INDEX idx_wishlist_item_product ON wishlist_item(product_id);
