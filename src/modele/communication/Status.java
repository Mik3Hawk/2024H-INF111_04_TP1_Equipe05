package modele.communication;

import utilitaires.Vect2D;

/**
 * Classe qui gere les Status, extend la classe message
 * <p>
 * Contient un vecteur qui représente la position actuelle du rover
 * <p>
 * services offerts:
 * - getVect
 *
 * @author Noah Tremblay, Cédric Ruel, Houssam Moussafir ETS
 * @version Fev, 2024
 */
public class Status extends Message {
    private Vect2D vect;

    /**
     * Constructeur
     *
     * @param compte Le compte du message
     * @param vect   Le vecteur du rover
     */
    public Status(int compte, Vect2D vect) {
        super(compte);
        this.vect = vect;
    }

    /**
     * Accesseur du vecteur
     *
     * @return Le vecteur associée au message Status
     */
    public Vect2D getVect() {
        return this.vect;
    }
}
