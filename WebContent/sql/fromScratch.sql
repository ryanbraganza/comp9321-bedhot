drop table if exists tbl_purchases cascade;
drop table if exists tbl_cartItems cascade;
drop table if exists tbl_carts cascade;
drop table if exists tbl_hotelReviews cascade;
drop table if exists tbl_hotels cascade;
drop table if exists tbl_deals cascade;
drop table if exists tbl_providers cascade;
drop table if exists tbl_customers cascade;
drop table if exists tbl_users cascade;


    CREATE TABLE TBL_USERS (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        ISADMIN BOOLEAN NOT NULL,
        PASSWORD VARCHAR(20) NOT NULL,
        PRIMARY KEY (ID)
    )

    CREATE TABLE TBL_CUSTOMERS (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        USERID INTEGER,
        EMAIL  VARCHAR(50) NOT NULL,
        CCTYPE VARCHAR(10)  ,
        CCNUMBER VARCHAR(20)  ,
        CCNAME VARCHAR(30)  ,

        PRIMARY KEY (ID),
        FOREIGN KEY (USERID) REFERENCES TBL_USERS(ID)
    )

    CREATE TABLE TBL_PROVIDERS (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        USERID INTEGER,
        ADMINFULLNAME VARCHAR(50),
        ADMINEMAIL    VARCHAR(30),

        PRIMARY KEY (ID),
        FOREIGN KEY (USERID) REFERENCES TBL_USERS(ID)
    )
    
    CREATE TABLE TBL_HOTELS (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        PROVIDERID INTEGER NOT NULL,
        NAME VARCHAR(30),
        ADDRESS VARCHAR(100),
        INFO VARCHAR(200),
        NUMSTARS INTEGER,
        IMAGE VARCHAR(200),

        CHECK (NUMSTARS >=0),
        CHECK (NUMSTARS <=5),
        PRIMARY KEY (ID),
        FOREIGN KEY (PROVIDERID) REFERENCES TBL_PROVIDERS(ID)
    )

    CREATE TABLE TBL_DEALS (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        HOTELID INTEGER NOT NULL,
        STARTDATE DATE NOT NULL,
        ENDDATE DATE,
        
        INFO VARCHAR(200),

        PRIMARY KEY (ID),
        FOREIGN KEY (HOTELID) REFERENCES TBL_HOTELS(ID)
    )



    CREATE TABLE TBL_HOTELREVIEWS( 
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        HOTELID INTEGER NOT NULL,
        CUSTID INTEGER NOT NULL,
        INFO VARCHAR(200),
        RATING INTEGER,
        TIME TIMESTAMP NOT NULL,

        CHECK (RATING >= 0),
        CHECK (RATING <= 100),
        
        PRIMARY KEY(ID),
        FOREIGN KEY (HOTELID) REFERENCES TBL_HOTELS(ID),
        FOREIGN KEY (CUSTID) REFERENCES TBL_CUSTOMERS(ID)
    )


    CREATE TABLE TBL_CARTITEMS (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
        USERID INTEGER NOT NULL,
        DEALID INTEGER NOT NULL,

        PRIMARY KEY (ID),
        FOREIGN KEY (USERID) REFERENCES TBL_USERS(ID),
        FOREIGN KEY (DEALID) REFERENCES TBL_DEALS(ID)
    )

    CREATE TABLE TBL_PURCHASES (
        ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 10, INCREMENT BY 1) NOT NULL,
        CUSTID INTEGER NOT NULL,
        DEALID INTEGER NOT NULL,
        
        PRIMARY KEY (ID),
        FOREIGN KEY (DEALID) REFERENCES TBL_DEALS(ID),
        FOREIGN KEY (CUSTID) REFERENCES TBL_CUSTOMERS(ID)
    )