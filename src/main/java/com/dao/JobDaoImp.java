package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DB.ConnectionFactory;
import com.entity.Jobs;

public class JobDaoImp {

	private Connection con;

	public JobDaoImp(Connection con) {
		super();
		this.con = con;
	}
	
	String result =  " ";
	public boolean addJobs(String id, String title, String description, String category, String status, String location,String pdate)
	{
		int i = Integer.parseInt(id);
		boolean f = false;
		
		try {
			
			String sql = "insert into jobs(id,title,description,category,status,location,pdate) values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2,title);
			ps.setString(3, description);
			ps.setString(4,category);
			ps.setString(5, status);
			ps.setString(6, location);
			ps.setString(7, pdate);
			
		 
		   int p = ps.executeUpdate();
		   if(p==1)
		   {
			   f=true;
		   }
			result = "inserted";
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
//	ArrayList<Jobs> a1 = new ArrayList<Jobs>();
	public List<Jobs> getAllJobs(){
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		try
		{
		String sql = "select * from jobs order by id desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery(sql);
		
		while(rs.next())
		{
		    j = new Jobs();
			j.setId(rs.getString(1));
			j.setTitle(rs.getString(2));
			j.setDescription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getString(7));
			list.add(j);
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		return list;
	}
	}
	

	public Jobs getJobById(String id){
		Jobs j = null;
	
		try
		{
		String sql = "select * from jobs where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next())
		{
			j = new Jobs();
			j.setId(rs.getString(1));
			j.setTitle(rs.getString(2));
			j.setDescription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getString(7));
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		return j;
	}
	}

	public List<Jobs> getAllJobsForUser(){
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		try
		{
		String sql = "select * from jobs where status='Active' order by id desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		//ps.setString(1, "Active");
		ResultSet rs = ps.executeQuery(sql);
		
		while(rs.next())
		{
		    j = new Jobs();
			j.setId(rs.getString(1));
			j.setTitle(rs.getString(2));
			j.setDescription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getString(7));
			list.add(j);
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		return list;
	}
	}

	public List<Jobs> getJobsORLocationAndCate(String category,String location){
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		try
		{
		String sql = "select * from jobs where category='Devloper' or location='jharkhand' order by id desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, category);
//		ps.setString(2, location);
		ResultSet rs = ps.executeQuery(sql);
		
		while(rs.next())
		{
		    j = new Jobs();
			j.setId(rs.getString(1));
			j.setTitle(rs.getString(2));
			j.setDescription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getString(7));
			list.add(j);
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		return list;
	}
	}
	
	public List<Jobs> getJobsAndLocationAndCate(String category,String location){
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		try
		{
		String sql = "select * from jobs where category=? and location=? order by id desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category);
		ps.setString(2, location);
		ResultSet rs = ps.executeQuery(sql);
		
		while(rs.next())
		{
		    j = new Jobs();
			j.setId(rs.getString(1));
			j.setTitle(rs.getString(2));
			j.setDescription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getString(7));
			list.add(j);
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		return list;
	}
	}
	
	public boolean updateJobs(String id, String title, String description, String category, String status, String location,String pdate)
	{
		int i = Integer.parseInt(id);
		boolean f = false;
		
		try {
			
			String sql = "update jobs set title=?,description=?,category=?,status=?,location=?,pdate=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(7, i);
			ps.setString(1,title);
			ps.setString(2, description);
			ps.setString(3,category);
			ps.setString(4, status);
			ps.setString(5, location);
			ps.setString(6, pdate);
			
		 
		   int p = ps.executeUpdate();
		   if(p==1)
		   {
			   f=true;
		   }
			result = "updated";
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	
	public boolean deleteJobs(String id)
	{
		boolean f = false;
		try {
			int i = Integer.parseInt(id);
		//	Connection con = ConnectionFactory.getCon();
			
			String sql = "delete from jobs where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			
			int p = ps.executeUpdate();
			   if(p==1)
			   {
				   f=true;
			   }
			result = "deleted";
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		finally
		{
			return f;
		}
	}
	
	
}
