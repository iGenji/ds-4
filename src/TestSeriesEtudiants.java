public class TestSeriesEtudiants {
	public static void main(String[] args) {
		String[] tableNoms = {"nom1","nom2","nom3","nom4","nom5"};
		System.out.println("Test :  3 series - 5 etudiants : ");
		SeriesEtudiants series = new SeriesEtudiants(3,tableNoms);
		System.out.println(series);
		
		System.out.println("tests - nombre etudiants");
		System.out.println("Nombre etudiants serie 1 : " + series.nombreEtudiants(1));
		System.out.println("Nombre etudiants serie 2 : " + series.nombreEtudiants(2));
		System.out.println("Nombre etudiants serie 3 : " + series.nombreEtudiants(3));
		try{
			System.out.println("Nombre etudiants serie 0 : " + series.nombreEtudiants(0));
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException : " + e.toString());
		}
		try{
			System.out.println("Nombre etudiants serie -1 : " + series.nombreEtudiants(-1));
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException : " + e.toString());
		}
		try{
			System.out.println("Nombre etudiants serie 4 : " + series.nombreEtudiants(4));
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException : " + e.toString());
		}
		System.out.println("\ntests - liste etudiants");	
		System.out.println("liste etudiants serie 1 : " + series.listeEtudiants(1));
		System.out.println("liste etudiants serie 2 : " + series.listeEtudiants(2));
		System.out.println("liste etudiants serie 3 : " + series.listeEtudiants(3));

		System.out.println("\ntests - numero serie");
		System.out.println("Serie de nom4 : "+series.numeroSerie("nom4"));
		System.out.println("Serie de nom1 : "+series.numeroSerie("nom1"));
		System.out.println("Serie de nom5 : "+series.numeroSerie("nom5"));
		System.out.println("Serie de nom2 : "+series.numeroSerie("nom2"));
		System.out.println("Serie de nom3 : "+series.numeroSerie("nom3"));

		System.out.println("\ntests - changement serie");
		series.changerSerie("nom4", 3);
		System.out.println("Nouvelle serie pour nom4 (3) : "+series.numeroSerie("nom4"));
		series.changerSerie("nom5", 1);
		System.out.println("Nouvelle serie pour nom5 (1) : "+series.numeroSerie("nom5"));
		series.changerSerie("nom3", 2);
		System.out.println("Nouvelle serie pour nom3 (2) : "+series.numeroSerie("nom3"));
		
	}
}
