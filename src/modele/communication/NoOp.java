package modele.communication;

public class NoOp extends Message{

    /**
     * constructeur qui fait appel au constructeur mère
     * @param compte, identifiant unique et incrémental pour indiquer la position du message
     */
    public NoOp(int compte){
        super(compte);
    }
}
