-- SCRIPT POUR LA CREATION DES TABLE POUR LA BDD
-- [AMDJAD]

-- PROPRIETAIRE
-- TODO: ✅
CREATE TABLE PROPRIETAIRE(
    IDPR       CHAR(8)      not null,
    NOM        VARCHAR2(15) not null,
    PRENOM     VARCHAR2(15) not null,
    ADRESSE    VARCHAR2(80) not null,
    CODEPOSTAL CHAR(5)      not null,
    VILLE      VARCHAR2(20) not null,
    EMAIL      VARCHAR2(70) not null,
    TELEPHONE  CHAR(10)     not null
);

create unique index INDEX_PROPRIETAIRE
    on PROPRIETAIRE (IDPR);

alter table PROPRIETAIRE
    add constraint PK_PROPRIETAIRE
        primary key (IDPR);

-- BIEN
-- TODO: ✅
create table BIEN
(
    IDIM           CHAR(6)      not null,
    ADRESSE        VARCHAR2(80) not null,
    CODEPOSTAL     VARCHAR2(5)  not null,
    VILLE          VARCHAR2(20) not null,
    DESCRIPTION    VARCHAR2(100),
    NBLOGEMENTSMAX NUMBER       not null,
    IDPR           CHAR(8)      not null
        constraint FK_BIEN_PROPRIO
            references PROPRIETAIRE
);

create unique index INDEX_PK_BIEN
    on BIEN (IDIM);

alter table BIEN
    add constraint PK_BIEN
        primary key (IDIM);

-- LOGEMENT
-- TODO: ✅
create table LOGEMENT (
    IDIM      CHAR(6)              not null
        constraint FK_LOGEMENT_IDBIEN
            references BIEN,
    IDLOG     CHAR(6)              not null,
    SURFACE   NUMBER               not null,
    NUM_ETAGE NUMBER               not null,
    PRIX_M2   NUMBER  default 6,
    NBPIECES  NUMBER               not null,
    TYPELOG   CHAR(2) default null not null
        constraint CK_TYPELOG_LOG
            check (TYPELOG in ('T1', 'F1', 'T2', 'F2', 'T3', 'F3', 'T4', 'F4', 'T5', 'F5'))
);

create unique index INDEX_LOGEMENT
    on LOGEMENT (IDIM, IDLOG);

alter table LOGEMENT
    add constraint PK_LOGEMENT
        primary key (IDIM, IDLOG);

-- REVISION
-- TODO: ✅
create table REVISION
(
    DATE_REVISION DATE         not null,
    ICC           NUMBER       not null,
    TYPELOG       VARCHAR2(20) not null
        constraint CK_TYPELOG_REV
            check (TYPELOG in ('T1', 'F1', 'T2', 'F2', 'T3', 'F3', 'T4', 'F4', 'T5', 'F5'))
);

create unique index INDEX_REVISION
    on REVISION (DATE_REVISION);

alter table REVISION
    add constraint PK_REVISION
        primary key (DATE_REVISION);

-- LOCATAIRE
-- TODO: ✅
create table LOCATAIRE
(
    IDLOC      CHAR(8)      not null,
    CIVILITE   VARCHAR2(5)  not null
        constraint CK_CIVILITE_LOC
            check (CIVILITE in ('M', 'MME', 'MLLE', 'IEL')),
    NOM        VARCHAR2(20) not null,
    PRENOM     VARCHAR2(20) not null,
    ADRESSE    VARCHAR2(80) not null,
    CODEPOSTAL CHAR(5)      not null,
    VILLE      VARCHAR2(20) not null,
    COURRIEL   VARCHAR2(80) not null,
    NUM_TEL    CHAR(10)     not null
);

create unique index INDEX_LOCATAIRE
    on LOCATAIRE (IDLOC);

alter table LOCATAIRE
    add constraint PK_LOCATAIRE
        primary key (IDLOC);

-- FACTURE BIEN
-- TODO: ✅
create table FACTURE_BIEN
(
    NUMFAC         CHAR(10)     not null,
    IDBIEN         CHAR(6)      not null
        constraint FK_FACTURE_BIEN_IDBIEN
            references BIEN,
    TYPEFAC        VARCHAR2(4)  not null
        constraint CK_FACTURE_IMM_TYPE
            check (typefac in ('eau', 'elec', 'gaz')),
    DATE_EMISSSION DATE         not null,
    DATE_PAIEMENT  DATE,
    MODE_PAIEMENT  VARCHAR2(50) not null,
    NUMERO_CHEQUE  VARCHAR2(12),
    IDPR           CHAR(8)      not null
        constraint FK_FACTURE_BIEN_IDPR
            references PROPRIETAIRE,
    MONTANT        NUMBER(6, 2)
);

create unique index INDEX_FACTURE_BIEN
    on FACTURE_BIEN (IDBIEN, NUMFAC);

alter table FACTURE_BIEN
    add constraint PK_FACTURE_BIEN
        primary key (IDBIEN, NUMFAC);

-- FACTURE LOCATAIRE
-- TODO: ✅
create table FACTURE_LOCATAIRE
(
    NUMFAC VARCHAR2(10) not null,
    IDLOC CHAR(8) not null,
    NATURE varchar2(100),
    LIBELLE_ENTREPRISE VARCHAR2(30),
    MONTANT number(6,2) not null,
    MONTANT_DEDUCTIBLE number(6,2) not null,
    DATE_FACTURE DATE not null,
    constraint FK_FACTURE_LOCATAIRE_LOC
        foreign key (IDLOC) references LOCATAIRE
);

alter table FACTURE_LOCATAIRE
    add constraint PK_FACTURE_LOCATAIRE
        primary key (IDLOC, NUMFAC);

-- COMPTEUR
-- TODO: ✅
create table COMPTEUR_LOGEMENT
(
    MATRICULE     VARCHAR2(10) not null,
    IDBIEN        CHAR(6)      not null,
    IDLOG         CHAR(6)      not null,
    ANCIEN_INDICE VARCHAR2(10) not null,
    NOUVEL_INDICE VARCHAR2(10),
    TYPEC         VARCHAR2(12) not null
        constraint CK_TYPEC_COMPTEUR_LOG
            check (TYPEC in ('eau', 'électrique', 'gaz')),
    constraint FK_COMPTEUR_LOG_BIEN
        foreign key (IDBIEN, IDLOG) references LOGEMENT
);

create unique index INDEX_COMPTEUR_LOG
    on COMPTEUR_LOGEMENT (MATRICULE, IDBIEN, IDLOG);

alter table COMPTEUR_LOGEMENT
    add constraint PK_COMPTEUR_LOGEMENT
        primary key (MATRICULE, IDBIEN, IDLOG);

-- LOCATION LOGEMENT
-- TODO: ✅
create table LOCATION_LOGEMENT (
    IDLOC                  CHAR(8) not null
        constraint FK_LOCATION_LOGEMENT_IDLOC
            references LOCATAIRE,
    IDBIEN                 CHAR(6) not null,
    IDLOG                  CHAR(6) not null,
    DATE_DEBUT             DATE    not null,
    PROVISION_POUR_CHARGES NUMBER  not null,
    DATE_FIN               DATE,
    constraint FK_LOCATION_LOGEMENT_IDLOG
        foreign key (IDBIEN, IDLOG) references LOGEMENT
);

create unique index INDEX_LOCATION_LOGEMENT
    on LOCATION_LOGEMENT (IDLOC, IDBIEN, IDLOG, DATE_DEBUT);

alter table LOCATION_LOGEMENT
    add constraint PK_LOCATION_LOGEMENT
        primary key (IDLOC, IDBIEN, IDLOG, DATE_DEBUT);

-- ENTREPRISE
-- TODO: ✅
create table ENTREPRISE
(
    NUM_SIRET  CHAR(14)     not null,
    NOM        VARCHAR2(25) not null,
    EMAIL      VARCHAR2(50) not null,
    NUMTEL     VARCHAR2(16) not null,
    ADRESSE    VARCHAR2(80) not null,
    CODEPOSTAL CHAR(5)      not null,
    VILLE      VARCHAR2(20) not null
);

create unique index INDEX_ENTREPRISE
    on ENTREPRISE (NUM_SIRET);

alter table ENTREPRISE
    add constraint PK_ENTREPRISE
        primary key (NUM_SIRET);

-- COMPTEUR GENERAL
-- TODO: ✅
create table COMPTEUR_GENERAL
(
    MATRICULE     VARCHAR2(10) not null,
    IDBIEN        CHAR(6)      not null
        constraint FK_COMPTEUR_GENERAL_BIEN
            references BIEN,
    ANCIEN_INDICE CHAR(4)      not null,
    NOUVEL_INDICE VARCHAR2(4),
    TYPEC         VARCHAR2(15) not null
        constraint CK_TYPEC_COMPTEUR
            check (TYPEC in ('électrique', 'gaz', 'eau'))
);

create unique index INDEX_COMPTEUR_GENERAL
    on COMPTEUR_GENERAL (MATRICULE, IDBIEN);

alter table COMPTEUR_GENERAL
    add constraint PK_COMPTEUR_GENERAL
        primary key (MATRICULE, IDBIEN);

-- GARAGE
-- TODO: ✅
create table GARAGE
(
    ID_GAR  CHAR(6)      not null,
    IDIM_N  CHAR(6)      not null
        constraint FK_GARAGE_IDBIEN
            references BIEN,
    SURFACE NUMBER(6, 2) not null,
    PRIX_M2 NUMBER(6, 2) not null,
    IDIM    CHAR(6),
    IDLOG   CHAR(6),
    constraint FK_GARAGE_IDLOG
        foreign key (IDIM, IDLOG) references LOGEMENT
);

create unique index INDEX_GARAGE
    on GARAGE (IDIM_N, ID_GAR);

create unique index INDEX_GARAGE_LOG
    on GARAGE (IDIM, IDLOG);

-- LOCATION GARAGE
-- TODO: ✅
create table LOCATION_GARAGE
(
    IDBIEN                 CHAR(6)      not null,
    IDGAR                  CHAR(6)      not null,
    IDLOC                  CHAR(8)      not null
        constraint FK_LOC_GARAGE_LOCATAIRE
            references LOCATAIRE,
    DATE_DEBUT             DATE         not null,
    PROVISION_POUR_CHARGES VARCHAR2(50) not null,
    DATE_FIN               DATE,
    constraint FK_LOC_GARAGE_BIEN
        foreign key (IDBIEN, IDGAR) references GARAGE
);

create unique index INDEX_LOC_GARAGE
    on LOCATION_GARAGE (IDBIEN, IDGAR, IDLOC, DATE_DEBUT);

alter table LOCATION_GARAGE
    add constraint PK_LOCATION_GARAGE
        primary key (IDBIEN, IDGAR, IDLOC, DATE_DEBUT);

-- BAIL_LOCATAIRE
-- TODO: ✅
create table BAIL_LOCATAIRE
(
    DATE_SIGNATURE DATE         not null,
    IDLOC          CHAR(8)      not null
        references LOCATAIRE,
    DATE_EFFET     DATE         not null,
    DATE_FIN       DATE         not null,
    CAUTION        NUMBER(6, 2) not null,
    LIEN_FICHIER   VARCHAR2(200),
    primary key (IDLOC, DATE_SIGNATURE)
);

-- ETAT_DES_LIEUX
-- TODO: ✅
create table ETAT_DES_LIEUX
(
    IDBIEN       CHAR(6) not null,
    IDLOG        CHAR(6) not null,
    IDLOC        CHAR(8) not null
        references LOCATAIRE,
    DATE_ANALYSE DATE    not null,
    ELEMENT_OBS  VARCHAR2(30),
    ETAT_GENERAL VARCHAR2(80),
    OBSERVATION  VARCHAR2(200),
    LIEN_FICHIER VARCHAR2(200),
    primary key (IDBIEN, IDLOG, DATE_ANALYSE, IDLOC),
    foreign key (IDBIEN, IDLOG) references LOGEMENT
);

-- DIAGNOSTICS
-- TODO: ✅
create table DIAGNOSTIC_LOGEMENT
(
    IDIM                CHAR(6)      not null,
    IDLOG               CHAR(6)      not null,
    DATE_RENOUVELLEMENT VARCHAR2(50) not null,
    REALISATION         VARCHAR2(5)  not null
        constraint CK_DIAGNOSTICS_REALISATION
            check (Realisation in ('TRUE', 'FALSE')),
    LIEN_DIAGNOSTIC     VARCHAR2(50) not null,
    constraint FK_DIAGNOSTIC_IDLOG
        foreign key (IDIM, IDLOG) references LOGEMENT
);

create unique index INDEX_DIAGNOSTIC_LOG_DATE_REN
    on DIAGNOSTIC_LOGEMENT (IDIM, IDLOG, DATE_RENOUVELLEMENT);

alter table DIAGNOSTIC_LOGEMENT
    add constraint PK_DIAGNOSTIC_LOG
        primary key (IDIM, IDLOG, DATE_RENOUVELLEMENT);

-- CHARGES LOCATAIRE
-- TODO: ✅
create table CHARGE_LOCATAIRE
(
    IDLOC       CHAR(6)      not null
        references BIEN,
    DATE_RELEVE DATE         not null,
    TYPE_C      VARCHAR2(20) not null,
    PARTIE_FIXE NUMBER       not null,
    primary key (IDLOC, DATE_RELEVE)
);

-- PAIEMENT_LOYER
-- TODO: ✅
create table PAIEMENT_LOYER
(
    IDLOC         CHAR(8) not null
        constraint PK_PLOYER_LOC
            references LOCATAIRE,
    DATE_EMISSION DATE    not null,
    DATE_PAIEMENT DATE,
    MONTANT       NUMBER  not null,
    PROVISION NUMBER(4,2) not null
);

create unique index INDEX_PLOYER
    on PAIEMENT_LOYER (IDLOC, DATE_EMISSION);

alter table PAIEMENT_LOYER
    add constraint PK_PLOYER
        primary key (IDLOC, DATE_EMISSION);

-- ASSURANCE
-- TODO: ✅
create table ASSURANCE
(
    IDASSURANCE      CHAR(5)      not null,
    LIBELLE_ASSUREUR VARCHAR2(20) not null
);

create unique index INDEX_ASSURANCE
    on ASSURANCE (IDASSURANCE);

alter table ASSURANCE
    add constraint PK_ASSURANCE
        primary key (IDASSURANCE);

-- ASSURER
-- TODO: ✅
create table ASSURER
(
    NUM_POLICE  CHAR(8) not null,
    IDBIEN      CHAR(6) not null
        constraint FK_ASSURER_BIEN
            references BIEN,
    IDASSURANCE CHAR(5)
        constraint FK_ASSURER_ASSURANCE
            references ASSURANCE,
    PROT_JURI   NUMBER  not null,
    PRIME       NUMBER  not null,
    QUOTITE     NUMBER,
    DATE_DEBUT  DATE    not null,
    DATE_FIN    DATE    not null
);

create unique index INDEX_ASSURER
    on ASSURER (NUM_POLICE, IDBIEN);

alter table ASSURER
    add constraint PK_ASSURER
        primary key (NUM_POLICE, IDBIEN);

-- FACTURE TRAVAUX
-- TODO: ✅
create table FACTURE_TRAVAUX
(
    NUMFAC                 VARCHAR2(15) not null
        constraint PK_FT
            primary key,
    NUMERO_SIRET           CHAR(14)     not null
        constraint FK_FT_ENTREPRISE
            references ENTREPRISE,
    DATEFACTURE            DATE         not null,
    NATURE                 VARCHAR2(100),
    MONTANT                NUMBER(6, 2) not null,
    MONTANT_NON_DEDUCTIBLE NUMBER(6, 2),
    REDUCTION              NUMBER,
    DATEPAIEMENT           DATE,
    MODEDEPAIEMENT         VARCHAR2(50),
    NUMERO_CHEQUE          CHAR(13),
    IDBIENLOGEMENT         CHAR(6),
    IDLOGEMENT             CHAR(6),
    IDBIEN                 CHAR(6)
        constraint FK_FT_BIEN
            references BIEN,
    constraint FK_FT_LOGEMENT
        foreign key (IDBIENLOGEMENT, IDLOGEMENT) references LOGEMENT
);

create unique index INDEX_FACTURE_TRAVAUX
    on FACTURE_TRAVAUX (NUMFAC);

-- EN COLOCATION
-- TODO: ✅
create table EN_COLOCATION
(
    IDLOC   CHAR(6) not null
        constraint FK_EN_COLOC_LOC
            references LOCATAIRE,
    IDLOC_N CHAR(6) not null
        constraint FK_EN_COLOC_LOC_N
            references LOCATAIRE
);

create unique index INDEX_EN_COLOC_LOC_LOC_N
    on EN_COLOCATION (IDLOC, IDLOC_N);

alter table EN_COLOCATION
    add constraint PK_EN_COLOC
        primary key (IDLOC, IDLOC_N);

-- MODULARITY
create table charge_calcul_config (
    id_serial char(8) PRIMARY KEY,
    nom varchar2(255) NOT NULL,
    formule varchar2(255) NOT NULL
);



