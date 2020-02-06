package org.mines.douai.j2ee.tp.acevedo.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

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
	private HashMap<String,BigDecimal> cryptoCurrencies = new HashMap<String,BigDecimal>();
       
	
	public void updateValues() {
		
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
		java.io.PrintWriter out= response.getWriter();
		this.showButton(response, request);
		if(request.getParameter("conversion").equals("bitcoin")) {
			out.print("<h2>Hello</h2></body></html>");
		}
		
	}

	
	public void showButton(HttpServletResponse rep, HttpServletRequest req) throws IOException {
		rep.setContentType("text/html");
		java.io.PrintWriter out= rep.getWriter();
		out.print("<html><head><title>TP1</title></head>");
		out.print("<body>"
				+ "<select name=\"conversion\" form=\"myForm\">");
		out.print("<option value=\"bitcoin\">Bitcoin</option>"
				+ "<option value=\"litcoin\">Litcoin</option>"
				+ "<option value=\"namecoin\">Namecoin</option></select>");
		out.print( "<form action=\"http://localhost:8080/TP1/SimpleQuote\" methode=Post id='myForm'>"
				+ "<input type=submit name=refresh value=\"refresh\"></form>");
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
