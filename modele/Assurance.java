package modele;

import java.util.Objects;

public class Assurance {
    private final String idAssurance;
    private final String libelleAssurance;

    public Assurance(String idAssurance, String libelleAssurance) throws Exception {
        if (idAssurance.length() != 5) {
            throw new Exception("L'identifiant de l'assurance doit être composé de 5 caractères");
        }
        this.idAssurance = idAssurance;
        this.libelleAssurance = libelleAssurance;
    }

    public String getIdAssurance() {
        return idAssurance;
    }

    public String getLibelleAssurance() {
        return libelleAssurance;
    }

	@Override
	public int hashCode() {
		return Objects.hash(idAssurance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Assurance)) {
			return false;
		}
		Assurance other = (Assurance) obj;
		return Objects.equals(idAssurance, other.idAssurance);
	}
    
    
}
