package com.ella.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ella.member.model.service.MemberService;
import com.ella.member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/member/mypage.kh")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			String memberId = request.getParameter("memberId"); 
			// 쿼리에 아이디있어서 조작하면 해킹가능
			// 세션에서 아이디 가져오기 -> 로그인한 사용자에 한해서 마이페이지 정보를 가져올 수 있음.
			HttpSession session = request.getSession();
			String memberId = (String) session.getAttribute("memberId"); // 세션의 값은 오브젝트라서 형변환해주기
			if (session != null && !"".equals(memberId)) { // memberId가 ""(비어있는 상태)도 아닌 상태여야해! !는 부정연산자
				MemberService mService = new MemberService();
				Member member = mService.selectOneById(memberId);
				if (member != null) {
					request.setAttribute("member", member);
					request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "존재하지 않는 정보입니다");
					request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "로그인이 필요합니다");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
