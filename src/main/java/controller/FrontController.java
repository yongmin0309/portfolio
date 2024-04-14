package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForntController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    String charset = null;
	HashMap<String, Controller> list = null;
	
	private final String prefix = "/view/";
	private final String postfix = ".jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("프론트 생성");
		charset = config.getInitParameter("charset");
		
			list = new HashMap<String, Controller>();
			list.put("/", new MainController());
			list.put("/cosList", new CosListController());
			list.put("/cosInsert", new CosInsertController());
			list.put("/cosUpdate", new CosUpdateController());
			list.put("/cosDelete", new CosDeleteController());

			
			
			
		
			
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException{
		System.out.println("프론트 실행");
		req.setCharacterEncoding(charset);
		
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		
		Controller subController = list.get(path);
		
		if(subController == null) {
			resp.sendRedirect("/");
			return;
		}
		
		System.out.println("여기까진 옴 : "+ path);
		String result = subController.execute(req, resp);
		System.out.println("여기까진 옴 : "+ result);
			
		if(result.indexOf("redirect::") != 0) {
			System.out.println(prefix + result + postfix);
			RequestDispatcher dispatcher = req.getRequestDispatcher(prefix + result + postfix);
			System.out.println("포워딩 함");
			dispatcher.forward(req, resp);
		}else {
			String reUrl = result.substring("redirect::".length());
			resp.sendRedirect(reUrl);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

