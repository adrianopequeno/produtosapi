CREATE TABLE tb_product (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(18, 2)
);