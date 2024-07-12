package com.ella.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ella.notice.model.service.NoticeService;
import com.ella.notice.model.vo.Notice;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/notice/insert.kh")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String noticeSubject = request.getParameter("notice-subject");
			String noticeContent = request.getParameter("notice-content");
			String writer = (String)session.getAttribute("memberId");
			Notice notice = new Notice(noticeSubject, noticeContent, writer);
			NoticeService nService = new NoticeService();
			int result = nService.insertNotice(notice);
			if (result > 0) {
				response.sendRedirect("/notice/list.kh");
				// reponse.sendRedirect는 jsp를 못부름 
				// dispatcher로 부르면 request값이 없어서 나오는 내용이 없다
			} else {
				request.setAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
