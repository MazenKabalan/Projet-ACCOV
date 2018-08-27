## PARADIGME DES "CAMÉNÉONS"

 ### Le but du projet est l’étude de la synchronisation dans une relation de pair à pair, en se servant du paradigme des "caménéons". 
 
 #### 1. Jeu des caménéons
 Le "caménéon" est une variété de lézard qui prend l’une des trois couleurs : bleu, jaune, rouge. Une population est constituée de N "caménéons" qui ont un comportement cyclique. C’est un animal qui habituellement vit seul dans la forêt, mange du chèvrefeuille et s'entraîne au jeu de maillet. Au bout d'un certain temps, le "caménéon" se sent prêt pour la compétition. Il cherche un compagnon de jeu (un autre "caménéon" ), puis entre sur un 'mail' ( (dans le midi de la France, le mail est une promenade bordée d’arbres, où l’on jouait jadis au jeu de maillet - ou jeu de mail ) ) où il peut jouer avec ce compagnon et où une mutation peut se produire. 
Quand deux "caménéons" se rencontrent, en effet une mutation peut se produire. Si les deux "caménéons" sont de couleurs différentes, ils changent de couleur et prennent la troisième couleur, sinon ils ne changent pas de couleur. Il faut donc simuler la vie des "caménéons" et permettre à deux "caménéons" de se rencontrer et de muter sans interférer avec les autres "caménéons". On étudie ainsi l’évolution des couleurs d’une population de N "caménéons". 

#### 2. Architecture opérationnelle globale de l’application
Chaque "caménéon" sera représenté par un identifiant unique et une couleur. Chaque "caménéon" sera représenté par un processus (une tâche). Bien que plusieurs solutions techniques soient envisageables, il est très difficile de définir à l'avance laquelle sera la plus pertinente. On étudiera deux architectures radicalement différentes : 

- La solution de base est d'utiliser une agora, un lieu de rencontre où les "caménéons" iront lorsqu'ils voudront se rencontrer. Cette agora sera le centre névralgique du système et attribuera les rencontres entre "caménéons". Les échanges sont par conséquent triviaux, un "caménéon" ne communiquera qu'avec l'agora. On peut apparenter cela à un réseau en étoile. Il y a (n) constituants, dont (1) serveur et (n-1) clients qui peuvent s'y connecter tout en ignorant la présence et l'existence des autres clients. Une fois qu’un "caménéon" connaît un partenaire, il continue le dialogue (le jeu de maillet et l’éventuel changement de couleur) sans passer par l’agora. Les rencontres des "caménéons" se font sur l’agora. Le premier arrivé attend un congénère et lorsque celui-ci arrive, chacun des deux "caménéons" apprend le nom et la couleur de son partenaire puis ils peuvent aller jouer sur un 'mail' et éventuellement changer de couleur. Une fois que le jeu et la mutation sont terminés, le caménéon peut recommencer un nouveau cycle de vie (manger, s’entraîner, aller au 'mail' et subir une nouvelle mutation). L’agora peut être représentée par un objet actif ou par un objet passif. On pourra aussi représenter l’agora comme un lieu de rencontre où certains "caménéons" attendent des partenaires, et d’autres cherchent des partenaires pour jouer (modèle P2P dissymétrique) . 

- L'autre solution, beaucoup plus complexe, est de faire se rencontrer deux "caménéons" au hasard. Cela signifie qu'il n'y a pas d'agora prédéfinie, les "caménéons" vont d'eux-mêmes chercher leur partenaire. C’est une solution répartie où un caménéon doit pouvoir lancer une demande de rendez-vous et aussi répondre à une demande d’autres "caménéons". Bien entendu, la combinatoire de cette solution est beaucoup plus élevée, et la validation d'une telle solution beaucoup plus complexe. Notamment pour garantir l’absence d’interblocage (tous sont en état d’appel et aucun n’est en état de répondre) et pour vérifier la non présence de famine d'un caménéon (la solitude éternelle).

Il vous est demandé de développer les deux solutions 

#### 3. Propriétés attendues, QOS
Les propriétés attendues sont :
- Respect du rendez vous entre deux caménéons et deux seulement.
- Pas d’interblocage.
- Respect de l’équité.

-----

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
*caméléon*|Represente un caméléon qui envoi une demande de mutation, un thread pour chaque caméléon, un caméléon est identifie par un "id", un "couleur" et l'interface graphique dans laquelle doit afficher ces comportements, un caméléon utilise les **Variables atomiques** dans la synchronization entre les differentes demandes de mutation envoyées par les caméléons, les demandes de mutation sont faites directement entre les caméléons sans utiliser aucune interface intermediare (peer to peer).
*caméléonGraphicalDisplay*|Interface graphique JFrame pour afficher le comportement des caméléons, peut afficher le comportement au plus de neuf (9) caméléons, affiche la derniere mutation entre deux caméléons
*Couleur*|Classe des couleurs des caméléons, les couleurs definies sont le bleu, le rouge, et le jaune
*Simulation*|Classe qui simule la mutation des caméléons, contient la fonction main du projet


## Paramètres Globales 
Modifier|Type|Field|Description
---     |--- |---  |---
static|boolean 	 |*Simulation.AfficherTravailcaméléon*|Affiche le comportement des caméléons sur le system.out et sur l'interface graphique, *N.B.: l'interface graphique peut afficher seulement au plus les comportements de 9 caméléons, en tant que pour le System.out, pas de limite sur le nombre des caméléons*
static|int 	     |*Simulation.fontSize*|Definit la taille du fonte utilisee sur l'interface graphique
static|long 	   |*Simulation.timeOutInSeconds*|Definit le retard entre les fontions d'un caméléon (en secondes)
