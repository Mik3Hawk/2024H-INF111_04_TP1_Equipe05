package modele.communication;

/**
 * Classe de base qui définit un message.
 * <p>
 * Elle contient les informations permettant d'identifier la position
 * du message dans la séquence et le temps de son envoi
 * <p>
 * Services offerts:
 * - Message
 * - getTempsEnvoi
 * - setTempsEnvoi
 * - getCompte
 *
 * @author Frederic Simard, ETS
 * @version Ete, 2021
 */


public abstract class Message implements Comparable<Message> {

    private int compte;
    private long tempsEnvoi;

    /**
     * Constructeur, requiert un compte unique pour identifier sa position dans
     * la séquence de messages envoyés
     *
     * @param compte, identifiant unique et incrémental
     */
    public Message(int compte) {
        this.compte = compte;
        tempsEnvoi = System.currentTimeMillis(); // prend en note le temps de l'envoi
    }

    /**
     * Accesseur informateur, pour obtenir le temps de l'envoi
     *
     * @return long, temps de l'envoi
     */
    public long getTempsEnvoi() {
        return tempsEnvoi;
    }

    /**
     * Accesseur mutateur, pour mettre à jours le temps de l'envoi
     */
    public void setTempsEnvoi(long tempsEnvoi) {
        this.tempsEnvoi = tempsEnvoi;
    }

    /**
     * Accesseur informateur, pour obtenir le compte unique
     *
     * @return int, compte unique
     */
    public int getCompte() {
        return compte;
    }

    /**
     * méthode compareTo qui compare deux Messages
     *
     * @param msg2 message qu'on veut comparere
     * @return -1 si msg1<msg2, 0 si msg1=msg2, +1 si msg1>msg2
     */
    public int compareTo(Message msg2) {
        if (this instanceof Nack && !(msg2 instanceof Nack)) {
            return 1;
        }
        if (!(this instanceof Nack) && msg2 instanceof Nack) {
            return -1;
        }
        //dans ce cas les deux messages sont du meme "type"
        return msg2.compte - this.compte;
    }

    @Override
    public String toString() {
        String s = Integer.toString(this.compte);
        if (this instanceof Nack) {
            return "nack" + s;
        }
        if (this instanceof NoOp) {
            return "noop" + s;
        }
        if (this instanceof Commande) {
            return "Commande" + s + "," + ((Commande) this).getCommande() + ((Commande) this).getVect();
        }
        if (this instanceof Status) {
            return "Status" + s + " :" + ((Status) this).getVect();
        }

        return "msg" + s;
    }
}
