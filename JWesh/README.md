# JWesh framework

L'objectif du framework est de cacher la mécanique des servlets et de l'appel des jsp derrière des nouvelles classes et méthodes liées au framework.  
  
Il ne contient qu'une seule servlet qui fera le dispatching des requêtes selon l'URL.  
  
Le mapping se fait via une classe "Mapping". Un filtre est placé devant la servlet pour permettre aux requêtes sur les ressources de passer (images, par exemple).  
  
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
