CREATE TYPE user_role AS ENUM (
    'USER',
    'ADMIN'
);

CREATE TYPE product_attribute_type AS ENUM (
    'COLOR',
    'SIZE', 
    'RAM',
    'STORAGE',
    'RESOLUTION',
    'PROCESSOR'
);

CREATE TYPE order_status AS ENUM (
	'pending',
	'processing',
	'shipped',
	'delivered',
	'cancelled'
);

CREATE TYPE payment_provider AS ENUM (
	'visa',
	'mastercard',
	'paypal',
	'apple_pay' 
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    phone_number VARCHAR(20),
    role user_role NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE addresses (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE,
    address_line_1 VARCHAR(255) NOT NULL,
    address_line_2 VARCHAR(255) NOT NULL,
    country VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    landmark VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE sub_categories (
    id SERIAL PRIMARY KEY,
    category_id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    brand VARCHAR(100),
    subcategory_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (subcategory_id) REFERENCES sub_categories(id)
);

CREATE TABLE product_attributes (
    id SERIAL PRIMARY KEY,
    type product_attribute_type NOT NULL,
    value VARCHAR(255) NOT NULL
);

CREATE TABLE products_skus (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL,
    sku VARCHAR(100) NOT NULL UNIQUE,
    price DECIMAL(10,2) NOT NULL,
    quantity INTEGER NOT NULL,
    cover VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE sku_attributes (
    id SERIAL PRIMARY KEY,
    products_sku_id INTEGER NOT NULL,
    product_attribute_id INTEGER NOT NULL,
    FOREIGN KEY (products_sku_id) REFERENCES products_skus(id),
    FOREIGN KEY (product_attribute_id) REFERENCES product_attributes(id),
    UNIQUE(products_sku_id, product_attribute_id)
);

CREATE TABLE wishlist (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE wishlist_item (
    id SERIAL PRIMARY KEY,
    wishlist_id INTEGER NOT NULL,
    products_sku_id INTEGER NOT NULL,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (wishlist_id) REFERENCES wishlist(id),
    FOREIGN KEY (products_sku_id) REFERENCES products_skus(id),
    UNIQUE(wishlist_id, products_sku_id)
);

CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE,
    total DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cart_item (
    id SERIAL PRIMARY KEY,
    cart_id INTEGER NOT NULL,
    products_sku_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cart_id) REFERENCES cart(id),
    FOREIGN KEY (products_sku_id) REFERENCES products_skus(id)
);

CREATE TABLE order_details (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    total DECIMAL(10,2),
	status order_status NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_item (
    id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL,
    products_sku_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES order_details(id),
    FOREIGN KEY (products_sku_id) REFERENCES products_skus(id)
);

CREATE TABLE payment_details (
    id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL UNIQUE,
    amount DECIMAL(10,2) NOT NULL,
    provider payment_provider NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES order_details(id)
);