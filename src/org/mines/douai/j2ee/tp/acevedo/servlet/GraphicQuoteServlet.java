package org.mines.douai.j2ee.tp.acevedo.servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.geom.Ellipse2D;
import java.awt.Color;

/**
 * Servlet implementation class GraphicQuoteServlet
 */
@WebServlet("/QuoteRating")
public class GraphicQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 public void createImage() {
	BufferedImage bufferedImage = new BufferedImage(200, 200,
			BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();
			// Draw on the image
			g2d.setColor(Color.red);
			g2d.fill(new Ellipse2D.Float(0, 0, 200, 100));
 }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphicQuoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
