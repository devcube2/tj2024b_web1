package day08.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doPost] 호출");

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> map = mapper.readValue(req.getReader(), HashMap.class);

		int 대기번호 = (Integer) map.get("대기번호");
		String 전화번호 = map.get("전화번호").toString();
		int 인원수 = (Integer) map.get("인원수");
		System.out.printf("대기번호: %d , 전화번호: %s , 인원수: %d\n", 대기번호, 전화번호, 인원수);

		resp.setContentType("application/json");

		HttpSession session = req.getSession();
		Object object = session.getAttribute(String.valueOf(대기번호));
		if (object != null) {
			resp.setStatus(HttpServletResponse.SC_CONFLICT);
			resp.getWriter().print("{\"message\": \"이미 등록된 대기번호 입니다.\"}");
			return;
		}

		session.setAttribute(String.valueOf(대기번호), mapper.writeValueAsString(map));
		resp.getWriter().print(true);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doGet] 호출");

		HttpSession session = req.getSession();

		resp.setContentType("application/json");

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode jsonArray = mapper.createArrayNode();

		// 세션 속성 값을 순회하면서 가져오기
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);

			jsonArray.add(attributeValue.toString());
		}

		resp.getWriter().println(jsonArray);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doPut] 호출");

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> map = mapper.readValue(req.getReader(), HashMap.class);

		int 대기번호 = (Integer) map.get("대기번호");
		String 전화번호 = map.get("전화번호").toString();
		int 인원수 = (Integer) map.get("인원수");

		resp.setContentType("application/json");

		HttpSession session = req.getSession();
		Object object = session.getAttribute(String.valueOf(대기번호));
		if (object == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			resp.getWriter().print("{\"message\": \"존재하지 않는 대기번호 입니다.\"}");
			return;
		}

		session.setAttribute(String.valueOf(대기번호), mapper.writeValueAsString(map));
		resp.getWriter().print(true);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doDelete] 호출");

		int 대기번호 = Integer.parseInt(req.getParameter("대기번호"));

		resp.setContentType("application/json");

		HttpSession session = req.getSession();
		Object object = session.getAttribute(String.valueOf(대기번호));
		if (object == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			resp.getWriter().print("{\"message\": \"존재하지 않는 대기번호 입니다.\"}");
			return;
		}

		session.removeAttribute(String.valueOf(대기번호));
		resp.getWriter().print(true);
	}
}
