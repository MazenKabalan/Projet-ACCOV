/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameleonPck;

//

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

//class Simulation(themainclass)
//

/**
 * classe qui simule la mutation des cameleons 
 * contient la fonction main du projet
 * 
 * @author mazen
 */
public class Simulation{
    
    /**
     * affiche le comportement des cameleons sur le system.out set sur l'interface graphique
     * 
     */
    public static final boolean AfficherTravailCameleon = true;

    /**
     * definit le retard entre les fonctions d'un cameleon (en secondes)
     * 
     */
    public static final long timeOutInSeconds = (long) 1;

    /**
     * definit la taille du fonte utilisee su l'interface graphique
     * 
     */
    public static final int fontSize = 16;
    
    /**
     * definit la liste des cameleons qui doivent muter (un couleur pour chacun)
     * N.B.: l'interface graphique peut afficher seulement au plus les comportements de 9 cameleons
     *       en tant que pour le System.out, pas de limite sur le nombre des cameleons
     * 
     */
    static Couleur[] LesCouleurs = 
    { Couleur.JAUNE,
      Couleur.BLEU,
      Couleur.ROUGE,
      Couleur.BLEU,
      Couleur.JAUNE,
      Couleur.BLEU,
      Couleur.BLEU,
      Couleur.JAUNE,
      Couleur.BLEU
    };
    
    static Cameleon[] LeCameleon = new Cameleon[LesCouleurs.length];
    
    /**
     * fonction main responsable du lancement de la simulation des mutations des cameleons 
     * @param args
     */
    public static void main(String args[]){
        
        /**
         * creation d'une instance de l'interface graphique
         */
        CameleonGraphicalDisplay camGraDisp = new CameleonGraphicalDisplay();
        
        /**
         * creation d'un thread cameleon pour chaque couleur dans la liste "LesCouleurs"
         * 
         */
        for(int i = 0 ; i < LesCouleurs.length; i++){
            LeCameleon[i] = new Cameleon(i+1, LesCouleurs[i], camGraDisp);
        }
        
        /** 
         * lancement de l'interface graphique
         * 
         */
        if (Simulation.AfficherTravailCameleon)
        {
         java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                        camGraDisp.setVisible(true);
                }
         });   
        }
        
        
        /** 
         * lancement des thread cameleons
         *  
         */
        for(int i=0; i < LesCouleurs.length ; i++){
            LeCameleon[i].start();
            try {
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        
        
        
        
    }
}

