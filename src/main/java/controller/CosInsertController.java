package controller;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CosService;
import vo.ReVo;





public class CosInsertController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertServic(req, resp);
		}else if (req.getMethod().equals("GET")) {
			return processInsertView(req, resp);
		}
		return "redirect::/";
	}
	
	private String processInsertServic(HttpServletRequest req, HttpServletResponse resp) {
	int re_code = Integer.parseInt(req.getParameter("re_code"));
	String re_phone = req.getParameter("re_phone");
	Date re_date = Date.valueOf(req.getParameter("re_date"));
	String re_time = req.getParameter("re_time");
	int re_person = Integer.parseInt(req.getParameter("re_person"));
	String cos_code = req.getParameter("cos_code");
	String cos_price = req.getParameter("cos_price");
		
		
		ReVo re = new ReVo();
		re.setRe_code(re_code);
		re.setRe_phone(re_phone);
		re.setRe_date(re_date);
		re.setRe_time(re_time);
		re.setRe_person(re_person);
		re.setCos_code(cos_code);
		re.setCos_price(cos_price);
		
		
		
		CosService service = new CosService();
		int  n = 0;	
		try {
			n = service.cosInsert(re);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::courseList"; 
		}else {
			return "cosInsert";
		}
	}
	private String processInsertView(HttpServletRequest req, HttpServletResponse resp) {
		
				CosService service = new CosService();
				int re_code = service.getMaxRe_code();
				req.setAttribute("re_code", re_code);
				
				return "cosInsert";
			
	}
}
