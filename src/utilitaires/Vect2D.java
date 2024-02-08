package utilitaires;
/**
 * Classe qui gère les  vecteurs 2D
 *
 * services offerts:
 * 	- Accesseurs x/y: getX/getY
 * 	- getCompteActuel
 *
 * @author Noah Tremblay, ETS
 * @version Fev, 2024
 */

public class Vect2D {
    private double x,y;

    //constructeur par défault(initie a 0,0)
    public Vect2D(){
        this.x=0.0;
        this.y=0.0;
    }
    //constructeur par parametres
    public Vect2D(double x,double y){
        this.x=x;
        this.y=y;
    }
    //constructeur par copie
    public Vect2D(Vect2D vecteur){
        this.x= vecteur.x;
        this.y= vecteur.y;
    }
    //accesseur longueur X
    public double getX(){
        return this.x;
    }
    //accesseur longueur Y
    public double getY(){
        return this.y;
    }
    //accesseur longueur
    public double getLongueur(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    //accesseur angle
    public double getAngle(){
        return Math.atan2(this.y,this.x);
    }
    //calculer la différence entre deux vecteurs
    public Vect2D calculerDiff(Vect2D posFin){
        double xS,yS;
        Vect2D vectRes;

        xS = posFin.getX()-this.x;
        yS = posFin.getY()-this.y;

        vectRes = new Vect2D(xS,yS);
        return vectRes;
    }
    //diviser le vecteur
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
    //ajouter au vecteur
    public void ajouter(double x,double y){
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString(){
        return "("+this.x+", "+this.y+")";
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
