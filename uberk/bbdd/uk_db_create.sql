-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-13 22:25:17.921

-- tables
-- Table: uk_availability
CREATE TABLE uk_availability (
    availability_id int  NOT NULL,
    car_id int  NOT NULL,
    driver_id int  NOT NULL,
    car_coordinate_id int  NOT NULL,
    travel_status_id int  NULL,
    start_time varchar(45)  NOT NULL,
    end_time varchar(45)  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_availability_pk PRIMARY KEY (availability_id)
);

-- Table: uk_car
CREATE TABLE uk_car (
    car_id serial  NOT NULL,
    type_car_id int  NOT NULL,
    brand_car varchar(100)  NOT NULL,
    car_model varchar(200)  NOT NULL,
    car_registration varchar(100)  NOT NULL,
    soat boolean  NOT NULL,
    ruat boolean  NOT NULL,
    inspection boolean  NOT NULL,
    year_car varchar(45)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_car_pk PRIMARY KEY (car_id)
);

-- Table: uk_car_coordinate
CREATE TABLE uk_car_coordinate (
    car_coordinate_id serial  NOT NULL,
    length decimal(15,10)  NOT NULL,
    latitude decimal(15,10)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_coordinate_pk PRIMARY KEY (car_coordinate_id)
);

-- Table: uk_credit_card
CREATE TABLE uk_credit_card (
    credit_card_id serial  NOT NULL,
    user_id int  NOT NULL,
    date varchar(45)  NOT NULL,
    number_card varchar(45)  NOT NULL,
    country varchar(200)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_credit_card_pk PRIMARY KEY (credit_card_id)
);

-- Table: uk_destiny_coordinate
CREATE TABLE uk_destiny_coordinate (
    destiny_coordinate_id serial  NOT NULL,
    length decimal(15,10)  NOT NULL,
    latitude decimal(15,10)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_coordinate_pk PRIMARY KEY (destiny_coordinate_id)
);

-- Table: uk_driver
CREATE TABLE uk_driver (
    driver_id serial  NOT NULL,
    name_driver varchar(200)  NOT NULL,
    last_name_driver varchar(200)  NOT NULL,
    phone_driver varchar(30)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_driver_pk PRIMARY KEY (driver_id)
);

-- Table: uk_group
CREATE TABLE uk_group (
    group_id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_group_pk PRIMARY KEY (group_id)
);

-- Table: uk_group_user
CREATE TABLE uk_group_user (
    group_user_id serial  NOT NULL,
    user_id int  NOT NULL,
    group_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_group_user_pk PRIMARY KEY (group_user_id)
);

-- Table: uk_h_availability
CREATE TABLE uk_h_availability (
    h_availability_id serial  NOT NULL,
    availability_id serial  NOT NULL,
    start_time varchar(45)  NOT NULL,
    end_time varchar(45)  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_availability_pk PRIMARY KEY (h_availability_id)
);

-- Table: uk_h_car
CREATE TABLE uk_h_car (
    h_car_id serial  NOT NULL,
    car_id serial  NOT NULL,
    brand_car varchar(100)  NOT NULL,
    car_model varchar(200)  NOT NULL,
    car_resgitration varchar(100)  NOT NULL,
    soat boolean  NOT NULL,
    ruat boolean  NOT NULL,
    inspection boolean  NOT NULL,
    year varchar(45)  NOT NULL,
    availability boolean  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_car_pk PRIMARY KEY (h_car_id)
);

-- Table: uk_h_car_coordinate
CREATE TABLE uk_h_car_coordinate (
    h_car_coordinate_id serial  NOT NULL,
    car_coordinate_id serial  NOT NULL,
    length decimal(15,10)  NOT NULL,
    latitude decimal(15,10)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_coordinate_pk PRIMARY KEY (h_car_coordinate_id)
);

-- Table: uk_h_credit_card
CREATE TABLE uk_h_credit_card (
    h_credit_card_id serial  NOT NULL,
    credit_card_id serial  NOT NULL,
    date varchar(45)  NOT NULL,
    number_card varchar(45)  NOT NULL,
    country varchar(200)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_credit_card_pk PRIMARY KEY (h_credit_card_id)
);

-- Table: uk_h_destiny_coordinate
CREATE TABLE uk_h_destiny_coordinate (
    h_destiny_coordinate_id serial  NOT NULL,
    destiny_coordinate_id serial  NOT NULL,
    length decimal(15,10)  NOT NULL,
    latitude decimal(15,10)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_coordinate_pk PRIMARY KEY (h_destiny_coordinate_id)
);

-- Table: uk_h_driver
CREATE TABLE uk_h_driver (
    h_driver_id serial  NOT NULL,
    driver_id serial  NOT NULL,
    name_driver varchar(200)  NOT NULL,
    last_name_driver varchar(200)  NOT NULL,
    phone_driver varchar(30)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_driver_pk PRIMARY KEY (h_driver_id)
);

-- Table: uk_h_group
CREATE TABLE uk_h_group (
    h_group_id serial  NOT NULL,
    group_id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_group_pk PRIMARY KEY (h_group_id)
);

-- Table: uk_h_group_user
CREATE TABLE uk_h_group_user (
    h_group_user_id serial  NOT NULL,
    group_user_id serial  NOT NULL,
    user_id int  NOT NULL,
    group_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_group_user_pk PRIMARY KEY (h_group_user_id)
);

-- Table: uk_h_origin_coordinate
CREATE TABLE uk_h_origin_coordinate (
    h_origin_coordinate_id serial  NOT NULL,
    origin_coordinate_id serial  NOT NULL,
    length decimal(15,10)  NOT NULL,
    latitude decimal(15,10)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_coordinate_pk PRIMARY KEY (h_origin_coordinate_id)
);

-- Table: uk_h_role
CREATE TABLE uk_h_role (
    h_role_id serial  NOT NULL,
    role_id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_role_pk PRIMARY KEY (h_role_id)
);

-- Table: uk_h_role_group
CREATE TABLE uk_h_role_group (
    h_role_group_id serial  NOT NULL,
    role_group_id serial  NOT NULL,
    group_id int  NOT NULL,
    role_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_role_group_pk PRIMARY KEY (h_role_group_id)
);

-- Table: uk_h_travel
CREATE TABLE uk_h_travel (
    h_travel_id serial  NOT NULL,
    travel_id serial  NOT NULL,
    start_time varchar(45)  NOT NULL,
    end_time varchar(45)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_travel_pk PRIMARY KEY (h_travel_id)
);

-- Table: uk_h_travel_detail
CREATE TABLE uk_h_travel_detail (
    h_travel_detail_id serial  NOT NULL,
    travel_detail_id serial  NOT NULL,
    travel_id int  NOT NULL,
    unit_price decimal(15,5)  NOT NULL,
    quantity int  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_travel_detail_pk PRIMARY KEY (h_travel_detail_id)
);

-- Table: uk_h_travel_status
CREATE TABLE uk_h_travel_status (
    h_travel_status_id serial  NOT NULL,
    travel_status_id serial  NOT NULL,
    travel_status_name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_travel_status_pk PRIMARY KEY (h_travel_status_id)
);

-- Table: uk_h_type_car
CREATE TABLE uk_h_type_car (
    h_type_car_id serial  NOT NULL,
    type_car_id serial  NOT NULL,
    type_car_name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_type_car_pk PRIMARY KEY (h_type_car_id)
);

-- Table: uk_h_type_pay
CREATE TABLE uk_h_type_pay (
    h_type_pay_id serial  NOT NULL,
    type_pay_id serial  NOT NULL,
    type_pay_name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_h_type_pay_pk PRIMARY KEY (h_type_pay_id)
);

-- Table: uk_h_user
CREATE TABLE uk_h_user (
    h_user_id serial  NOT NULL,
    user_id serial  NOT NULL,
    user_name varchar(100)  NOT NULL,
    name varchar(200)  NOT NULL,
    last_name varchar(200)  NOT NULL,
    password varchar(100)  NOT NULL,
    email varchar(200)  NOT NULL,
    phone varchar(30)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT idUser PRIMARY KEY (h_user_id)
);

-- Table: uk_origin_coordinate
CREATE TABLE uk_origin_coordinate (
    origin_coordinate_id serial  NOT NULL,
    length decimal(15,10)  NOT NULL,
    latitude decimal(15,10)  NOT NULL,
    status_coordinate boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_coordinate_pk PRIMARY KEY (origin_coordinate_id)
);

-- Table: uk_role
CREATE TABLE uk_role (
    role_id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_role_pk PRIMARY KEY (role_id)
);

-- Table: uk_role_group
CREATE TABLE uk_role_group (
    role_group_id serial  NOT NULL,
    group_id int  NOT NULL,
    role_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_role_group_pk PRIMARY KEY (role_group_id)
);

-- Table: uk_travel
CREATE TABLE uk_travel (
    travel_id serial  NOT NULL,
    user_id int  NOT NULL,
    origin_coordinate_id int  NOT NULL,
    destiny_coordinate_id int  NOT NULL,
    type_pay_id int  NULL,
    travel_status_travel_status_id int  NULL,
    start_time varchar(45)  NOT NULL,
    end_time varchar(45)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL
);

-- Table: uk_travel_detail
CREATE TABLE uk_travel_detail (
    travel_detail_id serial  NOT NULL,
    unit_price decimal(15,5)  NOT NULL,
    quantity int  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL
);

-- Table: uk_travel_status
CREATE TABLE uk_travel_status (
    travel_status_id serial  NOT NULL,
    travel_status_name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL
);

-- Table: uk_type_car
CREATE TABLE uk_type_car (
    type_car_id serial  NOT NULL,
    type_car_name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_type_car_pk PRIMARY KEY (type_car_id)
);

-- Table: uk_type_pay
CREATE TABLE uk_type_pay (
    type_pay_id serial  NOT NULL,
    type_pay_name varchar(100)  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_type_pay_pk PRIMARY KEY (type_pay_id)
);

-- Table: uk_user
CREATE TABLE uk_user (
    user_id serial  NOT NULL,
    user_name varchar(100)  NOT NULL,
    name varchar(200)  NOT NULL,
    last_name varchar(200)  NOT NULL,
    password varchar(100)  NOT NULL,
    email varchar(200)  NOT NULL,
    phone varchar(30)  NOT NULL,
    status boolean  NOT NULL,
    tx_date timestamp  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(400)  NOT NULL,
    CONSTRAINT uk_user_pk PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: uk_availability_uk_car (table: uk_availability)
ALTER TABLE uk_availability ADD CONSTRAINT uk_availability_uk_car
    FOREIGN KEY (car_id)
    REFERENCES uk_car (car_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_availability_uk_car_coordinate (table: uk_availability)
ALTER TABLE uk_availability ADD CONSTRAINT uk_availability_uk_car_coordinate
    FOREIGN KEY (car_coordinate_id)
    REFERENCES uk_car_coordinate (car_coordinate_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_availability_uk_driver (table: uk_availability)
ALTER TABLE uk_availability ADD CONSTRAINT uk_availability_uk_driver
    FOREIGN KEY (driver_id)
    REFERENCES uk_driver (driver_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_availability_uk_travel_status (table: uk_availability)
ALTER TABLE uk_availability ADD CONSTRAINT uk_availability_uk_travel_status
    FOREIGN KEY (travel_status_id)
    REFERENCES uk_travel_status (travel_status_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_car_uk_type_car (table: uk_car)
ALTER TABLE uk_car ADD CONSTRAINT uk_car_uk_type_car
    FOREIGN KEY (type_car_id)
    REFERENCES uk_type_car (type_car_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_credit_card_uk_user (table: uk_credit_card)
ALTER TABLE uk_credit_card ADD CONSTRAINT uk_credit_card_uk_user
    FOREIGN KEY (user_id)
    REFERENCES uk_user (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_group_user_uk_group (table: uk_group_user)
ALTER TABLE uk_group_user ADD CONSTRAINT uk_group_user_uk_group
    FOREIGN KEY (group_id)
    REFERENCES uk_group (group_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_group_user_uk_user (table: uk_group_user)
ALTER TABLE uk_group_user ADD CONSTRAINT uk_group_user_uk_user
    FOREIGN KEY (user_id)
    REFERENCES uk_user (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_role_group_uk_group (table: uk_role_group)
ALTER TABLE uk_role_group ADD CONSTRAINT uk_role_group_uk_group
    FOREIGN KEY (group_id)
    REFERENCES uk_group (group_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_role_group_uk_role (table: uk_role_group)
ALTER TABLE uk_role_group ADD CONSTRAINT uk_role_group_uk_role
    FOREIGN KEY (role_id)
    REFERENCES uk_role (role_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_travel_detail_uk_travel (table: uk_travel_detail)
ALTER TABLE uk_travel_detail ADD CONSTRAINT uk_travel_detail_uk_travel
    FOREIGN KEY (uk_travel_travel_id)
    REFERENCES uk_travel (travel_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_travel_uk_destiny_coordinate (table: uk_travel)
ALTER TABLE uk_travel ADD CONSTRAINT uk_travel_uk_destiny_coordinate
    FOREIGN KEY (destiny_coordinate_id)
    REFERENCES uk_destiny_coordinate (destiny_coordinate_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_travel_uk_origin_coordinate (table: uk_travel)
ALTER TABLE uk_travel ADD CONSTRAINT uk_travel_uk_origin_coordinate
    FOREIGN KEY (origin_coordinate_id)
    REFERENCES uk_origin_coordinate (origin_coordinate_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_travel_uk_travel_status (table: uk_travel)
ALTER TABLE uk_travel ADD CONSTRAINT uk_travel_uk_travel_status
    FOREIGN KEY (travel_status_travel_status_id)
    REFERENCES uk_travel_status (travel_status_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_travel_uk_type_pay (table: uk_travel)
ALTER TABLE uk_travel ADD CONSTRAINT uk_travel_uk_type_pay
    FOREIGN KEY (type_pay_id)
    REFERENCES uk_type_pay (type_pay_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: uk_travel_uk_user (table: uk_travel)
ALTER TABLE uk_travel ADD CONSTRAINT uk_travel_uk_user
    FOREIGN KEY (user_id)
    REFERENCES uk_user (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

