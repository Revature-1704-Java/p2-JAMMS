/*******************
*RESET THE DATABASE*
*******************/

DROP TABLE Library;
DROP TABLE Carts;
DROP TABLE Book_Genre;
DROP TABLE Genres;
DROP TABLE Discounts;
DROP TABLE FlaggedReviews;
DROP TABLE Reviews;
DROP TABLE Books;
DROP TABLE Authors;
DROP TABLE Flags;
DROP TABLE Ratings;
DROP TABLE Customers;
DROP SEQUENCE seqPK_Library;
DROP SEQUENCE seqPK_Carts;
DROP SEQUENCE seqPK_Book_Genre;
DROP SEQUENCE seqPK_Discounts;
DROP SEQUENCE seqPK_FlaggedReviews;
DROP SEQUENCE seqPK_Books;
DROP SEQUENCE seqPK_Authors;
DROP SEQUENCE seqPK_Reviews;
DROP SEQUENCE seqPK_Customers;

/***********************
*Create Database Tables*
***********************/
CREATE TABLE Library
(
	ID INT NOT NULL,
	Customer INT NOT NULL,
	Book INT NOT NULL,
	Price NUMBER(5,2) NOT NULL,
	CONSTRAINT PK_Library PRIMARY KEY (ID)
);

CREATE TABLE Carts
(
	ID INT NOT NULL,
	Customer INT NOT NULL,
	Book INT NOT NULL,
	CONSTRAINT PK_Carts PRIMARY KEY (ID)
);

CREATE TABLE Book_Genre
(
	ID INT NOT NULL,
	Book INT NOT NULL,
	Genre INT NOT NULL,
	CONSTRAINT PK_Book_Genre PRIMARY KEY (ID)
);

CREATE TABLE Genres
(
	ID INT NOT NULL,
	Genre VARCHAR2(35) UNIQUE NOT NULL,
	CONSTRAINT PK_Genres PRIMARY KEY (ID)
);

CREATE TABLE Discounts
(
	ID INT NOT NULL,
	Book INT NOT NULL,
	Discount NUMBER(5,2) NOT NULL,
	StartDate DATE NOT NULL,
	EndDate DATE NOT NULL,
	CONSTRAINT PK_Discounts PRIMARY KEY (ID)
);

CREATE TABLE FlaggedReviews
(
	ID INT NOT NULL,
	Customer INT NOT NULL,
	Review INT NOT NULL,
	Flag INT NOT NULL,
	CONSTRAINT PK_FlaggedReviews PRIMARY KEY (ID)
);

CREATE TABLE Reviews
(
	ID INT NOT NULL,
	Customer INT NOT NULL,
	Book INT NOT NULL,
	DateAdded DATE NOT NULL,
	Rating INT,
	Review VARCHAR2(160),
	CONSTRAINT PK_Reviews PRIMARY KEY (ID)
);

CREATE TABLE Books
(
	ID INT NOT NULL,
	Title VARCHAR2(160) NOT NULL,
	Author INT NOT NULL,
	Description VARCHAR2(160) NOT NULL, 
	Published DATE NOT NULL,
	Price NUMBER(5,2) NOT NULL,
	CONSTRAINT PK_Books PRIMARY KEY (ID)
);

CREATE TABLE Authors
(
	ID INT NOT NULL,
	FirstName VARCHAR2(35) NOT NULL,
	LastName VARCHAR2(35) NOT NULL,
	CONSTRAINT PK_Authors PRIMARY KEY (ID)
);

CREATE TABLE Flags
(
	ID INT NOT NULL,
	Flag VARCHAR2(20) UNIQUE NOT NULL,
	CONSTRAINT PK_Flags PRIMARY KEY (ID)
);

CREATE TABLE Ratings
(
	ID INT NOT NULL,
	Rating INT UNIQUE NOT NULL,
	CONSTRAINT PK_Ratings PRIMARY KEY (ID)
);

CREATE TABLE Customers
(
	Customer_ID INT NOT NULL,
	Username VARCHAR2(70) UNIQUE NOT NULL,
	Email VARCHAR2(100) UNIQUE NOT NULL,
	Passwd VARCHAR2(128) NOT NULL,
	CONSTRAINT PK_Customers PRIMARY KEY (Customer_ID)
);


/****************************
*Add Foriegn Key Constraints*
****************************/
ALTER TABLE Library ADD CONSTRAINT FK_TblPB_ColCu FOREIGN KEY (Customer) REFERENCES Customers (Customer_ID);
ALTER TABLE Library ADD CONSTRAINT FK_TblPB_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Carts ADD CONSTRAINT FK_TblCu_ColCu FOREIGN KEY (Customer) REFERENCES Customers (Customer_ID);
ALTER TABLE Carts ADD CONSTRAINT FK_TblCu_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Book_Genre ADD CONSTRAINT FK_TblBG_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Book_Genre ADD CONSTRAINT FK_Tbl_BG_ColGe FOREIGN KEY (Genre) REFERENCES Genres (ID);
ALTER TABLE Discounts ADD CONSTRAINT FK_TblDi_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE FlaggedReviews ADD CONSTRAINT FK_Tbl_ColCu FOREIGN KEY (Customer) REFERENCES Customers (Customer_ID);
ALTER TABLE FlaggedReviews ADD CONSTRAINT FK_Tbl_ColRe FOREIGN KEY (Review) REFERENCES Reviews (ID);
ALTER TABLE FlaggedReviews ADD CONSTRAINT FK_Tbl_ColFl FOREIGN KEY (Flag) REFERENCES Flags (ID);
ALTER TABLE Reviews ADD CONSTRAINT FK_TblRe_ColCu FOREIGN KEY (Customer) REFERENCES Customers (Customer_ID);
ALTER TABLE Reviews ADD CONSTRAINT FK_TblRe_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Reviews ADD CONSTRAINT FK_TblRe_ColRa FOREIGN KEY (Rating) REFERENCES Ratings (ID);
ALTER TABLE Books ADD CONSTRAINT FK_TblBo_ColAu FOREIGN KEY (Author) REFERENCES Authors (ID);


/*************************
*Add Reference Table Data*
*************************/
INSERT INTO Genres (ID,Genre) VALUES (1,'NONFICTION');
INSERT INTO Genres (ID,Genre) VALUES (2,'SCIENCE_FICTION');
INSERT INTO Genres (ID,Genre) VALUES (3,'ACTION_AND_ADVENTURE');
INSERT INTO Genres (ID,Genre) VALUES (4,'MYSTERY');
INSERT INTO Genres (ID,Genre) VALUES (5,'HORROR');
INSERT INTO Genres (ID,Genre) VALUES (6,'SELF_HELP');

INSERT INTO Flags (ID,Flag) VALUES (1,'UNFLAGGED');
INSERT INTO Flags (ID,Flag) VALUES (2,'INNAPROPRIATE');
INSERT INTO Flags (ID,Flag) VALUES (3,'SPAM');
INSERT INTO Flags (ID,Flag) VALUES (4,'HELPFUL');

INSERT INTO Ratings (ID,Rating) VALUES (1,1);
INSERT INTO Ratings (ID,Rating) VALUES (2,2);
INSERT INTO Ratings (ID,Rating) VALUES (3,3);
INSERT INTO Ratings (ID,Rating) VALUES (4,4);
INSERT INTO Ratings (ID,Rating) VALUES (5,5);


/*****************************
*Create Primary Key Sequences*
*****************************/
CREATE SEQUENCE seqPK_Library;
CREATE SEQUENCE seqPK_Carts;
CREATE SEQUENCE seqPK_Book_Genre;
CREATE SEQUENCE seqPK_Discounts;
CREATE SEQUENCE seqPK_FlaggedReviews;
CREATE SEQUENCE seqPK_Reviews;
CREATE SEQUENCE seqPK_Books;
CREATE SEQUENCE seqPK_Authors;
CREATE SEQUENCE seqPK_Customers;


/****************
*Create Triggers*
****************/
CREATE OR REPLACE TRIGGER inc_Library
BEFORE INSERT ON Library
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Library.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Carts
BEFORE INSERT ON Carts
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Carts.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Book_Genre
BEFORE INSERT ON Book_Genre
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Book_Genre.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Discounts
BEFORE INSERT ON Discounts
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Discounts.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_FlaggedReviews
BEFORE INSERT ON FlaggedReviews
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_FlaggedReviews.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Reviews
BEFORE INSERT ON Reviews
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Reviews.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Books
BEFORE INSERT ON Books
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Books.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Authors
BEFORE INSERT ON Authors
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_Authors.NEXTVAL;
	END;
/

CREATE OR REPLACE TRIGGER inc_Customers
BEFORE INSERT ON Customers
FOR EACH ROW
	BEGIN
		:NEW.Customer_ID := seqPK_Customers.NEXTVAL;
	END;
/


/********************
*Add Mock Table Data*
********************/
--INSERT INTO (ID,) VALUES (1,);

INSERT INTO customers (username, email, passwd)
VALUES('samy', 's@email.com', 'asd');
INSERT INTO customers (username, email, passwd)
VALUES('mike', 'm@email.com', 'asd');

----------------------------Authors-----------------------------------
INSERT INTO authors (firstname, lastname)
VALUES('JK', 'Rowling');

INSERT INTO authors (firstname, lastname)
VALUES('Ted', 'Seuss');

---------------------------Books--------------------------------------

INSERT INTO books (title, author, description, published, price)
VALUES('Harry Potter: Sorcers Stone', 1, 'Your a wizard harry!', '21-JAN-95',9.99);

INSERT INTO books (title, author, description, published, price)
VALUES('Green Eggs and Ham', 2, 'Would you like some green eggs and ham?', '22-JAN-85',9.99);

INSERT INTO books (title, author, description, published, price)
VALUES('The Cat in the Hat', 2, 'The Cat is back!', '22-JAN-84',10.99);

commit;

