package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	public Connection conn; // DB와 연동 결과를 조작하느 인터페이스
	private String dburl = "jdbc:mysql://localhost:3306/jspweb";
	private String dbuser = "root"; // 연동할 DB 서버의 계정명
	private String dbpwd = "1234"; // 연동할 DB 서버의 비밀번호

	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch (Exception e) {
			System.out.println("[DB 연동 실패]" + e);
		}
	}
}