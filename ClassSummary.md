# Class Summary 

Class 	|Description
---     |---
Agora 	|Lieu de rencontre des cameleons, utilise la methode "monitoring" pour synchroniser entre les differentes demandes de mutation des cameleons
Cameleon|Represente les cameleons qui demandent les mutations, un thread pour chaque cameleon, un cameleon est identifie par un "id", un "couleur" et l'agora dans lequelle doit muter
CameleonGraphicalDisplay|Interface graphique JFrame pour afficher le comportement des cameleons, peut afficher le comportement au plus de neuf (9) cameleons, affiche la derniere mutation entre deux cameleons
Couleur|Classe des couleurs des cameleons, les couleurs definies sont le bleu, le rouge, et le jaune
Simulation|Classe qui simule la mutation des cameleons, contient la fonction main du projet
