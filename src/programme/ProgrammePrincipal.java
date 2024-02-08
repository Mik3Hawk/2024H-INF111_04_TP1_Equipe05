package programme;

import java.io.IOException;

import modele.satelliteRelai.SatelliteRelai;
import utilitaires.Vect2D;

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
		testVect2D();
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

}
