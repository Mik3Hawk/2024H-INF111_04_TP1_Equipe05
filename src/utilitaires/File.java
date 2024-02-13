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

/**
 * Classe file
 */
public class File {
    private Noeud premier,dernier;
    private int taille;

    /**
     * classe noeud pour représenter les objets ainsi que leur suivant.
     */
    private class Noeud{
        Object donnee;
        Noeud suivant;
        public Noeud(Object data, Noeud next) {
            this.donnee = data;
            this.suivant = next;
        }
    }

    /**
     * Constructeur avec un premier
     * @param premier: premier objet le la file
     */
    public File(Object premier){
        Noeud n = new Noeud(premier,null) ;
        this.premier = n;
        this.dernier = n;
        this.taille++;
    }
    /**
     * Constructeur par défault
     */
    public File(){
        this.premier=this.dernier=null;
        this.taille=0;
    }

    /**
     * accesseur taille
     * @return la taille de la file (int)
     */
    public int getTaille(){
        return this.taille;
    }
    public boolean estVide(){
        return this.taille==0;
    }

    /**
     * fonction qui permet d'enfiler un élément
     * @param element: éléement qu'on souhaite enfilet
     */
    public void enfiler(Object element){
        Noeud n = new Noeud(element,null);
        if(this.estVide()){
            this.premier=this.dernier=n;
        }
        else{
            this.dernier.suivant = n;
            this.dernier = n;
        }
        this.taille++;
    }

    /**
     * fonction qui permet de défiler un element de la file
     * @return l'objet défilé
     */
    public Object defiler(){
        if (this.estVide()){
            System.out.println("ERREUR la file est vide, impossible de retirer un element!");
            System.exit(1); //code d'erreur
        }
        if (this.taille ==1){
            System.out.println("DEBUG: attention la file est maitenant vide!");
        }
        Noeud temp = this.premier;
        this.premier = temp.suivant;
        this.taille--;
        return temp.donnee;
    }

    @Override

    public String toString(){
        if (this.estVide()) {
            return "La file est vide.";
        }
        String retour="La file: ";
        Noeud courant = this.premier;
        int i;
        for (i=0;i<this.taille;i++){
            retour+=courant.donnee.toString();
            if(i!=this.taille-1){
                retour+=",";
            }
            courant=courant.suivant;
        }
        return retour;
    }
}
