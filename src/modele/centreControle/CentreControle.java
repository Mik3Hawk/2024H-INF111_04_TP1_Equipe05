package modele.centreControle;

import modele.communication.Message;
import modele.communication.TransporteurMessage;
import modele.satelliteRelai.SatelliteRelai;
import utilitaires.File;

public class CentreControle extends TransporteurMessage {

    private SatelliteRelai satelliteRelai;

    // Définitions des méthodes abstraites
    @Override
    protected void envoyerMessage(Message msg) {
        satelliteRelai.envoyerMessageVersRover(msg);
        msgEnvoyes.enfilerPrioritaire(msg);
        System.out.println("CentreControle envoie : " + msg);
    }

    @Override
    protected void gestionnaireMessage(Message msg) {
        //System.out.println("CentreControle reçoit : " + msg);
    }


    public CentreControle(SatelliteRelai satelliteRelai) {
        this.satelliteRelai = satelliteRelai;
    }

}
