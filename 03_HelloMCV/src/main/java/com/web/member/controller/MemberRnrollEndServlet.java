package com.web.member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.member.dto.Member;
import com.web.member.service.MemberService;

import oracle.sql.CharacterSet;

/**
 * Servlet implementation class MemberRnrollEndServlet
 */
@WebServlet("/member/enrollend.do")
public class MemberRnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 form 태그로 전송한 테이를
		// 정해진 DB에 젖아하는 기능
		
//		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		
		//dto(Vo)클래스를 선언
		Member m = new Member();
		m.setUserId(userId);
		m.setPassword(password);
		m.setUserName(userName);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setGender(gender);
		m.setHobby(String.join(",",hobby));
		
		int result =  new MemberService(). insertMember(m);
		String msg,loc;
		if(result > 0) {
			//회원가입 성공
			msg ="회원가입을 축하드립나다 :D";
			loc="/";
		}
		else {
			//회원가입실패
			msg ="회원가입에 실패했습니다 :(";
			loc="/member/enrollmember.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
		
//		System.out.println(userId);
//		System.out.println(password);
//		System.out.println(userName);
//		System.out.println(age);
//		System.out.println(email);
//		System.out.println(phone);
//		System.out.println(address);
//		System.out.println(gender);
//		System.out.println(Arrays.toString(hobby));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
