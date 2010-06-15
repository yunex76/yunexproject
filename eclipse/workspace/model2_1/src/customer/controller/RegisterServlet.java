package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.service.CustomerService;
import customer.model.vo.CustomerVO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 클라이언트 요청 받기 - form-data 읽어들이기
		 * 2. Business Logic 처리 (Model에게 요청)
		 * 3. 응답 처리 (View에게 요청)
		 */
		// 한글처리
		request.setCharacterEncoding("euc-kr");
		
		// 1.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 2.
		CustomerService cs = new CustomerService();
		CustomerVO cvo = new CustomerVO(id, password, name, age);
		cs.registerCustomer(cvo);
		
		// 3.
		// 요청 디스패치 방식
		request.setAttribute("custInfo", cvo);
		RequestDispatcher rdp = request.getRequestDispatcher("reg_success.jsp");
		rdp.forward(request, response);
	}

}
