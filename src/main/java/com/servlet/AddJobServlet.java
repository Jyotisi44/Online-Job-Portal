package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;



import com.DB.ConnectionFactory;
import com.dao.JobDaoImp;
import com.entity.Jobs;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/add_job")
public class AddJobServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");
			String pdate=LocalDate.now().toString();
			
			
			HttpSession session = req.getSession();
			
//			JobDaoImp dao = new JobDaoImp(ConnectionFactory.getCon());
//			boolean f = dao.addJobs(id, title, location, category, status,desc, pdate);
//			
			if(new JobDaoImp(ConnectionFactory.getCon()).addJobs(id, title, desc, category, status, location, pdate)) {
				session.setAttribute("succMsg","Job Post Successfully");
				resp.sendRedirect("add_job.jsp");
			}
			else
			{
				session.setAttribute("succMsg","Something wrong on server");
				resp.sendRedirect("add_job.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
