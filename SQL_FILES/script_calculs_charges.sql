-- Ici seront écrits les fonctions de calcul des différents charge
-- Veuillez vous référencer sur les informations fournises sur MOODLE
-- [BARAN & THOMAS & YAHYA]

CREATE OR REPLACE FUNCTION calculer_charges(bien_id CHAR(6)) RETURN NUMBER AS
    charge NUMBER;
BEGIN
     -- Exécutez la formule de calcul de manière dynamique
    SELECT formule INTO charge FROM NRM4206A.charge_calcul_config c
        WHERE c.nom = 'electricite' AND ROWNUM < 1;
    EXECUTE IMMEDIATE 'SELECT ' || charge || ' FROM DUAL' INTO charge;
    RETURN charge;
end calculer_charges;