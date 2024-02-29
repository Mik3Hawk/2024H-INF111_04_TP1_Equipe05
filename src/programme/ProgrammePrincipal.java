package programme;

import java.io.IOException;

import modele.communication.Message;
import modele.communication.Nack;
import modele.communication.NoOp;
import modele.satelliteRelai.SatelliteRelai;
import utilitaires.Vect2D;
import utilitaires.File;

public class ProgrammePrincipal {

    /**
     * Programme principale, instancie les éléments de la simulation,
     * les lie entre eux, puis lance la séquence de test.
     *
     * @param args, pas utilisé
     */
    public static void main(String[] args) {

		/*SatelliteRelai satellite = new SatelliteRelai();
		satellite.start();

		//TEST SatelliteRelais
		satellite.envoyerMessageVersRover("allo test 1");
		satellite.envoyerMessageVersRover("allo test 2");
		satellite.envoyerMessageVersRover("allo test 3");

		//boucle qui effectue 1 itération a chaque 5 secondes 10 fois
		for (int i = 0; i < 10; i++) {

			System.out.println("Itération " + (i + 1));

			System.out.println(satellite.getFileMessageVersRover());
			// Attente de 5 secondes trouvé sur internet
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/


        //TEST Vect2D
        //testVect2D();

        //TEST File
        testFile();
    }

//=================================================================================================//

    /**
     * Fonction de test pour la classe Vect2D
     */

    public static void testVect2D() {
        Vect2D v = new Vect2D();
        System.out.println(v);

        //============================================//
        //avec parametre
        Vect2D testPar = new Vect2D(1.0, 3.0);
        System.out.println(testPar);

        //============================================//
        //copie de vect2d
        Vect2D copie = new Vect2D(testPar);
        System.out.println(copie);

        //============================================//
        //get x
        double x = copie.getX();
        System.out.println(x);

        //============================================//
        //get y
        double y = copie.getY();
        System.out.println(y);

        //============================================//
        //longueur du vecteur
        double longueur = copie.getLongueur();
        System.out.println("la longeur du vecteur est " + longueur);

        //============================================//
        //angle
        double angle = copie.getAngle();
        System.out.println("L'angle (rad): " + angle);

        //============================================//
        //Calculdiff
        Vect2D vecteur1 = new Vect2D(3.0, 4.0);
        Vect2D vecteur2 = new Vect2D(1.0, 2.0);

        //============================================//
        // Calcul de la différence entre les deux vecteurs
        Vect2D difference = vecteur2.calculerDiff(vecteur1);
        System.out.println("Différence entre les vecteurs :" + difference);

        //============================================//
        //diviser
        Vect2D c = new Vect2D(2.0, 4.0);
        c.diviser(2);
        System.out.println("Diviser : " + c);

        //Ajouter
        c.ajouter(2, 10);
        System.out.println("Somme : " + c);

        //toString
        System.out.println("toString" + c);

        //Equals
        Vect2D vect1 = new Vect2D(3.0, 4.0);
        Vect2D vect2 = new Vect2D(2.0, 4.0);

        System.out.println(vect1.equals(vect2));
    }

//=================================================================================================//

    /**
     * Fonction de Test pour la classe File
     */

    public static void testFile() {

        //============================================//
        //test général
        File<String> file1 = new File<>();
        String a = "a", b = "b", c = "c", d = "d";
        file1.enfiler(a);
        file1.enfiler(b);
        if (file1.defiler().equals(a))
            System.out.println("a = a, OK");
        else
            System.out.println("a != a, ERREUR");
        if (file1.defiler().equals(b))
            System.out.println("b = b, OK");
        else
            System.out.println("b != b, ERREUR");

        //============================================//
        //test estVide
        if (file1.estVide())
            System.out.println("file est vide, OK");
        else
            System.out.println("File n'est pas vide, ERREUR");

        //============================================//
        //test defiler
        //file1.defiler();

        //============================================//
        //test taille
        System.out.println(file1.getTaille() + " <- si: 0, OK");
        file1.enfiler(a);
        file1.enfiler(b);
        file1.enfiler(c);
        file1.enfiler(d);
        System.out.println(file1.getTaille() + " <- si: 4, OK");

        //============================================//
        //test to string
        System.out.println(file1 + " <- si: a,b,c,d, OK");
        System.out.println(file1.getTaille() + " <- si: 4, OK");
        System.out.println(file1.defiler() + " <- si: a, OK");
        System.out.println(file1.getTaille() + " <- si: 3, OK");
        System.out.println(file1 + " <- si: b,c,d, OK");

        while (!file1.estVide()) {
            file1.defiler();
        }
        System.out.println(file1.getTaille() + " <- si: 0, OK");

        //============================================//
        //test enfilerPrioritaire
        file1.enfilerPrioritaire("b");
        System.out.println(file1.getTaille() + " <- si: 1, OK");
        System.out.println(file1);
        file1.enfilerPrioritaire("b");
        System.out.println(file1.getTaille() + " <- si: 2, OK");
        file1.enfilerPrioritaire("c");
        System.out.println(file1.getTaille() + " <- si: 3, OK");
        System.out.println(file1);
        file1.enfilerPrioritaire("d");
        file1.enfilerPrioritaire("e");
        file1.enfilerPrioritaire("f");
        System.out.println(file1 + " <- si: f,e,d,c,b,a OK");
        System.out.println(file1.defiler() + " <- si: f OK");
        file1.enfilerPrioritaire("e");
        file1.enfilerPrioritaire("f");
        System.out.println(file1 + " <- si: f,e,e,d,c,b,a OK");
        file1.enfilerPrioritaire("d");
        file1.enfilerPrioritaire("b");
        System.out.println(file1 + " <- si: f,e,e,d,d,c,b,b,a OK");
        file1.enfilerPrioritaire("a");


        //============================================//
        //test peek
        System.out.println(file1.peek() + " <- si: f OK");
        while (!file1.estVide()) {
            file1.defiler();
        }
        System.out.println(file1.peek() + " <- si: null OK");

        //============================================//
        //test file avec message
        File<Message> fileMsg = new File<>();
        Message nack1 = new Nack(1);
        Message nack2 = new Nack(2);
        Message nack3 = new Nack(3);
        Message nack4 = new Nack(4);
        Message noop1 = new NoOp(1);
        Message noop2 = new NoOp(2);
        Message noop3 = new NoOp(3);
        Message noop4 = new NoOp(4);

        fileMsg.enfilerPrioritaire(nack1);
        fileMsg.enfilerPrioritaire(noop2);
        System.out.println(fileMsg + " <- si: nack1,noop2 OK");
        fileMsg.enfilerPrioritaire(nack3);
        fileMsg.enfilerPrioritaire(noop4);
        fileMsg.enfilerPrioritaire(nack4);
        fileMsg.enfilerPrioritaire(noop1);
        fileMsg.enfilerPrioritaire(nack2);
        fileMsg.enfilerPrioritaire(noop3);
        System.out.println(fileMsg + " <- si: nack1, nack2, nack3, nack4, noop1, noop2, noop3, noop4 OK");


    }
}
