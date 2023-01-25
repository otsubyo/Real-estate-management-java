-- Script contenant les différents vue et procédures
-- pour les données qui seront affichés dans la VUE

-- Liste des biens
create or replace view liste_biens as
    SELECT idim, adresse, codepostal, ville, description, nblogementsmax from BIEN;

-- Liste des logement/garages à partir d'un bien et du type
create or replace function aff_logements_garages(p_idbien in NRM4206A.bien.IDIM%type, p_type in varchar2) return sys_refcursor as
    curLog sys_refcursor;
begin
    -- GARAGES
    if p_type = 'Garages' then
        open curLog for select idlog, surface from NRM4206A.GARAGE
                            where IDIM = p_idbien;
        return curLog;
    end if;

    -- LOGEMENTS
    open curLog for select idlog, surface, num_etage from NRM4206A.LOGEMENT
                            where IDIM = p_idbien;
    return curLog;
end aff_logements_garages;

-- Assurance en fonction de l'année
create or replace function protect_juri_date(p_idbien in NRM4206A.bien.IDIM%type,
                                                p_date in DATE) return sys_refcursor as
    curPJ sys_refcursor ;
begin
    open curPJ for select * from NRM4206A.ASSURER a where a.DATE_DEBUT = p_date
                                and p_idbien = a.IDBIEN;
    return curPJ;
end protect_juri_date;

-- Liste des locations de logements
create or replace view locations_logements as
    select loc.NOM || ' ' || loc.PRENOM as Locataire, ll.IDBIEN, ll.IDLOG, ll.DATE_DEBUT, ll.PROVISION_POUR_CHARGES, ll.DATE_FIN  from NRM4206A.LOCATAIRE loc, NRM4206A.LOCATION_LOGEMENT ll
            where loc.IDLOC = ll.IDLOC;

-- Liste des locations de garages
create or replace view locations_garages as
    select loc.NOM || ' ' || loc.PRENOM as Locataire, lg.IDBIEN, lg.IDGAR, lg.DATE_DEBUT, lg.PROVISION_POUR_CHARGES, lg.DATE_FIN  from NRM4206A.LOCATAIRE loc, NRM4206A.LOCATION_GARAGE lg
            where loc.IDLOC = lg.IDLOC;

-- Récupération des logements non loués
create or replace view liste_logements_non_loues as
    select * from NRM4206A.LOGEMENT where IDLOG not in (select IDLOG from NRM4206A.LOCATION_LOGEMENT)
                            and IDIM not in (select IDIM from NRM4206A.LOCATION_LOGEMENT)
            order by IDIM;

-- Récupération des garages non loués
create or replace view liste_garages_non_loues as
    select * from NRM4206A.GARAGE where ID_GAR not in (select ID_GAR from NRM4206A.LOCATION_GARAGE)
                        and IDIM_N not in (select IDIM from NRM4206A.LOCATION_GARAGE);

-- Récupération des garages non attenants
create or replace view liste_garages_non_attenants as
    select * from NRM4206A.GARAGE where IDIM is null and IDLOG is null;

-- Récupération des factures de travaux d'un bien
create or replace function liste_factures_travaux_biens(p_idbien in NRM4206A.FACTURE_TRAVAUX.IDBIEN%type) return sys_refcursor as
    cur_FB sys_refcursor;
begin
    open cur_FB for
        select * from NRM4206A.FACTURE_TRAVAUX where IDBIEN = p_idbien;
    return cur_FB;
end liste_factures_travaux_biens;

-- Barran : kwb3565a
-- Thomas : DRT3715A
-- Yahya : bnh4388a
-- Carl : prc3653a
-- prof1 : THERRY_MILLAN
-- prof2 : MOHAND_BOUGHANEM
GRANT ALL ON BIEN TO bnh4388a;
GRANT ALL ON BAIL_LOCATAIRE TO bnh4388a;
GRANT ALL ON ASSURANCE TO bnh4388a;
GRANT ALL ON ASSURER TO bnh4388a;
GRANT ALL ON LOCATAIRE TO bnh4388a;
GRANT ALL ON COMPTEUR_LOGEMENT TO bnh4388a;
GRANT ALL ON COMPTEUR_GENERAL TO bnh4388a;
GRANT ALL ON DIAGNOSTIC_LOGEMENT TO bnh4388a;
GRANT ALL ON EN_COLOCATION TO bnh4388a;
GRANT ALL ON ENTREPRISE TO bnh4388a;
GRANT ALL ON ETAT_DES_LIEUX TO bnh4388a;
GRANT ALL ON FACTURE_BIEN TO bnh4388a;
GRANT ALL ON FACTURE_TRAVAUX TO bnh4388a;
GRANT ALL ON GARAGE TO bnh4388a;
GRANT ALL ON LOCATAIRE TO bnh4388a;
GRANT ALL ON LOCATION_GARAGE TO bnh4388a;
GRANT ALL ON LOCATION_LOGEMENT TO bnh4388a;
GRANT ALL ON LOGEMENT TO bnh4388a;
GRANT ALL ON PAIEMENT_LOYER TO bnh4388a;
GRANT ALL ON PROPRIETAIRE TO bnh4388a;
GRANT ALL ON REVISION TO bnh4388a;
GRANT ALL ON AFF_LOGEMENTS_GARAGES TO bnh4388a;
GRANT ALL ON AJOUT_ASSURANCE TO bnh4388a;
GRANT ALL ON AJOUT_GARAGE TO bnh4388a;
GRANT ALL ON AJOUT_ASSURER TO bnh4388a;
GRANT ALL ON AJOUT_BAIL TO bnh4388a;
GRANT ALL ON AJOUT_BIEN TO bnh4388a;
GRANT ALL ON AJOUT_CHARGE_BIEN TO bnh4388a;
GRANT ALL ON AJOUT_CHARGE_LOCATAIRE TO bnh4388a;
GRANT ALL ON AJOUT_COMPTEUR_LOGEMENT TO bnh4388a;
GRANT ALL ON AJOUT_COMPTEUR_GENERAL TO bnh4388a;
GRANT ALL ON AJOUT_DIAGNOSTIC TO bnh4388a;
GRANT ALL ON AJOUT_ENTREPRISE TO bnh4388a;
GRANT ALL ON AJOUT_ETAT_DES_LIEUX TO bnh4388a;
GRANT ALL ON AJOUT_FACTURE_BIEN TO bnh4388a;
GRANT ALL ON AJOUT_FACTURE_TRAVAUX_IMMEUBLE TO bnh4388a;
GRANT ALL ON AJOUT_FACTURE_TRAVAUX_LOGEMENT TO bnh4388a;
GRANT ALL ON AJOUT_LOCATAIRE TO bnh4388a;
GRANT ALL ON AJOUT_LOCATION_GARAGE TO bnh4388a;
GRANT ALL ON AJOUT_LOCATION_LOGEMENT TO bnh4388a;
GRANT ALL ON AJOUT_LOGEMENT TO bnh4388a;
GRANT ALL ON AJOUT_PAIEMENT_LOYER TO bnh4388a;
GRANT ALL ON ATTENIR_GARAGE TO bnh4388a;
GRANT ALL ON LISTE_FACTURES_TRAVAUX_BIENS TO bnh4388a;
GRANT ALL ON PROTECT_JURI_DATE TO bnh4388a;


