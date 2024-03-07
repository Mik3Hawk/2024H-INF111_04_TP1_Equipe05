package modele.communication;

import utilitaires.Vect2D;

/**
 * Classe qui représente les Commandes extend la classe Message
 * <p>
 * services offerts:
 * - getCommande
 * - getVect
 *
 * @author Noah Tremblay, Cédric Ruel, Houssam Moussafir ETS
 * @version Fev, 2024
 */
public class Commande extends Message {
    private eCommande commande;
    private Vect2D vect;

    /**
     * Constructeur de Commande pour les commandes qui ne nécéssitent pas de vecteurs
     *
     * @param compte,   compte du message
     * @param commande, la commande a envoyer
     */
    public Commande(int compte, eCommande commande) {
        super(compte);

        if (commande == eCommande.DEPLACER_ROVER) {
            System.out.println("ERREUR la commande est de type DEPLACER_ROVER, vous devez fournir un vecteur!");
            System.exit(1); //code d'erreur
        }

        this.commande = commande;
        this.vect = null;
    }

    /**
     * Constructeur de Commande pour les de type DEPLACER_ROVER.
     *
     * @param compte Le compte du message.
     * @param vect   Le point ou on veut que le rover se rende.
     */
    public Commande(int compte, Vect2D vect) {
        super(compte);

        this.commande = eCommande.DEPLACER_ROVER;
        this.vect = vect;
    }

    /**
     * Obtient la commande du message Commande.
     *
     * @return La commande.
     */
    public eCommande getCommande() {
        return this.commande;
    }

    /**
     * Obtient le vecteur associé à une commande de type DEPLACER_ROVER.
     *
     * @return Le vecteur.
     */
    public Vect2D getVect() {
        if (this.commande != eCommande.DEPLACER_ROVER) {
            System.out.println("ERREUR la commande n'est pas de type DEPLACER_ROVER, impossible d'obtenir un vecteur!");
            System.exit(1); //code d'erreur
        }

        return this.vect;
    }
}
