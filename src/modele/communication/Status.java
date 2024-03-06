package modele.communication;

import utilitaires.Vect2D;

public class Status extends Message {
    private Vect2D vect;

    public Status(int compte, Vect2D vect) {
        super(compte);
        this.vect = vect;
    }

    public Vect2D getVect() {
        return this.vect;
    }

}
