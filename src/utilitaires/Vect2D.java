package utilitaires;
/**
 * Classe qui gère les  vecteurs 2D
 *
 * services offerts:
 * 	- getlongueur
 * 	- getAngle
 * 	- calculerDiff
 * 	- diviser
 * 	- ajouter
 *
 * @author Noah Tremblay, ETS
 * @version Fev, 2024
 */

public class Vect2D {
    private double x,y;
    /**
     * Constructeur par défault, initalise le vecteur a (0,0)
     */
    public Vect2D(){
        this.x=0.0;
        this.y=0.0;
    }
    /**
     * Constructeur qui initalise le vecteur au données en paramètres
     * @param x: valeur de x
     * @param y: valeur de y
     */
    public Vect2D(double x,double y){
        this.x=x;
        this.y=y;
    }
    /**
     * Constructeur initalise le vecteur en copiant un autre vecteur
     * @param vecteur: vecteur qu'on souhaite copier
     */
    public Vect2D(Vect2D vecteur){
        this.x= vecteur.x;
        this.y= vecteur.y;
    }
    /**
     * Méthode qui retourne la valeur de x du vecteur
     * @return la valeur de x du vecteur
     */
    public double getX(){
        return this.x;
    }
    /**
     * Méthode qui retourne la valeur de y du vecteur
     * @return la valeur de y
     */
    public double getY(){
        return this.y;
    }
    /**
     * Méthode qui calcule la longueur du vecteur
     * @return la longueur du vecteur
     */
    public double getLongueur(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    /**
     * Méthode qui calcule l'orientation θ du vecteur
     * @return l'orientation du vecteur (degrés)
     */
    public double getAngle(){
        return Math.atan2(this.y,this.x);
    }
    /**
     * Méthode qui calcule le vecteur résultant d ela différence entre deux vecteurs
     * @param posFin: un vecteur auquel on soustrait le vecteur this
     * @return un vecteur, résultat de l'opéation
     */
    public Vect2D calculerDiff(Vect2D posFin){
        double xS,yS;
        Vect2D vectRes;

        xS = posFin.getX()-this.x;
        yS = posFin.getY()-this.y;

        vectRes = new Vect2D(xS,yS);
        return vectRes;
    }

    /**
     * Méthode qui permet de diviser un vecteur
     * @param div: nombre parlequel le vecteur est divisé
     */
    public void diviser(double div){
        if(div==0){
            System.out.println("ERREUR impossible de diviser "+this+"par 0!");
            System.exit(1); //code d'erreur
        }
        else {
            this.x /=div;
            this.y /=div;
        }
    }
    /**
     * Méthode qui permet d'ajouter au composantes d'un vecteur
     * @param x: valeur a ajouter au x
     * @param y: valeur a ajouter au y
     */
    public void ajouter(double x,double y){
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj==null)
            return false;
        if(!(obj instanceof Vect2D))
            return false;
        Vect2D vect = (Vect2D) obj;
        return vect.getX()==this.x && vect.getY()==this.y;
    }

}
