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

CREATE SEQUENCE SEQ_SHOPPRODUCT;

CREATE SEQUENCE SEQ_SHOPLINEITEM;
DROP SEQUENCE SEQ_SHOPLINEITEM;
ALTER TABLE ShopProduct ADD image_link VARCHAR(200);

INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Tempura String bean roll','Tempura with spring bean roll (6 pieces)','roll',4,'images/1.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Takuan roll','Yellow pickled roll (6 pieces)','roll',3.5,'images/2.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Seaweed roll','Tasty assorted seaweed Roll , salman, tuna (12 pieces)','roll',4,'images/3.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Kanpyo roll','Sweet melon rolls with seafood','roll',4,'images/4.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Vegetable roll ', 'Avocado w/ Cucumber roll','roll',3.5,'images/5.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Avocado roll','','roll',3.5,'images/6.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Cucumber roll','','roll',4,'images/7.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Seaweed salad','Salad bowl with seaweed','roll',3.5,'images/8.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Tempura Asparagus roll','Tempura shrimp with asparagus','roll',4,'images/9.jpg');
INSERT INTO SHOPPRODUCT VALUES (SEQ_SHOPPRODUCT.NEXTVAL,'Sweet potatoes roll','','roll',3.5,'images/10.jpg');
