package day03.task3;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet {
	private ObjectMapper mapper = new ObjectMapper();
	
	// 1. 방문록 등록	: POST		, url : http://localhost:8080/tj2024b_web1/day03/visit2
	// 매개변수 : BOD	Y 			, 매개변수 예] { "content":"안녕" , "age":"30" }
	// 반환타입 : application/json	, 배개변수 예] true
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		// 2. DAO 처리
		boolean result = VisitDao.getInstance().write(visitDto);
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// 2. 방문록 전체 조회			: GET			, 매개변수 : X
	// 매개변수 : X
	// 반환타입 : application/json	, 매개변수 예] [ {"num" : 1 , "content" : "안녕1" , "age" : 30} , {"num" : 2 , "content" : "안녕2" , "age" : 40} ]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<VisitDto> result = VisitDao.getInstance().findByAll();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	// 3. 방문록 수정				: PUT			, 매개변수 : BODY
	// 매개변수 : BODY 				, 매개변수 예] { "num":3 , "content":"수정안녕" , "age":40 }
	// 반환타입 : application/json	, 배개변수 예] true
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		// 2. DAO 처리
		boolean result = VisitDao.getInstance().update(visitDto);
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// 4. 방문록 삭제				: DELETE		, 매개변수 : querySring
	// 매개변수 : queryString 		, 매개변수 예] ?bnum=1
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		boolean result = VisitDao.getInstance().delete(num);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}