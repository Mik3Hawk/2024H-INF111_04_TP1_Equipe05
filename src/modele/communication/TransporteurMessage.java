package modele.communication;
/**
 * Classe qui implémente le protocol de communication entre le Rover
 * et le Centre d'opération.
 * <p>
 * Il se base sur une interprétation libre du concept de Nack:
 * https://webrtcglossary.com/nack/
 * <p>
 * Les messages envoyés sont mémorisé. À l'aide du compte unique
 * le transporteur de message peut identifier les Messages manquant
 * dans la séquence et demander le renvoi d'un Message à l'aide du Nack.
 * <p>
 * Pour contourner la situation ou le Nack lui-même est perdu, le Nack
 * est renvoyé periodiquement, tant que le Message manquant n'a pas été reçu.
 * <p>
 * C'est également cette classe qui gère les comptes unique.
 * <p>
 * Les messages reçu sont mis en file pour être traité.
 * <p>
 * La gestion des messages reçu s'effectue comme une tâche s'exécutant indépendamment (Thread)
 * <p>
 * Quelques détails:
 * - Le traitement du Nack a priorité sur tout autre message.
 * - Un message NoOp est envoyé périodiquement pour s'assurer de maintenir
 * une communication active et identifier les messages manquants en bout de séquence.
 * <p>
 * Services offerts:
 * - TransporteurMessage
 * - receptionMessageDeSatellite
 * - run
 *
 * @author Frederic Simard, ETS
 * @version Hiver, 2024
 */

import utilitaires.File;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class TransporteurMessage extends Thread {

    // compteur de message
    protected CompteurMessage compteurMsg;
    // lock qui protège la liste de messages reçu
    private ReentrantLock lock = new ReentrantLock();

    private File msgRecus, msgEnvoyes;

    /**
     * Constructeur, initialise le compteur de messages unique
     */
    public TransporteurMessage() {
        compteurMsg = new CompteurMessage();
    }

    /**
     * Méthode gérant les messages reçu du satellite. La gestion se limite
     * à l'implémentation du Nack, les messages spécialisé sont envoyés
     * aux classes dérivés
     * @param msg, message reçu
     */
    public void receptionMessageDeSatellite(Message msg) {
        lock.lock();
        try {
            //6.3.3
            if (msg instanceof Nack) {
                //quelle file ? parler au prof
            }

        } finally {
            lock.unlock();
        }
    }

    @Override
    /**
     * Tâche effectuant la gestion des messages reçu
     */
    public void run() {

        int compteCourant = 0;

        while (true) {

            lock.lock();

            try {

                /*
                 * (6.3.4) Insérer votre code ici
                 */

            } finally {
                lock.unlock();
            }

            // pause, cycle de traitement de messages
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * méthode abstraite utilisé pour envoyer un message
     * @param msg, le message à envoyer
     */
    abstract protected void envoyerMessage(Message msg);

    /**
     * méthode abstraite utilisé pour effectuer le traitement d'un message
     * @param msg, le message à traiter
     */
    abstract protected void gestionnaireMessage(Message msg);


}
