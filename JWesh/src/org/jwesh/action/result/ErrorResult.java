package org.jwesh.action.result;

public class ErrorResult implements ActionResult {

	private int code;

	public ErrorResult(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
