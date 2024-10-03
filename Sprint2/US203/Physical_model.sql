CREATE TABLE Client (
    id_client int NOT NULL PRIMARY KEY,
    name varchar(70) NOT NULL,
    birth_date date NOT NULL,
    phone varchar(15) NOT NULL,
    email varchar(70) NOT NULL,
    adress varchar(150) NOT NULL,
    nif varchar(9) NOT NULL
);

CREATE TABLE Type_refrigeration(
    id_type_refrigeration int NOT NULL PRIMARY KEY,
    type_refrigeration varchar(30) NOT NULL,
    energy int NOT NULL
);

CREATE TABLE Container(
    id_container varchar(13) NOT NULL PRIMARY KEY,
    id_type_refrigeration int NOT NULL,
    iso_code varchar(40) NOT NULL,
    payload int NOT NULL,
    tare int NOT NULL,
    gross int NOT NULL,
    FOREIGN KEY (id_type_refrigeration) REFERENCES Type_refrigeration(id_type_refrigeration)
);

CREATE TABLE Type_vehicle(
    id_type_vehicle int NOT NULL PRIMARY KEY,
    type_vehicle varchar(5) NOT NULL
);

CREATE TABLE Vehicle(
    id_vehicle int NOT NULL PRIMARY KEY,
    id_type_vehicle int NOT NULL,
    FOREIGN KEY (id_type_vehicle) REFERENCES Type_vehicle(id_type_vehicle)
);

CREATE TABLE Truck(
    id_truck int NOT NULL PRIMARY KEY,
    truck varchar(20) NOT NULL,
    id_vehicle int UNIQUE NOT NULL,
    FOREIGN KEY (id_vehicle) REFERENCES Vehicle(id_vehicle)
);

CREATE TABLE Role(
    id_role int NOT NULL PRIMARY KEY,
    role varchar(20) NOT NULL
);

CREATE TABLE Worker(
    id_worker int NOT NULL PRIMARY KEY,
    name varchar(50) NOT NULL,
    id_role int NOT NULL,
    birth_date date NOT NULL,
    email varchar(70) NOT NULL,
    adress varchar(150) NOT NULL,
    phone varchar(15) NOT NULL,
    salary int NOT NULL,
    FOREIGN KEY (id_role) REFERENCES Role(id_role)
);

CREATE TABLE Worker_vehicle(
    id_worker_vehicle int NOT NULL PRIMARY KEY,
    id_worker int NOT NULL,
    worker_start_date date NOT NULL,
    worker_end_date date,
    id_vehicle int NOT NULL,
    FOREIGN KEY (id_vehicle) REFERENCES Vehicle(id_vehicle),
    FOREIGN KEY (id_worker) REFERENCES Worker(id_worker)
);

CREATE TABLE Ship(
    id_mmsi varchar(9) NOT NULL PRIMARY KEY,
    imo varchar(7) NOT NULL,
    n_generator int NOT NULL,
    length int NOT NULL,
    p_generator int NOT NULL,
    width int NOT NULL,
    capacity int NOT NULL,
    ship_name varchar(20) NOT NULL,
    vessel_type int NOT NULL,
    call_sign varchar(9) NOT NULL,
    draft float NOT NULL,
    id_vehicle int UNIQUE NOT NULL,
    FOREIGN KEY (id_vehicle) REFERENCES Vehicle(id_vehicle)
);

CREATE TABLE Transceiver_class(
    id_transceiver_class int NOT NULL PRIMARY KEY,
    transceiver_class varchar(1) NOT NULL
);

CREATE TABLE Ship_dynamic(
    id_dynamic int NOT NULL PRIMARY KEY,
    id_mmsi varchar(9) NOT NULL,
    date_time date NOT NULL,
    lat float NOT NULL,
    lon float NOT NULL,
    sog float NOT NULL,
    cog float NOT NULL,
    heading int NOT NULL,
    id_transceiver_class int NOT NULL,
    FOREIGN KEY (id_mmsi) REFERENCES Ship(id_mmsi),
    FOREIGN KEY (id_transceiver_class) REFERENCES Transceiver_class(id_transceiver_class)
);

CREATE TABLE Continent(
    id_continent int NOT NULL PRIMARY KEY,
    continent varchar(10) NOT NULL
);

CREATE TABLE Country(
    id_country int NOT NULL PRIMARY KEY,
    country varchar(60) NOT NULL,
    id_continent int NOT NULL,
    population int NOT NULL,
    lat float NOT NULL,
    long float NOT NULL,
    alpha_code_2 varchar(2) NOT NULL,
    alpha_code_3 varchar(3) NOT NULL,
    FOREIGN KEY (id_continent) REFERENCES Continent(id_continent)
);

CREATE TABLE Type_manifest(
    id_type_manifest int NOT NULL PRIMARY KEY,
    type_manifest varchar(10) NOT NULL
);

CREATE TABLE Type_facility(
    id_type_facility int NOT NULL PRIMARY KEY,
    type_facility varchar(20) NOT NULL
);

CREATE TABLE Facility(
    id_facility int NOT NULL PRIMARY KEY,
    name varchar(20) NOT NULL,
    lon float NOT NULL,
    lat float NOT NULL,
    id_country int NOT NULL,
    id_type_facility int NOT NULL,
    id_city int NOT NULL,
    FOREIGN KEY (id_country) REFERENCES Country(id_country),
    FOREIGN KEY (id_type_facility) REFERENCES Type_facility(id_type_facility),
    FOREIGN KEY (id_city) REFERENCES City(id_city)
);

CREATE TABLE Worker_facility(
    id_worker_facility int NOT NULL PRIMARY KEY,
    id_worker int NOT NULL,
    id_facility int NOT NULL,
    FOREIGN KEY (id_worker) REFERENCES Worker(id_worker),
    FOREIGN KEY (id_facility) REFERENCES Facility(id_facility)
);

CREATE TABLE Manifest_travel(
    id_manifest_travel int NOT NULL PRIMARY KEY,
    id_departure int NOT NULL,
    id_arrival int NOT NULL,
    id_vehicle int NOT NULL,
    date_manifest date NOT NULL,
    FOREIGN KEY (id_departure) REFERENCES Facility(id_facility),
    FOREIGN KEY (id_arrival) REFERENCES Facility(id_facility),
    FOREIGN KEY (id_vehicle) REFERENCES Vehicle(id_vehicle)
);

CREATE TABLE Manifest_load_unload(
    id_manifest_lu int NOT NULL PRIMARY KEY,
    date_manifest date NOT NULL,
    id_type_manifest int NOT NULL,
    id_facility int NOT NULL,
    id_manifest_travel int NOT NULL,
    FOREIGN KEY (id_type_manifest) REFERENCES Type_manifest(id_type_manifest),
    FOREIGN KEY (id_facility) REFERENCES Facility(id_facility),
    FOREIGN KEY (id_manifest_travel) REFERENCES Manifest_Travel(id_manifest_travel)
);

CREATE TABLE Container_manifest(
    id_container_manifest int NOT NULL PRIMARY KEY,
    id_container varchar(13) NOT NULL,
    id_manifest_lu int NOT NULL,
    position varchar(40) NOT NULL,
    id_client int NOT NULL,
    gross_weight int NOT NULL,
    FOREIGN KEY (id_container) REFERENCES Container(id_container),
    FOREIGN KEY (id_manifest_lu) REFERENCES Manifest_load_unload(id_manifest_lu),
    FOREIGN KEY (id_client) REFERENCES Client(id_client)
);

CREATE TABLE Ship_container(
    id_ship_container int NOT NULL PRIMARY KEY,
    id_vehicle int NOT NULL,
    id_container_manifest int NOT NULL,
    FOREIGN KEY (id_vehicle) REFERENCES Vehicle(id_vehicle),
    FOREIGN KEY (id_container_manifest) REFERENCES Container_manifest(id_container_manifest)
);

CREATE TABLE Facility_container(
    id_facility int NOT NULL,
    id_container_manifest int NOT NULL,
    PRIMARY KEY (id_facility, id_container_manifest),
    FOREIGN KEY (id_facility) REFERENCES Facility(id_facility),
    FOREIGN KEY (id_container_manifest) REFERENCES Container_manifest(id_container_manifest)
);

CREATE TABLE Sea_dist(
    id_facility1 int NOT NULL,
    id_facility2 int NOT NULL,
    sea_dist float NOT NULL,
    PRIMARY KEY (id_facility1, id_facility2),
    FOREIGN KEY (id_facility1) REFERENCES Facility(id_facility),
    FOREIGN KEY (id_facility2) REFERENCES Facility(id_facility)
);

CREATE TABLE Frontier(
    id_country_1 int NOT NULL,
    id_country_2 int NOT NULL,
    PRIMARY KEY (id_country_1, id_country_2),
    FOREIGN KEY (id_country_1) REFERENCES Country(id_country),
    FOREIGN KEY (id_country_2) REFERENCES Country(id_country)
);

CREATE TABLE Operation_type(
    id_type_operation int NOT NULL PRIMARY KEY,
    type_operation varchar(70) NOT NULL
);

CREATE TABLE City(
    id_city int NOT NULL PRIMARY KEY,
    city varchar(40) NOT NULL,
    id_country int NOT NULL,
    capital varchar(40),
    FOREIGN KEY (id_country) REFERENCES Country(id_country)
);