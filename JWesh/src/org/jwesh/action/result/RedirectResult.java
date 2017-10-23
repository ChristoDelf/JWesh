package org.jwesh.action.result;

public class RedirectResult implements ActionResult {

	private String redirectUrl;

	public RedirectResult(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	
}
