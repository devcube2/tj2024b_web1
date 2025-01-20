package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1단계 : 임의의 클래스 의 extends HttpServlet
// 2단계 : (web.xml자동처리) 선언된 클래스위에 @WebServlet("/주소정의")
// 3단계 : http method 매핑 메소드들을 재정의(오버라이딩)

@WebServlet("/day03/example1")
public class Example1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP POST 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1");
		System.out.printf("data1: %s\n", data1);
		String data2 = req.getParameter("data2");
		System.out.printf("data2: %s", data2);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP GET 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1");
		System.out.printf("data1: %s\n", data1);
		String data2 = req.getParameter("data2");
		System.out.printf("data2: %s", data2);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP PUT 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1");
		System.out.printf("data1: %s\n", data1);
		String data2 = req.getParameter("data2");
		System.out.printf("data2: %s", data2);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP DELETE 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1");
		System.out.printf("data1: %s\n", data1);
		String data2 = req.getParameter("data2");
		System.out.printf("data2: %s", data2);
	}
}
