package modele;

import java.util.Objects;

public class BailLocataire {
    private String dateSignature;
    private String idloc;
    private String dateEffet;
    private String dateFin;
    private float caution;
    private String lienFichier;

    public BailLocataire(String dateSignature, String idloc, String dateEffet, String dateFin, float caution, String lienFichier) throws Exception {
        if (idloc.length() != 8) throw new Exception("L'identifiant du locataire doit contenir 6 caractères");
        this.dateSignature = dateSignature;
        this.idloc = idloc;
        this.dateEffet = dateEffet;
        this.dateFin = dateFin;
        this.caution = caution;
        this.lienFichier = lienFichier;
    }

    public String getDateSignature() {
        return dateSignature;
    }

    public String getIdloc() {
        return idloc;
    }

    public String getDateEffet() {
        return dateEffet;
    }

    public String getDateFin() {
        return dateFin;
    }

    public float getCaution() {
        return caution;
    }

    public String getLienFichier() {
        return lienFichier;
    }

	@Override
	public int hashCode() {
		return Objects.hash(dateSignature, idloc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BailLocataire)) {
			return false;
		}
		BailLocataire other = (BailLocataire) obj;
		return Objects.equals(dateSignature, other.dateSignature) && Objects.equals(idloc, other.idloc);
	}

	@Override
	public String toString() {
		return "BailLocataire [date_signature=" + dateSignature + ", idloc= " + idloc + ", dateEffet=" + dateEffet + ", dateFin=" + dateFin + ", caution=" + caution + ", lienFichier="
				+ lienFichier + "]";
	}
}
