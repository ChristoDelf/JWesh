# JWesh framework
Créer un framework, sur base des technologies de base JEE (web.xml, servlets)

## Objectif
L'objectif du framework est de cacher la mécanique des servlets et de l'appel des jsp derrière des nouvelles classes et méthodes liées au framework. On
n'utilise plus de web.xml, ni de servlets.

## Comment l'installer/l'utiliser
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
Forum de Raphaël : https://github.com/lutin2706/JWesh/tree/master/JForum
