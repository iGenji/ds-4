
public class SeriesEtudiants{
	
	private ListeSimpleImpl[] tableSeries;
	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS
	
	/**
	 * constructeur
	 * @param nombreSeries
	 * @param noms table contenant les noms des etudiants a repartir parmi les differentes series
	 * @throws IllegalArgumentException si le nombre de series est <= 0, si la table noms est null ou vide
	 */
	public SeriesEtudiants(int nombreSeries, String[] noms) {
		if (nombreSeries <= 0 || noms == null || noms.length == 0) {
			throw new IllegalArgumentException();
		}
		tableSeries = new ListeSimpleImpl[nombreSeries];
		for (int i = 0; i < nombreSeries; i++) {
			tableSeries[i] = new ListeSimpleImpl<>();
		}
		for (int i = 0; i < noms.length; i++) {
			tableSeries[i % nombreSeries].insererEnTete(noms[i]);
		}
	}
	
	/**
	 * cette methode renvoie le nombre d'etudiants de la serie dont le numero est passe en parametre
	 * @param numeroSerie (la numerotation des series commence a 1)
	 * @return le nombre d'etudiants
	 * @throws IllegalArgumentException si le numero de serie n'existe pas
	 */
	public int nombreEtudiants(int numeroSerie) throws IllegalArgumentException {
		if (numeroSerie <= 0 || numeroSerie > tableSeries.length)
			throw new IllegalArgumentException();
		return tableSeries[numeroSerie - 1].taille();
	}
	
	/**
	 * cette methode renvoie sous forme d'un String les noms des etudiants de la serie dont le numero est passe en parametre
	 * @param numeroSerie (la numerotation des series commence a 1)
	 * @return un String avec les noms des etudiants
	 * @throws IllegalArgumentException si le numero de serie n'existe pas
	 */
	public String listeEtudiants(int numeroSerie) {
		if (numeroSerie <= 0 || numeroSerie > tableSeries.length)
			throw new IllegalArgumentException();
		String texte = "";
		for (Object element : tableSeries[numeroSerie - 1]) {
			texte += element + " ";
		}
		return texte;
	}

	public String toString() {
		String texte = "";
		for (int i = 1; i <= tableSeries.length; i++) {
			listeEtudiants(i);
		}
		return texte;
	}

	/**
	 * cette methode renvoie le numero de serie de l'etudiant dont le nom est passe en parametre
	 * @param nom
	 * @return le numero de la serie ou -1 si l'etudiant n'appartient a aucune des series
	 * @throws IllegalArgumentException si le nom est null
	 */
	public int numeroSerie(String nom) {
		if (nom == null || nom.equals(""))
			throw new IllegalArgumentException();
		for (int i = 0; i < tableSeries.length; i++) {
			if (tableSeries[i].contient(nom))
				return i + 1;
		}
		return -1;
	}
	
	/**
	 * cette methode deplace l'etudiant de sa serie vers une autre serie 
	 * a condition que l'etudiant existe et qu'il n'etait pas deja dans cette serie
	 * @param nom 
	 * @param nouveauNumeroSerie 
	 * @return true si un changement a ete effectue, false sinon
	 * @throws IllegalArgumentException si le nom est null ou si le nouveauNumeroSerien'existe pas
	 */
	public boolean changerSerie(String nom, int nouveauNumeroSerie) {
		if (nouveauNumeroSerie <= 0 || nouveauNumeroSerie > tableSeries.length)
			throw new IllegalArgumentException();
		int serieActuelle = numeroSerie(nom);
		if (serieActuelle == -1 || serieActuelle == nouveauNumeroSerie)
			return false;
		tableSeries[serieActuelle - 1].supprimer(nom);
		tableSeries[nouveauNumeroSerie - 1].insererEnTete(nom);
		return true;
	}
}
