CREATE TABLE customer (
customer_id varchar(50) NOT NULL PRIMARY KEY,
first_name varchar(45),
last_name varchar(45),
email_id varchar(50),
phone_number varchar(10),
creation_date TIMESTAMP
)

INSERT INTO customer(
    customer_id, creation_date, email_id, first_name, last_name, phone_number)
VALUES ('a0ec2a02-af74-4da1-a44b-d65b70a7bb82', '2016-06-22 19:10:25-07', 'mark@gmail.com', 'mark', 'zee','9696435632' );

CREATE TABLE address (
address_id varchar(50) NOT NULL PRIMARY KEY,
customer_id varchar(50),
address1 varchar(45),
address2 varchar(45),
city varchar(30),
state varchar(45),
postal_code INT,
last_update_date TIMESTAMP,
CONSTRAINT fk_customer
      FOREIGN KEY(customer_id)
      REFERENCES customer(customer_id)
)

INSERT INTO address(
    address_id, address1, address2, city, last_update_date, postal_code, state, customer_id)
VALUES ('c930ef78-e714-11eb-ba80-0242ac130004', 'Park Street','Down Town' , 'Texas', '2016-06-22 19:10:25-07', 3232, 'California', 'a0ec2a02-af74-4da1-a44b-d65b70a7bb82');
