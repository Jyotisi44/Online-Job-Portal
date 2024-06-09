package com.servlet;

import java.io.IOException;



import com.DB.ConnectionFactory;
import com.dao.JobDaoImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("id");
			
			HttpSession session = req.getSession();
			
			if(new JobDaoImp(ConnectionFactory.getCon()).deleteJobs(id)) {
				session.setAttribute("succMsg","Job delete Successfully");
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
