public class ListeCaracteres {

	private NoeudCaractere tete;

	public ListeCaracteres() {
		this.tete = null;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeCaracteres(char[] tableCaracteres) {
		for (int i = tableCaracteres.length - 1; i >= 0; i--) {
			this.tete = new NoeudCaractere(tableCaracteres[i], tete);
		}
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString() {
		String aRenvoyer = "";
		NoeudCaractere baladeur = tete;
		while (baladeur != null) {
			aRenvoyer += " " + baladeur.caractere;
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche) {
		NoeudCaractere baladeur = tete;
		while (baladeur != null && baladeur.caractere != caractereRecherche) {
			baladeur = baladeur.suivant;
		}
		return baladeur != null;
	}

	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche) {
		NoeudCaractere baladeur = tete;
		int cpt = 0;
		while (baladeur != null) {
			if (baladeur.caractere == caractereRecherche)
				cpt++;
			baladeur = baladeur.suivant;
		}
		return cpt;
	}
	
	/**
	 * verifie si la liste est triee par ordre alphabetique 
	 * @return true si la liste est triee, false sinon
	 */
	public boolean estTriee() {
		if (tete == null)
			return true;
		NoeudCaractere baladeur = tete;
		while (baladeur.suivant != null && baladeur.suivant.caractere >= baladeur.caractere) {
			baladeur = baladeur.suivant;
		}
		return baladeur.suivant == null;
	}
	
	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c est sa premiere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */
	public boolean supprimerPremiereOccurrence(char caractereASupprimer) {
		if (tete == null)
			return false;
		if (tete.caractere == caractereASupprimer) {
			tete = tete.suivant;
			return true;
		}
		NoeudCaractere baladeur = tete;
		NoeudCaractere precedent = tete; 
		while (baladeur != null) {
			if (baladeur.caractere == caractereASupprimer) {
				precedent.suivant = baladeur.suivant;
				return true;
			}
			precedent = baladeur;
			baladeur = baladeur.suivant;
		}
		return false;
	}
	
	/**
	 * verifie si les 2 listes contiennent les memes caracteres et ceci dans le meme ordre
	 * Une liste est une structure LINEAIRE!
	 * @param l la liste a comparer a la liste courante
	 * @return true si les 2 listes sont les memes, false sinon
	 */
	public boolean estEgalA(ListeCaracteres l) {
		if (l == null)
			throw new IllegalArgumentException();
		NoeudCaractere baladeurCourant = tete;
		NoeudCaractere baladeurL = l.tete;
		while (baladeurCourant != null && baladeurL != null) {
			if (baladeurCourant.caractere != baladeurL.caractere)
				return false;
			baladeurCourant = baladeurCourant.suivant;
			baladeurL = baladeurL.suivant;
		}
		return baladeurCourant == baladeurL;
	}
	
	/**
	 * ajoute la liste l a la fin de la liste courante
	 * @param l la liste a ajouter
	 */
	public void concatener(ListeCaracteres l) {
		if (l == null)
			throw new IllegalArgumentException();
		NoeudCaractere baladeurCourant = tete;
		if (tete == null)
			tete = l.tete;
		else {
			while (baladeurCourant.suivant != null)
				baladeurCourant = baladeurCourant.suivant;
			baladeurCourant.suivant = l.tete;
		}
	}
	
	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c'est sa derniere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */
	public boolean supprimerDerniereOccurrence(char caractereASupprimer) {
		NoeudCaractere baladeur = tete;
		NoeudCaractere precedent = new NoeudCaractere('b', tete);
		NoeudCaractere derniereOccurencePrecedent = null;
		while (baladeur != null) {
			if (caractereASupprimer == baladeur.caractere) {
				derniereOccurencePrecedent = precedent;
				derniereOccurencePrecedent.suivant = baladeur;
			}
			precedent = baladeur;
			baladeur = baladeur.suivant;
		}
		if (derniereOccurencePrecedent == null)
			return false;
		derniereOccurencePrecedent.suivant = derniereOccurencePrecedent.suivant.suivant;
		return true;
	}
	
	/**
	 * supprime le caractere autant de fois qu'il est present dans la liste
	 * @param caractereASupprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(char caractereASupprimer) {
		int cpt = 0;
		if (tete == null)
			return 0;
		NoeudCaractere baladeur = tete;
		NoeudCaractere precedent = new NoeudCaractere('b', tete);
		while (baladeur != null) {
			if (baladeur.caractere == caractereASupprimer) {
				if (baladeur.equals(tete)) {
					tete = tete.suivant;
				} else {
					precedent.suivant = baladeur.suivant;
				}
				baladeur = baladeur.suivant;
				cpt++;
			} else {
				precedent = baladeur;
				baladeur = baladeur.suivant;
			}
		}
		return cpt;
	}
	
	private class NoeudCaractere {
		private char caractere;
		private NoeudCaractere suivant;

		public NoeudCaractere(char caractere, NoeudCaractere suivant) {
			this.caractere = caractere;
			this.suivant = suivant;
		}
	}
}
