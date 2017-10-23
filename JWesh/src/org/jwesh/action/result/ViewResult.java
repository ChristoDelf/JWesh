package org.jwesh.action.result;

public class ViewResult implements ActionResult {

	private String viewName;
	
	public ViewResult(String viewName) {
		this.viewName = viewName;
	}
	
	public String getViewName() {
		return viewName;
	}
}
