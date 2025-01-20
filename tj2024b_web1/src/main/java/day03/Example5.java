package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = true;						// 1. 응답할 자료 준비
		resp.setContentType("application/json");	// 2. HTTP 를 이용한 응답 헤더 정보 추가
		resp.getWriter().print(result);				// 3. HTTP 를 이용한 요청에 따른 응답 자료 보내기
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "java";
		resp.setContentType("text/plain");	// 문자열 1개는 application/json 타입변환 불가능
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 30;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석", 50);
		// DTO --> JSON 으로 변환
		// 1. ObjectMapper 인스턴스 생성
		
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json"); // 오류 : DTO 를 JSON 으로 타입변환 불가능.
		resp.getWriter().print(jsonResult);
	}
}
