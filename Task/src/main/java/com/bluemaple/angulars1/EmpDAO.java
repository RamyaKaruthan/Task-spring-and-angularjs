package com.bluemaple.angulars1;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.bluemaple.js.Loginpage;


@Repository
public class EmpDAO implements IempDAo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	/*@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public Loginpage getLogin(String username,String password) {
		String sql="SELECT*FROM employeedb WHERE user_name=? AND password=?";
		System.out.println("Login Query: "  + " with params: "
				+ username + "," + password);
		try {
			
			Loginpage loginpage1 = jdbcTemplate.query(sql,
					new ResultSetExtractor<Loginpage>() {

						public Loginpage extractData(ResultSet rs)
								throws SQLException, DataAccessException {
							if (rs.next()) {
								Loginpage user = new Loginpage();
								user.setUsername(rs.getString(2));								
								user.setEmailaddress(rs.getString(6));

								return user;
							}
							return null;
						}
					}, new Object[] { username, password });
			if (loginpage1 != null) {
				return loginpage1;
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		return null;
	}

	
	public Loginpage getReg(Loginpage loginpage) {
		String sql = "INSERT INTO employeedb"
				+ "(Userid,username,password,emailaddress,firstname,lastname,dob,age,sex) VALUES (?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, loginpage.getUserid(),
				loginpage.getUsername(), loginpage.getPassword(),
				loginpage.getEmailaddress(), loginpage.getLastname(),
				loginpage.getDob(), loginpage.getAge(), loginpage.getSex());
		return loginpage;

	}



	
}