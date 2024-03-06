package modele.communication;

import utilitaires.Vect2D;

public class Commande extends Message {
    private eCommande commande;
    private Vect2D vect;

    public Commande(int compte, eCommande commande) {
        super(compte);
        this.commande = commande;
    }

    public Commande(int compte, Vect2D vect) {
        super(compte);
        this.commande = eCommande.DEPLACER_ROVER;
        this.vect = vect;
    }

    public eCommande getCommande() {
        return this.commande;
    }

    public Vect2D getVect() {
        if (this.commande != eCommande.DEPLACER_ROVER) {
            System.out.println("ERREUR la commande n'est pas de type DEPLACER_ROVER, impossible d'obtenir un vecteur!");
            System.exit(1); //code d'erreur
        }
        return this.vect;
    }
}
