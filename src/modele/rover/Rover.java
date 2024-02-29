package modele.rover;

import modele.communication.Message;
import modele.communication.TransporteurMessage;
import modele.satelliteRelai.SatelliteRelai;
import utilitaires.File;

public class Rover extends TransporteurMessage {
    private SatelliteRelai satelliteRelai;


    // Définitions des méthodes abstraites
    @Override
    protected void envoyerMessage(Message msg) {
        satelliteRelai.envoyerMessageVersCentrOp(msg);
        msgEnvoyes.enfilerPrioritaire(msg);
        //System.out.println("Rover envoie : " + msg);
    }

    @Override
    protected void gestionnaireMessage(Message msg) {
        System.out.println("Rover reçoit : " + msg);
    }

    public Rover(SatelliteRelai satelliteRelai) {
        this.satelliteRelai = satelliteRelai;
    }
}
