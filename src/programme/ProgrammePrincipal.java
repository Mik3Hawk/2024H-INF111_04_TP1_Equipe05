package programme;

import java.io.IOException;

import modele.satelliteRelai.SatelliteRelai;
import utilitaires.Vect2D;
import utilitaires.File;

public class ProgrammePrincipal {
//fintest
	/**
	 * Programme principale, instancie les éléments de la simulation,
	 * les lie entre eux, puis lance la séquence de test.
	 * @param args, pas utilisé
	 */
	public static void main(String[] args){
//
//		SatelliteRelai satellite = new SatelliteRelai();
//		satellite.start();
//

		//TEST Vect2D
		//testVect2D();

		//TEST File
		testFile();
	}

	//TEST Vect2D
	public static void testVect2D(){
		Vect2D v = new Vect2D();
		System.out.println(v);

		//avec parametre
		Vect2D testPar = new Vect2D(1.0,3.0);
		System.out.println(testPar);

		//copie de vect2d
		Vect2D copie = new Vect2D(testPar);
		System.out.println(copie);

		//get x
		double x = copie.getX();
		System.out.println(x);

		//get y
		double y = copie.getY();
		System.out.println(y);

		//longueur du vecteur
		double longueur = copie.getLongueur();
		System.out.println("la longeur du vecteur est "+longueur);

		//angle
		double angle = copie.getAngle();
		System.out.println("L'angle (rad): "+ angle);

		//Calculdiff
		Vect2D vecteur1 = new Vect2D(3.0, 4.0);
		Vect2D vecteur2 = new Vect2D(1.0, 2.0);

		// Calcul de la différence entre les deux vecteurs
		Vect2D difference = vecteur2.calculerDiff(vecteur1);
		System.out.println("Différence entre les vecteurs :"+ difference);

		//diviser
		Vect2D c = new Vect2D(2.0,4.0);
		c.diviser(2);
		System.out.println("Diviser : "+c);

		//Ajouter
		c.ajouter(2,10);
		System.out.println("Somme : "+c);

		//toString
		System.out.println("toString"+c);

		//Equals
		Vect2D vect1 = new Vect2D(3.0, 4.0);
		Vect2D vect2 = new Vect2D(2.0, 4.0);

		System.out.println(vect1.equals(vect2));
	}
	public static void testFile(){
		//test général
		File file1 = new File();
		String a="a",b="b",c="c",d="d";
		file1.enfiler(a);
		file1.enfiler(b);
		if(file1.defiler().equals(a))
			System.out.println("a = a, OK");
		else
			System.out.println("a != a, ERREUR");
		if(file1.defiler().equals(b))
			System.out.println("b = b, OK");
		else
			System.out.println("b != b, ERREUR");

		//test estVide
		if(file1.estVide())
			System.out.println("file est vide, OK");
		else
			System.out.println("File n'est pas vide, ERREUR");
		//test defiler
		//file1.defiler();

		//test taille
		System.out.println(file1.getTaille()+" <- si: 0, OK");
		file1.enfiler(a);
		file1.enfiler(b);
		file1.enfiler(c);
		file1.enfiler(d);
		System.out.println(file1.getTaille()+" <- si: 4, OK");

		//test to string
		System.out.println(file1+" <- si: a,b,c,d, OK");
		System.out.println(file1.getTaille()+" <- si: 4, OK");
		System.out.println(file1.defiler()+" <- si: a, OK");
		System.out.println(file1.getTaille()+" <- si: 3, OK");
		System.out.println(file1+" <- si: b,c,d, OK");

		//test avec plusieurs objet
		int un=1,deux=2;
		boolean nul=false;
		Vect2D vect = new Vect2D(4,6);

		file1.enfiler(un);
		file1.enfiler(deux);
		file1.enfiler(nul);
		file1.enfiler(vect);
		System.out.println(file1.getTaille()+" <- si: 7, OK");
		System.out.println(file1+" <- si: b,c,d,1,2,false,(4.0,6.0), OK");
		file1.defiler();
		file1.defiler();
		file1.defiler();
		file1.defiler();
		file1.defiler();
		file1.defiler();
		System.out.println(file1+" <- si: (4.0,6.0), OK");
		if(file1.defiler().equals(new Vect2D(4,6)))
			System.out.println("les vecteur sont égaux, OK");
		else
			System.out.println("les vecteur ne sont pas égaux, ERREUR");
	}

}
