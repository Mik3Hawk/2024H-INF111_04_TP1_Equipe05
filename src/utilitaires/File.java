package utilitaires;

/**
 * Classe qui gère les files d'objets
 *
 * services offerts:
 * - estPleine
 * - estVide
 * - enfiler
 * - defiler
 *
 * @author Noah Tremblay, ETS
 * @version Fev, 2024
 */


//ATTENTION!!!! CETTE CLASSE N'EST PAS BONNE, LA FILE DOIT ETRE SOUS FORME DE CHAINE ET NON DANS UN TABLEAU!!!!!
public abstract class File {
    private Object[] donnees;
    private int premier,dernier;

    /**
     * ce constructeur initalise une file vide
     * @param taille: taille du tableau contenant la file
     */
    public File(int taille){
        donnees= new Object[taille];
        premier=0;
        dernier=0;
    }
    /**
     *méthode vérifiant si une file est vide en deux conditions
     * @return retourne vrai si la file est vide
     */
    public boolean estVide(){
        return this.premier==this.dernier && this.donnees[this.dernier]==null;
    }
    /**
     * Méthode vérifiant si une file est pleine en deux conditions
     * @return vrai si la file est pleine
     */
    public boolean estPleine(){
        return this.premier==this.dernier && this.donnees[this.dernier]!=null;
    }

    /**
     * Méthode permet d'ajouter un objet a la fin de la file
     * @param obj: l'objet qu'on veut enfiler
     */
    public void enfiler(Object obj){
        if(this.estPleine()){
            System.out.println("ERREUR: impossible d'enfiler, la file est pleine");
            System.exit(1);
        }
        else{
            this.donnees[this.dernier]=obj;
            this.dernier =(this.dernier+1)%this.donnees.length;
        }
    }

    /**
     * Méthode permmetant d'objetnir l'objet au début de la file et d'actualiser cette derniere
     * @return l'objet au début de la file
     */
    public Object defiler(){
        if(this.estVide()){
            System.out.println("ERREUR: impossible de défiler, la file est vide!");
            System.exit(1);
            return null;
        }
        else{
            Object obj=this.donnees[premier]; //on prend l'objet premier
            this.donnees[premier]=null;//on supprime l'objet dans la case du premier
            premier = (this.premier+1)%this.donnees.length; //on donne 0 au premier si ce dernier est a la fin du tablea
            return obj;
        }
    }
}
