import java.util.Scanner;

public class TestListeCaracteres {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println("KO");
				System.out.println("     "+messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println("KO");
			System.out.println("    "+messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);			
		}
	}

	public static void main(String[] args) {

		System.out.println("*********************************************");
		System.out.println("Programme Test pour la classe ListeCaracteres");
		System.out.println("*********************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode contient");
			System.out.println("2 -> Tester la methode nombreOccurrences");
			System.out.println("3 -> Tester la methode estTriee");
			System.out.println("4 -> Tester la methode supprimerPremiereOccurrence");
			System.out.println("5 -> Tester la methode estEgalA");
			System.out.println("6 -> Tester la methode concatener");
			System.out.println("7 -> Tester la methode supprimerDerniereOccurrence");
			System.out.println("8 -> Tester la methode supprimerToutesLesOccurrencess");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testContient();
				break;
			case 2:
				testNombreOccurrences();
				break;
			case 3:
				testEstTriee();
				break;	
			case 4:
				testSupprimerPremiereOccurrence();
				break;
			case 5:
				testEstEgalA();
				break;
			case 6:
				testConcatener();
				break;	
			case 7:
				testSupprimerDerniereOccurrence();
				break;
			case 8:
				testsupprimerToutesLesOccurrencess();
				break;


			default:
				break;
			}
		} while (choix >= 1 && choix <= 8 );
	}


	private static void testSupprimerDerniereOccurrence() {
		char [] caracteres = {'a','b','a','c','a','b'};
		ListeCaracteres l = new ListeCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l + " : suppression a : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerDerniereOccurrence('a'));
		assertEquals("contenu liste ko "," a b a c b",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l + " : suppression b : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerDerniereOccurrence('b'));
		assertEquals("contenu liste ko "," a b a c a",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+ " : suppression c : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerDerniereOccurrence('c'));
		assertEquals("contenu liste ko "," a b a a b",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+ " : suppression x : ");
		assertEquals("booleen renvoye ko ",false,l.supprimerDerniereOccurrence('x'));
		assertEquals("contenu liste ko "," a b a c a b",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres();
		System.out.print("Test 5 : liste vide : suppression a : ");
		assertEquals("booleen renvoye ko ",false,l.supprimerDerniereOccurrence('a'));
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	
	}

	private static void testConcatener() {
		char [] caracteres1 = {'a','b','c'};
		char [] caracteres2 = {'x','y'};
		
		ListeCaracteres l1 = new ListeCaracteres(caracteres1);
		ListeCaracteres l2 = new ListeCaracteres(caracteres2);
		System.out.print("Test 1 : "+l1+ " +"+l2+" : ");
		l1.concatener(l2);
		assertEquals("contenu ko "," a b c x y",l1.toString());
		System.out.println("ok");
		
		
		l1 = new ListeCaracteres(caracteres1);
		l2 = new ListeCaracteres(caracteres2);
		System.out.print("Test 2 : "+l2+ " +"+l1+" : ");
		l2.concatener(l1);
		assertEquals("contenu ko "," x y a b c",l2.toString());
		System.out.println("ok");
		
		l1 = new ListeCaracteres();
		l2 = new ListeCaracteres(caracteres2);
		System.out.print("Test 3 : liste vide + "+l2+" : ");
		l1.concatener(l2);
		assertEquals("contenu ko "," x y",l1.toString());
		System.out.println("ok");
		
		l1 = new ListeCaracteres();
		l2 = new ListeCaracteres(caracteres2);
		System.out.print("Test 4 : "+l2+ " liste vide : ");
		l2.concatener(l1);
		assertEquals("contenu ko "," x y",l2.toString());
		System.out.println("ok");
		
		l1 = new ListeCaracteres();
		l2 = new ListeCaracteres();
		System.out.print("Test 5 : liste vide + liste vide : ");
		l2.concatener(l1);
		assertEquals("contenu ko ","",l2.toString());
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testEstEgalA() {
		char [] caracteres1 = {'a','b','c'};
		char [] caracteres2 = {'a','b','x'};
		char [] caracteres3 = {'a','b'};
		char [] caracteres4 = {'x','b','c'};
		
		ListeCaracteres l1 = new ListeCaracteres(caracteres1);
		ListeCaracteres l1Bis = new ListeCaracteres(caracteres1);
		ListeCaracteres l2 = new ListeCaracteres(caracteres2);
		ListeCaracteres l3 = new ListeCaracteres(caracteres3);
		ListeCaracteres l4 = new ListeCaracteres(caracteres4);
		ListeCaracteres lVide = new ListeCaracteres();
		ListeCaracteres lVideBis = new ListeCaracteres();
		
		System.out.print("Test 1 : this : "+l1+ "   parametre : "+l1Bis+" : ");
		assertEquals("booleen renvoye ko ",true,l1.estEgalA(l1Bis));
		assertEquals("Attention contenu modifie!", " a b c", l1.toString());
		assertEquals("Attention contenu modifie!", " a b c", l1Bis.toString());
		System.out.println("ok");
		
		System.out.print("Test 2 : this : "+l1+ "   parametre : "+l2+" : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(l2));
		System.out.println("ok");
		
		System.out.print("Test 3 : this : "+l1+ "   parametre : "+l4+" : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(l4));
		System.out.println("ok");
		
		System.out.print("Test 4 : this : "+l1+ "   parametre : "+l3+" : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(l3));
		System.out.println("ok");
		
		System.out.print("Test 5 : this : "+l3+ "   parametre : "+l1+" : ");
		assertEquals("booleen renvoye ko ",false,l3.estEgalA(l1));
		System.out.println("ok");
		
		System.out.print("Test 6 : this : liste vide   parametre : "+l1+" : ");
		assertEquals("booleen renvoye ko ",false,lVide.estEgalA(l1));
		System.out.println("ok");
		
		System.out.print("Test 7 : this : "+l1+"   parametre : liste vide : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(lVide));
		System.out.println("ok");
		
		System.out.print("Test 8 : this : liste vide   parametre : liste vide : ");
		assertEquals("booleen renvoye ko ",true,lVide.estEgalA(lVideBis));
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testNombreOccurrences(){
		char [] caracteres = {'a','a','b','a'};
		
		ListeCaracteres l = new ListeCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l +" nombre occurrences a : ");
		assertEquals("nombre occurrences ko ",3,l.nombreOccurrences('a'));
		assertEquals("la liste a ete modifiee! "," a a b a",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l +" nombre occurrences b : ");
		assertEquals("nombre occurrences ko ",1,l.nombreOccurrences('b'));
		assertEquals("la liste a ete modifiee! "," a a b a",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l +" nombre occurrences x : ");
		assertEquals("nombre occurrences ko ",0,l.nombreOccurrences('x'));
		assertEquals("la liste a ete modifiee! "," a a b a",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres();
		System.out.println("Test 4 : liste vide : nombre occurrences a");
		assertEquals("nombre occurrences ko ",0,l.nombreOccurrences('a'));
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();
	}

	private static void testSupprimerPremiereOccurrence(){
		char [] caracteres = {'a','b','a','c'};
		ListeCaracteres l = new ListeCaracteres(caracteres);
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l+" suppression b : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerPremiereOccurrence('b'));
		assertEquals("nouveau contenu ko "," a a c",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l +" suppression a : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerPremiereOccurrence('a'));
		assertEquals("nouveau contenu ko "," b a c",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+" suppression c : ");
		assertEquals("suppression c ko ",true,l.supprimerPremiereOccurrence('c'));
		assertEquals("nouveau contenu ko "," a b a",l.toString());
		System.out.println("ok");
		
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+" suppression x : ");
		assertEquals("booleen renvoye ko ",false,l.supprimerPremiereOccurrence('x'));
		assertEquals("contenu ko (contenu modifie)"," a b a c",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres();
		System.out.print("Test 5 : liste vide : suppression a : ");
		assertEquals("booleen renvoye ko ",false,l.supprimerPremiereOccurrence('a'));
		assertEquals("contenu ko (contenu modifie)","",l.toString());
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();
	}

	private static void testsupprimerToutesLesOccurrencess(){
		char [] caracteres = {'a','b','a','c','a','b'};
		ListeCaracteres l = new ListeCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l + " : suppression a : ");
		assertEquals("nombre renvoye ko ",3,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko "," b c b",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l + " : suppression b : ");
		assertEquals("nombre renvoye ko ",2,l.supprimerToutesLesOccurrences('b'));
		assertEquals("contenu liste ko "," a a c a",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+ " : suppression c : ");
		assertEquals("nombre renvoye ko ",1,l.supprimerToutesLesOccurrences('c'));
		assertEquals("contenu liste ko "," a b a a b",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+ " : suppression x : ");
		assertEquals("nombre renvoye ko ",0,l.supprimerToutesLesOccurrences('x'));
		assertEquals("contenu liste ko "," a b a c a b",l.toString());
		System.out.println("ok");
		
		l = new ListeCaracteres();
		System.out.print("Test 5 : liste vide : suppression a : ");
		assertEquals("booleen renvoye ko ",0,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	
	}

	private static void testContient(){
		char [] caracteres = {'a','b','c','d'};
		ListeCaracteres l;
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l+" contient c : ");
		assertEquals("booleen renvoye ko",true,l.contient('c'));
		assertEquals("Attention, liste modifiee! "," a b c d",l.toString());
		System.out.println("ok");
		
	
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l+ " contient f : ");
		assertEquals("booleen renvoye ko ",false,l.contient('f'));
		System.out.println("ok");

	
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+" contient d : ");
		assertEquals("booleen renvoye ko ",true, l.contient('d'));
		System.out.println("ok");
		
	
		l = new ListeCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+" contient a : ");
		assertEquals("booleen renvoye ko ",true, l.contient('a'));
		System.out.println("ok");
		
		
		l = new ListeCaracteres();
		System.out.print("Test 5 : liste vide : contient a : ");
		assertEquals("booleen renvoye ko ",false,l.contient('a'));
		System.out.println("ok");

		char [] caractereA = {'a'};
		l = new ListeCaracteres(caractereA);
		System.out.print("Test 6 : liste testee : "+l+" contient a : ");
		assertEquals("booleen renvoye ko ",true,l.contient('a'));
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();

	}

	private static void testEstTriee(){
		
		char [] caracteres1 = {'a','b','c','d'};
		ListeCaracteres l1 = new ListeCaracteres(caracteres1);
		System.out.print("Test 1 : liste testee : "+l1+" : ");
		assertEquals("booleen renvoye ko ",true,l1.estTriee());
		assertEquals("Attention, liste modifiee! "," a b c d",l1.toString());
		System.out.println("ok");
		
		char [] caracteres2 = {'c','d','a','b'};
		ListeCaracteres l2 = new ListeCaracteres(caracteres2);
		System.out.print("Test 2 : liste testee : "+l2+" : ");
		assertEquals("booleen renvoye ko",false,l2.estTriee());
		System.out.println("ok");
		
		char [] caracteres3 = {'a'};
		ListeCaracteres l3 = new ListeCaracteres(caracteres3);
		System.out.print("Test 3 : liste testee : "+l3+" : ");
		assertEquals("booleen renvoye ko",true,l3.estTriee());
		System.out.println("ok");
		
		ListeCaracteres l4 = new ListeCaracteres();
		System.out.print("Test 4 : liste vide : ");
		assertEquals("booleen renvoye ko",true,l4.estTriee());
		System.out.println("ok");
		
		char [] caracteres5 = {'a','b','c','d','a'};
		ListeCaracteres l5 = new ListeCaracteres(caracteres5);
		System.out.print("Test 5 : liste testee : "+l5+" : ");
		assertEquals("booleen renvoye ko",false,l5.estTriee());
		System.out.println("ok");

		char [] caracteres6 = {'b','a','c','d'};
		ListeCaracteres l6 = new ListeCaracteres(caracteres6);
		System.out.print("Test 6 : liste testee : "+l6+" : ");
		assertEquals("booleen renvoye ko",false,l6.estTriee());
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();
	}

}
