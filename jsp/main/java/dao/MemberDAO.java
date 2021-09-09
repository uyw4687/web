package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Member;

public class MemberDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url, "scott", "tiger");
		
	}
	
	public boolean insert(Member newMember) {
		
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into member values(?,?,?,?)");
			pst.setString(1, newMember.getId());
			pst.setString(2, newMember.getPw());
			pst.setString(3, newMember.getNick());
			pst.setString(4, newMember.getEmail());
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean remove(String id) {

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from member where id=?");
			pst.setString(1, id);
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Member search(String id) {

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from member where id=?");
			pst.setString(1, id);
			
			ResultSet result = pst.executeQuery();
			
			Member member = null; 
			if(result.next()) {
				member = new Member();
				member.setId(result.getString(1));
				member.setPw(result.getString(2));
				member.setNick(result.getString(3));
				member.setEmail(result.getString(4));
			}
			
			result.close();
			pst.close();
			con.close();
			
			return member;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean change(Member member) {

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update member set pw=?, nick=?, email=? where id=?");
			pst.setString(1, member.getPw());
			pst.setString(2, member.getNick());
			pst.setString(3, member.getEmail());
			pst.setString(4, member.getId());
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public ResultSet show() {

		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			
			ResultSet result = st.executeQuery("select * from member");
			
			result.close();
			st.close();
			con.close();
			
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
