package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

	class MemberRowMapper implements RowMapper<Member> {
		
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), 
					rs.getString("NAME"), rs.getTimestamp("REGDATE"));
			member.setId(rs.getLong("ID"));
			return member;
		}
		
	}

//	private static long nextId = 0;
//
//	private Map<String, Member> map = new HashMap<>();
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
	
	}
	
	public Member selectByEmail(String email) {
		
		List<Member> list = jdbcTemplate.query("select * from member where email=?",
				new MemberRowMapper(), email);
		
		if(!list.isEmpty()) {
			return list.get(0);
		}
		else {
			return null;
		}
		
//		return map.get(email);

	}
	
	public void insert(final Member member) {
		
		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update((Connection con) -> {
			PreparedStatement ps = con.prepareStatement("insert into member(EMAIL, PASSWORD, NAME, REGDATE) "
					+ "values(?, ?, ?, ?)", new String[]{"ID"} );
			ps.setString(1, member.getEmail());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getName());
			ps.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
			return ps;	
		}, holder);

		System.out.println("추가 완료 id : " + holder.getKey().longValue());
		
//		member.setId(nextId++);
//		map.put(member.getEmail(), member);
	
	}
	
	public void update(Member member) {

		jdbcTemplate.update("update member set PASSWORD=? where EMAIL=?"
				, member.getPassword(), member.getEmail());
		
//		map.put(member.getEmail(), member);
		
	}
	
	public List<Member> selectAll() {
		
		List<Member> res = jdbcTemplate.query("select * from member", new MemberRowMapper());
		return res;
		
//		return map.values();

	}

	public int count() {
		
		return jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
	
	}
	
}