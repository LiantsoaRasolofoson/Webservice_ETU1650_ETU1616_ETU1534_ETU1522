insert into Compagnie(nomCompagnie,email) values ('Air Madagascar','Airmada@gmail.com');

insert into Avion(nomAvion,idCompagnie,photo) values ('Being 737',1,'img.jpg');
insert into Avion(nomAvion,idCompagnie,photo) values ('Air Bus340',1,'img2.jpg');
insert into Avion(nomAvion,idCompagnie,photo) values ('Being 777',1,'img3.jpg');
insert into Avion(nomAvion,idCompagnie,photo) values ('ATR 500',1,'img4.jpg');
insert into Avion(nomAvion,idCompagnie,photo) values ('AIR Bus 380',1,'img5.jpg');

insert into Kilometrage(debutKm,finKm,DateKm,idAvion) values ( 100,150,'2022-05-12',1);
insert into Kilometrage(debutKm,finKm,DateKm,idAvion) values ( 400,650,'2021-06-06',2);
insert into Kilometrage(debutKm,finKm,DateKm,idAvion) values ( 202,950,'2022-10-01',3);
insert into Kilometrage(debutKm,finKm,DateKm,idAvion) values ( 90,350,'2021-04-11',4);
insert into Kilometrage(debutKm,finKm,DateKm,idAvion) values ( 170,450,'2022-09-13',5);

insert into Assurance(dateAssurance,dateExpiration,idAvion) values ('2022-04-11','2022-09-14',1);
insert into Assurance(dateAssurance,dateExpiration,idAvion) values ('2021-01-12','2022-11-05',2);
insert into Assurance(dateAssurance,dateExpiration,idAvion) values ('2022-05-13','2022-12-19',3);
insert into Assurance(dateAssurance,dateExpiration,idAvion) values ('2021-11-16','2022-04-12',4);
insert into Assurance(dateAssurance,dateExpiration,idAvion) values ('2022-03-14','2022-09-02',5);

insert into Entretient(dateEntretient,motif,idAvion) values ('2022-01-12','dossier',1);
insert into Entretient(dateEntretient,motif,idAvion) values ('2021-08-12','maintenance',2);
insert into Entretient(dateEntretient,motif,idAvion) values ('2022-06-05', 'mecanique',3);
insert into Entretient(dateEntretient,motif,idAvion) values ('2022-03-04','dossier',4);
insert into Entretient(dateEntretient,motif,idAvion) values ('2022-06-15','maintenance',5);

insert into Utilisateur(nom,logins,motDePasse) values('Liantsoa','Liantsoa01','0123');
insert into Utilisateur(nom,logins,motDePasse) values('Mihaja','Mihaja02','12345');
insert into Utilisateur(nom,logins,motDePasse) values('Xena','Xena03','456');
insert into Utilisateur(nom,logins,motDePasse) values('Toky','Toky04','123');

insert into Token(idUtilisateur,tokenValues,dateExpiration) values (1,'A-DBN','2022-12-01');
insert into Token(idUtilisateur,tokenValues,dateExpiration) values (2,'A-SVR','2022-02-21');
insert into Token(idUtilisateur,tokenValues,dateExpiration) values (3,'A-ERR','2022-11-27');
insert into Token(idUtilisateur,tokenValues,dateExpiration) values (4,'A-SEV','2022-10-14');
