drop database tenderplus;
create database if not exists tenderplus;
use tenderplus;

create table if not exists role(
	role_id int auto_increment primary key,
	naziv varchar(50) not null unique
);


INSERT INTO role (naziv) VALUES ('Menadzer'), ('Serviser');


create table if not exists login_zaposleni(
    login_zaposleni_id int auto_increment primary key,
	username varchar(50) not null unique,
    password varchar(50) not null,
	role_id int not null,
	foreign key(role_id) REFERENCES role(role_id)
);

INSERT INTO login_zaposleni (username, password, role_id)
 VALUES ('miljana', '123456', '1'),
 ('jovan', '123456', '2'),
 ('aleksandar', '123456', '2'),
 ('milan', '123456','2'),
 ('ana','123456','1');



create table if not exists zaposleni(
	zaposleni_id int auto_increment primary key,
	ime varchar(50) not null,
	prezime varchar(50) not null,
	email varchar(50) not null unique,
	adresa varchar(50) not null,
	telefon varchar(50) not null,
	login_zaposleni_id int not null,
    foreign key(login_zaposleni_id) REFERENCES login_zaposleni(login_zaposleni_id)
);
INSERT INTO zaposleni (ime, prezime, email,adresa,telefon,login_zaposleni_id)
 VALUES ( 'Miljana', 'Stamenkovic', 'miljana@gmail.com', 'Sremska 25', '064653256','1'),
 ( 'Jovan', 'Jovanovic', 'jovan@gmail.com', 'Radnicka 67', '06041254123','2'),
 ( 'Aleksandar', 'Nikic', 'aleks@gmail.com', 'Ustanicka 12', '0642514522','3'),
 ( 'Milan', 'Petrovic', 'milan@gmail.com', 'Sokolska 67', '0605443253','4'),
 ( 'Ana', 'Manic', 'ana@gmail.com', 'Redarska 67', '0604758762','5');
 
 create table if not exists serviseri(
	serviseri_id int auto_increment primary key,
	broj_licence varchar(30) unique,
	vazi_do date,
	zaposleni_id int not null,
	foreign key(zaposleni_id) references zaposleni(zaposleni_id)
 
 );
 INSERT INTO serviseri (broj_licence, vazi_do,zaposleni_id) VALUES
 ('86423456/17','2019-10-21', '2'),
  ('3464663636/17','2018-10-21', '3'),
  ('352523525/17','2018-11-21', '4');
 
 create table if not exists kupci(
	kupac_id int auto_increment primary key,
	naziv_kupca varchar(50),
	pib_kupca varchar(30) unique,
	tracun_kupca varchar(20),
	odgovorno_lice varchar(30)
 );
 
 INSERT INTO kupci (naziv_kupca,pib_kupca,tracun_kupca,odgovorno_lice) VALUES 
 ('KC Nis', '23454367','840-574323352-33','Petar Petrovic'),
  ('KC Kragujevac', '453454366','840-325252253-33','Marko Markovic'),
   ('KC Pirot', '5885685','840-77474766-33','Marko Markovic'); 
 
 create table if not exists servis(
	servis_id int auto_increment primary key,
	datum_izdavanja date,
	datum_naloga date,
	nalog_ispunjen bit,
	serviser_id int not null,
	kupac_id int not null,
	foreign key(serviser_id) REFERENCES serviseri(serviseri_id),
	foreign key(kupac_id) REFERENCES kupci(kupac_id)
 );
 
 INSERT INTO servis (datum_izdavanja, datum_naloga, nalog_ispunjen,serviser_id,kupac_id) VALUES 
 ('2018-6-6','2018-6-20','1','1','1'),
  ('2018-7-7','2018-7-20','1','1','2'),
   ('2018-7-15','2018-8-20','1','1','3');
 
 

 

 create table if not exists tenderi(
	tenderi_id int auto_increment primary key,
	datum_podnosenja_dokumenata date,
	datum_donosenja_resenja date,
	tender_prosao bit,
	kupci_id int not null,
	odgovorno_lice_id int not null,
	foreign key(kupci_id) references kupci(kupac_id),
	foreign key(odgovorno_lice_id) references zaposleni(zaposleni_id)
 );
 
 INSERT INTO tenderi(datum_podnosenja_dokumenata,datum_donosenja_resenja,tender_prosao,kupci_id, odgovorno_lice_id)
 VALUES 
 ('2018-06-06','2018-12-6','1','1','1'),
 ('2018-06-10','2018-06-18','0','1','5'),
 ('2018-07-21','2018-07-28','1','1','1'),
 ('2018-05-10','2018-05-12','0','1','1'),
 ('2018-05-05','2018-05-15','1','1','5')
 ;
 
 create table if not exists proizvodjac (
	proizvodjac_id int auto_increment primary key,
	naziv_proizvodjaca varchar(50) not null,
	pib_proizvodjaca varchar(50),
	tracun_proizvodjaca varchar(50),
	drzava_proizvodjaca varchar(50)
 );
 
 INSERT INTO proizvodjac(naziv_proizvodjaca,pib_proizvodjaca,tracun_proizvodjaca,drzava_proizvodjaca) VALUES
 ('Mindray','nema','3272738573203525','NR Kina');
 
 create table if not exists delovi(
	delovi_id int auto_increment primary key,
	naziv varchar(50) not null,
	serijski_broj varchar(50),
	cena_po_komadu decimal not null,
	proizvodjac_id int not null,
	foreign key(proizvodjac_id) REFERENCES proizvodjac(proizvodjac_id)
 );
 
 create table if not exists potrosni_materijal(
	potrosni_id int auto_increment primary key,
	naziv_materijala varchar(50) not null,
	serijski_broj varchar(50),
	cena_po_komadu decimal not null,
	proizvodjac_id int not null,
	foreign key(proizvodjac_id) REFERENCES proizvodjac(proizvodjac_id)
 );
 
 create table if not exists tip_opreme(
	tip_id int auto_increment primary key,
	tip_opreme varchar(50) not null
 );
 INSERT INTO `tip_opreme`(`tip_opreme`) VALUES ("Monitor za nadgledanje"),
 ("Inkubator"),
 ("Ventilator"),
 ("Operacioni sto");
 
 
 create table if not exists oprema(
	oprema_id int auto_increment primary key,
	naziv_opreme varchar(50) not null,
	Alims_resenje_broj varchar(50) not null,
	serijski_broj varchar(50),
	lager int,
	tip_opreme int not null,
	proizvodjac_id int not null,
	foreign key(tip_opreme) references tip_opreme(tip_id),
	foreign key(proizvodjac_id) REFERENCES proizvodjac(proizvodjac_id)
 );
 INSERT INTO `oprema`( `naziv_opreme`, `Alims_resenje_broj`, `serijski_broj`, `lager`, `tip_opreme`, `proizvodjac_id`) VALUES
 ('Bene N Series N22','43666/17','5454484326','5','1','1'),
  ('Bene N Series N18','214244/17','33466436','10','1','1'), 
  ('SV700','475747/17','68568658','8','3','1');
 
 create table if not exists tender_delovi(
	tender_delovi_id int auto_increment primary key,
	tender_id int not null,
	delovi_id int not null,
	foreign key(tender_id) references tenderi(tenderi_id),
	foreign key(delovi_id) references delovi(delovi_id)
 );
 
 create table if not exists tender_potrosni_materijal(
	tender_potrosni_id int auto_increment primary key,
	tender_id int not null,
	potrosni_id int not null,
	foreign key(tender_id) references tenderi(tenderi_id),
	foreign key(potrosni_id) references potrosni_materijal(potrosni_id)
 );
 
 create table if not exists tender_oprema(
 tender_oprema_id int auto_increment primary key,
	tender_id int not null,
	oprema_id int not null,
	foreign key(tender_id) references tenderi(tenderi_id),
	foreign key(oprema_id) references oprema(oprema_id)
 );
 
 
 
 
 
 
 