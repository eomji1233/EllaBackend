package com.ella.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ella.spring.member.domain.MemberVO;
import com.ella.spring.member.service.MemberService;

@Controller 
// spring하면 bean생각 bean하면 내가 만든 클래스 bean에 등록하기 component로 할 수도 있고 
// 구체화된 Controller랑 Service를 Annotation으로 추가해주기
public class MemberController {
	@Autowired
	private MemberService mService; // 결합도 낮추기 위해서 인터페이스 사용
	
	// url인 value는 똑같아도됨 메소드만 다르면 돼
	@RequestMapping(value="/member/register.kh", method=RequestMethod.GET)
	public String showInsertForm(Model model) {
		return "member/insert";
	}
	
	
	// 컨트롤러에서 메소드를 쓸 때는 @RequestMapping, void가 아닌 String, 
	// 전달값에는 model, return은 String
	@RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
	public String insertMember(
			HttpServletRequest request // 쓸 순 있음 나중에 세션쓸 때 사용!
			, HttpServletResponse response
			, @RequestParam("memberId") String memberId
			, @RequestParam("memberPw") String memberPw
			, @RequestParam("memberName") String memberName
			, @RequestParam(value="memberAge", required=false, defaultValue="0") int memberAge
			, @RequestParam(value="memberGender", required=false) String memberGender
			, @RequestParam(value="memberEmail", required=false) String memberEmail
			, @RequestParam(value="memberPhone", required=false) String memberPhone
			, @RequestParam(value="memberAddress", required=false) String memberAddress
			, Model model) {
			// request 대신 model! 이 페이지의 정보 넣어놓는거
//		String memberId = request.getParameter("memberId");
//		String memberPw = request.getParameter("memberPw");
		try {
			MemberVO member = new MemberVO(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddress);
			int result = mService.insertMember(member); // 그냥 컨트롤 누르면 인터페이스로 이동 얘랑 결합되있으니까!
			if(result > 0) {
				// 메인페이지로 이동
//				response.sendRedirect("/");
				return "redirect:/index.jsp";
			} else {
				// 에러페이지로 이동
//				request.setAttribute("msg", "회원가입이 완료되지 않았습니다");
//				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
				model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
				return "common/errorPage";
				// 이게 가능한 이유는 return ""을 쓰면 ViewResolver를 쓴다는 뜻인데 
				// servlet-context.xml에 자동으로 값을 붙여주기 떄문임 
			}			
		} catch (Exception e) {
			// 에러페이지로 이동
//			request.setAttribute("msg", e.getMessage());
//			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	@RequestMapping(value="/member/login.kh", method=RequestMethod.POST) // 로그인은 1차적으로 안보이는게 목적이니까 POST로 한다
	public String checkLogin(Model model
			, HttpSession session
			, @RequestParam("memberId") String memberId
			, @RequestParam("memberPw") String memberPw) {
		try {
			// MemberVO member = new MemberVO(memberId, memberPw);
			MemberVO member = new MemberVO();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member = mService.checkMemberLogin(member);
			if(member != null) {
				// 로그인 성공 후 세션에 정보 저장
				session.setAttribute("memberId", member.getMemberId());
				// 이거 때문에 ${memberId}했을 때 값 받아올 수 있음
				session.setAttribute("memberName", member.getMemberName());
				return "redirect:/";
			} else {
				// 로그인 실패
				model.addAttribute("msg", "로그인이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// 그 외에 예외 발생시(쿼리문 오타, NullPointExciption 등...)
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	@RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)
	public String memberLogout(Model model, HttpSession session) {
		try {
			if(session != null) {
				session.invalidate();
				return "redirect:/";
			} else {
				model.addAttribute("msg", "로그아웃을 완료하지 못하였습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
}
