package programme;

import java.io.IOException;

import modele.satelliteRelai.SatelliteRelai;

public class ProgrammePrincipal {
//test2 mike
	/**
	 * Programme principale, instancie les éléments de la simulation,
	 * les lie entre eux, puis lance la séquence de test.
	 * @param args, pas utilisé
	 */
	public static void main(String[] args){
	
		SatelliteRelai satellite = new SatelliteRelai();
		satellite.start();
		
	}

}
