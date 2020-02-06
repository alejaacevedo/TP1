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

/**
 * Servlet implementation class SimpleQuoteServlet
 */
@WebServlet("/SimpleQuote")
public class SimpleQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
       
	
	public HashMap<String,BigDecimal> createMap() {
		HashMap<String,BigDecimal> cryptoCurrencies = new HashMap<String,BigDecimal>();
		Random rand = new Random();
		cryptoCurrencies.put("Bitcoin", new BigDecimal(rand.nextInt(10000)));
		cryptoCurrencies.put("Litecoin", new BigDecimal(rand.nextInt(100)));
		cryptoCurrencies.put("Namecoin", new BigDecimal(rand.nextInt(30)));
		return cryptoCurrencies;
		}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleQuoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		this.showListSelection(response, request);
		
	}

	
	public void showListSelection(HttpServletResponse rep, HttpServletRequest req) throws IOException {
		rep.setContentType("text/html");
		java.io.PrintWriter out= rep.getWriter();
		HashMap<String,BigDecimal> currencies= createMap();
		String selection = req.getParameter("conversion");
		
	
		out.print("<html><head><title>TP1</title></head>");
		out.print("<body><select name=\"conversion\" form=\"myForm\">");
		for(String i: currencies.keySet()) {
			if( selection != null && selection.equals(i)) {
				out.print("<option value=\""+i+"\" selected>"+i+"</option>");
				
			}else {
				out.print("<option value=\""+i+"\">"+i+"</option>");
			}
		}
		out.print( "</select> <form  methode=Post id='myForm'>"
				+ "<input type=submit name=refresh value=\"refresh\"></form>");
		if(selection!= null) {
		out.print("<p> Crypto: "+ selection + " value is: "+ currencies.get(selection)+ "</p>");
		}
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("refresh") != null) {
			doGet(request, response);
			}
			
			
		
	}

}
