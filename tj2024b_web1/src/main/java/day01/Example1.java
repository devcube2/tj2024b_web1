package day01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://192.168.40.72:8080/tj2024b_web1/day01/example1   URL : 절대경로 
// URL : 
@WebServlet("/day01/example1")
public class Example1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("안녕 나는 서블릿이야. 444");
	}
}
