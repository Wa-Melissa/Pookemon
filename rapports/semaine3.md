Pouvoirs a implémenter :
- _## Choix de conception:
- Nous avons fait une classe éléments qui regroupe tous les éléments. Les éléments sont différenciés par un nom sous forme de string ("Eau","Feu","Air" ou "Terre"). Nous définissons et stockons au moment de la création d'un élément son avantage et son désavantage. Ainsi la gestion des éléments est facile et centralisée.


- Nous avons une classe statique pour l'initialisation des noms des pokemons. Dès que nous attribuons un nom nous l'enlevons de la liste ce qui nous permet dêtres sûrs qu'aucun nom n'est attribué 2 fois.


- Nous avons choisi de faire hériter l'ordinateur de la classe joueur comme les deux utilisent les mêmes méthodes. Le joueur représente donc l'utilisateur et l'ordinateur, qui utilise les mêmes méthodes mais pour qui le placement des pokemons et l'attaque sont redéfinis, son adversaire.


- Nous avons géré tout l'affichage du plateau depuis une classe dédiée. De cette manière toutes les méthodes principales de l'affichage se situent au même endroit.


- Nous avons fait une classe abstraite power dont hérite toutes les classes pour chaque pouvoir. De cette manière la méthode qui vérifie les conditions d'utilisation d'un pouvoir n'est implémentée qu'une fois et la méthode liée a l'action du pouvoir en lui meme est sépcifique a chaque classe. 

## Fonctionalités implémentées:
- La création de pokemons
- La gestion des avantages des éléments
- La création du joueur
- Piocher et placer des pokemons sur le terrain
- Afficher le terrain
- l'implémentation de l'ordinateur
- les attaques
- la gestion des tours de jeux
- le resumé des actions de l'ordi
- Berserk
- Kamikaze
- Usurpation
- SoinSimple
- SoinZone

## Difficultés rencontrées:
- Faire en sorte que les cartes affichant les pokemons sur le terrain soient toutes de la meme taille malgré le changement de texte à l'intérieur
- Rendre les affichages successifs du terrain facilement compréhensible pour l'utilisateur
- resumer les actions de l'ordinateur
- Pouvoir afficher correctement le Pouvoir du pokemon, à notre stade, le pouvoir ne s'affiche pas correctement, il génère une erreur.

## To Do_
- implémenter les pouvoirs affinité plomb, ether et extension du territoire
- gerer les pouvoirs pour l'ordinateur
- Afficher les pouvoirs des pokemons
- arreter le pouvoir berserk apres un tour
