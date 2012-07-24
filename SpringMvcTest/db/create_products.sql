DROP TABLE products;
CREATE TABLE products (
  id INTEGER NOT NULL PRIMARY KEY,
  description varchar(255),
  price integer 
);
CREATE INDEX products_description ON products(description);
