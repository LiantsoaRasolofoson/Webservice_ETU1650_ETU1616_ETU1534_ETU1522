CREATE DATABASE avion;
CREATE user avion WITH PASSWORD 'avion';
GRANT ALL PRIVILEGES ON DATABASE "avion" to avion;
ALTER DATABASE avion OWNER TO avion; 

CREATE TABLE Compagnie(
  idCompagnie SERIAL NOT NULL,
  nomCompagnie varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  PRIMARY KEY (idCompagnie)
);

CREATE TABLE Avion (
  idAvion      SERIAL NOT NULL, 
  nomAvion varchar(255) NOT NULL,
  idCompagnie int4 NOT NULL, 
  photo text,
  PRIMARY KEY (idAvion)
);

CREATE TABLE Kilometrage(
  idKilometrage SERIAL NOT NULL, 
  debutKm       int4, 
  finKm        int4, 
  DateKm        date, 
  idAvion    int4 NOT NULL, 
  PRIMARY KEY (idKilometrage)
);

CREATE TABLE Assurance(
  idAssurance SERIAL NOT NULL,
  dateAssurance date NOT NULL,
  dateExpiration date NOT NULL,
  idAvion int4 NOT NULL, 
  PRIMARY KEY (idAssurance)
);

CREATE TABLE Entretient(
  idEntretient SERIAL NOT NULL,
  dateEntretient date NOT NULL,
  motif varchar(255) NOT NULL,
  idAvion int4 NOT NULL,
  PRIMARY KEY (idEntretient)
);

CREATE TABLE Utilisateur (
  idUtilisateur SERIAL NOT NULL, 
  nom           varchar(255), 
  logins        varchar(255), 
  motDePasse    varchar(35), 
  PRIMARY KEY (idUtilisateur)
);

CREATE TABLE Token(
  idToken SERIAL NOT NULL,
  idUtilisateur int4,
  tokenValues varchar(255),
  dateExpiration timestamp
);

ALTER TABLE Avion ADD FOREIGN KEY (idCompagnie) REFERENCES Compagnie (idCompagnie);
ALTER TABLE Kilometrage ADD FOREIGN KEY (idAvion) REFERENCES Avion (idAvion);
ALTER TABLE Token ADD FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur);
