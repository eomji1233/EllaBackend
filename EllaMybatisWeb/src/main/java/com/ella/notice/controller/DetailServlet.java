package com.ella.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ella.common.PageUtils;
import com.ella.notice.model.service.NoticeService;
import com.ella.notice.model.vo.Notice;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/notice/detail.kh")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageUtils pu = new PageUtils();
		String pageUrl = "/WEB-INF/views/common/errorPage.jsp";
		try {
//			String noticeNo = request.getParameter("noticeNo");
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			NoticeService nService = new NoticeService();
			Notice notice = nService.selectOneByNo(noticeNo);
			if(notice != null) {
				// detail.jsp 페이지로 이동
				// notice에 선택받은 notice 넣어줘야 글번호, 글쓴이, 작성일이 나와
				request.setAttribute("notice", notice);
				request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
			}else {
				// 오류 페이지 이동
				String errorMsg = "존재하지 않는 정보입니다.";
				pu.moveErrorPage(request, response, errorMsg); // 세번째 인자로 에러 메시지를 받는 경우
			}
		} catch (Exception e) {
			// TODO: handle exception
			pu.moveErrorPage(request, response, pageUrl); // 세번째 인자로 페이지 URL을 받는 경우
//			pu.moveErrorPage(request, pageUrl, pageUrl, e.getMessage());
		}
	}
}




























