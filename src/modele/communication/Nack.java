package modele.communication;

public class Nack extends Message{

    /**
     * constructeur qui fait appel au constructeur mère
     * @param compte, identifiant unique et incrémental pour indiquer la position du message
     */
    public Nack(int compte){
        super(compte);
    }

}
