/*set*/
CREATE TABLE ITEMS_SET(
	ID NUMBER(3) PRIMARY KEY,
	NAME VARCHAR2(20)
);
CREATE TABLE IMAGES_SET(
	FILENAME VARCHAR2(20),
	ITEMS_ID NUMBER(10) REFERENCES ITEMS_SET(ID),
	PRIMARY KEY(ITEMS_ID,FILENAME)
);
/*list*/
CREATE TABLE ITEMS_LIST(
	ID NUMBER(3) PRIMARY KEY,
	NAME VARCHAR2(20)
);
CREATE TABLE IMAGES_LIST(
	FILENAME VARCHAR2(20),
	POSITION NUMBER(10),
	ITEMS_ID NUMBER(10) REFERENCES ITEMS_SET(ID),
	PRIMARY KEY(POSITION,FILENAME)
);
/*bag*/
CREATE TABLE ITEMS_BAG(
	ID NUMBER(3) PRIMARY KEY,
	NAME VARCHAR2(20)
);

CREATE TABLE IMAGES_BAG(
	ID NUMBER(10) PRIMARY KEY,
	FILENAME VARCHAR2(20),
	ITEMS_ID NUMBER(10) REFERENCES ITEMS_SET(ID)
);

/*map*/
CREATE TABLE ITEMS_MAP(
	ID NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(20)
);

CREATE TABLE IMAGES_MAP(
	IMAGE_NAME VARCHAR2(20),
	FILENAME VARCHAR2(20),
	ITEMS_ID NUMBER(10) REFERENCES ITEMS_SET(ID),
	PRIMARY KEY(ITEMS_ID,IMAGE_NAME)
);