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
public class Noeud{
    Object donnee;
    File.Noeud suivant;
}
public abstract class File {
    private Noeud premier,dernier;
    pivate taille;


}
