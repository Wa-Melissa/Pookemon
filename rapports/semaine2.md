_## Choix de conception:
- Nous avons fait une classe éléments qui regroupe tous les éléments. Les éléments sont différenciés par un nom sous forme de string ("Eau","Feu","Air" ou "Terre"). Nous définissons et stockons au moment de la création d'un élément son avantage et son désavantage. Ainsi la gestion des éléments est facile et centralisée.


- Nous avons une classe statique pour l'initialisation des noms des pokemons. Dès que nous attribuons un nom nous l'enlevons de la liste ce qui nous permet dêtres sûrs qu'aucun nom n'est attribué 2 fois.


- Nous avons choisi de faire hériter l'ordinateur de la classe joueur comme les deux utilisent les mêmes méthodes. Le joueur représente donc l'utilisateur et l'ordinateur, qui utilise les mêmes méthodes mais pour qui le placement des pokemons et l'attaque sont redéfinis, son adversaire. 


- Nous avons géré tout l'affichage du plateau depuis une classe dédiée. De cette manière toutes les méthodes principales de l'affichage se situent au même endroit.

## Fonctionalités implémentées:
- La création de pokemons
- La gestion des avantages des éléments
- La création du joueur
- Piocher et placer des pokemons sur le terrain
- Afficher le terrain
- l'implémentation de l'ordinateur
- les attaques
- la gestion des tours de jeux

## Difficultés rencontrées:
- Faire en sorte que les cartes affichant les pokemons sur le terrain soient toutes de la meme taille malgré le changement de texte à l'intérieur
- Rendre les affichages successifs du terrain facilement compréhensible pour l'utilisateur

## To Do_
- enlever le "placez vos pokemons !" lorsqu'il est au mauvais endroit dans l'affichage
