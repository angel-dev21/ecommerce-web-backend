-- Categories
INSERT INTO categories (name, description) VALUES
('Electronics', 'Electronic devices and gadgets'),
('Clothing', 'Fashion and apparel'),
('Home & Garden', 'Home improvement and gardening items'),
('Sports', 'Sports equipment and accessories');

-- Sub Categories
INSERT INTO sub_categories (category_id, name, description) VALUES
(1, 'Smartphones', 'Mobile phones and accessories'),
(1, 'Laptops', 'Portable computers'),
(1, 'Tablets', 'Tablet computers'),
(2, 'Men Clothing', 'Clothing for men'),
(2, 'Women Clothing', 'Clothing for women'),
(3, 'Furniture', 'Home furniture'),
(4, 'Fitness', 'Fitness equipment and gear');

-- Product Attributes
INSERT INTO product_attributes (type, value) VALUES
('COLOR', 'Black'),
('COLOR', 'White'),
('COLOR', 'Blue'),
('COLOR', 'Red'),
('SIZE', 'S'),
('SIZE', 'M'),
('SIZE', 'L'),
('SIZE', 'XL'),
('RAM', '8GB'),
('RAM', '16GB'),
('STORAGE', '128GB'),
('STORAGE', '256GB'),
('STORAGE', '512GB'),
('RESOLUTION', '1920x1080'),
('RESOLUTION', '2560x1440'),
('PROCESSOR', 'Intel Core i5'),
('PROCESSOR', 'Intel Core i7');

-- Users
INSERT INTO users (first_name, last_name, username, email, password, date_of_birth, phone_number, role) VALUES
('Admin', 'System', 'admin', 'admin@ecommerce.com', 'hashed_password_admin', '1985-01-01', '+1234567800', 'ADMIN'),
('John', 'Doe', 'johndoe', 'john@example.com', 'hashed_password_1', '1990-05-15', '+1234567890', 'USER'),
('Jane', 'Smith', 'janesmith', 'jane@example.com', 'hashed_password_2', '1985-08-22', '+1234567891', 'USER'),
('Mike', 'Johnson', 'mikejohnson', 'mike@example.com', 'hashed_password_3', '1992-12-10', '+1234567892', 'USER'),
('Sarah', 'Wilson', 'sarahwilson', 'sarah@example.com', 'hashed_password_4', '1988-03-07', '+1234567893', 'USER'),
('Maria', 'Rodriguez', 'mariaadmin', 'maria@ecommerce.com', 'hashed_password_admin2', '1990-06-15', '+1234567801', 'ADMIN');

-- Addresses
INSERT INTO addresses (user_id, address_line_1, address_line_2, country, city, postal_code, landmark) VALUES
(1, '100 Admin Plaza', 'Suite 1000', 'USA', 'Seattle', '98101', 'Tech District'),
(2, '123 Main St', 'Apt 4B', 'USA', 'New York', '10001', 'Near Central Park'),
(3, '456 Oak Ave', 'Suite 200', 'USA', 'Los Angeles', '90210', 'Beverly Hills Area'),
(4, '789 Pine Rd', 'Unit 15', 'USA', 'Chicago', '60601', 'Downtown District'),
(5, '321 Elm St', 'Floor 3', 'USA', 'Miami', '33101', 'Ocean View'),
(6, '200 Commerce St', 'Office 5', 'USA', 'Austin', '78701', 'Downtown');

-- Products
INSERT INTO products (name, description, brand, subcategory_id) VALUES
('iPhone 15 Pro', 'Latest Apple smartphone with advanced camera', 'Apple', 1),
('Samsung Galaxy S24', 'Premium Android smartphone', 'Samsung', 1),
('MacBook Pro 14"', 'Professional laptop for creators', 'Apple', 2),
('Dell XPS 13', 'Ultra-portable business laptop', 'Dell', 2),
('iPad Air', 'Versatile tablet for work and play', 'Apple', 3),
('Nike Air Max', 'Comfortable running shoes', 'Nike', 7),
('Adidas T-Shirt', 'Cotton sports t-shirt', 'Adidas', 4);

-- Product SKUs
INSERT INTO products_skus (product_id, sku, price, quantity, cover) VALUES
(1, 'IPH15P-128-BLK', 999.99, 50, 'iphone15pro-black.jpg'),
(1, 'IPH15P-256-WHT', 1099.99, 30, 'iphone15pro-white.jpg'),
(2, 'SGS24-128-BLU', 899.99, 40, 'galaxys24-blue.jpg'),
(2, 'SGS24-256-BLK', 999.99, 25, 'galaxys24-black.jpg'),
(3, 'MBP14-512-SLV', 1999.99, 15, 'macbookpro14-silver.jpg'),
(3, 'MBP14-1TB-GRY', 2299.99, 10, 'macbookpro14-grey.jpg'),
(4, 'XPS13-256-BLK', 1299.99, 20, 'dellxps13-black.jpg'),
(5, 'IPAD-128-BLU', 599.99, 35, 'ipadair-blue.jpg'),
(6, 'NAM-42-BLK', 129.99, 100, 'nikeairmax-black.jpg'),
(6, 'NAM-43-WHT', 129.99, 80, 'nikeairmax-white.jpg'),
(7, 'ADT-M-RED', 29.99, 200, 'adidastshirt-red.jpg'),
(7, 'ADT-L-BLU', 29.99, 150, 'adidastshirt-blue.jpg');

-- SKU Attributes
INSERT INTO sku_attributes (products_sku_id, product_attribute_id) VALUES
-- iPhone 15 Pro 128GB Black
(1, 1), (1, 11),
-- iPhone 15 Pro 256GB White  
(2, 2), (2, 12),
-- Samsung Galaxy S24 128GB Blue
(3, 3), (3, 11),
-- Samsung Galaxy S24 256GB Black
(4, 1), (4, 12),
-- MacBook Pro 14" 512GB
(5, 13), (5, 16),
-- MacBook Pro 14" 1TB
(6, 13), (6, 17),
-- Dell XPS 13
(7, 1), (7, 12),
-- iPad Air
(8, 3), (8, 11),
-- Nike Air Max Size 42 Black
(9, 1),
-- Nike Air Max Size 43 White
(10, 2),
-- Adidas T-Shirt M Red
(11, 4), (11, 6),
-- Adidas T-Shirt L Blue
(12, 3), (12, 7);

-- Wishlist
INSERT INTO wishlist (user_id) VALUES
(2), (3), (4), (5);

-- Wishlist Items
INSERT INTO wishlist_item (wishlist_id, products_sku_id) VALUES
(1, 1), (1, 5),
(2, 3), (2, 8),
(3, 6), (3, 9),
(4, 2), (4, 7);

-- Cart
INSERT INTO cart (user_id, total) VALUES
(2, 1129.98),
(3, 929.98),
(4, 159.98),
(5, 1899.98);

-- Cart Items
INSERT INTO cart_item (cart_id, products_sku_id, quantity) VALUES
(1, 1, 1), (1, 11, 4),
(2, 3, 1), (2, 9, 1),
(3, 10, 1), (3, 12, 1),
(4, 2, 1), (4, 8, 1);

-- Order Details
INSERT INTO order_details (user_id, total, status) VALUES
(2, 999.99, 'delivered'),
(3, 1299.99, 'shipped'),
(4, 259.98, 'processing'),
(5, 1699.98, 'pending');

-- Order Items
INSERT INTO order_item (order_id, products_sku_id, quantity) VALUES
(1, 1, 1),
(2, 7, 1),
(3, 9, 2),
(4, 5, 1), (4, 8, 1);

-- Payment Details
INSERT INTO payment_details (order_id, amount, provider) VALUES
(1, 999.99, 'visa'),
(2, 1299.99, 'paypal'),
(3, 259.98, 'mastercard'),
(4, 1699.98, 'apple_pay');