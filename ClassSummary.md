# Première Solution : Mutation Avec Agora
  Dans cette solution:
  - les cameleons sont des threads
  - Les demandes de mutation sont envoyées a l'agora 
  - Un agora est le lieu de rencontre des cameleons
  - La synchronization entre les differentes demandes de mutation des cameleons se fait au niveau de l'agora
  - La methode "monitoring" est utilisee dans la synchronization

## Résumé de classes 

Classe 	|Description
---     |---
*Agora* 	|Lieu de rencontre des cameleons, utilise la methode "monitoring" pour synchronizer entre les differentes demandes de mutation des cameleons
*Cameleon*|Represente les cameleons qui demandent les mutations, un thread pour chaque cameleon, un cameleon est identifie par un "id", un "couleur" et l'agora dans lequelle doit muter
*CameleonGraphicalDisplay*|Interface graphique JFrame pour afficher le comportement des cameleons, peut afficher le comportement au plus de neuf (9) cameleons, affiche la derniere mutation entre deux cameleons
*Couleur*|Classe des couleurs des cameleons, les couleurs definies sont le bleu, le rouge, et le jaune
*Simulation*|Classe qui simule la mutation des cameleons, contient la fonction main du projet


## Parametres Globales 
Modifier|Type|Field|Description
---     |--- |---  |---
static|boolean 	 |*Simulation.AfficherTravailCameleon*|Affiche le comportement des cameleons sur le system.out et sur l'interface graphique, *N.B.: l'interface graphique peut afficher seulement au plus les comportements de 9 cameleons, en tant que pour le System.out, pas de limite sur le nombre des cameleons*
static|int 	     |*Simulation.fontSize*|Definit la taille du fonte utilisee sur l'interface graphique
static|long 	   |*Simulation.timeOutInSeconds*|Definit le retard entre les fontions d'un cameleon (en secondes)
