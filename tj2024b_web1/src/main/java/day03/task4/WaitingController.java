package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting2")
public class WaitingController extends HttpServlet{	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doPost 호출]");			
		// 2. JSON -> DTO 변환
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto visitDto = mapper.readValue(req.getReader(), WaitingDto.class);				
		// 3. DAO 처리
		boolean result = WaitingDao.getInstance().write(visitDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doGet 호출]");		
		ArrayList<WaitingDto> result = WaitingDao.getInstance().findByAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doPut 호출]");
		// 2. JSON -> DTO 변환
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);		
		System.out.println(waitingDto);
		// 3. DAO 처리
		boolean result = WaitingDao.getInstance().update(waitingDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doDelete 호출]");
		// 1. queryString의 매개변수를 파싱 하기 위한 코드
		int no = Integer.parseInt(req.getParameter("no"));		
		// 2. DAO 처리
		boolean result = WaitingDao.getInstance().delete(no);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
