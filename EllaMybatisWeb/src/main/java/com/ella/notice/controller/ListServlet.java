package com.ella.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ella.notice.model.service.NoticeService;
import com.ella.notice.model.vo.Notice;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/notice/list.kh")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nService = new NoticeService();
		List<Notice> nList = nService.selectAllNotice();
//		if(nList.isEmpty() > 0) {
		if(nList.size() > 0) {
			// list.jsp로 이동
			request.setAttribute("nList", nList);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "존재하지 않는 정보입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
		}
	}

}
