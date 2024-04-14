package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CosService;



public class CosDeleteController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int re_code = Integer.parseInt(req.getParameter("re_code"));
		
		CosService service = new CosService();
		int n = service.cosDelete(re_code);
		
		return "redirect::/cosList";
	}
}
