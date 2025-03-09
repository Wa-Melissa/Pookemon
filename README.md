# Pookemon Project

C'est un jeu où deux dresseurs s'affrontent en plaçant sur leur terrain différents Pokémons.

## Organisation

- Projet en première année de BUT (avril - juin 2024)
- Travail en binôme
- Durée : 5 semaines
- en Java

## Le jeu

Il s'agit d'un jeu avec un joueur humain face à l'ordinateur, qui se joue **au tour par tour**. Le gagnant est celui qui parvient à **éliminer tous les Pokémons de son adversaire**.

### Composition du jeu

Chaque joueur a à sa disposition :

- un **terrain** pouvant accueillir 3 Pokémons,
- une **main** de 5 Pokémons maximum,
- une **pioche** de 20 ou 21 Pokémons (lire partie Mise en place du jeu),
- une **défausse** contenant les Pokémons éliminés.

### Mise en place du jeu

1. Le premier joueur à jouer est choisi aléatoirement.
2. Le premier joueur possède une **pioche de 20 Pokémons**, le second de **21 Pokémons**.
3. Chaque joueur **pioche 5 Pokémons**.
4. Le premier joueur **place 3 Pokémons** de sa main sur son terrain face visible puis le second joueur fait de même.
5. Le premier joueur commence à jouer.

### Déroulement d'un tour

À son tour, le joueur humain :

1. **Peut lire** la description des pouvoirs des Pokémons de son terrain.
2. **Peut jouer** une fois le pouvoir de chacun des Pokémons de son terrain, dans l'ordre de son choix.
3. **Pioche** des Pokémons jusqu'à en avoir 5 en main ou que sa pioche soit vide.
4. **Place** un Pokémon de sa main face visible sur chaque emplacement vide sur son terrain.
5. **Attaque** une fois avec chacun des Pokémons de son terrain, dans l'ordre de son choix.

À son tour, l'ordinateur :

1. **Joue les pouvoirs** de chacun des pokemons de son terrain.
2. **Pioche** des Pokémons jusqu'à en avoir 5 en main ou que sa pioche soit vide.
3. **Place** un Pokémon de sa main face visible sur chaque emplacement vide sur son terrain, **dans l'ordre de sa main**.
4. **Attaque** une fois avec chacun des Pokémons de son terrain **dans l'ordre de ses terrains**.

## Les Pokémons

Chaque Pokémon possède :

- un **nom**
- des **points de vie**
- une **force d'attaque**
- une **affinité avec un élément**

Certains Pokémons possèdent en plus un pouvoir spécial unique dans le jeu.

### Les éléments

Il y a 4 éléments : la terre, l'eau, le feu et l'air. Chaque élément a un avantage sur un autre élément :

- la terre a l'avantage sur l'eau
- l'eau à l'avantage sur le feu
- le feu a l'avantage sur l'air
- l'air a l'avantage sur la terre.

### Les pouvoirs 

Il y a 8 pouvoirs, les pouvoirs peuvent être à utilisation unique ou être réutilisables à chaque tour. 

- **Berserk** : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Pour le tour en cours, l'attaque de ce Pokémon est doublée.(utilisation unique)
- **Extension du territoire** : le terrain du joueur gagne un quatrième emplacement sur lequel il peut placer immédiatement un Pokémon de sa main. Lorsque le Pokémon qui a utilisé ce pouvoir meurt, son emplacement est perdu et le terrain possède de nouveau trois emplacements.(utilisation unique)
- **Kamikaze** : le Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés. (utilisation unique)
- **Peur** : le Pokémon choisit un Pokémon du camp adverse. Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci infligent 10 dégats de moins. (utilisation unique)
- **Regeneration** : le Pokémon choisit un Pokémon de son camp. Si le Pokémon a déjà utilisé un pouvoir à utilisation unique, il peut alors l'utiliser une seconde fois. (utilisation unique)
- **Soin simple** : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Celui-ci regagne 30 points de vie (mais ne peut pas dépasser son nombre de points de vie initial). (utilisable à chaque tour)
- ***Soin de zone** : chaque Pokémon de son camp regagne 10 points de vie. (utilisable à chaque tour)
- **Usurpation** : le Pokémon choisit un Pokémon (dans son camp ou dans le camp adverse). Il gagne alors le pouvoir du Pokémon choisi et le Pokémon choisi perd son pouvoir. Fonctionne aussi pour les pouvoirs à utilisation unique déjà utilisés.(utilisation unique)

### Attaque des Pokémons

- Lorsqu'un Pokémon attaque un autre Pokémon, il **diminue le nombre de points de vie** de son adversaire de la valeur de sa force d'attaque.
- Si, suite à une attaque, un Pokémon n'a **plus de points de vie**, il est placé dans la **défausse** de l'adversaire.
- Un **avantage d'affinité** augmente une attaque de 10.
- Un **désavantage d'affinité** diminue une attaque de 10.

### Stratégie d'attaque de l'ordinateur

Un Pokémon de l'ordinateur :

- attaque en priorité le Pokémon dont l'affinité lui donne l'avantage
- s'il n'y en a pas (ou s'il y en a plusieurs), il attaque le Pokémon qui possède le moins de points de vie (parmi ceux-ci).
- s'il y en a encore plusieurs, il attaque l'un de ces Pokémon au hasard.

### Génération des Pokémons

À chaque partie, les Pokémons de chaque pioche sont générées selon l'algorithme suivant :

- leur nom est tiré aléatoirement parmi une liste de noms fixe, mais deux Pokémons ne peuvent pas avoir le même nom,
- leur nombre de points de vie est un multiple de 10, compris entre 100 et 200 et déterminé aléatoirement,
- leur valeur d'attaque est un multiple de 10 compris entre 10 et 40 et déterminé aléatoirement,
- leur affinité est choisie aléatoirement.
- ils se voient attribuer un ou aucun pouvoir. Le même pouvoir ne peut se voir attribuer qu'à un seul Pokémon dans tout le jeu.

## L'application

- propose une interface textuelle,
- permet de visualiser les Pokémons sur les terrains et ceux en main du joueur humain, mais pas celles de l'ordinateur,
- indique quelles sont les actions possibles et les entrées clavier à effectuer pour les réaliser.
- affiche les actions effectuées par l'ordinateur lorsque c'est son tour

### Exemple d'affichage

```console
********************************************************************************
Tour 3:
                                    Players.Joueur 2

********************************************************************************

                                    Players.Joueur 1

pioche: 15 pokemons
defausse: 0 pokemons
   ---------------------      ---------------------      -------------------- 
  |     Herbizarre      |    |     Florizarre      |    |     Salamèche      |
   --------------------       ---------------------      -------------------- 
  | Attaque: 20         |    | Attaque: 40         |    | Attaque: 20        |
  | Vie: 50/120         |    | Vie: 50/150         |    | Vie: 50/130        |
  | Affinite : Air      |    | Affinite : Air      |    | Affinite : Feu     |
   ---------------------      ---------------------      --------------------
  | Pouvoir : Peur   |       | Pouvoir : -----     |    | Pouvoir : -----    |
   ---------------------      ---------------------      -------------------- 
  
----------------------------------------------------------------------------------------------------

   --------------------      -----------------------      -------------------- 
  |     Dracaufeu      |    |     Bulbizarre        |    |      Pikachu       |
   ---------------------      ---------------------      -------------------- 
  | Affinite : Feu     |    | Affinite : Eau        |    | Affinite : Terre   |
  | Vie: 50/180        |    | Vie: 50/150           |    | Vie: 50/100        |
  | Attaque: 40        |    | Attaque: 30           |    | Attaque: 10        |
   --------------------      ----------------------      --------------------
  | Pouvoir : -----    |    | Pouvoir : Soin Simple |    | Pouvoir : -----    |
   --------------------      -----------------------      -------------------- 

pioche: 12 pokemons
defausse: 0 pokemons

En main:
- Reptincel, Feu, Vie: 160, Attaque: 20, Pouvoir: Berserk
- Carapuce, Eau, Vie: 100, Attaque: 40, Pouvoir: Aucun
- Tortank, Eau, Vie: 200, Attaque: 20, Pouvoir: Extension du territoire
- Papilusion, Air, Vie: 120, Attaque: 20, Pouvoir: Aucun
- Roucool, Air, Vie: 150, Attaque: 30, Pouvoir: Aucun

                                    Players.Joueur 2

Quel pokemon souhaitez-vous jouer? (Dracaufeu/Bulbizarre/Pikachu):
```


### Fin du jeu

À la fin du jeu, un écran affiche "Vous avez perdu" ou "Vous avez gagné" et indique le nombre de Pokémons restants au gagnant.
