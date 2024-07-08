// 이건 자바코드랑 html코드가 짬뽕으로 섞여있어!
package com.ella.inputTaste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputTasteServlet
 */
@WebServlet("/InputTasteServlet")
public class InputTasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputTasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user-name");
		String color = request.getParameter("color");
		String [] foods = request.getParameterValues("foods");
		String pet = request.getParameter("pet");
		
		// 영어를 한글로 바꿔주는 역할
		Map<String, String> colorMap = new HashMap<String, String>();
		colorMap.put("red", "빨강");
		colorMap.put("blue", "파랑");
		colorMap.put("yellow", "노랑");
		colorMap.put("green", "초록");		
		
		Map<String, String> petMap = new HashMap<String, String>();
		petMap.put("puppy", "강아지");
		petMap.put("kitty", "고양이");
		petMap.put("elephant", "코끼리");
		petMap.put("lion", "사자");

		Map<String, String> foodMap = new HashMap<String, String>();
		foodMap.put("zzazang", "짜장면");
		foodMap.put("zzambbong", "짬뽕");
		foodMap.put("tangsu", "탕수육");
		foodMap.put("mapa", "마파두부");
		foodMap.put("palbo", "팔보채");
		
		
		String foodstr = "";
		for(String food : foods) {
			foodstr += foodMap.get(food) + ", ";
		}
		
//		response.sendRedirect("/taste/result.html"); html은 request가 접근할 수 없음
		// jsp와 연결해주는 역할
//		response.sendRedirect("/taste/tasteResult.jsp");
		request.setAttribute("userName", userName);
		request.setAttribute("color", colorMap.get(color));
		request.setAttribute("pet", petMap.get(pet));
		request.setAttribute("foodStr", foodstr);
		request.getRequestDispatcher("/taste/tasteResult.jsp").forward(request, response);
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>취향 조사 결과</title>");
//		out.println("</head><body>");
//		out.println("<h1>개인 취향 테스트 결과</h1>");
//		out.println("<p>이름? " + userName + "<br>");
//		out.println("좋아하는 색? <span style='color:"+color+";'><b>" + colorMap.get(color) + "</b></span><br>");
//		out.println("좋아하는 음식은? " + foodstr + "<br>");
//		out.println("좋아하는 동물은? " + petMap.get(pet) + "<br>");
//		out.println("</p>");
//		out.println("</body></html>");	
	}
}

//		if("red".equals(color)) {
//			color = "빨강";
//			} else if("blue".equals(color)) {
//				color = "파랑";
//			} else if("yellow".equals(color)) {
//				color = "노랑";
//			} else if("green".equals(color)) {
//				color = "초록";
//			}