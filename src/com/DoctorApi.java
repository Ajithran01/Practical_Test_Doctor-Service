package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoctorApi {

	@WebServlet("/ItemsAPI")
	public static class ItemsAPI extends HttpServlet {
		Doctor d1 = new Doctor();

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String output = d1.insertDoctor(request.getParameter("ID"), request.getParameter("dName"),
					request.getParameter("specialization"), request.getParameter("hName"));
			response.getWriter().write(output);
		}

		private static Map getParasMap(HttpServletRequest request) {
			Map<String, String> map = new HashMap<String, String>();
			try {
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
				scanner.close();
				String[] params = queryString.split("&");
				for (String param : params) {
					String[] p = param.split("=");
					map.put(p[0], p[1]);
				}
			} catch (Exception e) {
			}
			return map;
		}
		protected void doPut(HttpServletRequest request, HttpServletResponse response)
				 throws ServletException, IOException
				{
				 Map paras = getParasMap(request);
				 String output = d1.updateDoctor(paras.get("hidItemIDSave").toString(),
				 paras.get("dName").toString(),
				paras.get("specialization").toString(),
				 paras.get("hName").toString());
				response.getWriter().write(output);
				}
				protected void doDelete(HttpServletRequest request, HttpServletResponse response)
				 throws ServletException, IOException
				{
				 Map paras = getParasMap(request);
				 String output = d1.deleteDoctor(paras.get("ID").toString());
				response.getWriter().write(output);
				}

	}
}
