package modele;

public class ChargeCalculConfig {
    private final String idSerial;
    private final String nom;
    private final String formule;

    public ChargeCalculConfig(String idSerial, String nom, String formule) throws Exception {
        if (idSerial.length() != 8) {
            throw new Exception("L'identifiant du bien doit être composé de 8 caractères");
        }
        this.idSerial = idSerial;
        this.nom = nom;
        this.formule = formule;
    }

    public String getIdSerial() {
        return idSerial;
    }

    public String getNom() {
        return nom;
    }

    public String getFormule() {
        return formule;
    }
}
