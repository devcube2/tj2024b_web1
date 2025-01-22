package day04;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day04/example1")
public class Example1 extends HttpServlet {
	// 1. 쿼리스트링 예]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 URL의 쿼리스트링의 매개변수 값 반환 함수
		String value1 = req.getParameter("value1");
		int value2 = Integer.parseInt(req.getParameter("value2"));
		System.out.println("value1: " + value1);
		System.out.println("value2: " + value2);
		// 2. 응답 HTTP header body
		boolean result = true;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}

	// 2. HTTP header body(본문) 예]
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 HTTP HEADER BODY(본문) 의 JSON 타입 --> DTO 로 변환
		ObjectMapper mapper = new ObjectMapper();
		ValueDto valueDto = mapper.readValue(req.getReader(), ValueDto.class);
		System.out.println(valueDto);
		// 2. 응답 HTTP header body
		ValueDto result = new ValueDto("강호동", 23);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}