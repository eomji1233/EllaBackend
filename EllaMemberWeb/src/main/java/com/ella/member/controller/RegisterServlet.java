package com.ella.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.ContinueResponseTiming;

import com.ella.member.model.service.MemberService;
import com.ella.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
//주소 표시줄에 url을 직접 입력해서 들어가는건 무조건 get방식
@WebServlet("/member/join.do")
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
//		response.sendRedirect("/WEB-INF/views/member/register.jsp"); 이건 그냥 주소창에 경로를 복붙한거랑 똑같음
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
		// 이건 창띄우는 용도
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이건 정보 저장하는 용도
		request.setCharacterEncoding("UTF-8"); //모든걸 request로 받고있으니까 request로 받는 값을 utf-8로 받아!
		String memberId   = request.getParameter("member-id");
		String memberPw   = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String gender     = request.getParameter("gender");
		String age 		  = request.getParameter("age");
		String email      = request.getParameter("email");
		String phone 	  = request.getParameter("phone");
		String address 	  = request.getParameter("address");
		String hobby 	  = request.getParameter("hobby");
		
		// 회원가입 비즈니스 로직
		Member member = new Member(memberId, memberPw, memberName, gender, Integer.parseInt(age), email, phone, address, hobby);		
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		if(result > 0) {
			// 성공 메시지 출력
			// 1. redirect
			// response.sendRedirect("");
			// 2. requestDispatcher
			// request.getRequestDispatcher("").forward(request, response);
			// request.setAttribute("msg", "성공"); -- 어떤 메시지를 전달해야할 때
			// 오류페이지를 만들어놨고 그대로 오류페이지를 보여주고 싶으면 1
			// 오류페이지 다르게 만들고 싶으면 2 (불러온 객체를 넣어서 반응)
			response.sendRedirect("/index.jsp");
		} else {
			// 실패 메시지 출력
//			response.sendRedirect("/common/error/errorPage.jsp"); // erropPage.jsp를 WEB-INF 아래로 옮겼기 때문에 불가능
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}

}













