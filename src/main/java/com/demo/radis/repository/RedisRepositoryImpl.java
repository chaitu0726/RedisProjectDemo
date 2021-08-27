package com.demo.radis.repository;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.radis.model.Login;

@Repository
public class RedisRepositoryImpl  implements RedisRepository{

	private static final String LOGIN_QUERY = "Select * from Login where user_id = ? and passcode = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public Login login(Login login) {
		try {
			Login data = this.jdbcTemplate.queryForObject(LOGIN_QUERY, new Object[]{login.getUsername(),login.getPassword()}, new RowMapper<Login>() {
	
				public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Login login = new Login();
					login.setLoginId(rs.getInt(1));
					login.setUsername(rs.getString(2));
					login.setPassword(rs.getString(3));
					return login;
				}
			}); 
			
			return data;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
