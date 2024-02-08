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
	
		SatelliteRelai satellite = new SatelliteRelai();
		satellite.start();


		//TEST Vect2D
		testVect2D();
	}

	//TEST Vect2D
	public static void testVect2D(){
		Vect2D v = new Vect2D();
		System.out.println(v);
	}

}
