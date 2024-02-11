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

public abstract class File {
    public class Noeud{
        Object donnee;
        Noeud suivant;
    }

    private Noeud premier,dernier;
    pivate taille;


}
