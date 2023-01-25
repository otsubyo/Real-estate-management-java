-- SCRIPT DES PROCEDURES D'AJOUT DE DONNEES
-- [AMDJAD]

-- Ajout propriétaire
-- TODO: ✅
create or replace procedure AJOUT_PROPRIO(
                                          p_idpr in NRM4206A.PROPRIETAIRE.idpr%type,
                                          p_nom in NRM4206A.PROPRIETAIRE.nom%type,
                                          p_prenom in NRM4206A.PROPRIETAIRE.prenom%type,
                                          p_adresse in NRM4206A.PROPRIETAIRE.adresse%type,
                                          p_codePostal in NRM4206A.PROPRIETAIRE.codepostal%type,
                                          p_ville in NRM4206A.PROPRIETAIRE.ville%type,
                                          p_email in NRM4206A.PROPRIETAIRE.email%type,
                                          p_telephone in NRM4206A.PROPRIETAIRE.telephone%type) as
begin
    INSERT INTO NRM4206A.PROPRIETAIRE VALUES(p_idpr,p_nom,p_prenom,p_adresse,p_codepostal,p_ville,p_email,p_telephone);
end AJOUT_PROPRIO;

-- Ajout bien
-- TODO: ✅
create or replace procedure AJOUT_BIEN(p_idbien in NRM4206A.BIEN.IDIM%type,p_adresse in NRM4206A.BIEN.adresse%type,
                                       p_codepostal in NRM4206A.BIEN.codepostal%type, p_ville in BIEN.ville%type,
                                       p_description in NRM4206A.BIEN.description%type default null,
                                       p_nblogementsmax in NRM4206A.BIEN.nblogementsmax%type) as
 v_idpr NRM4206A.BIEN.idpr%type;
begin
    SELECT idpr into v_idpr FROM NRM4206A.PROPRIETAIRE WHERE ROWNUM <= 1;
    INSERT INTO NRM4206A.BIEN VALUES(p_idbien,p_adresse,p_codepostal,p_ville,p_description,p_nblogementsmax,v_idpr);
end AJOUT_BIEN;

-- Ajout logement
-- TODO: ✅
create or replace procedure AJOUT_LOGEMENT(p_idbien in NRM4206A.LOGEMENT.idim%type,
                                           p_idlog in NRM4206A.LOGEMENT.IDLOG%type,
                                           p_surface in NRM4206A.LOGEMENT.surface%type,
                                           p_num_etage in NRM4206A.LOGEMENT.num_etage%type,
                                           p_prix_m2 in NRM4206A.LOGEMENT.prix_m2%type,
                                           p_nb_pieces in NRM4206A.LOGEMENT.nbpieces%type,
                                           p_type_log in NRM4206A.LOGEMENT.TYPELOG%type) as
begin
    if p_num_etage > 9 then
        raise_application_error(-20002,'Numéro d étage non supporté');
    end if;
    INSERT INTO NRM4206A.LOGEMENT VALUES(p_idbien,p_idlog,p_surface,p_num_etage,p_prix_m2,p_nb_pieces, p_type_log);
end AJOUT_LOGEMENT;

-- Ajout compteur
-- TODO: ✅
create or replace procedure AJOUT_COMPTEUR_LOGEMENT(p_matricule in NRM4206A.COMPTEUR_LOGEMENT.matricule%type,
                                                    p_idbien in NRM4206A.COMPTEUR_LOGEMENT.IDBIEN%type,
                                                    p_idlog in NRM4206A.COMPTEUR_LOGEMENT.idlog%type,
                                                    p_ancien_indice in NRM4206A.COMPTEUR_LOGEMENT.ancien_indice%type,
                                                    p_nouvel_indice in NRM4206A.COMPTEUR_LOGEMENT.nouvel_indice%type default NULL,
                                                    p_typec in NRM4206A.COMPTEUR_LOGEMENT.typec%type) as
    v_ni varchar2(10);
begin
    v_ni := p_nouvel_indice;
    if p_nouvel_indice = 'null' then
        v_ni := null;
    end if;
    INSERT INTO NRM4206A.COMPTEUR_LOGEMENT VALUES(p_matricule,p_idbien,p_idlog,p_ancien_indice,v_ni, p_typec);
end AJOUT_COMPTEUR_LOGEMENT;

-- Ajout compteur general
-- TODO: ✅
create or replace procedure AJOUT_COMPTEUR_GENERAL(p_matricule in NRM4206A.COMPTEUR_GENERAL.matricule%type, p_idbien in NRM4206A.COMPTEUR_GENERAL.IDBIEN%type,
                                                    p_ancien_indice in NRM4206A.COMPTEUR_GENERAL.ancien_indice%type,
                                                    p_nouvel_indice in NRM4206A.COMPTEUR_GENERAL.nouvel_indice%type default null, p_typec in NRM4206A.COMPTEUR_GENERAL.typec%type) as
begin
    INSERT INTO NRM4206A.COMPTEUR_GENERAL VALUES(p_matricule,p_idbien,p_ancien_indice,p_nouvel_indice,p_typec);
end AJOUT_COMPTEUR_GENERAL;

-- Ajout d'une entreprise
-- TODO: ✅
create or replace procedure AJOUT_ENTREPRISE(p_siret in NRM4206A.ENTREPRISE.num_siret%type,p_nom in NRM4206A.ENTREPRISE.nom%type,
                                             p_email in NRM4206A.ENTREPRISE.email%type,p_num in NRM4206A.ENTREPRISE.numtel%type,
                                             p_adresse in NRM4206A.ENTREPRISE.ADRESSE%type,p_codepostal in NRM4206A.ENTREPRISE.CODEPOSTAL%type,
                                             p_ville in NRM4206A.ENTREPRISE.ville%type) as
begin
    INSERT INTO NRM4206A.ENTREPRISE VALUES(p_siret,p_nom,p_email,p_num,p_adresse,p_codepostal,p_ville);
end AJOUT_ENTREPRISE;

-- Ajout d'une facture de travaux pour un immeuble entier
-- TODO: ✅
create procedure AJOUT_FACTURE_TRAVAUX_IMMEUBLE(p_numfac in NRM4206A.FACTURE_TRAVAUX.numfac%type, p_num_siret in NRM4206A.FACTURE_TRAVAUX.NUMERO_SIRET%type,
                                            p_date_facture in NRM4206A.FACTURE_TRAVAUX.DATEFACTURE%type,
                                            p_nature in NRM4206A.FACTURE_TRAVAUX.NATURE%type default null, p_montant in NRM4206A.FACTURE_TRAVAUX.montant%type,
                                            p_montant_non_deduc in NRM4206A.FACTURE_TRAVAUX.MONTANT_NON_DEDUCTIBLE%type default null, p_reduction in NRM4206A.FACTURE_TRAVAUX.reduction%type default null,
                                            p_bien in NRM4206A.FACTURE_TRAVAUX.IDBIEN%type,p_date_paiement in NRM4206A.FACTURE_TRAVAUX.DATE_PAIEMENT%type, p_mode_paiement in NRM4206A.FACTURE_TRAVAUX.MODE_PAIEMENT%type,
                                            p_num_ch in NRM4206A.FACTURE_TRAVAUX.NUMERO_CHEQUE%type) as
begin
    INSERT INTO NRM4206A.FACTURE_TRAVAUX VALUES(p_numfac,p_num_siret,p_date_facture,p_nature,p_montant,p_montant_non_deduc,p_reduction,NULL,NULL, p_bien,p_date_paiement, p_mode_paiement, p_num_ch);
end AJOUT_FACTURE_TRAVAUX_IMMEUBLE;

-- Ajout d'une facture de travaux pour un logement en particulier
-- TODO: ✅
create procedure AJOUT_FACTURE_TRAVAUX_LOGEMENT(p_numfac in NRM4206A.FACTURE_TRAVAUX.numfac%type, p_num_siret in NRM4206A.FACTURE_TRAVAUX.NUMERO_SIRET%type,
                                            p_date_facture in NRM4206A.FACTURE_TRAVAUX.DATEFACTURE%type,
                                            p_nature in NRM4206A.FACTURE_TRAVAUX.NATURE%type default null, p_montant in NRM4206A.FACTURE_TRAVAUX.montant%type,
                                            p_montant_non_deduc in NRM4206A.FACTURE_TRAVAUX.MONTANT_NON_DEDUCTIBLE%type default null, p_reduction in NRM4206A.FACTURE_TRAVAUX.reduction%type default null,
                                            p_idlog_bien in NRM4206A.FACTURE_TRAVAUX.IDBIENLOGEMENT%type, p_idlog in NRM4206A.FACTURE_TRAVAUX.IDLOGEMENT%type,
                                            p_date_paiement in NRM4206A.FACTURE_TRAVAUX.DATE_PAIEMENT%type, p_mode_paiement in NRM4206A.FACTURE_TRAVAUX.MODE_PAIEMENT%type,
                                            p_num_ch in NRM4206A.FACTURE_TRAVAUX.NUMERO_CHEQUE%type) as
begin
    INSERT INTO NRM4206A.FACTURE_TRAVAUX VALUES(p_numfac,p_num_siret,p_date_facture,p_nature,p_montant,p_montant_non_deduc,p_reduction,p_idlog_bien,p_idlog, NULL, p_date_paiement, p_mode_paiement, p_num_ch);
end AJOUT_FACTURE_TRAVAUX_LOGEMENT;

-- Ajout d'un garage
-- TODO : ✅
create or replace procedure AJOUT_GARAGE(p_idgar in NRM4206A.GARAGE.ID_GAR%type,p_idbien_n in NRM4206A.BIEN.idim%type, p_surface in NRM4206A.GARAGE.surface%type,
                                         p_prixm2 in NRM4206A.GARAGE.PRIX_M2%type) as
begin
    INSERT INTO NRM4206A.GARAGE VALUES(p_idgar,p_idbien_n,p_surface,p_prixm2,NULL,NULL);
end AJOUT_GARAGE;

-- Ajout d'un locataire
-- TODO : ✅
create or replace procedure AJOUT_LOCATAIRE(p_idloc in NRM4206A.LOCATAIRE.IDLOC%type,
                                            p_civilite in NRM4206A.LOCATAIRE.civilite%type,
                                            p_nom in NRM4206A.LOCATAIRE.nom%type,
                                            p_prenom in NRM4206A.LOCATAIRE.prenom%type,
                                            p_adresse in NRM4206A.LOCATAIRE.adresse%type,
                                            p_codepostal in NRM4206A.LOCATAIRE.codepostal%type,
                                            p_ville in NRM4206A.LOCATAIRE.ville%type,
                                            p_courriel in NRM4206A.LOCATAIRE.courriel%type,
                                            p_numtel in NRM4206A.LOCATAIRE.num_tel%type) as
begin
    INSERT INTO NRM4206A.LOCATAIRE VALUES(p_idloc,p_nom,p_prenom,p_adresse,p_codepostal,p_ville,p_courriel,p_numtel,p_civilite);
end AJOUT_LOCATAIRE;

-- Ajout d'une assurance
-- TODO : ✅
create or replace procedure AJOUT_ASSURANCE(p_idass in NRM4206A.ASSURANCE.IDASSURANCE%type,p_libelle_assureur in NRM4206A.ASSURANCE.libelle_assureur%type) as
begin
    INSERT INTO NRM4206A.ASSURANCE VALUES(p_idass,p_libelle_assureur);
end AJOUT_ASSURANCE;

-- Ajout d'un assurer
-- TODO : ✅
create or replace procedure AJOUT_ASSURER(p_num_police in NRM4206A.ASSURER.num_police%type, p_idbien in NRM4206A.ASSURER.idbien%type,
                                          p_idassurance in NRM4206A.ASSURER.idassurance%type, p_prot_juri in NRM4206A.ASSURER.prot_juri%type,
                                          p_prime in NRM4206A.ASSURER.prime%type, p_quotite in NRM4206A.ASSURER.quotite%type default 0,
                                          p_date_debut in NRM4206A.ASSURER.date_debut%type, p_date_fin in NRM4206A.ASSURER.date_fin%type) as
begin
    INSERT INTO NRM4206A.ASSURER VALUES (p_num_Police, p_idbien, p_idassurance, p_prot_juri, p_prime, p_quotite, p_date_debut, p_date_fin);
end AJOUT_ASSURER;

-- Ajout d'un bail locataire
-- TODO: ✅
create or replace procedure AJOUT_BAIL(p_date_signature in NRM4206A.BAIL_LOCATAIRE.DATE_SIGNATURE%type,
                                        p_date_effet in NRM4206A.BAIL_LOCATAIRE.DATE_EFFET%type,
                                        p_date_fin in NRM4206A.BAIL_LOCATAIRE.DATE_FIN%type,
                                        p_caution in NRM4206A.BAIL_LOCATAIRE.CAUTION%type,
                                        p_lien_bail in NRM4206A.BAIL_LOCATAIRE.LIEN_FICHIER%type,
                                        p_idloc in NRM4206A.BAIL_LOCATAIRE.IDLOC%type) as
begin
    INSERT INTO NRM4206A.BAIL_LOCATAIRE VALUES (p_date_signature,p_idloc,p_date_effet,p_date_fin,p_caution,p_lien_bail);
end AJOUT_BAIL;

-- Ajout d'une charge
-- TODO: ✅
create or replace procedure AJOUT_CHARGE_BIEN(p_idbien in NRM4206A.CHARGE_BIEN.idbien%type, p_date_releve in NRM4206A.CHARGE_BIEN.DATE_RELEVE%type,
                                            p_type NRM4206A.CHARGE_BIEN.TYPE_C%type, p_partie_fixe in NRM4206A.CHARGE_BIEN.PARTIE_FIXE%type default null) as
begin
    INSERT INTO NRM4206A.CHARGE_BIEN VALUES(p_idbien,p_date_releve,p_type,p_partie_fixe);
end AJOUT_CHARGE_BIEN;

-- Ajout charge locataire
-- TODO: ✅
create or replace procedure AJOUT_CHARGE_LOCATAIRE(p_idloc in NRM4206A.CHARGE_LOCATAIRE.idloc%type, p_date_releve in NRM4206A.CHARGE_LOCATAIRE.DATE_RELEVE%type,
                                            p_type NRM4206A.CHARGE_LOCATAIRE.TYPE_C%type, p_partie_fixe in NRM4206A.CHARGE_LOCATAIRE.PARTIE_FIXE%type default null) as
begin
    INSERT INTO NRM4206A.CHARGE_LOCATAIRE VALUES(p_idloc,p_date_releve,p_type,p_partie_fixe);
end AJOUT_CHARGE_LOCATAIRE;

-- Ajout diagnostic logement
-- TODO: ✅
create or replace procedure AJOUT_DIAGNOSTIC(p_idbien in NRM4206A.DIAGNOSTIC_LOGEMENT.idim%type,
                                            p_idlog in NRM4206A.DIAGNOSTIC_LOGEMENT.IDLOG%type,
                                            p_date in NRM4206A.DIAGNOSTIC_LOGEMENT.DATE_RENOUVELLEMENT%type,
                                            p_realisation in NRM4206A.DIAGNOSTIC_LOGEMENT.REALISATION%type,
                                            p_lien_diagnostic in NRM4206A.DIAGNOSTIC_LOGEMENT.LIEN_DIAGNOSTIC%type) as
begin
    INSERT INTO NRM4206A.DIAGNOSTIC_LOGEMENT VALUES (p_idbien,p_idlog,p_date,p_realisation,p_lien_diagnostic);
end AJOUT_DIAGNOSTIC;

-- Ajout d'un etat des lieux
-- TODO: ✅
create or replace procedure AJOUT_ETAT_DES_LIEUX(p_idbien in NRM4206A.ETAT_DES_LIEUX.IDBIEN%type,
                                            p_idlog in NRM4206A.ETAT_DES_LIEUX.IDLOG%type,
                                            p_idloc in NRM4206A.ETAT_DES_LIEUX.IDLOC%type,
                                            p_date in NRM4206A.ETAT_DES_LIEUX.DATE_ANALYSE%type,
                                            p_element_obs in NRM4206A.ETAT_DES_LIEUX.ELEMENT_OBS%type,
                                            p_etat_general in NRM4206A.ETAT_DES_LIEUX.ETAT_GENERAL%type,
                                            p_observation in NRM4206A.ETAT_DES_LIEUX.OBSERVATION%type,
                                            p_lien_fichier in NRM4206A.ETAT_DES_LIEUX.LIEN_FICHIER%type) as
begin
    INSERT INTO NRM4206A.ETAT_DES_LIEUX VALUES (p_idbien,p_idlog,p_idloc,p_date,p_element_obs,p_etat_general,p_observation,p_lien_fichier);
end AJOUT_ETAT_DES_LIEUX;

call NRM4206A.AJOUT_ETAT_DES_LIEUX('BIEN03','L015E2','NRM4206A','02/01/2023',
    'Vitre de la fenêtre cassé !','OK','Sol infesté de cafards',null);

-- Ajout d'une facture d'un bien
-- TODO: ✅
create or replace procedure AJOUT_FACTURE_BIEN(p_numfac in NRM4206A.FACTURE_BIEN.numfac%type, p_idbien in NRM4206A.FACTURE_BIEN.IDBIEN%type,
                                                p_typefac in NRM4206A.FACTURE_BIEN.TYPEFAC%type, p_date_emission in NRM4206A.FACTURE_BIEN.DATE_EMISSSION%type,
                                                p_date_paiement in NRM4206A.FACTURE_BIEN.DATE_PAIEMENT%type,p_mode_paiement in NRM4206A.FACTURE_BIEN.MODE_PAIEMENT%type default null,
                                                p_num_cheque in NRM4206A.FACTURE_BIEN.NUMERO_CHEQUE%type,
                                                p_montant in NRM4206A.FACTURE_BIEN.MONTANT%type) as
    v_idpr NRM4206A.FACTURE_BIEN.IDPR%type;
begin
    SELECT IDPR into v_idpr FROM PROPRIETAIRE WHERE ROWNUM = 1;
    INSERT INTO NRM4206A.FACTURE_BIEN VALUES (p_numfac,p_idbien,p_typefac,p_date_emission,p_date_paiement,p_mode_paiement,p_num_cheque,v_idpr, p_montant);
end AJOUT_FACTURE_BIEN;

-- Ajout d'une location de garage
-- TODO: ✅
create or replace procedure AJOUT_LOCATION_GARAGE(p_idbien in NRM4206A.LOCATION_GARAGE.idbien%type,p_idgar in NRM4206A.LOCATION_GARAGE.IDGAR%type, p_idloc in NRM4206A.LOCATION_GARAGE.IDLOC%type,
                                                    p_date_debut in NRM4206A.LOCATION_GARAGE.DATE_DEBUT%type, p_provision_charges in NRM4206A.LOCATION_GARAGE.PROVISION_POUR_CHARGES%type,
                                                    p_date_fin in NRM4206A.LOCATION_GARAGE.DATE_FIN%type) as

begin
    INSERT INTO NRM4206A.LOCATION_GARAGE VALUES (p_idbien,p_idgar, p_idloc, p_date_debut, p_provision_charges, p_date_fin);
end AJOUT_LOCATION_GARAGE;

-- Ajout d'une location de logement
-- TODO: ✅
create or replace procedure AJOUT_LOCATION_LOGEMENT(p_idbien in NRM4206A.LOCATION_LOGEMENT.idbien%type,p_idlog in NRM4206A.LOCATION_LOGEMENT.IDLOG%type, p_idloc in NRM4206A.LOCATION_LOGEMENT.IDLOC%type,
                                                    p_date_debut in NRM4206A.LOCATION_LOGEMENT.DATE_DEBUT%type, p_provision_charges in NRM4206A.LOCATION_LOGEMENT.PROVISION_POUR_CHARGES%type,
                                                    p_date_fin in NRM4206A.LOCATION_LOGEMENT.DATE_FIN%type) as

begin
    INSERT INTO NRM4206A.LOCATION_LOGEMENT VALUES (p_idloc, p_idbien, p_idlog, p_date_debut, p_provision_charges, p_date_fin);
end AJOUT_LOCATION_LOGEMENT;

-- Ajout d'un paiement de loyer
-- TODO: ✅
create or replace procedure AJOUT_PAIEMENT_LOYER(p_idloc in NRM4206A.PAIEMENT_LOYER.idloc%type, p_date_emission in NRM4206A.PAIEMENT_LOYER.DATE_EMISSION%type,
                                                    p_date_paiement in NRM4206A.PAIEMENT_LOYER.DATE_PAIEMENT%type default null, p_montant in NRM4206A.PAIEMENT_LOYER.MONTANT%type) as
begin
    INSERT INTO NRM4206A.PAIEMENT_LOYER VALUES (p_idloc, p_date_emission, p_date_paiement, p_montant);
end AJOUT_PAIEMENT_LOYER;

-- ATTENIR UN GARAGE
-- TODO: ✅️
create procedure ATTENIR_GARAGE(p_idgar in NRM4206A.GARAGE.id_gar%type,
                                            p_idim_n in NRM4206A.GARAGE.idim_n%type,
                                            p_idbienlog in NRM4206A.GARAGE.idim%type,
                                            p_idlog in NRM4206A.GARAGE.idlog%type) as
    v_idgar NRM4206A.liste_garages_non_attenants.ID_GAR%type;
    v_idim_n NRM4206A.liste_garages_non_attenants.ID_GAR%type;
begin
    v_idgar := NULL;
    v_idgar := NULL;
    SELECT ID_GAR INTO v_idgar FROM NRM4206A.liste_garages_non_attenants WHERE ID_GAR = p_idgar AND ROWNUM = 1;
    SELECT IDIM_N INTO v_idim_n FROM NRM4206A.liste_garages_non_attenants WHERE IDIM_N = p_idim_n AND ROWNUM = 1;
    if v_idgar is NULL and v_idim_n is NULL then
        raise_application_error(-20003,'Ce garage est déjà lié à un autre logement');
    end if;
    UPDATE NRM4206A.GARAGE SET IDIM = p_idbienlog, IDLOG = p_idlog WHERE IDIM = p_idbienlog AND IDLOG = p_idlog;
end ATTENIR_GARAGE;

-- MODULARITY
create or replace FUNCTION calculer_charges(bien_id in CHAR(6)) RETURN NUMBER AS
    charge NUMBER;
BEGIN
     -- Exécutez la formule de calcul de manière dynamique
    SELECT formule INTO charge FROM NRM4206A.charge_calcul_config c
        WHERE c.nom = 'electricite' AND ROWNUM < 1;
    EXECUTE IMMEDIATE 'SELECT ' || charge || ' FROM DUAL' INTO charge;
    RETURN charge;
end calculer_charges;
