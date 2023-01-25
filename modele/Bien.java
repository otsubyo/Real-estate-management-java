package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Bien {
    private String idbien;
    private List<Logement> logements;
    private List<CompteurGeneral> compteursGeneral;
    private final String adresse;
    private final String codepostal;
    private final String ville;
    private final String description;
    private final int nbLogementmax;

    public Bien(String idbien, String adresse, String codepostal, String ville, String description, int nbLogementmax) throws Exception{
        if (codepostal.length() != 5) throw new Exception("Le code postal doit être composé de 5 caractères");
        this.idbien = idbien;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.description = description;
        this.nbLogementmax = nbLogementmax;
        this.logements = new ArrayList<>();
        this.compteursGeneral = new ArrayList<>();
    }

    public Collection<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}

	public List<CompteurGeneral> getCompteursGeneral() {
		return compteursGeneral;
	}

	public void setCompteursGeneral(List<CompteurGeneral> compteursGeneral) {
		this.compteursGeneral = compteursGeneral;
	}

    public String getIdbien(){
        return idbien;
    }

    public String getAdresse(){
        return adresse;
    }

    public String getCodepostal(){
        return codepostal;
    }

    public String getVille(){
        return ville;
    }

    public String getDescription(){
        return description;
    }

    public int getNbLogementmax() {
        return nbLogementmax;
    }

	@Override
	public int hashCode() {
		return Objects.hash(idbien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bien)) {
			return false;
		}
		Bien other = (Bien) obj;
		return Objects.equals(idbien, other.idbien);
	}

	@Override
	public String toString() {
		return "Bien [idbien=" + idbien + ", logements=" + logements + ", compteursGeneral=" + compteursGeneral
				+ ", adresse=" + adresse + ", codepostal=" + codepostal + ", ville=" + ville
				+ ", description=" + description + ", nbLogementmax=" + nbLogementmax + "]";
	}
	
	
}
