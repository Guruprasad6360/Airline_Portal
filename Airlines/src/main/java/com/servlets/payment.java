package com.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.Dao;

@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String upi = request.getParameter("upi");
		String card = request.getParameter("card");

		HashMap<String, String> user = new HashMap<>();
		user.put("upi", upi);
		user.put("card", card);

		try {
			Dao dao = new Dao();
			boolean result = dao.payment(user);
			HttpSession session = request.getSession();
			if (result) {
				session.setAttribute("message", "wait for some seconds!!");
			} else {
				session.setAttribute("message", "Payment not done!!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		response.sendRedirect("confirm.jsp");

	}   
}