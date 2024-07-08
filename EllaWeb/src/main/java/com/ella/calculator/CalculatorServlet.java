package com.ella.calculator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String operator = request.getParameter("operator");
		
		// Wrapper클래스
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int result = 0;
		
		switch(operator) {
		case "+" :
			result = number1 + number2;
			break;
		case "-" :
			result = number1 - number2;
			break;
		case "*" :
			result = number1 * number2;
			break;
		case "/" :
			result = number1 / number2;
			break;
		case "%" :
			result = number1 % number2;
			break;
		}
		// 앞에는 String이고 뒤에는 Object 타입임
		// 오브젝트는 모든 클래스의 슈퍼클래스기 때문에 int도 되고 String도 가능
		// 업캐스팅 발생
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("operator", operator);
		request.setAttribute("result", result);
		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
	
		System.out.println(String.valueOf(number1) instanceof String);
		System.out.println(number1+""  instanceof String);
		System.out.println(Integer.valueOf(number1).toString() instanceof String);
		
		
	}
	
	
}










