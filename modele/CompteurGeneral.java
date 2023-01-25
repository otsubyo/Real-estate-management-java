package modele;

public class CompteurGeneral {

        private String matricule;
        private String idbien;
        private String typeCompteur;
        private String ancienIndice;
        private String nouvelIndice;

        public CompteurGeneral(String matricule, String idbien, String ancienIndice, String nouvelIndice, String typeCompteur) throws Exception {
            if (idbien.length() != 6) throw new Exception("L'identifiant du bien doit contenir 6 caractères");
            this.matricule = matricule;
            this.idbien = idbien;
            this.typeCompteur = typeCompteur;
            this.ancienIndice = ancienIndice;
            this.nouvelIndice = nouvelIndice;
        }

        public String getMatricule() {
            return matricule;
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
		public String toString() {
			return "CompteurGeneral [matricule=" + matricule + ", idbien=" + idbien + ", typeCompteur=" + typeCompteur
					+ ", ancienIndice=" + ancienIndice + ", nouvelIndice=" + nouvelIndice + "]";
		}
}
