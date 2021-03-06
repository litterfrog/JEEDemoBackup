DROP TABLE T_ORDERLINE;
DROP TABLE T_ORDER;

CREATE TABLE T_ORDER(
	ID NUMBER(10) PRIMARY KEY,
	ORDERED_DATE DATE NOT NULL,
	SHIPPED_DATE DATE,
	TOTAL NUMBER(10,2)
);

CREATE TABLE T_ORDERlINE(
	ID NUMBER(10) PRIMARY KEY,
	PRICE NUMBER(10,2),
	QUANTITY NUMBER(10),
	PRODUCT VARCHAR2(30),
	ORDER_ID NUMBER(10) REFERENCES T_ORDER(ID)
);

DROP SEQUENCE T_ORDER_SEQ;
CREATE SEQUENCE T_ORDER_SEQ
START WITH 1
INCREMENT BY 1;

DROP SEQUENCE T_ORDERLINE_SEQ;
CREATE SEQUENCE T_ORDERLINE_SEQ
START WITH 1
INCREMENT BY 1;