package com.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.member.dto.Member;
import com.web.member.service.MemberService;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�α��α��
		//����ڰ� ���� id, password�� ������ -> request��ü�� ������ �Ǿ�����
		//DB�� Ư�����̺� �ִ��� Ȯ���ϰ� ������ ����ó�� ������ ����ó��
		//Ŭ���̾�Ʈ�� ���� �����͸� ���������� 
		//request.getParameter() -> �Ѱ����� �����ö�  
		//request.getParameterValues() -> ���߰��� �����ö� 
		//�޼ҵ带 �̿�
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		System.out.println(userId);
		System.out.println(password);
		
		String saveId=request.getParameter("saveId");
		System.out.println(saveId);
		if(saveId!=null) {
			//Cookie�� ������ ����
			Cookie c=new Cookie("saveId",userId);
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}else {
			//����� Cookie�� ����
			Cookie c=new Cookie("saveId","");
			//�����Ⱓ�� 0���� ���� -> ����
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
		//������ ���� DB�� �ִ��� check
		//DB�� �����ϱ� -> JDBC jar�� �߰�
		//���̵� ��ġ�ϴ� ȸ���� ��ȸ��.
		Member m=new MemberService().selectMemberById(userId);
		//System.out.println(m);
		if(m!=null && m.getPassword().equals(password)) {
			//���̵� �ִ� ȸ�� -> ����ó��
			//HttpSession��ü�� ����
			HttpSession session=request.getSession();
			session.setAttribute("loginMember", m);
			//�α��� �� ����ȭ������ �̵�
			response.sendRedirect(request.getContextPath());
			
		}else {
			//���̵� ���� ȸ�� -> ��������
			request.setAttribute("msg",
					"���̵� �н����尡 ��ġ���� �ʽ��ϴ�.");
			request.setAttribute("loc", "/");
			//�޼���ó�� �������� ��ȯ�ϱ�
			RequestDispatcher rd=request
					.getRequestDispatcher("/views/common/msg.jsp");
			rd.forward(request,response);
			
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
