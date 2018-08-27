/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameleonPck;

//
//class Cameleon
//

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represente les cameleons qui demandent les mutations
 * un thread pour chaque cameleon
 * un cameleon est identifie par un "id", un "couleur", et l'interface graphique dans lequelle doit afficher ces comportments 
 * utilise les "variables atomiques" pour synchroniser entre les differentes demandes de mutation des cameleons,
 * les demandes de mutation sont faites directement entre les cameleons sans utiliser aucune interface intermediare (peer to peer)
 *
 * @author mazen
 */
public class Cameleon extends Thread {
    
    final static Object moniteur = new Object();
    private CameleonGraphicalDisplay cameleonGraphicalDisplay;
    
   
    private static AtomicInteger ACouleur = new AtomicInteger(-1);
    private static AtomicInteger BCouleur = new AtomicInteger(-1);
    private static AtomicInteger AAncienCouleur = new AtomicInteger(-1);
    private static AtomicInteger BAncienCouleur = new AtomicInteger(-1);
    private static AtomicInteger AId = new AtomicInteger(-1);
    private static AtomicInteger BId = new AtomicInteger(-1);
   
    private static AtomicBoolean PremierAppel = new AtomicBoolean(true);
    private static AtomicBoolean DoitAttendre = new AtomicBoolean(false);
  

    
    private int id, autreId;
    private Couleur monCouleur,autreCouleur;
    
    /**
     *
     * @param id
     * @param c
     * @param camGraDisp
     */
    public Cameleon(int id,Couleur c,CameleonGraphicalDisplay camGraDisp){
        this.id=id;
        this.monCouleur=c;
        this.cameleonGraphicalDisplay=camGraDisp;
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
                            "Caméléon[" + AId +"," + Couleur.AfficherCouleur(AAncienCouleur.intValue()) + "] et Caméléon[" + BId +"," + Couleur.AfficherCouleur(BAncienCouleur.intValue()) + "]" +
                            " ==> " +
                            "les deux caméléons prennent la couleur " + Couleur.AfficherCouleur(ACouleur.intValue())
                          ); 

               cameleonGraphicalDisplay.setTextArea(99, "                            Dernier mutation faite entre Caméléon #" + id +" et Caméléon #" + autreId , monCouleur.couleurInterne,f2,0);    

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
           
            cameleonGraphicalDisplay.setTextArea(this.id, displayCameleonInTextArea, monCouleur.couleurInterne,f,borderThickness);    

        }
       
    }
    
    /** 
     * fonction manger 
     */
    private void Manger()
    {
        Message("je mange",false,false);
    }
    
    /**
     * fonction s'entrainer
     */
    private void Entrainer(){
        Message("je m'entraine",false,false);
    }
       
    /**
     * fonction se rencontrer avec un autre cameleon d'une facon directe (peer to peer)
     *
     * @throws InterruptedException
     */
    public  void Muter() throws InterruptedException{

     synchronized(moniteur) {  
      Message("je vais muter",false,false);
      
      //TimeUnit.SECONDS.sleep(timeOutInSeconds);
      
      while (DoitAttendre.get()){
         Message("j'ai mis en attente",false,false);
         try{moniteur.wait();} catch(InterruptedException e){}
      }
         

      if(PremierAppel.get()){
        ACouleur.set(monCouleur.couleurInterne);
        
        AAncienCouleur.set(monCouleur.couleurInterne);
        AId.set(id);
  
        PremierAppel.set(false);
        moniteur.notifyAll();
        
        while(!PremierAppel.get()){
          Message("j'ai mis en attente",false,false);
          try{moniteur.wait();} catch(InterruptedException e){Message("exception",false,false);}
        }

        monCouleur= new Couleur(ACouleur.get());
        
        autreCouleur = new Couleur(BAncienCouleur.get());
        autreId = BId.get();
        
        DoitAttendre.set(false);
        moniteur.notifyAll();
        
        Message("j'ai fait une mutation avec #" + autreId,true,true);
        
        //Message("j'ai mis en attente",false,false);
        //moniteur.wait();
        
     }
     else {
        BCouleur.set(monCouleur.couleurInterne);
        
        BAncienCouleur.set(monCouleur.couleurInterne);
        BId.set(id);
        
        autreCouleur = new Couleur(ACouleur.get());
        autreId = AId.get();
        
        DoitAttendre.set(true);

        monCouleur=monCouleur.CouleurComplementaire(autreCouleur);
        
        ACouleur.set(monCouleur.couleurInterne);
        BCouleur.set(monCouleur.couleurInterne);

        PremierAppel.set(true);
        moniteur.notifyAll();

        Message("j'ai fait une mutation avec #" + autreId,true,false);
        
        //Message("j'ai mis en attente",false,false);
        //moniteur.wait();
       }

     
      }
    }
    
    /**
     * fonction run du thread cameleon
     * peut etre ralenti ou lancee rapidement en modifiant le parametre [Simulation.timeOutInSeconds]
     * un cameleon va manger, s'entrainer avant d'aller demander une rencontre
     */
    public void run(){
        while(true){
         try {
             
                Manger();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
                Entrainer();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);
                Muter();
                TimeUnit.SECONDS.sleep(Simulation.timeOutInSeconds);

            
            } catch (InterruptedException ex) {
                Logger.getLogger(Cameleon.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

