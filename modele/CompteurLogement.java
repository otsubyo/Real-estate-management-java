package modele;

import java.util.Objects;

public class CompteurLogement {


    private final String matricule;
    private final String idLog;
    private final String idbien;
    private final String typeCompteur;
    private final String ancienIndice;
    private final String nouvelIndice;

    public CompteurLogement(String matricule, String idbien, String idLog, String ancienIndice, String nouvelIndice,String typeCompteur) throws Exception {
        if (idbien.length() != 6) throw new Exception("L'identifiant du bien doit contenir 6 caractères");
        this.matricule = matricule;
        this.idLog = idLog;
        this.idbien = idbien;
        this.typeCompteur = typeCompteur;
        this.ancienIndice = ancienIndice;
        this.nouvelIndice = nouvelIndice;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getIdLog() {
        return idLog;
    }

    public String getIdbien() {
        return idbien;
    }

    public String getTypeCompteur() {
        return typeCompteur;
    }

    public String getAncienIndice() {
        return ancienIndice;
    }

    public String getNouvelIndice() {
        return nouvelIndice;
    }

	@Override
	public int hashCode() {
		return Objects.hash(idLog, idbien, matricule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CompteurLogement)) {
			return false;
		}
		CompteurLogement other = (CompteurLogement) obj;
		return Objects.equals(idLog, other.idLog) && Objects.equals(idbien, other.idbien)
				&& Objects.equals(matricule, other.matricule);
	}

	@Override
	public String toString() {
		return "CompteurLogement [matricule=" + matricule + ", idLog=" + idLog + ", idbien=" + idbien
				+ ", typeCompteur=" + typeCompteur + ", ancienIndice=" + ancienIndice + ", nouvelIndice=" + nouvelIndice
				+ "]";
	}
    
    
}
