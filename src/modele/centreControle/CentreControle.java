package modele.centreControle;

import modele.communication.*;
import modele.satelliteRelai.SatelliteRelai;
import utilitaires.Vect2D;

/**
 * Classe qui représente le centre de controle extend la classe transporteurMessage
 * <p>
 * Elle permet de gérer la réception et l'envoi de message depuis le CentreOp et contient une référence a son Satellite
 * <p>
 * services offerts:
 * - sequeceTest
 * - envoyerMessage
 * - gestionaireMessage
 *
 * @author Noah Tremblay, Cédric Ruel, Houssam Moussafir ETS
 * @version Fev, 2024
 */
public class CentreControle extends TransporteurMessage {

    private SatelliteRelai satelliteRelai;

    /**
     * Cette méthode privée gère la réception d'un Message Status
     *
     * @param msg Le Message Status a gérer
     */
    private void receptionStatus(Status msg) {
//        System.out.println("Status reçu par Centre de Controle " +
//                "\nPosition du Rover: x: " + msg.getVect().getX() + " y: " + msg.getVect().getY());
    }

    /**
     * Constructeur Principal
     *
     * @param satelliteRelai Le satellite a relier avec le CentreControle
     */
    public CentreControle(SatelliteRelai satelliteRelai) {
        this.satelliteRelai = satelliteRelai;
    }

    /**
     * Séquence de Test pour tester DEPLACER_ROVER
     */
    public void sequenceTest() {
        Commande msgCmd = null;
        msgCmd = new Commande(compteurMsg.getCompteActuel(), new Vect2D(25, 75));
        this.envoyerMessage(msgCmd);

        msgCmd = new Commande(compteurMsg.getCompteActuel(), new Vect2D(99, 15));
        this.envoyerMessage(msgCmd);

        msgCmd = new Commande(compteurMsg.getCompteActuel(), new Vect2D(10, 10));
        this.envoyerMessage(msgCmd);
    }

    // Définitions des méthodes abstraites

    /**
     * Envoie le message au rover via le Sateillite et l'enfile dans la file des messages envoyés du centreOp
     *
     * @param msg Le message a envoyer.
     */
    @Override
    protected void envoyerMessage(Message msg) {
        this.satelliteRelai.envoyerMessageVersRover(msg);
        this.msgEnvoyes.enfilerPrioritaire(msg);
//        System.out.println("CentreControle envoie : " + msg);
    }

    /**
     * Gestionaire des messages recus par le Centre op
     *
     * @param msg Le message recu
     */
    @Override
    protected void gestionnaireMessage(Message msg) {
//        System.out.println("CentreControle reçoit : " + msg);

        if (msg instanceof Status) {
            this.receptionStatus((Status) msg);
        }
    }


}
