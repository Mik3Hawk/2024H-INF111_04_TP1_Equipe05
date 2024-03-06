package modele.centreControle;

import modele.communication.*;
import modele.satelliteRelai.SatelliteRelai;
import utilitaires.File;
import utilitaires.Vect2D;

public class CentreControle extends TransporteurMessage {

    private SatelliteRelai satelliteRelai;

    private void receptionStatus(Status msg) {
        System.out.println("Status reçu par Centre de Controle " +
                "\nPosition du Rover: x: " + msg.getVect().getX() + " y: " + msg.getVect().getY());
    }

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
    @Override
    protected void envoyerMessage(Message msg) {
        this.satelliteRelai.envoyerMessageVersRover(msg);
        this.msgEnvoyes.enfilerPrioritaire(msg);
        //System.out.println("CentreControle envoie : " + msg);
    }

    @Override
    protected void gestionnaireMessage(Message msg) {
        //System.out.println("CentreControle reçoit : " + msg);

        if (msg instanceof Status) {
            this.receptionStatus((Status) msg);
        }
    }

    public CentreControle(SatelliteRelai satelliteRelai) {
        this.satelliteRelai = satelliteRelai;
    }

}
