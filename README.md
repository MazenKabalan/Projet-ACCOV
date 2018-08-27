# Première Solution : Mutation Avec Agora
  Dans cette solution:
  - les caméléons sont des threads.
  - Les demandes de mutation sont envoyées a l'agora. 
  - Un agora est le lieu de rencontre des caméléons.
  - La synchronization entre les differentes demandes de mutation des caméléons se fait au niveau de l'agora.
  - La methode **Monitoring** est utilisée dans la synchronization.
  - La simulation se fait sur neuf (9) caméléons.

## Résumé de classes 

Classe 	|Description
---     |---
*Agora* 	|Lieu de rencontre des caméléons, utilise la methode "monitoring" pour synchronizer entre les differentes demandes de mutation des caméléons
*caméléon*|Represente les caméléons qui demandent les mutations, un thread pour chaque caméléon, un caméléon est identifie par un "id", un "couleur" et l'agora dans lequelle doit muter
*caméléonGraphicalDisplay*|Interface graphique JFrame pour afficher le comportement des caméléons, peut afficher le comportement au plus de neuf (9) caméléons, affiche la derniere mutation entre deux caméléons
*Couleur*|Classe des couleurs des caméléons, les couleurs definies sont le bleu, le rouge, et le jaune
*Simulation*|Classe qui simule la mutation des caméléons, contient la fonction main du projet


## Paramètres Globales 
Modifier|Type|Field|Description
---     |--- |---  |---
static|boolean 	 |*Simulation.AfficherTravailcaméléon*|Affiche le comportement des caméléons sur le system.out et sur l'interface graphique, *N.B.: l'interface graphique peut afficher seulement au plus les comportements de 9 caméléons, en tant que pour le System.out, pas de limite sur le nombre des caméléons*
static|int 	     |*Simulation.fontSize*|Definit la taille du fonte utilisee sur l'interface graphique
static|long 	   |*Simulation.timeOutInSeconds*|Definit le retard entre les fontions d'un caméléon (en secondes)

----

# Deuxième Solution : Mutation Sans Agora
  Dans cette solution:
  - les caméléons sont des threads.
  - Les demandes de mutation sont envoyées entre les caméléons sans l'utilisation d'une interface intermediare comme l'agora, la communication est de type (peer to peer).
  - La synchronization entre les differentes demandes de mutation des caméléons se fait a l'aide des **variables atomiques** 
  - La simulation se fait sur neuf (9) caméléons.

## Résumé de classes 

Classe 	|Description
---     |---
*caméléon*|Represente un caméléon qui envoi une demande de mutation, un thread pour chaque caméléon, un caméléon est identifie par un "id", un "couleur" et l'interface graphique dans laquelle doit afficher ces comportements, on utilise les **Variables atomiques** dans la synchronization entre les differentes demandes de mutation envoyées par les caméléons, les demandes de mutation sont faites directement entre les caméléons sans utiliser aucune interface intermediare (peer to peer).
*caméléonGraphicalDisplay*|Interface graphique JFrame pour afficher le comportement des caméléons, peut afficher le comportement au plus de neuf (9) caméléons, affiche la derniere mutation entre deux caméléons
*Couleur*|Classe des couleurs des caméléons, les couleurs definies sont le bleu, le rouge, et le jaune
*Simulation*|Classe qui simule la mutation des caméléons, contient la fonction main du projet


## Paramètres Globales 
Modifier|Type|Field|Description
---     |--- |---  |---
static|boolean 	 |*Simulation.AfficherTravailcaméléon*|Affiche le comportement des caméléons sur le system.out et sur l'interface graphique, *N.B.: l'interface graphique peut afficher seulement au plus les comportements de 9 caméléons, en tant que pour le System.out, pas de limite sur le nombre des caméléons*
static|int 	     |*Simulation.fontSize*|Definit la taille du fonte utilisee sur l'interface graphique
static|long 	   |*Simulation.timeOutInSeconds*|Definit le retard entre les fontions d'un caméléon (en secondes)
