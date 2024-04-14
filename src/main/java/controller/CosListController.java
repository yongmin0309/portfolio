package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CosService;

import vo.ReVo;

public class CosListController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		CosService service = new CosService();
		ArrayList<ReVo> list = service.cosList();
		
		req.setAttribute("list", list);
		return "cosList";
	}
}
