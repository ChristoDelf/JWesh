package org.jwesh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.ActionMan;
import org.jwesh.action.mapping.HttpMethod;
import org.jwesh.action.mapping.Mapping;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ErrorResult;
import org.jwesh.action.result.RedirectResult;
import org.jwesh.action.result.ViewResult;

@WebServlet("/pages/*")
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = -6576740060032078854L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		System.out.println("------- Entry in " + request.getRequestURI());
		
		HttpMethod httpMethod = HttpMethod.valueOf(method);

		Action action = ActionMan.getInstance().getAction(new Mapping(httpMethod, url.substring(contextPath.length()).substring("/pages".length())));
		if (action != null) {
			ActionResult result = action.execute(request, response);
			
			if (result != null) {
				if (result instanceof ViewResult) {
					String viewName = ((ViewResult) result).getViewName();
					request.getRequestDispatcher("/WEB-INF/" + viewName + ".jsp").forward(request, response);
				} else if (result instanceof RedirectResult) {
					String redirectUrl = ((RedirectResult) result).getRedirectUrl();
					response.sendRedirect(redirectUrl);
				} else if (result instanceof ErrorResult) {
					int code = ((ErrorResult) result).getCode();
				}
				// TODO : Ajouter la possibilité de renvoyer du JSON
			}
		} else {
			response.sendError(404);
		}
	}

}
