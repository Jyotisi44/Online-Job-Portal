package com.servlet;

import java.io.IOException;
import java.time.LocalDate;



import com.DB.ConnectionFactory;
import com.dao.JobDaoImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet {

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
				
			if(new JobDaoImp(ConnectionFactory.getCon()).updateJobs(id, title, desc, category, status, location, pdate)) {
				session.setAttribute("succMsg","Job update Successfully");
				resp.sendRedirect("view_job.jsp");
			}
			else
			{
				session.setAttribute("succMsg","Something wrong on server");
				resp.sendRedirect("view_job.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
