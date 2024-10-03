INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (1,'Artur Dias',TO_DATE('16/01/1989', 'DD/MM/YYYY'),'915788423','arturdias@gmail.com','R.Dr.Antonio Bernardino de Almeida','123456789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (2,'Afonso Dias',TO_DATE('11/02/1992', 'DD/MM/YYYY'),'935624987','afonsodias@gmail.com','R.Dr.Antonio Bernardino de Almeida','123445789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (3,'Jorge Dias',TO_DATE('19/04/1974', 'DD/MM/YYYY'),'965789423','jorgedias@gmail.com','R.Dr.Antonio Bernardino de Almeida','126856789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (4,'Igor Fernandes',TO_DATE('18/11/1962', 'DD/MM/YYYY'),'9345983265','igor@gmail.com','R.Dr.Antonio Bernardino de Almeida','123456799');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (5,'Igor Fernandes',TO_DATE('07/06/1989', 'DD/MM/YYYY'),'921957684','joaquim@gmail.com','R.Dr.Antonio Bernardino de Almeida','133456789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (6,'Alvaro Martins',TO_DATE('06/05/1999', 'DD/MM/YYYY'),'962597845','alvaromartins@gmail.com','R.Dr.Antonio Bernardino de Almeida','123455789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (7,'Jorge Soares',TO_DATE('20/01/1975', 'DD/MM/YYYY'),'925789423','jorges@gmail.com','R.Dr.Antonio Bernardino de Almeida','123458789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (8,'Angelo Soares',TO_DATE('15/09/1984', 'DD/MM/YYYY'),'961532469','anges@gmail.com','R.Dr.Antonio Bernardino de Almeida','125756789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (9,'Cesar Couto',TO_DATE('16/07/1998', 'DD/MM/YYYY'),'931649875','cesar@outloook.pt','R.Dr.Antonio Bernardino de Almeida','128556789');
INSERT INTO Client (id_client,name,birth_date,phone,email,adress,nif) VALUES (10,'Joao Marques',TO_DATE('17/08/1960', 'DD/MM/YYYY'),'969874531','joao@sapo.pt','R.Dr.Antonio Bernardino de Almeida','123966789');

INSERT INTO Type_refrigeration (id_type_refrigeration,type_refrigeration,energy) VALUES (1,'interior temperature of 7?C',1);
INSERT INTO Type_refrigeration (id_type_refrigeration,type_refrigeration,energy) VALUES (2,'interior temperature of -5?C',1);

INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('BICJ5697847',1,'20G0',2000,6000,8000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('BJKJ5697847',2,'20H1',2500,5500,8000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('BIYT9897847',2,'22U0',7000,6000,13000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('POLK3597847',1,'22U1',3000,6000,9000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('NHJK3127847',1,'20G0',2000,2000,4000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('HJIU5670247',2,'42R0',1000,9000,10000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('ADER8756457',1,'48P0',2000,6000,8000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('BUYTJ349584',1,'42B0',3500,1000,4500);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('POPCJ987847',2,'42P3',8700,2300,11000);
INSERT INTO Container (id_container,id_type_refrigeration,iso_code,payload,tare,gross) VALUES ('IJCJ8757847',2,'26T0',2500,6500,9000);

INSERT INTO Type_vehicle (id_type_vehicle,type_vehicle) VALUES (1,'Truck');
INSERT INTO Type_vehicle (id_type_vehicle,type_vehicle) VALUES (2,'Ship');

INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (1,1);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (2,2);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (3,2);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (4,1);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (5,2);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (6,2);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (7,1);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (8,1);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (9,1);
INSERT INTO Vehicle (id_vehicle,id_type_vehicle) VALUES (10,2);

INSERT INTO Truck (id_truck,truck,id_vehicle) VALUES (1,'29-AP-54',1);
INSERT INTO Truck (id_truck,truck,id_vehicle) VALUES (2,'OZ-02-87',4);
INSERT INTO Truck (id_truck,truck,id_vehicle) VALUES (3,'27-KL-64',7);
INSERT INTO Truck (id_truck,truck,id_vehicle) VALUES (4,'65-87-RE',8);
INSERT INTO Truck (id_truck,truck,id_vehicle) VALUES (5,'17-XI-76',9);

INSERT INTO Role (id_role,role) VALUES (1,'Warehouse staff');
INSERT INTO Role (id_role,role) VALUES (2,'Truck driver');
INSERT INTO Role (id_role,role) VALUES (3,'Port manager');
INSERT INTO Role (id_role,role) VALUES (4,'Port staff');
INSERT INTO Role (id_role,role) VALUES (5,'Fleet manager');
INSERT INTO Role (id_role,role) VALUES (6,'Ship chief elen');
INSERT INTO Role (id_role,role) VALUES (7,'Ship captain');
INSERT INTO Role (id_role,role) VALUES (8,'Warehouse manager');
INSERT INTO Role (id_role,role) VALUES (9,'Traffic manager');

INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (1,'Sandra Dias',1,TO_DATE('16/01/1989', 'DD/MM/YYYY'),'sd@gmail.com','Pra?a dos Le?es','961567458',660);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (2,'Alexandre Santos',2,TO_DATE('02/01/1975', 'DD/MM/YYYY'),'as@gmail.com','Rua da Boavista','913667875',660);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (3,'Faria Alex',3,TO_DATE('08/07/1998', 'DD/MM/YYYY'),'fa@gmail.com','Travessa D.Jo?o','925467458',2000);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (4,'Thibault Sedita',4,TO_DATE('02/01/1967', 'DD/MM/YYYY'),'td@gmail.com','Largo da Liberdade','922274589',660);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (5,'Florian Fernandes',5,TO_DATE('19/07/1987', 'DD/MM/YYYY'),'ff@gmail.com','Rua das Cruzes','919763458',3000);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (6,'Pedro Guterres',6,TO_DATE('23/12/1973', 'DD/MM/YYYY'),'pg@gmail.com','Rua Almeida','913549858',1500);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (7,'Carlos Diogo',7,TO_DATE('17/11/1959', 'DD/MM/YYYY'),'cd@gmail.com','Travessa das Moscas','926587458',1000);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (8,'Pedro Guerra',8,TO_DATE('27/08/1960', 'DD/MM/YYYY'),'pguerra@gmail.com','Largo do Bolh?o','911867458',2500);
INSERT INTO Worker (id_worker,name,id_role,birth_date,email,adress,phone,salary) VALUES (9,'Beatriz Carla',9,TO_DATE('19/07/1992', 'DD/MM/YYYY'),'bc@gmail.com','Rua das Quinas','926567458',2600);

INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (1,1,TO_DATE('16/01/2013', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),1);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (2,2,TO_DATE('07/02/2020', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),2);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (3,3,TO_DATE('17/03/2014', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),3);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (4,4,TO_DATE('19/04/2007', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),4);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (5,5,TO_DATE('22/05/2013', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),5);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (6,6,TO_DATE('13/06/2018', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),6);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (7,7,TO_DATE('01/08/2019', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),7);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (8,8,TO_DATE('15/07/2020', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),8);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (9,9,TO_DATE('16/09/2015', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),9);
INSERT INTO Worker_vehicle (id_worker_vehicle,id_worker,worker_start_date,worker_end_date,id_vehicle) VALUES (10,1,TO_DATE('04/05/2016', 'DD/MM/YYYY'),TO_DATE('31/12/2022', 'DD/MM/YYYY'),10);

INSERT INTO Ship (id_mmsi,imo,n_generator,length,p_generator,width,capacity,ship_name,vessel_type,call_sign,draft,id_vehicle) VALUES ('211331640','9193305',2,294,1400,32,70,'Golden Mary',70,'DHBN',13.6,2);
INSERT INTO Ship (id_mmsi,imo,n_generator,length,p_generator,width,capacity,ship_name,vessel_type,call_sign,draft,id_vehicle) VALUES ('255806169','9465095',3,333,1000,43,71,'Black Pearl',71,'CQAG7',-12.6,3);
INSERT INTO Ship (id_mmsi,imo,n_generator,length,p_generator,width,capacity,ship_name,vessel_type,call_sign,draft,id_vehicle) VALUES ('255806194','9241475',2,207,1500,30,71,'Jolly Roger',71,'CQAJ8',9,5);
INSERT INTO Ship (id_mmsi,imo,n_generator,length,p_generator,width,capacity,ship_name,vessel_type,call_sign,draft,id_vehicle) VALUES ('366929710','5076949',2,104,2000,22,71,'Ranger',60,'WM4599',8,6);
INSERT INTO Ship (id_mmsi,imo,n_generator,length,p_generator,width,capacity,ship_name,vessel_type,call_sign,draft,id_vehicle) VALUES ('636092932','9225641',2,299,1750,40,79,'Adventure Galley',79,'D5VK6',8,10);

INSERT INTO Transceiver_class (id_transceiver_class,transceiver_class) VALUES (1,'A');
INSERT INTO Transceiver_class (id_transceiver_class,transceiver_class) VALUES (2,'B');

INSERT INTO Ship_dynamic (id_dynamic,id_mmsi,date_time,lat,lon,sog,cog,heading,id_transceiver_class) VALUES (1,'211331640',TO_DATE('15/07/2020', 'DD/MM/YYYY'),36.39094,-122.71335,19.7,145.5,147,1);
INSERT INTO Ship_dynamic (id_dynamic,id_mmsi,date_time,lat,lon,sog,cog,heading,id_transceiver_class) VALUES (2,'255806169',TO_DATE('20/12/2021', 'DD/MM/YYYY'),36.39094,-122.71335,19.7,145.5,147,1);
INSERT INTO Ship_dynamic (id_dynamic,id_mmsi,date_time,lat,lon,sog,cog,heading,id_transceiver_class) VALUES (3,'255806194',TO_DATE('06/12/2021', 'DD/MM/YYYY'),36.39094,-122.71335,19.7,145.5,147,1);
INSERT INTO Ship_dynamic (id_dynamic,id_mmsi,date_time,lat,lon,sog,cog,heading,id_transceiver_class) VALUES (4,'366929710',TO_DATE('20/12/2021', 'DD/MM/YYYY'),36.39094,-122.7133,19.7,145.5,147,1);
INSERT INTO Ship_dynamic (id_dynamic,id_mmsi,date_time,lat,lon,sog,cog,heading,id_transceiver_class) VALUES (5,'636092932',TO_DATE('20/12/2021', 'DD/MM/YYYY'),36.39094,-122.71335,19.7,145.5,147,1);

INSERT INTO Continent (id_continent,continent) VALUES (1,'Antartica');
INSERT INTO Continent (id_continent,continent) VALUES (2,'Asia');
INSERT INTO Continent (id_continent,continent) VALUES (3,'Europe');
INSERT INTO Continent (id_continent,continent) VALUES (4,'America');
INSERT INTO Continent (id_continent,continent) VALUES (5,'Africa');
INSERT INTO Continent (id_continent,continent) VALUES (6,'Oceania');

INSERT INTO Country (id_country,country,id_continent) VALUES (1,'Japan',2);
INSERT INTO Country (id_country,country,id_continent) VALUES (2,'Portugal',3);
INSERT INTO Country (id_country,country,id_continent) VALUES (3,'Brazil',4);
INSERT INTO Country (id_country,country,id_continent) VALUES (4,'Angola',5);
INSERT INTO Country (id_country,country,id_continent) VALUES (5,'Australia',6);
INSERT INTO Load_unload (id_load_unload,load_unload) VALUES (1,'Load');
INSERT INTO Load_unload (id_load_unload,load_unload) VALUES (2,'Unload');

INSERT INTO Port_or_ware (id_port_or_ware,port_ware) VALUES (1,'Port');
INSERT INTO Port_or_ware (id_port_or_ware,port_ware) VALUES (2,'Warehouse');

INSERT INTO Port_ware (id_port_ware,name,lat,lon,id_country,id_port_or_ware) VALUES (1,'Leix�es Port',36.39094,-122.71335,2,1);
INSERT INTO Port_ware (id_port_ware,name,lat,lon,id_country,id_port_or_ware) VALUES (2,'Luanda Warehouse',26.52601,-78.76733,4,2);
INSERT INTO Port_ware (id_port_ware,name,lat,lon,id_country,id_port_or_ware) VALUES (3,'Matosinhos Port',40.03473,-73.84087,2,1);
INSERT INTO Port_ware (id_port_ware,name,lat,lon,id_country,id_port_or_ware) VALUES (4,'Sydney Warehouse',36.42886,-122.66037,5,2);

INSERT INTO Worker_port_ware (id_worker_port_ware,id_worker,id_port_ware) VALUES (1,1,2);
INSERT INTO Worker_port_ware (id_worker_port_ware,id_worker,id_port_ware) VALUES (2,3,1);
INSERT INTO Worker_port_ware (id_worker_port_ware,id_worker,id_port_ware) VALUES (3,4,1);
INSERT INTO Worker_port_ware (id_worker_port_ware,id_worker,id_port_ware) VALUES (4,8,2);

INSERT INTO Manifest_travel (id_manifest_travel,id_departure,id_arrival,id_vehicle,date_manifest_tr) VALUES (1,1,3,1,TO_DATE('01/12/2021', 'DD/MM/YYYY'));
INSERT INTO Manifest_travel (id_manifest_travel,id_departure,id_arrival,id_vehicle,date_manifest_tr) VALUES (2,2,4,2,TO_DATE('22/11/2021', 'DD/MM/YYYY'));

INSERT INTO Manifest_lu (id_manifest_lu,date_manifest,id_load_unload,id_port_ware,id_manifest_travel) VALUES (1,TO_DATE('22/11/2021', 'DD/MM/YYYY'),1,3,1);
INSERT INTO Manifest_lu (id_manifest_lu,date_manifest,id_load_unload,id_port_ware,id_manifest_travel) VALUES (2,TO_DATE('01/12/2021', 'DD/MM/YYYY'),2,4,2);
INSERT INTO Manifest_lu (id_manifest_lu,date_manifest,id_load_unload,id_port_ware,id_manifest_travel) VALUES (3,TO_DATE('19/12/2021', 'DD/MM/YYYY'),2,4,1);

INSERT INTO Manifest_cont (id_manifest_cont,id_container,id_manifest_lu,position,id_client,gross_weight) VALUES (1,'BICJ5697847',1,2,1,8000);
INSERT INTO Manifest_cont (id_manifest_cont,id_container,id_manifest_lu,position,id_client,gross_weight) VALUES (2,'POLK3597847',2,6,10,9000);

INSERT INTO Ship_container (id_ship_container,id_vehicle,id_manifest_cont) VALUES (1,2,1);
INSERT INTO Ship_container (id_ship_container,id_vehicle,id_manifest_cont) VALUES (2,2,2);