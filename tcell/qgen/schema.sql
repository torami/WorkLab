CREATE TABLE QEP
(
IdGlobal numeric PRIMARY KEY,
QEPStr char(458),
SQLStr Blob,
ExplainStr Blob
)
/

CREATE TABLE LogDeleted 
(
TabId numeric,
TuplePos numeric,
Flag numeric 
) 
/
CREATE TABLE UpdateLog 
(
TabId numeric,
TuplePos numeric,
TupleSize numeric,
CompleteTup char(498)
)
/
CREATE TABLE MEDECIN 
( 
IdGlobal numeric PRIMARY KEY,
NomPROF char(15),
GRADE char(15),
SERVICE char(15)
)
/
CREATE TABLE PATIENT 
( 
IdGlobal numeric PRIMARY KEY,
FULLNAME char(15),
AGE numeric, 
SEX char(1),
TAILLE char(6)
)
/
CREATE TABLE VISITE
( 
IdGlobal numeric PRIMARY KEY,
IdPatient numeric REFERENCES PATIENT(IdGlobal),
IdMedecin numeric REFERENCES MEDECIN(IdGlobal),
IMC char(15),
TDT char(15), 
POID char(15),
DateVI char(8)
)
/
CREATE SKT VISITE
(
MEDECIN (IdGlobal),
PATIENT (IdGlobal)
)
/



