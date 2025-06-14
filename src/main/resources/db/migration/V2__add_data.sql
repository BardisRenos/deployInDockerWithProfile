-- Insert Addresses

INSERT INTO address (id, street, city) VALUES (1, '123 Main St', 'Springfield');
INSERT INTO address (id, street, city) VALUES (2, '456 Oak Ave', 'Shelbyville');
INSERT INTO address (id, street, city) VALUES (3, '789 Pine Rd', 'Capital City');
INSERT INTO address (id, street, city) VALUES (4, '321 Elm St', 'Ogdenville');
INSERT INTO address (id, street, city) VALUES (5, '654 Cedar Ln', 'North Haverbrook');

-- Insert Clients

INSERT INTO client (id, name, address_id) VALUES (1, 'John Doe', 1);
INSERT INTO client (id, name, address_id) VALUES (2, 'Jane Smith', 2);
INSERT INTO client (id, name, address_id) VALUES (3, 'Alice Johnson', 3);
INSERT INTO client (id, name, address_id) VALUES (4, 'Bob Brown', 4);
INSERT INTO client (id, name, address_id) VALUES (5, 'Charlie Davis', 5);

-- Insert Orders

INSERT INTO client_order (id, product, client_id) VALUES (1, 'Laptop', 1);
INSERT INTO client_order (id, product, client_id) VALUES (2, 'Phone', 1);
INSERT INTO client_order (id, product, client_id) VALUES (3, 'Tablet', 2);
INSERT INTO client_order (id, product, client_id) VALUES (4, 'Monitor', 3);
INSERT INTO client_order (id, product, client_id) VALUES (5, 'Keyboard', 3);
INSERT INTO client_order (id, product, client_id) VALUES (6, 'Mouse', 4);
INSERT INTO client_order (id, product, client_id) VALUES (7, 'Webcam', 5);