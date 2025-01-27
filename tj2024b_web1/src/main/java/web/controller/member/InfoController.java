package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@WebServlet("/member/info")
public class InfoController extends HttpServlet {
	// [ 내(로그인된) 정보 조회 ]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDto result = null;
		
		// 현재 로그인된 회원의 번호
		HttpSession session = req.getSession(); // 세션 가져오기.
		Object object = session.getAttribute("loginMno");
		if ( object != null ) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().myInfo(loginMno);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result); 
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		
		boolean result = false;
		if ( object != null ) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().delete(loginMno);
			if (result) {
				session.removeAttribute("loginMno"); // 세션객체내 속성제거 -> 로그아웃				
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);		
		
		boolean result = false;
		// 현재 로그인 된 회원번호
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if (object != null) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno); // 조회된 로그인된 회원번호를 dto에 넣어주고.
			result = MemberDao.getInstance().update(memberDto);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
