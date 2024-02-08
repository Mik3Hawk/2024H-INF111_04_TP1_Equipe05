package utilitaires;

public class File {

    private Object[] donnees;
    private int premier,dernier;

    public int taille(){
        int n ;
        n= this.donnees.length;
        return (n - premier + dernier) % n;
    }

}
