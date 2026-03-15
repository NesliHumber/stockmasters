-- -----------------------------
-- BRANDS
-- -----------------------------
INSERT INTO brand (brand_id, name) VALUES (1, 'Apple');
INSERT INTO brand (brand_id, name) VALUES (2, 'Samsung');
INSERT INTO brand (brand_id, name) VALUES (3, 'Nike');

-- -----------------------------
-- CATEGORIES
-- -----------------------------
INSERT INTO category (category_id, name) VALUES (1, 'Electronics');
INSERT INTO category (category_id, name) VALUES (2, 'Clothing');
INSERT INTO category (category_id, name) VALUES (3, 'Accessories');

-- -----------------------------
-- DISTRIBUTION CENTERS
-- -----------------------------
INSERT INTO distribution_center (center_id, name, city, state)
VALUES (1, 'Center A', 'Toronto', 'ON');

INSERT INTO distribution_center (center_id, name, city, state)
VALUES (2, 'Center B', 'Vancouver', 'BC');

INSERT INTO distribution_center (center_id, name, city, state)
VALUES (3, 'Center C', 'Montreal', 'QC');

-- -----------------------------
-- PRODUCTS
-- -----------------------------
INSERT INTO product (name, price, quantity, brand_id, category_id, created_at)
VALUES ('iPhone 15', 999, 50, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO product (name, price, quantity, brand_id, category_id, created_at)
VALUES ('MacBook Pro', 2499, 20, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO product (name, price, quantity, brand_id, category_id, created_at)
VALUES ('Samsung Galaxy S24', 899, 40, 2, 1, CURRENT_TIMESTAMP);

INSERT INTO product (name, price, quantity, brand_id, category_id, created_at)
VALUES ('Samsung TV 55"', 1200, 15, 2, 1, CURRENT_TIMESTAMP);

INSERT INTO product (name, price, quantity, brand_id, category_id, created_at)
VALUES ('Nike Running Shoes', 180, 60, 3, 2, CURRENT_TIMESTAMP);

INSERT INTO product (name, price, quantity, brand_id, category_id, created_at)
VALUES ('Nike Backpack', 90, 35, 3, 3, CURRENT_TIMESTAMP);

-- -----------------------------
-- INVENTORY
-- -----------------------------

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (1, 1, 25);

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (1, 2, 10);

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (2, 1, 8);

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (3, 2, 30);

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (4, 3, 12);

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (5, 1, 20);

INSERT INTO inventory (product_id, center_id, quantity)
VALUES (6, 3, 15);