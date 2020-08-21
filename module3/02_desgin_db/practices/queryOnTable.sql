use classicmodels;
CREATE TABLE if not exists contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
  /* Khoá chính của bảng này có tên là contacts_pk và được gán cho cột contact_id */
);

CREATE TABLE if not exists suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

DROP TABLE orders, orderdetails, payments, customers, suppliers;

ALTER TABLE contacts
  ADD email varchar(40) NOT NULL
    AFTER id,
  ADD phone varchar(35) NULL
    AFTER email;
    
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
  
ALTER TABLE contacts
  DROP COLUMN phone;
  
ALTER TABLE contacts
  CHANGE COLUMN email contact_email
    varchar(20) NOT NULL;
    
ALTER TABLE contacts
  RENAME TO people;