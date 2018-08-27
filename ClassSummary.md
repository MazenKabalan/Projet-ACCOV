# Résumé de classes 

Classe 	|Description
---     |---
*Agora* 	|Lieu de rencontre des cameleons, utilise la methode "monitoring" pour synchronizer entre les differentes demandes de mutation des cameleons
*Cameleon*|Represente les cameleons qui demandent les mutations, un thread pour chaque cameleon, un cameleon est identifie par un "id", un "couleur" et l'agora dans lequelle doit muter
*CameleonGraphicalDisplay*|Interface graphique JFrame pour afficher le comportement des cameleons, peut afficher le comportement au plus de neuf (9) cameleons, affiche la derniere mutation entre deux cameleons
*Couleur*|Classe des couleurs des cameleons, les couleurs definies sont le bleu, le rouge, et le jaune
*Simulation*|Classe qui simule la mutation des cameleons, contient la fonction main du projet


# Parametres Globales 
Modifier and Type|Field and Description
---              |---
static boolean 	 |*Simulation.AfficherTravailCameleon*: affiche le comportement des cameleons sur le system.out et sur l'interface graphique
static int 	     |*Simulation.fontSize*: definit la taille du fonte utilisee sur l'interface graphique
static long 	   |*Simulation.timeOutInSeconds*: definit le retard entre les fontions d'un cameleon (en secondes)
