package org.jwesh.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.result.ActionResult;

public interface Action {

	ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
