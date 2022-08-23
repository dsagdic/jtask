create table customer (
  customer_id SERIAL not null,
  customer_name varchar not null,
  PRIMARY KEY (customer_id)
);

create table Telephone (
  telephone_id SERIAL not null,
  telephone_no VARCHAR unique not null,
  telephone_type VARCHAR not null,
  customer_id INT not null,
  foreign key (customer_id)
      references customer (customer_id),
  PRIMARY key (telephone_id)
);

create table address (
	address_id SERIAL NOT NULL,
	full_address VARCHAR(200) not null,
	county varchar,
	province varchar,
	region varchar,
	country varchar,
	customer_id INT not null,
  	foreign key (customer_id)
      references customer (customer_id),
	PRIMARY KEY (address_id)
);

CREATE TABLE Account (
  account_id SERIAL NOT NULL,
  account_type VARCHAR NOT NULL,
  account_balance REAL NOT NULL,
  customer_id INT not null,
  foreign key (customer_id)
      references customer (customer_id),
  PRIMARY KEY (account_id)
);


select * from account;
select * from address;
select * from customer;
select * from telephone;
