/*******************
*RESET THE DATABASE*
*******************/

DROP TABLE PurchasedBooks;
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
DROP SEQUENCE seqPK_PurchasedBooks;
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
CREATE TABLE PurchasedBooks
(
	ID INT NOT NULL,
	Customer INT NOT NULL,
	Book INT NOT NULL,
	Price NUMBER(5,2) NOT NULL,
	CONSTRAINT PK_PurchasedBooks PRIMARY KEY (ID)
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
<<<<<<< HEAD
<<<<<<< HEAD
	Description VARCHAR2(2000) NOT NULL, 
=======
	Description VARCHAR2(160) NOT NULL,
>>>>>>> master
=======
	Description VARCHAR2(1500) NOT NULL,
>>>>>>> master
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
	ID INT NOT NULL,
	Username VARCHAR2(70) UNIQUE NOT NULL,
	Email VARCHAR2(100) UNIQUE NOT NULL,
	Password VARCHAR2(128) NOT NULL,
	CONSTRAINT PK_Customers PRIMARY KEY (ID)
);


/****************************
*Add Foriegn Key Constraints*
****************************/
ALTER TABLE PurchasedBooks ADD CONSTRAINT FK_TblPB_ColCu FOREIGN KEY (Customer) REFERENCES Customers (ID);
ALTER TABLE PurchasedBooks ADD CONSTRAINT FK_TblPB_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Carts ADD CONSTRAINT FK_TblCu_ColCu FOREIGN KEY (Customer) REFERENCES Customers (ID);
ALTER TABLE Carts ADD CONSTRAINT FK_TblCu_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Book_Genre ADD CONSTRAINT FK_TblBG_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Book_Genre ADD CONSTRAINT FK_Tbl_BG_ColGe FOREIGN KEY (Genre) REFERENCES Genres (ID);
ALTER TABLE Discounts ADD CONSTRAINT FK_TblDi_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE FlaggedReviews ADD CONSTRAINT FK_Tbl_ColCu FOREIGN KEY (Customer) REFERENCES Customers (ID);
ALTER TABLE FlaggedReviews ADD CONSTRAINT FK_Tbl_ColRe FOREIGN KEY (Review) REFERENCES Reviews (ID);
ALTER TABLE FlaggedReviews ADD CONSTRAINT FK_Tbl_ColFl FOREIGN KEY (Flag) REFERENCES Flags (ID);
ALTER TABLE Reviews ADD CONSTRAINT FK_TblRe_ColCu FOREIGN KEY (Customer) REFERENCES Customers (ID);
ALTER TABLE Reviews ADD CONSTRAINT FK_TblRe_ColBo FOREIGN KEY (Book) REFERENCES Books (ID);
ALTER TABLE Reviews ADD CONSTRAINT FK_TblRe_ColRa FOREIGN KEY (Rating) REFERENCES Ratings (ID);
ALTER TABLE Books ADD CONSTRAINT FK_TblBo_ColAu FOREIGN KEY (Author) REFERENCES Authors (ID);


/*************************
*Add Reference Table Data*
*************************/
INSERT INTO Genres (ID, Genre) VALUES (1, 'POLITICS');
INSERT INTO Genres (ID, Genre) VALUES (2, 'FANTASY');
INSERT INTO Genres (ID, Genre) VALUES (3, 'THRILLER');
INSERT INTO Genres (ID, Genre) VALUES (4, 'GRAPHIC_NOVEL');
INSERT INTO Genres (ID, Genre) VALUES (5, 'POETRY');
INSERT INTO Genres (ID, Genre) VALUES (6, 'CLASSIC');
INSERT INTO Genres (ID, Genre) VALUES (7, 'COMEDY');
INSERT INTO Genres (ID, Genre) VALUES (8, 'ACTION');
INSERT INTO Genres (ID,Genre) VALUES (11,'NONFICTION');
INSERT INTO Genres (ID,Genre) VALUES (12,'SCIENCE_FICTION');
INSERT INTO Genres (ID,Genre) VALUES (13,'ACTION_AND_ADVENTURE');
INSERT INTO Genres (ID,Genre) VALUES (14,'MYSTERY');
INSERT INTO Genres (ID,Genre) VALUES (15,'HORROR');
INSERT INTO Genres (ID,Genre) VALUES (16,'SELF_HELP');

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
CREATE SEQUENCE seqPK_PurchasedBooks;
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
CREATE OR REPLACE TRIGGER inc_PurchasedBooks
BEFORE INSERT ON PurchasedBooks
FOR EACH ROW
	BEGIN
		:NEW.ID := seqPK_PurchasedBooks.NEXTVAL;
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
		:NEW.ID := seqPK_Customers.NEXTVAL;
	END;
/


/********************
*Add Mock Table Data*
********************/

INSERT INTO Authors (ID, FirstName, LastName) VALUES (1,'Michael','Wolff');
INSERT INTO Authors (ID, FirstName, LastName) VALUES (2,'J. K.','Rowling');
INSERT INTO Authors (ID, FirstName, LastName) VALUES (3,'Dan','Brown');
INSERT INTO Authors (ID, FirstName, LastName) VALUES (4,'Alan','Moore');
INSERT INTO Authors (ID, FirstName, LastName) VALUES (5,'Dante','Alighieri');
INSERT INTO Authors (ID, FirstName, LastName) VALUES (6,'Douglas','Adams');
INSERT INTO Authors (ID, FirstName, LastName) VALUES (7,'Edgar Allen','Poe');



INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (1,'Fire and Fury: Inside the Trump White House',1,'The first nine months of Donald Trump’s term were stormy, outrageous—and absolutely mesmerizing. Now, thanks to his deep access to the West Wing, bestselling author Michael Wolff tells the riveting story of how Trump launched a tenure as volatile and fiery as the man himself.',TO_DATE('2018-01-05','yyyy-mm-dd'),30.00);

INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (2,'Harry Potter and the Sorcerer''s Stone',2,'Harry Potter has never been the star of a Quidditch team, scoring points while riding a broom far above the ground. He knows no spells, has never helped to hatch a dragon, and has never worn a cloak of invisibility.  All he knows is a miserable life with the Dursleys, his horrible aunt and uncle, and their abominable son, Dudley - a great big swollen spoiled bully. Harry''s room is a tiny closet at the foot of the stairs, and he hasn''t had a birthday party in eleven years.  But all that is about to change when a mysterious letter arrives by owl messenger: a letter with an invitation to an incredible place that Harry - and anyone who reads about him - will find unforgettable.  For it''s there that he finds not only friends, aerial sports, and magic in everything from classes to meals, but a great destiny that''s been waiting for him... if Harry can survive the encounter.',TO_DATE('1999-09-08','yyyy-mm-dd'),10.99);
INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (3,'The Davinci Code',3,'While in Paris on business, Harvard symbologist Robert Langdon receives an urgent late-night phone call: the elderly curator of the Louvre has been murdered inside the museum. Near the body, police have found a baffling cipher. While working to solve the enigmatic riddle, Langdon is stunned to discover it leads to a trail of clues hidden in the works of Da Vinci -- clues visible for all to see -- yet ingeniously disguised by the painter.  Langdon joins forces with a gifted French cryptologist, Sophie Neveu, and learns the late curator was involved in the Priory of Sion -- an actual secret society whose members included Sir Isaac Newton, Botticelli, Victor Hugo, and Da Vinci, among others.  In a breathless race through Paris, London, and beyond, Langdon and Neveu match wits with a faceless powerbroker who seems to anticipate their every move. Unless Langdon and Neveu can deipher the labyrinthine puzzle in time, the Priory''s ancient secret -- and an explosive historical truth -- will be lost forever.',TO_DATE('2006-03-28','yyyy-mm-dd'),14.95);
INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (4,'Digital Fortress',3,'When the NSA''s invincible code-breaking machine encounters a mysterious code it cannot break, the agency calls its head cryptographer, Susan Fletcher, a brilliant, beautiful mathematician. What she uncovers sends shock waves through the corridors of power. The NSA is being held hostage--not by guns or bombs -- but by a code so complex that if released would cripple U.S. intelligence. Caught in an accelerating tempest of secrecy and lies, Fletcher battles to save the agency she believes in. Betrayed on all sides, she finds herself fighting not only for her country but for her life, and in the end, for the life of the man she loves. ',TO_DATE('2008-11-04','yyyy-mm-dd'),9.99);
INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (5,'Watchmen',4,'Watchmen is set in an alternate reality that closely mirrors the contemporary world of the 1980s. The primary difference is the presence of superheroes. The point of divergence occurs in the year 1938. Their existence in this version of America is shown to have dramatically affected and altered the outcomes of real-world events such as the Vietnam War and the presidency of Richard Nixon. In keeping with the realism of the series, although the costumed crimefighters of Watchmen are commonly called "superheroes", only one (Doctor Manhattan) possesses any superhuman powers. The war in Vietnam ends with a U.S. victory in 1971 and Nixon is still president as of October 1985. The Soviet invasion of Afghanistan occurs approximately six years later than in real life. When the story begins, the existence of Doctor Manhattan has given the U.S. a strategic advantage over the Soviet Union, which has increased tensions between the two nations. Eventually, superheroes grow unpopular among the police and the public, leading to the passage of legislation (the Keene Act) in 1977 to outlaw them. While many of the heroes retired, Doctor Manhattan and a veteran superhero known as The Comedian operate as government-sanctioned agents. Another, Rorschach, continues to operate outside the law.',TO_DATE('2014-05-13','yyyy-mm-dd'),19.99);

INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (6,'The Divine Comedy',5,'A landmark of world literature, The Divine Comedy tells of the poet Dante''s travels through Hell, Purgatory, and Paradise in search of salvation. Before he is redeemed by his love for the heavenly Beatrice, he learns the meaning of evil, sin, damnation, and forgiveness through a series of unforgettable experiences and encounters. This edition of The Divine Comedy features Henry Wadsworth Longfellow''s renowned translation and 135 full-page reproductions of Gustave Doré''s classic engravings from the 1867 edition. The Divine Comedy is one of Barnes and Noble''s Collectible Editions classics. Each volume features authoritative texts by the world''s greatest authors in an exquisitely designed bonded-leather binding, with distinctive gilt edging and a ribbon bookmark. Decorative, durable, and collectible, these books offer hours of pleasure to readers young and old and are an indispensable cornerstone for every home library.',TO_DATE('2016-06-01','yyyy-mm-dd'),20.00);
INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (7,'The Ultimate Hitchhiker''s Guide to the Galaxy',6,'Your planet has just been destroyed and you’re lost in the space-time continuum, but—Don’t Panic! Just thumb your way to the end of the universe for a nice cuppa tea with the help of The Ultimate Hitchhiker’s Guide to the Galaxy, your Baedeker for intergalactic zaniness. Featuring all five novels in Douglas Adams’s beloved Hitchhiker’s series—The Hitchhiker’s Guide to the Galaxy; The Restaurant at the End of the Universe; Life, the Universe and Everything; So Long, and Thanks for All the Fish; Mostly Harmless—and the bonus short story “Young Zaphod Plays It Safe,” this omnibus provides you with the perfect itinerary for sightseeing across the universe, from the beginning to the end of time. Along the way you’ll meet paranoid robots, avert Armageddon (more than once!), and learn the answer to the ultimate question concerning life, the universe, and everything—even though you’ll never learn what the question is. So strap in, get ready for lift-off, and prepare yourself for comedy on a cosmic scale.  The Ultimate Hitchhiker’s Guide to the Galaxy is one of Barnes and Noble’s Collectible Editions classics. Each volume features authoritative texts by the world’s greatest authors in exquisitely designed bonded-leather bindings with distinctive gilt edging and an attractive ribbon bookmark. Decorative, durable, and collectable, these books offer hours of pleasure to readers young and old and are an indispensable cornerstone for any home library.',TO_DATE('2010-10-25','yyyy-mm-dd'),25.00);

INSERT INTO Books (ID,Title,Author,Description,Published,Price) VALUES (8,'The Complete Tales and Poems of Edgar Allen Poe',7,'Edgar Allan Poe is credited with having pioneered the short story, having perfected the tale of psychological horror, and having revolutionized modern poetics. The entirety of Poe''s body of imaginative work encompasses detective tales, satires, fables, fantasies, science fiction, verse dramas, and some of the most evocative poetry in the English language. This leatherbound omnibus collects all of Poe''s fiction and poetry in a single volume, including "The Fall of the House of Usher," "The Tell-Tale Heart," "The Pit and the Pendulum,." "The Raven," "Annabel Lee," the full-length novel The Narrative of Arthur Gordon Pym of Nantucket, and much more.  The Complete Tales and Poems of Edgar Allan Poe is part of Barnes and Noble''s Collectible Editions series. Each title in the series presents a classic work in an attractively designed edition bound in genuine bonded leather. These books make elegant additions to any home library.',TO_DATE('2015-07-31','yyyy-mm-dd'),25.00);


INSERT INTO Book_Genre (ID, Book, Genre) VALUES (1,1,1);
INSERT INTO Book_Genre (ID, Book, Genre) VALUES (2,2,2);
INSERT INTO Book_Genre (ID, Book, Genre) VALUES (3,3,3);
INSERT INTO Book_Genre (ID, Book, Genre) VALUES (4,4,3);
INSERT INTO Book_Genre (ID, Book, Genre) VALUES (5,5,4);
INSERT INTO Book_Genre (ID, Book, Genre) VALUES (6,6,6);
INSERT INTO Book_Genre (ID, Book, Genre) VALUES (7,6,5);

INSERT INTO Book_Genre (ID, Book, Genre) VALUES (8,7,6);

INSERT INTO Book_Genre (ID, Book, Genre) VALUES (9,8,5);


INSERT INTO Discounts (ID,Book,Discount,StartDate,EndDate) VALUES (1, 2, 9.99, TO_DATE('2018-01-01','yyyy-mm-dd'), TO_DATE('2018-02-01','yyyy-mm-dd'));
INSERT INTO Discounts (ID,Book,Discount,StartDate,EndDate) VALUES (2, 5, 14.99, TO_DATE('2018-01-01','yyyy-mm-dd'), TO_DATE('2018-02-01','yyyy-mm-dd'));
INSERT INTO Discounts (ID,Book,Discount,StartDate,EndDate) VALUES (3, 7, 20.00, TO_DATE('2018-01-01','yyyy-mm-dd'), TO_DATE('2018-02-01','yyyy-mm-dd'));


INSERT INTO Customers (ID, Username, Email, Password) VALUES (1,'Customer','customer@email.com','Pass');




INSERT INTO Reviews (ID,Customer,Book,DateAdded,Rating,Review) VALUES (1,1,5,TO_DATE('2018-01-16','yyyy-mm-dd'),5,'At Midnight All The Agents...');
INSERT INTO Reviews (ID,Customer,Book,DateAdded,Rating,Review) VALUES (2,1,1,TO_DATE('2018-01-16','yyyy-mm-dd'),1,'$#!T Hole');


INSERT INTO FlaggedReviews (ID, Customer, Review, Flag) VALUES (1,1,1,4);
INSERT INTO FlaggedReviews (ID, Customer, Review, Flag) VALUES (2,1,2,2);

commit;
