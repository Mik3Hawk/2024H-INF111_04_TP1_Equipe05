package modele.satelliteRelai;

/**
 * Classe simulant le satellite relai
 * 
 * Le satellite ne se contente que de transferer les messages du Rover vers le centre de contrôle
 * et vice-versa.
 * 
 * Le satellite exécute des cycles à intervale de TEMPS_CYCLE_MS. Période à
 * laquelle tous les messages en attente sont transmis. Ceci est implémenté à
 * l'aide d'une tâche (Thread).
 * 
 * Le relai satellite simule également les interférence dans l'envoi des messages.
 * 
 * Services offerts:
 *  - lierCentrOp
 *  - lierRover
 *  - envoyerMessageVersCentrOp
 *  - envoyerMessageVersRover
 * 
 * @author Frederic Simard, ETS
 * @version Hiver, 2024
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import modele.communication.Message;
import utilitaires.File;

public class SatelliteRelai extends Thread{
	
	static final int TEMPS_CYCLE_MS = 500;
	static final double PROBABILITE_PERTE_MESSAGE = 0.15;
	ReentrantLock lock = new ReentrantLock();
	private Random rand = new Random();

	private File fileMessageVersCentrOp = new File();
	private File fileMessageVersRover = new File();

	public File getFileMessageVersCentrOp(){return this.fileMessageVersCentrOp;}
	public File getFileMessageVersRover(){return this.fileMessageVersRover;}
	
	/**
	 * Méthode permettant d'envoyer un message vers le centre d'opération
	 * @param msg, message à envoyer
	 */
	public void envoyerMessageVersCentrOp(String msg) {
		lock.lock();
		
		try {
			//Tire un nombre aléatoire
			double value = rand.nextDouble();
			//Si le nombre aléatoire est plus grand que PROBABILITE_PERTE_MESSAGE,
			// le message est ajouté à la file de messages à destination du centre de contrôle.
			if(value>PROBABILITE_PERTE_MESSAGE)
				this.fileMessageVersCentrOp.enfiler(msg);

		}finally {
			lock.unlock();
		}
	}
	
	/**
	 * Méthode permettant d'envoyer un message vers le rover
	 * @param msg, message à envoyer
	 */
	public void envoyerMessageVersRover(String msg) {
		lock.lock();
		
		try {
			//Tire un nombre aléatoire
			double value = rand.nextDouble();
			//Si le nombre aléatoire est plus grand que PROBABILITE_PERTE_MESSAGE,
			// le message est ajouté à la file de messages à destination du Rover.
			if(value>PROBABILITE_PERTE_MESSAGE)
				this.fileMessageVersRover.enfiler(msg);

		}finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		
		while(true) {
			// a chaque cycle
			this.fileMessageVersRover.defiler();
			this.fileMessageVersCentrOp.defiler();

			// attend le prochain cycle
			try {
				Thread.sleep(TEMPS_CYCLE_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
