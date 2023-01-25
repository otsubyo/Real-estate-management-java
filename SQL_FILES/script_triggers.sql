-- Ici sont écrits les triggers
-- [AMDJAD & BARRAN]


-- TRIGGER Empêchant l'ajout de plus de 3 compteurs dans un logement
CREATE OR REPLACE TRIGGER T_AJOUT_COMPTEUR_LOG
BEFORE INSERT ON NRM4206A.COMPTEUR_LOGEMENT
FOR EACH ROW
DECLARE
    v_nbCompteurs int;
BEGIN
    v_nbCompteurs := null;
    SELECT count(*) INTO v_nbCompteurs FROM NRM4206A.COMPTEUR_LOGEMENT
                        WHERE IDBIEN = :NEW.IDBIEN AND IDLOG = :NEW.IDLOG;

    -- Si le nombre de comteur vaut déjà 3, alors on lève une exception
    IF v_nbCompteurs = 3 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Nombre de compteur maximum atteint pour ce logement !');
    END IF;
END T_AJOUT_COMPTEUR_LOG;

-- TRIGGER Empêchant l'ajout de plus de 3 compteurs dans un immeuble
CREATE OR REPLACE TRIGGER T_AJOUT_COMPTEUR_IMM
BEFORE INSERT ON NRM4206A.COMPTEUR_GENERAL
FOR EACH ROW
DECLARE
   v_nbCompteurs int;
BEGIN
    v_nbCompteurs := null;
    SELECT count(*) INTO v_nbCompteurs FROM NRM4206A.COMPTEUR_GENERAL
                        WHERE IDBIEN = :NEW.IDBIEN;

    -- Si le nombre de comteur vaut déjà 3, alors on lève une exception
    IF v_nbCompteurs = 3 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Nombre de compteur maximum atteint pour ce bien !');
    END IF;
END T_AJOUT_COMPTEUR_IMM;

-- TRIGGER empêchant l'insertion de logement dans un bien lorsque le maximum est atteint
CREATE OR REPLACE TRIGGER T_AJOUT_LOGEMENT_IMM
BEFORE INSERT ON NRM4206A.LOGEMENT
FOR EACH ROW
DECLARE
    v_nbLog int;
    v_logMaximum int;
BEGIN
    v_logMaximum := null;
    v_nbLog := null;
    SELECT count(*) into v_nbLog FROM NRM4206A.LOGEMENT WHERE IDIM = :NEW.IDIM;
    SELECT NBLOGEMENTSMAX into v_logMaximum FROM NRM4206A.BIEN WHERE IDIM = :NEW.IDIM;

    IF v_nbLog = v_logMaximum THEN
        RAISE_APPLICATION_ERROR(-20003, 'Nombre de logement maximum atteint pour ce batiment !');
    END IF;
END T_AJOUT_LOGEMENT_IMM;

-- TRIGGER empêchant la location d'un garage attenant d'un logement
CREATE OR REPLACE TRIGGER T_LOCATION_GARAGE
BEFORE INSERT ON NRM4206A.LOCATION_GARAGE
FOR EACH ROW
DECLARE
    v_idim NRM4206A.GARAGE.idim%type;
    v_log NRM4206A.GARAGE.idlog%type;
BEGIN
    v_idim := null;
    v_log := null;
    SELECT G.IDIM, G.IDLOG INTO v_idim, v_log FROM NRM4206A.GARAGE G
                            WHERE G.IDIM = :NEW.IDBIEN AND G.ID_GAR = :NEW.IDGAR;

    IF v_log IS NOT NULL AND v_idim IS NOT NULL THEN
        RAISE_APPLICATION_ERROR(-20004, 'Ce garage est attenant d''un logement !');
    END IF;
END T_LOCATION_GARAGE;

-- TRIGGER empêchant la saisie du mode de paiement par chèque sans la saisie du numéro de chèque
CREATE OR REPLACE TRIGGER T_CHEQUE_FACTURE_TRAVAUX
BEFORE INSERT ON NRM4206A.FACTURE_TRAVAUX
FOR EACH ROW
DECLARE
    v_mode_paiement VARCHAR2(50);
    v_num_cheque VARCHAR2(50);
BEGIN
    v_mode_paiement := null;
    v_num_cheque := null;

    SELECT MODE_PAIEMENT, NUMERO_CHEQUE INTO v_mode_paiement, v_num_cheque
                                        FROM NRM4206A.FACTURE_TRAVAUX
                                        WHERE NUMFAC = :NEW.NUMFAC;
    IF lower(v_mode_paiement) like 'chèque' THEN
        RAISE_APPLICATION_ERROR(-20005, 'Numéro de chèque non saisie !');
    END IF;
END T_CHEQUE_FACTURE_TRAVAUX;

-- //
CREATE OR REPLACE TRIGGER T_CHEQUE_FACTURE_BIEN
BEFORE INSERT ON NRM4206A.FACTURE_BIEN
FOR EACH ROW
DECLARE
    v_mode_paiement VARCHAR2(50);
    v_num_cheque VARCHAR2(50);
BEGIN
    v_mode_paiement := null;
    v_num_cheque := null;

    SELECT MODE_PAIEMENT, NUMERO_CHEQUE INTO v_mode_paiement, v_num_cheque
                                        FROM NRM4206A.FACTURE_BIEN
                                        WHERE NUMFAC = :NEW.NUMFAC;
    IF lower(v_mode_paiement) like 'chèque' THEN
        RAISE_APPLICATION_ERROR(-20005, 'Numéro de chèque non saisie !');
    END IF;
END T_CHEQUE_FACTURE_BIEN;

CREATE OR REPLACE TRIGGER T_CHEQUE_FACTURE_LOCATAIRE
BEFORE INSERT ON NRM4206A.FACTURE_LOCATAIRE
FOR EACH ROW
DECLARE
    v_mode_paiement VARCHAR2(50);
    v_num_cheque VARCHAR2(50);
BEGIN
    v_mode_paiement := null;
    v_num_cheque := null;

    SELECT MODE_PAIEMENT, NUMERO_CHEQUE INTO v_mode_paiement, v_num_cheque
                                        FROM NRM4206A.FACTURE_LOCATAIRE
                                        WHERE NUMFAC = :NEW.NUMFAC;
    IF lower(v_mode_paiement) like 'chèque' THEN
        RAISE_APPLICATION_ERROR(-20005, 'Numéro de chèque non saisie !');
    END IF;
END T_CHEQUE_FACTURE_LOCATAIRE;

