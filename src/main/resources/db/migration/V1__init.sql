CREATE TABLE orders (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_number varchar(255) DEFAULT NULL,
    sku_code varchar(255),
    quantity int,
    price decimal(19,2)
);