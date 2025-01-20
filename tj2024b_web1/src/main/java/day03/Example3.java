package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// * JSON 자료의 문자열 타입을 DTO 타입으로 변환해보기.
		System.out.println("[HTTP POST 방식으로 요청이 왔어요.]");
//		System.out.println(req.getReader().readLine());
		
		// JSON 모양의 문자열타입 자료를 DTO 로 변환 라이브러리가 필요하다.
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP PUT 방식으로 요청이 왔어요.]");
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
	}
}
