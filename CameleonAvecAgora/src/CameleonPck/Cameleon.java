/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameleonPck;

//

import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

//class Cameleon
//

/**
 * Represente les cameleons qui demandent les mutations
 * un thread pour chaque cameleon
 * un cameleon est identifie par un "id", un "couleur", et l'agora dans lequelle doit muter 
 * 
 * @author mazen
 */

public class Cameleon extends Thread {
    private Agora agora;
    private int id,autreId;
    private Couleur monCouleur,monAncienCouleur,autreCouleur;
    private boolean premierAppel;
    
    /**
     * le constructeur du classe
     * 
     * @param m
     * @param id
     * @param c
     * @param PremierAppel
     */
    public Cameleon(Agora m,int id,Couleur c, boolean PremierAppel){
        this.agora=m;
        this.id=id;
        this.monCouleur=c;
        this.premierAppel =  PremierAppel;
    }
    
    /**
     *
     * @return
     */
    public boolean getPremierAppel(){
        return premierAppel;
    }
    
    /**
     * sert a afficher et a registrer le comportement des mutations des cameleons
     * fonctionne seulement si [Simulation.AfficherTravailCameleon = true]
     * 1- affiche le comportement sur le System.out
     * 2- affiche le statut de chaque cameleon sur une interface graphique JFrame
     * 
     * @param mess
     * @param mutation
     * @param imprimerMutation 
     */ 
    private void Message(String mess, boolean mutation, boolean imprimerMutation){
       
        if (Simulation.AfficherTravailCameleon)
        {

            String displayCameleonInTextArea;
            Font f,f2;
            int borderThickness;
            
            System.out.println( "(" + id +") Je suis " + monCouleur.toString() + " et " + mess);
            
            f2 = new Font("Verdana", Font.BOLD, Simulation.fontSize);

            if (imprimerMutation)
            {
               System.out.println( "Mutation faite entre " +
                            "Caméléon[" + id +"," + Couleur.AfficherCouleur(monAncienCouleur.couleurInterne) + "] et Caméléon[" + autreId +"," + Couleur.AfficherCouleur(autreCouleur.couleurInterne) + "]" +
                            " ==> " +
                            "les deux caméléons prennent la couleur " + Couleur.AfficherCouleur(monCouleur.couleurInterne)
                          ); 

               agora.getCameleonGraphicalDisplay().setTextArea(99, "                            Dernier mutation faite entre Caméléon #" + agora.getAId() +" et Caméléon #" + agora.getBId() , monCouleur.couleurInterne,f2,0);    

            }
            

            if (!mutation)
              {
               f = new Font("Verdana", Font.PLAIN, Simulation.fontSize);
               borderThickness = 0;
              }
            else
              {
               f = new Font("Verdana", Font.BOLD, Simulation.fontSize-2);
               borderThickness = 2;
              }
            
            displayCameleonInTextArea = "\n" +
                                        "[Caméléon #"+ this.id + "] : \n" +
                                        "\n" + mess;
           
            agora.getCameleonGraphicalDisplay().setTextArea(this.id, displayCameleonInTextArea, monCouleur.couleurInterne,f,borderThickness);    

        }
   }
    
    /** 
     * fonction manger 
     */
    private void Manger(){
        Message("je mange",false,false);
    }
    
    /**
     * fonction s'entrainer
     */
    private void Entrainer(){
        Message("je m'entraine",false,false);
    }
    
    /**
     * fronction aller a l'agora ou le mail pour demander une rencontre
     */
    private void AllerAuMail(){
        Message("je vais à l'agora",false,false);
    }
    
    /**
     * fonction se rencontrer avec un autre cameleon sur l'agora
     */
    private void Muter(){
        Cameleon c;
        
        Message("je vais muter",false,false);
        monAncienCouleur = new Couleur(monCouleur.getCouleurInterne());
        
        c =  agora.Cooperation(id, monCouleur);
        autreCouleur = c.monCouleur;
        autreId = c.id;
        
        monCouleur=monCouleur.CouleurComplementaire(autreCouleur);
        if (c.getPremierAppel())
          Message("j'ai fait une mutation avec #" + autreId,true,true);
        else
          Message("j'ai fait une mutation avec #" + autreId,true,false);
        
    }
    
    /**
     * fonction run du thread cameleon
     * peut etre ralenti ou lancee rapidement en modifiant le parametre [Simulation.timeOutInSeconds]
     * un cameleon va manger, s'entrainer avant d'aller demander une rencontre sur l'agora
     */
    public void run(){
        while(true){
            try {
                Manger();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
                
                Entrainer();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
                
                AllerAuMail();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
                
                Muter();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cameleon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

