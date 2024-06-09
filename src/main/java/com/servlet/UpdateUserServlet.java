package com.servlet;

import java.io.IOException;



import com.DB.ConnectionFactory;
import com.dao.UserDaoImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
try {
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String qua = req.getParameter("qua");
			String email = req.getParameter("email");
			String ps = req.getParameter("ps");
		
			
			HttpSession session= req.getSession();
			
			if(new UserDaoImp(ConnectionFactory.getCon()).updateUser(id, name, email, ps, qua, "User"))
			{
				session.setAttribute("succMsg", "Profile Update Successfully");
				resp.sendRedirect("home.jsp");
			}
			else
			{
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("home.jsp");

			}
			
		}catch (Exception e) {
			
		}

	}
}
