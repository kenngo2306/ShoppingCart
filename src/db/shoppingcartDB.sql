CREATE TABLE ShopProduct
(
  product_id INTEGER PRIMARY KEY,
  product_name VARCHAR(200),
  product_description VARCHAR(200),
  product_type VARCHAR(10),
  price NUMBER(10,2)
);

CREATE TABLE ShopLineItem
(
  line_item_id INTEGER PRIMARY KEY,
  product_id INTEGER REFERENCES ShopProduct(product_id),
  quantity NUMBER(10,2)
);

CREATE TABLE ShopUser
(
  user_id INTEGER PRIMARY KEY,
  user_name VARCHAR(50),
  full_name VARCHAR(100),
  email VARCHAR(100),
  user_role VARCHAR(1)
);

CREATE TABLE ShopOrder 
(
  order_id INTEGER PRIMARY KEY,
  order_date DATE,
  order_status VARCHAR(20),
  order_total NUMBER(10,2),
  user_id INTEGER REFERENCES ShopUser(user_id)
);

CREATE TABLE ShopReview
(
  review_id INTEGER PRIMARY KEY,
  user_id INTEGER REFERENCES ShopUser(user_id),
  product_id INTEGER REFERENCES ShopProduct(product_id),
  review_content VARCHAR(255),
  stars NUMBER(1)
);

CREATE SEQUENCE SEQ_SHOPPRODUCT;

CREATE SEQUENCE SEQ_SHOPLINEITEM;
CREATE SEQUENCE SEQ_SHOPUSER;
CREATE SEQUENCE SEQ_SHOPORDER;
CREATE SEQUENCE SEQ_SHOPREVIEW;

ALTER TABLE SHOPLINEITEM ADD order_id INTEGER REFERENCES ShopOrder(order_id);
ALTER TABLE ShopUser ADD user_password VARCHAR(50);
ALTER TABLE SHOPORDER ADD credit_card VARCHAR(20);
ALTER TABLE SHOPORDER ADD billing_address VARCHAR(255);
ALTER TABLE SHOPORDER ADD shipping_address VARCHAR(255);
ALTER TABLE SHOPUSER ADD store_credit NUMBER(10,2);
ALTER TABLE SHOPPRODUCT ADD SHIPPINGCOST NUMBER(10,2);
ALTER TABLE SHOPPRODUCT ADD AVAILABLE VARCHAR(10);
ALTER TABLE SHOPPRODUCT ADD USER_ID INTEGER REFERENCES SHOPUSER(USER_ID);
ALTER TABLE ShopProduct ADD image_link VARCHAR(200);


INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Tempura String bean roll','Tempura with spring bean roll (6 pieces)','roll',4,1,'yes',1,'images/1.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Takuan roll (Yellow pickled)','Yellow pickled roll (6 pieces)','roll',3.5,1,'yes',1,'images/2.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Seaweed roll ()','Tasty assorted seaweed Roll , salman, tuna (12 pieces)','roll',4,1,'yes',1,'images/3.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Kanpyo roll','Sweet melon rolls with seafood','roll',4,1,'yes',1,'images/4.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Vegetable roll ', 'Avocado w/ Cucumber roll','roll',3.5,1,'yes',1,'images/5.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Avocado roll','','roll',3.5,1,'yes',1,'images/6.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Cucumber roll','','roll',4,1,'yes',1,'images/7.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Seaweed salad','Salad bowl with seaweed','roll',3.5,1,'yes',1,'images/8.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Tempura Asparagus roll','Tempura shrimp with asparagus','roll',4,1,'yes',1,'images/9.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Sweet potatoes roll','','roll',3.5,1,'yes',1,'images/10.jpg');




