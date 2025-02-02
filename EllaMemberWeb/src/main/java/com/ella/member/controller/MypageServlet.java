package com.ella.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ella.member.model.service.MemberService;
import com.ella.member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/member/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String memberId = request.getParameter("memberId");
			// 쿼리문? SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
			MemberService mService = new MemberService();
			Member member = mService.selectOnebyId(memberId);
			if(member != null) {
				// 마이페이지로 이동
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp")
				.forward(request, response);
			} else {
				// 에러페이지로 이동
			}

		}
		catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
		}
	}

}
