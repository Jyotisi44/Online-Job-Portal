package com.servlet;

import java.io.IOException;



import com.DB.ConnectionFactory;
import com.dao.JobDaoImp;
import com.dao.UserDaoImp;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String qua = req.getParameter("qua");
			String email = req.getParameter("email");
			String ps = req.getParameter("ps");
			String role = req.getParameter("role");
			
			HttpSession session= req.getSession();
			
//			UserDaoImp dao = new UserDaoImp(ConnectionFactory.getCon());
//			User u = new User(id,name,qua,email,ps,role);
//			boolean f = dao.register(id, name, email, ps, qua, role);
			
			if(new UserDaoImp(ConnectionFactory.getCon()).register(id, name, email, ps, qua, "User"))
			{
				session.setAttribute("succMsg", "Registration Successfully");
				resp.sendRedirect("signup.jsp");
			}
			else
			{
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("signup.jsp");

			}
			
		}catch (Exception e) {
			
		}
	}
}
