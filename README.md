# Petri-Network

## Description
Ce projet vise a créer une simulation de réseau de Pétri. Il implémente les éléments atomiques constitutifs de cette structure : des transitions, des places (avec un certain nombre de jetons), et 4 types d'arcs différents, faisant le lien entre les transitions et les places. Il existe deux arcs basiques : entrant et sortant (d'une place), et deux arcs sortants particuliers (arc zéro et arc videur).
De plus, une implémentation de l'interface du réseau est proposée afin de pouvoir mener des tests et exécuter des simulation.

## Environnement
Version d'Eclipse : 2022-06
Java Runtime Environment 11

## Exécution
Quelques exmeples de réseaux de Petri sont disponibles dans le package `run` du répertoire `tests`.
Les méthodes de création et utilisation du réseau sont données par l'interface `PetriNetwork` (`src/petriNet.PetriNetwork`).

## Tests
Des tests unitaires JUnit couvrent l'ensemble du projet. Ils sont contenus dans le package `unitTests` du répertoire `tests`.

## Modèle de conception
Le modèle de conception prévu est majoritairement respecté.
Nous avons cependant introduit deux modifications importante afin d'améliorer l'implémentation.

### Edge est désormais une classe abstraite
Nous avions prévu que `Edge` soit une interface, étant donné qu'un arc peut se décliner en plusieurs formes, et qu'un arc sans précision n'a pas de sens. Nous avons finalement opté pour une classe abstraite, cela permettant de largement factoriser du code utilisé quelque soit le type, en particulier les deux variables d'instance `weight` et `place` accompagnées de leurs accesseurs, ainsi que le constructeur.

### La classe représentant le réseau n'a pas accès aux arcs.
La classe `PetriNet` ne stocke pas la liste des arcs comme prévu initialement. En effet, nous pouvons accéder à tous les arcs via les transitions auxquelles ils sont liés. En revanche, il est toujours nécessaire de stocker les places, car celles-ci ne sont pas forcément liées à une transition par un arc. Elles peuvent exister seules.

### Ajout de constructeurs enchaînés
Le sujet indique que les arcs ont par défaut un poids de 1. Nous avons ajouté un nouveau constructeur ne prenant pas de poids en entrée, permettant d'implémenter ce poids par défaut.
