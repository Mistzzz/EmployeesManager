CREATE TABLE DB_DEPARTMENT (
    id     				CHAR(4)      	NOT NULL,
    signature   		VARCHAR(5)		NOT NULL,
	name   				VARCHAR(40)		NOT NULL,
    city_id				INT 			NOT NULL,
    PRIMARY KEY (id),
    UNIQUE  KEY (signature),
    FOREIGN KEY (city_id) REFERENCES DB_CITY (id) ON DELETE CASCADE
);

CREATE TABLE DB_EMPLOYEE (
    id 					INT             		NOT NULL,
    birthDate  			DATE           			NOT NULL,
    firstName  			VARCHAR(30)     		NOT NULL,
    lastName   			VARCHAR(30)     		NOT NULL,
    gender      		ENUM ('MALE','FEMALE')  NOT NULL, 
    hireDate   			DATE            		NOT NULL,
	contactData_id 		INT 							,
    PRIMARY KEY (id),
    KEY (contactData_id),
    FOREIGN KEY (contactData_id) REFERENCES db_contact (id)
);

CREATE TABLE DB_EMPLOYEE_DEPARTMENT (
  employee_id 				INT		NOT NULL,
  department_id 			INT 	NOT NULL,
  PRIMARY KEY (employee_id, department_id),
  KEY (department_id),
  FOREIGN KEY (employee_id) REFERENCES DB_EMPLOYEE (id),
  FOREIGN KEY (department_id) REFERENCES DB_DEPARTMENT (id)
  );

CREATE TABLE DB_TITLE (
    employee_no      	INT          NOT NULL,
    title       		VARCHAR(50)  NOT NULL,
    from_date   		DATE         NOT NULL,
    to_date     		DATE,
    KEY         (employee_no),
    FOREIGN KEY (employee_no) REFERENCES DB_EMPLOYEE (id) ON DELETE CASCADE,
    PRIMARY KEY (employee_no, title, from_date)
);

CREATE TABLE DB_SALARY (
    employee_id      	INT    NOT NULL,
    salary      		INT    NOT NULL,
    date_from   		DATE   NOT NULL,
    date_to     		DATE   NOT NULL,
    PRIMARY KEY         (id),
    KEY (employee_id),
    FOREIGN KEY (employee_id) REFERENCES DB_EMPLOYEE (id) ON DELETE CASCADE,
    PRIMARY KEY (employee_id, from_date)
);

-- =======================================================================================
-- =======================================================================================
CREATE TABLE DB_COUNTRY (
	id 				INT 			NOT NULL,
    name 			VARCHAR(50) 	NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
);

CREATE TABLE DB_CITY (
	id 				INT 			NOT NULL,
    name			VARCHAR(50)		NOT NULL,
    id_country 		INT				NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name),
    FOREIGN KEY (id_country) REFERENCES DB_COUNTRY (id) ON DELETE CASCADE
);

CREATE TABLE DB_EMAIL (
	id					INT				NOT NULL,
    value				VARCHAR(50)		NOT NULL,
    type				VARCHAR(50)		NOT NULL,
    id_contact			INT				NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (value, type),    
    FOREIGN KEY (contact_id) REFERENCES DB_CONTACT (id)
);

CREATE TABLE DB_PHONE (
	id					INT				NOT NULL,
    value				BIGINT			NOT NULL,
    type				VARCHAR(50)		NOT NULL,
    id_contact			INT 			NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (value, type),
    FOREIGN KEY (contact_id) REFERENCES DB_CONTACT (id)
);

CREATE TABLE DB_CONTACT (
	id 					INT 			NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE DB_ADDRESS (
    id      			INT   			NOT NULL,
    type				VARCHAR(50) 	NOT NULL,
    contact_id			INT				NOT NULL,
    line1	      		VARCHAR(50)    	NOT NULL,
    line2           	varchar(50) 	DEFAULT NULL,
    city_id				INT			   	NOT NULL,
    zipCode     		VARCHAR(50)   	NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (type, contact_id),
    FOREIGN KEY (contact_id) REFERENCES DB_CONTACT (id) ON DELETE CASCADE,
    FOREIGN KEY (city_id) REFERENCES DB_CITY (id) ON DELETE CASCADE
);
