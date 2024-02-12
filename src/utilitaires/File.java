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
 * classe noeud pour représenter les objets ainsi que leur suivant.
 */
class Noeud{
    Object donnee;
    Noeud suivant;
    public Noeud(Object data, Noeud next) {
        this.donnee = data;
        this.suivant = next;
    }
}
public abstract class File {
    private Noeud premier,dernier;
    private int taille;

    public File(Object premier){
        Noeud n = new Noeud(premier,null) ;
        this.premier = n;
        this.dernier = n;
        this.taille++;
    }
    public void ajouterElement(Object element){
        Noeud n = new Noeud(element,null);
        this.dernier.suivant = n;
        this.taille++;
    }
    public Object enleverElement(){
        if (this.taille <=0){
            System.out.println("ERREUR impossible de diviser "+this+"par 0!");
            System.exit(1); //code d'erreur
        }
        if (this.taille ==1){ //PAS FINI
            System.out.println("ERREUR impossible de diviser "+this+"par 0!");
            System.exit(1); //code d'erreur
        }

        Noeud temp = this.premier;
        this.premier = temp.suivant;
        this.taille--;
        return temp.donnee;
    }


}
