package com.zuidaima.service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String validateC = (String) request.getSession().getAttribute("checkcode");
		String veryCode = request.getParameter("c");
		PrintWriter out = response.getWriter();
		if (veryCode == null || "".equals(veryCode)) {
			out.println("请输入验证码！");
		} else {
			if (validateC.equals(veryCode)) {
				out.println(1);
			} else {
				out.println("验证码输入错误！");
			}
		}
		out.flush();
		out.close();
	}

}
