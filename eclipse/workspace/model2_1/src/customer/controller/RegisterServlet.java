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
		 * 1. Ŭ���̾�Ʈ ��û �ޱ� - form-data �о���̱�
		 * 2. Business Logic ó�� (Model���� ��û)
		 * 3. ���� ó�� (View���� ��û)
		 */
		// �ѱ�ó��
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
		// ��û ����ġ ���
		request.setAttribute("custInfo", cvo);
		RequestDispatcher rdp = request.getRequestDispatcher("reg_success.jsp");
		rdp.forward(request, response);
	}

}