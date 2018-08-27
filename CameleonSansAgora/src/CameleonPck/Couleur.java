/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameleonPck;


//
//class Couleur
//

/**
 *
 * classe couleurs des cameleons
 * les couleurs definies sont le bleu, le rouge, et le jaune
 * 
 * @author mazen
 */
public class Couleur  {

    /**
     *
     */
    public int couleurInterne;
      private static final int bleuInt = 0;
      private static final int rougeInt  = 1;
      private static final int jauneInt = 2;

    /**
     *
     */
    public static final Couleur BLEU = new Couleur(bleuInt);

    /**
     *
     */
    public static final Couleur ROUGE = new Couleur(rougeInt);

    /**
     *
     */
    public static final Couleur JAUNE = new Couleur(jauneInt);

    /**
     *
     * @param value
     */
    public Couleur (int value) 
             {couleurInterne = value % 3;}
      
    /**
     *
     * retourne le couleur resultant d'un rencontre entre deux cameleon 
     * qui doit etre utilise dans les deux cameleon apres la mutation
     * 
     * @param C
     * @return
     */
    public Couleur CouleurComplementaire(Couleur C){
            if(couleurInterne == C.couleurInterne)
                 return new Couleur(couleurInterne);
            else return new Couleur(3 - couleurInterne - C.couleurInterne);
          }
      
    /**
     *
     * @param couleur
     * @return
     */
    public static String AfficherCouleur(int couleur) {
          switch (couleur) {
              case 0:
                  return "bleu";
              case 1:
                  return "rouge";
              default:
                  return "jaune";
          }
     }

      public String toString() {
          switch (couleurInterne) {
              case bleuInt:
                  return "bleu";
              case rougeInt:
                  return "rouge";
              default:
                  return "jaune";
          }
     }
  }
