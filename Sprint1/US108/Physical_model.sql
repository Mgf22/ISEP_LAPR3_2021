CREATE TABLE Client (
    id_client int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(70) NOT NULL,
    birth_date date NOT NULL,
    phone varchar(15) NOT NULL,
    email varchar(70) NOT NULL,
    adress varchar(150) NOT NULL,
    nif varchar(9) NOT NULL
);

CREATE TABLE Container(
    id_container varchar(13) NOT NULL PRIMARY KEY,
    iso_code varchar(40) NOT NULL,
    refrigeration boolean NOT NULL,
    temperature int,
    payload int NOT NULL,
    tare int NOT NULL,
    gross int NOT NULL
);

CREATE TABLE Truck(
    id_truck int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    truck varchar(20) NOT NULL
);

CREATE TABLE Role(
    id_role int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role varchar(20) NOT NULL
);

CREATE TABLE Worker(
    id_worker int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    id_role int NOT NULL,
    birth_date date NOT NULL,
    email varchar(70) NOT NULL,
    adress varchar(150) NOT NULL,
    phone varchar(15) NOT NULL,
    salary int NOT NULL,
    FOREIGN KEY (id_role) REFERENCES Role(id_role)
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
    draft int NOT NULL
);

CREATE TABLE Ship_dynamic(
    id_dynamic int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_mmsi varchar(9) NOT NULL,
    date_time datetime NOT NULL,
    lat int NOT NULL,
    lon int NOT NULL,
    sog int NOT NULL,
    cog int NOT NULL,
    heading int NOT NULL,
    transceiver_class varchar(1) NOT NULL,
    FOREIGN KEY (id_mmsi) REFERENCES Ship(id_mmsi)
);

CREATE TABLE Ship_worker(
    id_ship_worker int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_mmsi varchar(9) NOT NULL,
    id_worker int NOT NULL,
    FOREIGN KEY (id_mmsi) REFERENCES Ship(id_mmsi),
    FOREIGN KEY (id_worker) REFERENCES Worker(id_worker)
);

CREATE TABLE Continent(
    id_continent int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    continent varchar(10)
);

CREATE TABLE Country(
    id_country int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country varchar(60)
);

CREATE TABLE Port_ware(
    id_port_ware int NOT NULL PRIMARY KEY,
    name varchar(20) NOT NULL,
    long int NOT NULL,
    lat int NOT NULL,
    id_continent int NOT NULL,
    id_country int NOT NULL,
    FOREIGN KEY (id_continent) REFERENCES Continent(id_continent),
    FOREIGN KEY (id_country) REFERENCES Country(id_country)
);

CREATE TABLE Worker_port_ware(
    id_worker_port_ware int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_worker int NOT NULL,
    id_portWare int NOT NULL,
    FOREIGN KEY (id_worker) REFERENCES Worker(id_worker),
    FOREIGN KEY (id_portWare) REFERENCES Port_Ware(id_port_ware)
);

CREATE TABLE Truck_manifest(
    id_truck_manifest int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_truck int NOT NULL,
    id_container varchar(13) NOT NULL,
    date datetime NOT NULL,
    gross_weight int NOT NULL,
    id_worker int NOT NULL,
    FOREIGN KEY (id_worker) REFERENCES Worker(id_worker),
    FOREIGN KEY (id_truck) REFERENCES Truck(id_truck),
    FOREIGN KEY (id_container) REFERENCES Container(id_container)
);

CREATE TABLE Ship_manifest(
    id_ship_manifest int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_mmsi varchar(9) NOT NULL,
    date datetime NOT NULL,
    gross_weight int NOT NULL,
    FOREIGN KEY (id_mmsi) REFERENCES Ship(id_mmsi)
);

CREATE TABLE Ship_manifest_cont(
    id_manifest_cont int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_container int NOT NULL,
    id_ship_manifest int NOT NULL,
    position int NOT NULL,
    id_client int NOT NULL,
    FOREIGN KEY (id_container) REFERENCES Container(id_container),
    FOREIGN KEY (id_ship_manifest) REFERENCES Ship_manifest(id_ship_manifest),
    FOREIGN KEY (id_client) REFERENCES Client(id_client)
);

CREATE TABLE Travel(
    id_travel int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_truck_manifest int NULL,
    id_ship_manifest int NULL,
    id_departure int NOT NULL,
    id_arrival int NOT NULL,
    FOREIGN KEY (id_truck_manifest) REFERENCES Truck_manifest(id_truck_manifest),
    FOREIGN KEY (id_ship_manifest) REFERENCES Ship_manifest(id_ship_manifest),
    FOREIGN KEY (id_departure) REFERENCES Port_Ware(id_port_ware),
    FOREIGN KEY (id_arrival) REFERENCES Port_Ware(id_port_ware),
    constraint CK_one_or_other check ((id_truck_manifest is null or id_ship_manifest is null) and not (id_truck_manifest is null and id_ship_manifest is null))
);