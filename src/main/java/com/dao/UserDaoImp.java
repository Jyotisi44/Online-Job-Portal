package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDaoImp {

	private Connection con;

	public UserDaoImp(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean register(String id, String name, String email, String password, String qualification, String role)
	{
		int i = Integer.parseInt(id);
		boolean f = false;
		
		try
		{
			String sql = "insert into user(id,name,email,password,qualification,role) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, qualification);
			ps.setString(6, "user");
			
			int p = ps.executeUpdate();
			if(p==1) {
				f=true;
			}
			
			
		}catch (Exception e) {
			
		}
		return f;
	}
	
	public User login(String em,String psw)
	
	{
		User u = null;
		
		try
		{
			String sql = "Select * from user where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,em);
			ps.setString(2, psw);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setQualification(rs.getString(5));
				u.setRole(rs.getString(6));
			}
		}catch (Exception e) {
		
		}
		return u;
	}
	
	public boolean updateUser(String id, String name, String email, String password, String qualification, String role)
	{
		int i = Integer.parseInt(id);
		boolean f = false;
		
		try
		{
			String sql = "update user set name=?,email=?,password=?,qualification=?,role=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(6, i);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, qualification);
			ps.setString(5, "user");
			
			int p = ps.executeUpdate();
			if(p==1) {
				f=true;
			}
			
			
		}catch (Exception e) {
			
		}
		return f;
	}
	
}
