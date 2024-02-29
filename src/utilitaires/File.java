package utilitaires;

import modele.communication.Message;
/**
 * Classe qui gère les files d'objets
 *
 * services offerts:
 * - getTaille
 * - estVide
 * - enfiler
 * - defiler
 * - peek
 * - toString
 *
 * @author Noah Tremblay, ETS
 * @version Fev, 2024
 */

import modele.communication.Message;

/**
 * Classe file
 * <p>
 * Services offerts:
 * - getTaille
 * - estVide
 * - enfiler
 * - defiler
 * - peek
 * - enfilerPrioritaire
 * - toString
 */

public class File<T extends Comparable<T>> {
    private Noeud premier, dernier;
    private int taille;

    /**
     * Constructeur avec un premier
     *
     * @param premier: premier objet le la file
     */
    public File(T premier) {
        Noeud n = new Noeud(premier, null);
        this.premier = n;
        this.dernier = n;
        this.taille = 1;
    }

    /**
     * Constructeur par défault
     */
    public File() {
        this.premier = this.dernier = null;
        this.taille = 0;
    }

    /**
     * accesseur taille (principaelement pour des tests)
     *
     * @return la taille de la file (int)
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * Méthode pour savoir si une file est vide
     *
     * @return True si la file est vide, sinon False
     */
    public boolean estVide() {
        return this.taille == 0;
    }

    /**
     * fonction qui permet d'enfiler un élément
     *
     * @param element: éléement qu'on souhaite enfilet
     */
    public void enfiler(T element) {
        Noeud n = new Noeud(element, null);
        if (this.estVide()) {
            this.premier = this.dernier = n;
        } else {
            this.dernier.suivant = n;
            this.dernier = n;
        }
        this.taille++;
    }

    /**
     * fonction qui permet de défiler noeud de la file
     *
     * @return l'objet du noeud défilé (donnee)
     */
    public T defiler() {
        if (this.estVide()) {
            System.out.println("ERREUR la file est vide, impossible de retirer un element!");
            System.exit(1); //code d'erreur
        }
        if (this.taille == 1) {
            System.out.println("DEBUG: attention la file est maitenant vide!");
        }
        T temp = this.premier.donnee;
        this.premier = this.premier.suivant;
        this.taille--;
        return temp;
    }

    /**
     * permet de voir l'élément au début de la file sans autant le défiler
     *
     * @return l'élément au début de la file
     */
    public T peek() {
        if (this.estVide()) {
            System.out.println("DEBUG: attention vous essayer de peek une file vide!");
            return null;
        } else {
            return this.premier.donnee;
        }
    }

    /**
     * Cette méthode permet d'enfiler un élément dans la file de facon prioritaire en utilisant equals
     *
     * @param element, élément a enfiler prioritairement
     */
    public void enfilerPrioritaire(T element) {

        if (this.estVide()) {
            Noeud n = new Noeud(element, null);
            this.premier = this.dernier = n;
        } else {

            Noeud courant = this.premier;
            //si l'élément est prioritaire sur tout les éléments de la file
            if (element.compareTo(courant.donnee) > 0) {
                System.out.println("j'enfile au debut");
                Noeud n = new Noeud(element, this.premier);
                this.premier = n;

            } else {
                //trouver ou inserer l'element
                while (courant.suivant != null && element.compareTo(courant.suivant.donnee) < 0) {
                    courant = courant.suivant;
                }

                //si on doit insérer a la fin de la file
                if (courant.suivant == null) {
                    System.out.println("j'enfile a la fin");
                    this.enfiler(element);
                }

                //insere dans la file
                else {
                    Noeud n = new Noeud(element, courant.suivant);
                    courant.suivant = n;
                }
            }
        }
        this.taille++;
    }

    /**
     * Méthode override to string (principalement a des fins de tests)
     *
     * @return les données en ordre de chaque noeud séparés par une virgule
     */
    @Override
    public String toString() {
        if (estVide()) {
            return "La file est vide.";
        }

        StringBuilder sb = new StringBuilder("La file: ");
        Noeud courant = premier;

        for (int i = 0; i < taille; i++) {
            sb.append(courant.donnee);

            if (i < taille - 1) {
                sb.append(", ");
            }
            courant = courant.suivant;
        }
        return sb.toString();
    }

    /**
     * classe noeud pour représenter les objets ainsi que leur suivant.
     */
    private class Noeud {
        T donnee;
        Noeud suivant;

        public Noeud(T data, Noeud next) {
            this.donnee = data;
            this.suivant = next;
        }
    }
}
