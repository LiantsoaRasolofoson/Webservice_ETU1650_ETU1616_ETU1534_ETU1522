CREATE OR REPLACE VIEW v_avion AS
    SELECT
        compagnie.nomCompagnie,
        compagnie.email,
        avion.*
    FROM
        Compagnie JOIN Avion ON compagnie.idCompagnie = avion.idCompagnie
;

CREATE OR REPLACE VIEW v_assurance AS
    SELECT 
        avion.*, assurance.idAssurance, assurance.dateAssurance, assurance.dateExpiration
    FROM 
        Avion JOIN Assurance ON avion.idAvion = assurance.idAvion
; 
