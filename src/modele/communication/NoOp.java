package modele.communication;

/**
 * Classe qui permet de gerer les NoOp extends la classe Message
 *
 * @author Noah Tremblay, Cédric Ruel, Houssam Moussafir ETS
 * @version Fev, 2024
 */
public class NoOp extends Message {

    /**
     * constructeur qui fait appel au constructeur mère
     *
     * @param compte, identifiant unique et incrémental pour indiquer la position du message
     */
    public NoOp(int compte) {
        super(compte);
    }
}
