# JWesh framework

L'objectif du framework est de cacher la mécanique des servlets et de l'appel des jsp derrière des nouvelles classes et méthodes liées au framework.  

## Structure
  
Il ne contient qu'une seule servlet (DispatcherServlet) qui fera le dispatching des requêtes selon l'URL vers les Actions.  Un filtre (ResourceFilter) est placé devant la servlet pour permettre aux requêtes sur les ressources de passer (images, par exemple).  Il n'y a pas de web.xml, le dispatching se fait par annotation @WebServlet("/pages/*")
  
ActionMan est un singleton, dont le rôle est de stocker les mappings encodés par l'application finale (liaison entre un Mapping et une Action).  
  
L'interface Action, implémentée par chacune des Action de l'application finale, ne définit qu'une seule méthode (execute), dans laquelle chaque Action définira le comportement.

Deux classes utiles sont définies : HttpMethod, une énumération des différentes méthodes HTTP et Mapping, qui associe une méthode à une URL, pour être utilisée par ActionMan.

Comportement de la Servlet : retrouver, en fonction de l'URL et de la méthode, l'Action à exécuter, l'exécuter, et en fonction du retour de l'Action :
* ViewResult : Afficher la jsp correspondante
* RedirectResult : Rediriger vers l'URL indiquée
* ErrorResult : Renvoyer une réponse Erreur, avec le code d'erreur donné

Définition des trois classes Result, implémentant une interface commune.

AppInit permet à l'application finale de définir le Mapping, en créant une classe qui hérite de AppInit.
  
## Comment l'utiliser
* Importer le fichier JWesh.jar dans le build path du projet
* Définir une classe Init qui étend AppInit pour définir le mapping (association d'une URL/méthode à une action)

```java
@WebListener

public class Init extends AppInit {

	@Override
	public void registerActions(ActionMan manager) {
		manager.addAction(Mapping.get("/"), new IndexAction());
//		manager.addAction(new Mapping.Builder().withMethodGet().withUrl("/").build(), new IndexAction());
	}
```
* Définir les actions (chacune implémente l'interface Action)
```java
public class IndexAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setAttribute("title", "Titre de la page");
		return new ViewResult("index");
		// On évite ici de rediriger vers la page .jsp avec les méthodes forward, etc
	}
```
   Chaque action retourne un ActionResult, qui peut être un ViewResult (envoi de la jsp correspondante), un RedirectResult (redirection vers une autre url) ou un ErrorResult (envoi d'une erreur).

## Exemples
JWeshDemo : https://github.com/lutin2706/JWesh/tree/master/JWeshDemo
Forum : 
