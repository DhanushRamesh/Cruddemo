package com.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.crud.model.UserModel;

public class UserDao {
	
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	
	public int save(UserModel userdetails) {
		 String sql="insert into crud.users(name,email,username) values('"+ userdetails.getName()+"','"+userdetails.getEmail()+"','"+userdetails.getUsername()+"')";    
		    return template.update(sql);    
	}


	public int update(UserModel userdetails) {
		String sql="update crud.users set name='"+userdetails.getName()+"', email='"+userdetails.getEmail()+"',username='"+userdetails.getUsername()+"' where id="+userdetails.getId()+"";    
	    return template.update(sql);    

	}

	
	public UserModel get(Integer id) {
		String sql="select * from crud.users where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<>(UserModel.class));    
	}

	
	public int delete(Integer id) {
		String sql="delete from crud.users where id="+id+"";    
	    return template.update(sql);   
	}

	
	public List<UserModel> list() {
		return template.query("select * from users",new RowMapper<UserModel>(){    
	        public UserModel mapRow(ResultSet rs, int row) throws SQLException {    
	            UserModel u=new UserModel();    
	            u.setId(rs.getInt(1));    
	            u.setName(rs.getString(2));      
	            u.setEmail(rs.getString(3));    
	            return u;    
	        }    
	    }); 
		
		
	}

}
