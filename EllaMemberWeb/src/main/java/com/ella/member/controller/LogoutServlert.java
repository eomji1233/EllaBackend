package com.ella.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlert
 */
@WebServlet("/member/logout.do")
public class LogoutServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlert() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 절대 post로 할 수 없어! a태그에 적었던 url을 클릭해서 들어가는게 get
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate(); // 세션 파괴 -> 다시 로그인
			response.sendRedirect("/");
		}
	}

}






















