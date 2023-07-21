CREATE TABLE products (
    product_code BIGINT NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_price DOUBLE NOT NULL,
    product_category VARCHAR(50) NOT NULL,
    product_brand VARCHAR(100) NOT NULL,
    product_supplier VARCHAR(100) NOT NULL,
    PRIMARY KEY (product_code)
)