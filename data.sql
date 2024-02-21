CREATE DATABASE jirama;
\c jirama;

CREATE TABLE utilisateur(
    id SERIAL PRIMARY KEY,
    login VARCHAR(30),
    mdp VARCHAR(30)
);

INSERT INTO utilisateur VALUES (1,'login','mdp');

CREATE TABLE region(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(150) 
);
CREATE TABLE service( /* Eau ou eletricite */
    id SERIAL PRIMARY KEY,
    nom VARCHAR(25)  
);

CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(20),
    idRegion INTEGER,
    FOREIGN KEY(idRegion) REFERENCES Region(id)
);

CREATE TABLE facture(
    id SERIAL PRIMARY KEY,
    idClient INTEGER,
    montant DECIMAL,
    idService INTEGER,
    dateFacture DATE,
    FOREIGN KEY (idClient) REFERENCES client(id),
    FOREIGN KEY (idService) REFERENCES service(id)
);

/* Ny liste Region dia select ihany , ary tsy miverina izay region efa ao  */

INSERT INTO region VALUES(default,'Analamanga');
INSERT INTO service VALUES (default,'Eau');
INSERT INTO client VALUES(default,'Diary',1);
INSERT INTO facture VALUES(default,1,1000,1,'2023-02-06');

