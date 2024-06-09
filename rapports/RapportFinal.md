## Choix de conception:
- Nous avons fait une classe éléments qui regroupe tous les éléments. Les éléments sont différenciés par un nom sous forme de string ("Eau","Feu","Air" ou "Terre"). Nous définissons et stockons au moment de la création d'un élément son avantage et son désavantage. Ainsi la gestion des éléments est facile et centralisée.


- Nous avons une classe statique séparée pour l'initialisation des noms et des noms des pouvoirs des pokemons. Dès que nous attribuons un nom nous l'enlevons de la liste ce qui nous permet dêtres sûrs qu'aucun nom n'est attribué 2 fois.


- Nous avons choisi de faire hériter l'ordinateur de la classe joueur commel'ordinateur est pour nous un type spécial de joueur. Le joueur représente donc l'utilisateur et l'ordinateur son adversaire. L'ordinateur utilise les memes méthodes que le joueur, certaines ayant du etre redéfinies et d'autres non ce qui nous a permis d'éviter de la répétition dans le code.


- Nous avons géré tout l'affichage du plateau depuis une classe dédiée. De cette manière toutes les méthodes principales de l'affichage se situent au même endroit. Nous avons dans le meme package mis les méthodes d'affichage liées aux pouvoirs et au joueur ce qui nous a permis de séparer la logique de l'affichage.


- Nous avons fait une classe abstraite power dont hérite toutes les classes pour chaque pouvoir. De cette manière la méthode qui vérifie les conditions d'utilisation d'un pouvoir n'est implémentée qu'une fois et la méthode liée a l'action du pouvoir en lui meme est sépcifique a chaque classe. L'ajout d'un nouveau pouvoir se fait donc aussi simplement.

## Fonctionalités implémentées:
- La création de pokemons
- La gestion des éléments (avec les avantages/désavantages)
- La création du joueur (+ pioche, main, terrain)
- Piocher et placer des pokemons sur le terrain
- Afficher le terrain +  interface textuelle,
- l'implémentation de l'ordinateur ( et attaques selon la stratégie spécifiée)
- les attaques
- la mise en place du jeu
- la gestion des tours de jeux
- le resumé des actions de l'ordi
- Berserk
- Kamikaze
- Usurpation
- SoinSimple
- SoinZone
- Extension du territoire
- Peur
- Regeneration
- couleurs sur certains éléments du terrain pour une lecture plus facile
- l'urilisation des pouvoirs par le joueur
- l'utilisation des pouvoirs par l'ordinateur
- effets des pouvoirs consultables avant leur utilisation
- afficher le résultat de l'action d'un pouvoir
- afficher les pouvoirs sur le terrain
- plusieurs tests pour chaque pouvoir

## Difficultés rencontrées:
- Faire en sorte que les cartes affichant les pokemons sur le terrain soient toutes de la meme taille malgré le changement de texte à l'intérieur
- Rendre les affichages successifs du terrain facilement compréhensible pour l'utilisateur
- resumer les actions de l'ordinateur
- Pouvoir afficher correctement le Pouvoir du pokemon, à notre stade, le pouvoir ne s'affiche pas correctement, il génère une erreur.
- cacher pour l'ordi les différentes phases de l'utilisation de pouvoir
- conceptualiser le code sans dépendances cycliques


#

#### repartition du travail :
* (estimation a vérifier) : 40 % - 60 %