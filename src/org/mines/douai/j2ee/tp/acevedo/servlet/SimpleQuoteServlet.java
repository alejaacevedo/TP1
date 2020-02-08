package org.mines.douai.j2ee.tp.acevedo.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mines.douai.j2ee.tp.acevedo.bean.ModelBean;

/**
 * Servlet implementation class SimpleQuoteServlet
 */
@WebServlet("/SimpleQuote")
public class SimpleQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModelBean bean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SimpleQuoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.showListSelection(response, request);

	}

	public void showListSelection(HttpServletResponse rep, HttpServletRequest req) throws IOException {
		rep.setContentType("text/html");
		java.io.PrintWriter out = rep.getWriter();
		this.bean = new ModelBean();
		HashMap<String, BigDecimal> currencies = bean.getCryptoCurrency();
		String selection = req.getParameter("conversion");

		out.print("<html><head><title>TP1</title></head>");
		out.print("<body><form method=Post>\n" + "<select name=\"conversion\" >");
		for (String i : currencies.keySet()) {
			if (selection != null && selection.equals(i)) {
				out.print("<option value=\"" + i + "\" selected>" + i + "</option>");

			} else {
				out.print("<option value=\"" + i + "\">" + i + "</option>");
			}
		}
		out.print("</select>" + "<input type=submit name=refresh value=\"refresh\"></form>");
		/*
		 * if(selection!= null) { out.print("<p> Crypto: "+ selection + " value is: "+
		 * currencies.get(selection)+ "</p>"); }
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String selection = "";
		HashMap<String, BigDecimal> currency = bean.getCryptoCurrency();
		this.doGet(request, response);
		if (request.getParameter("conversion") != null) {
			selection = request.getParameter("conversion");

		}
		java.io.PrintWriter out = response.getWriter();
		out.println("<br/> Le montant en dollard de la devise est de " + currency.get(selection).setScale(4, BigDecimal.ROUND_HALF_UP) + " $");

	}

}
