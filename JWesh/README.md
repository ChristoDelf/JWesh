# JWesh framework

L'objectif du framework est de cacher la mécanique des servlets et de l'appel des jsp derrière des nouvelles classes et méthodes liées au framework.  
  
Il ne contient qu'une seule servlet qui fera le dispatching des requêtes selon l'URL.  
  
Le mapping se fait via une classe "Mapping". Un filtre est placé devant la servlet pour permettre aux requêtes sur les ressources de passer (images, par exemple).  
  
## Comment l'utiliser
* Importer le fichier JWesh.jar dans le build path du projet
* Définir une classe 
