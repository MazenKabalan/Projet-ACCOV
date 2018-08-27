/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameleonPck;


//
//class Agora
//

/**
 * lieu de rencontre des cameleons
 * utilise la methode "monitoring" pour synchroniser entre les differentes demandes de mutation des cameleons
 * 
 * @author mazen
 */

public class Agora{
   private Couleur ACouleur,BCouleur;
   private int AId,BId;
   private boolean PremierAppel = true;
   private boolean DoitAttendre  = false;
   private CameleonGraphicalDisplay cameleonGraphicalDisplay;
   
    /**
     *
     * @param GraphicalDisplay
     */
    public Agora(CameleonGraphicalDisplay GraphicalDisplay){
        this.cameleonGraphicalDisplay = GraphicalDisplay;
    }
    
    /**
     *
     * @return
     */
    public int getAId(){
        return AId;
        }
   
    /**
     *
     * @return
     */
    public int getBId(){
        return BId;
        }

    /**
     *
     * @return
     */
    public boolean getPremierAppel(){
        return PremierAppel;
        }
        
    /**
     * 
     * @return
     */
    public CameleonGraphicalDisplay getCameleonGraphicalDisplay(){
        return cameleonGraphicalDisplay;
        }

    /**
     * sert a la synchronisation entre les differentes demandes de mutation des cameleons
     * 
     * @param Id
     * @param C
     * @return
     */
    public synchronized Cameleon Cooperation(int Id, Couleur C){
      Cameleon resultat;

      while (DoitAttendre){
         try{wait();} catch(InterruptedException e){}
      }

      if(PremierAppel){
         ACouleur=C;
         AId = Id;
         PremierAppel=false;

         while(!PremierAppel){
           try{wait();} catch(InterruptedException e){}
         }
         DoitAttendre = false;
         resultat = new Cameleon(this,BId,BCouleur,true);
         notifyAll();
     }
     else {
       BCouleur = C;
       BId = Id;

       resultat = new Cameleon(this,AId,ACouleur,false);
       PremierAppel = true;
       DoitAttendre = true;
       notifyAll();
     }

     return resultat;
}
}

