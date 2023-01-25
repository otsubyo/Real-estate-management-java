package modele;

public class Assurer {
    private String numeroPolice;
    private String idBien;
    private String idAssurance;
    private float protectionJuridique;
    private float prime;
    private float quotite;
    private String dateDebut;
    private String dateFin;

    public Assurer(String numeroPolice, String idBien, String idAssurance, float protectionJuridique, float prime, float quotite, String dateDebut, String dateFin) throws Exception {
        if (numeroPolice.length() != 8) {
            throw new Exception("Le numéro de police doit être composé de 8 caractères");
        }
        if (idBien.length() != 6) {
            throw new Exception("L'identifiant du bien doit être composé de 6 caractères");
        }
        if (idAssurance.length() != 5) {
            throw new Exception("L'identifiant de l'assurance doit être composé de 5 caractères");
        }
        this.numeroPolice = numeroPolice;
        this.idBien = idBien;
        this.idAssurance = idAssurance;
        this.protectionJuridique = protectionJuridique;
        this.prime = prime;
        this.quotite = quotite;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getNumeroPolice() {
        return numeroPolice;
    }

    public String getIdBien() {
        return idBien;
    }

    public String getIdAssurance() {
        return idAssurance;
    }

    public float getProtectionjuridique() {
        return protectionJuridique;
    }

    public float getPrime() {
        return prime;
    }

    public float getQuotite() {
        return quotite;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }
}
