package modele.rover;

import modele.communication.*;
import modele.satelliteRelai.SatelliteRelai;
import utilitaires.Vect2D;

/**
 * Classe qui représente le Rover extend la classe transporteurMessage
 * <p>
 * Elle permet de gérer la réception et l'envoi de message depuis le Rover et contient une référence a son Satellite
 * Le rover peut aussi bouger sur commande d'un message Commande
 * <p>
 * services offerts:
 * - sequeceTest
 * - envoyerMessage
 * - gestionaireMessage
 *
 * @author Noah Tremblay, Cédric Ruel, Houssam Moussafir ETS
 * @version Fev, 2024
 */

public class Rover extends TransporteurMessage {

    private SatelliteRelai satelliteRelai;
    private Vect2D pos;
    private static final double VITESSE_MparS = 0.5; //0.5

    /**
     * Constructeur du défault qui relie le Rover
     *
     * @param satelliteRelai Le sateiliteRelai qu'on veut lier au Rover
     * @param posInitiale    Le centreOp qu'on veut lier au Rover
     */
    public Rover(SatelliteRelai satelliteRelai, Vect2D posInitiale) {
        this.satelliteRelai = satelliteRelai;
        this.pos = posInitiale;
    }

    /**
     * Méthode qui permet de déplacer un rover a un destination
     *
     * @param destination La ou on veut déplacer le rover
     */
    private void deplacerRover(Vect2D destination) {
        int i;
        Vect2D vectDeplacement;

        //Calcul le déplacement à effectuer (destination - position actuelle)
        Vect2D deplacement = this.pos.calculerDiff(destination);

        //Calcul de la distance du déplacement
        double distance = deplacement.getLongueur();

        //Calcul du temps requis (distance/vitesse)
        double temps = distance / VITESSE_MparS;

        //Calcul de l’angle du déplacement
        double angle = deplacement.getAngle();

        //Envoyer un message status indiquant la position initiale du Rover
        this.envoyerMessage(new Status(this.compteurMsg.getCompteActuel(), this.pos));
        System.out.println("Le rover s'aprête a bouger pendant " + temps + " secondes et il est a :" + this.pos);

        //Pour le nombre de secondes entière que dure le déplacement
        for (i = (int) (temps / 1.0); i > 0; i--) {
            //ajouter (cos(angle)*VITESSE,sin(angle)*VITESSE) à la position
            this.pos.ajouter(Math.cos(angle) * VITESSE_MparS, Math.sin(angle) * VITESSE_MparS);
            System.out.println("Le rover avance il est maintenant a :" + this.pos + ". Il lui reste " + i + " déplacements");

            //Envoyer un message status indiquant la position initiale du Rover
            this.envoyerMessage(new Status(this.compteurMsg.getCompteActuel(), this.pos));
            //L'affichage du statut semble incorrect, mais en plaçant un point d'arrêt sur cette ligne(40)
            // en utilisant le débogage step into, le statut s'affiche correctement.
        }

        //Calcul de la fraction de secondes requise pour terminer le déplacement. (temps%1.0)
        temps %= 1.0;

        //Pour la dernière fraction de seconde du déplacement
        this.pos.ajouter(Math.cos(angle) * VITESSE_MparS * temps, Math.sin(angle) * VITESSE_MparS * temps);
        System.out.println("Le rover a fini son dépacement il est a :" + this.pos);

        //envoyer un message status indiquant la position du Rover
        this.envoyerMessage(new Status(this.compteurMsg.getCompteActuel(), this.pos));
    }

    // Définitions des méthodes abstraites

    @Override
    protected void envoyerMessage(Message msg) {
        this.satelliteRelai.envoyerMessageVersCentrOp(msg);
        this.msgEnvoyes.enfilerPrioritaire(msg);
        //System.out.println("Rover envoie : " + msg);
    }

    @Override
    protected void gestionnaireMessage(Message msg) {
        if (msg instanceof Commande) {
            switch (((Commande) msg).getCommande()) {

                case DEPLACER_ROVER:
                    System.out.println("on veut deplacer le rover a :" + ((Commande) msg).getVect());
                    deplacerRover(((Commande) msg).getVect());
                    break;

                case PRENDRE_PHOTOS:
                    System.out.println("on veut que le rover prenne une photo");
                    //PAS À IMPLEMENTER
                    break;

                case NULLE:
                    System.out.println("on veut rien faire avec le rover");
                    //PAS À IMPLEMENTER
                    break;
            }
        }
        System.out.println("Rover reçoit : " + msg);
    }
}
