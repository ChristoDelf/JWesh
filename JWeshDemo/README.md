# JWeshDemo
Projet léger utilisant JWesh Framework

## Techno utilisées
* Architecture
* Framework : JWesh
* Front-End: HTML/JSP
* Persistance des données: /
* Autres

## Structure des packages
* Init.java qui enregistre les Mappings, et les lie aux Actions
* Folder Action, qui ne contient qu'une action pour afficher la page d'Index

## Librairies utilisées
* jwesh.jar

## Procédure pour refaire le même projet
* Créer un Dynamic Web Project
* Importer jwesh.jar et l'inclure dans le Build Path
* Définir une classe Init qui étend AppInit pour définir le mapping (association d'une URL/méthode à une action)
* Définir les actions (chacune implémente l'interface Action)
