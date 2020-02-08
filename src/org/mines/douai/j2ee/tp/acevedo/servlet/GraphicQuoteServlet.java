package org.mines.douai.j2ee.tp.acevedo.servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mines.douai.j2ee.tp.acevedo.bean.ModelBean;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.Color;

/**
 * Servlet implementation class GraphicQuoteServlet
 */
@WebServlet("/QuoteRating")
public class GraphicQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Path2D drawPolyline( List<Double> yPoints) {
		
		List<Integer> days = Stream.iterate(1, n -> n + 1)
                .limit(30)
                .collect(Collectors.toList());
			Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD, days.size()-1);
			path.moveTo(days.get(0), yPoints.get(0));
			for (int i = 1; i < (days.size()-1); i++) {
				path.lineTo(days.get(i), yPoints.get(i));
			}
			return path;
	}
	
	public List<Double> generatePoints(String selectedCurrency) {
		ModelBean bean = new ModelBean();
		List<Double> currencyEvolution= new ArrayList<Double>();
		for(int i=0; i<31; i++) {
			currencyEvolution.add(bean.updateCurrency().get(selectedCurrency).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());	
		}
		
		return currencyEvolution;
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GraphicQuoteServlet() {
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
		response.setContentType("image/png");
		String selectedCurrency = request.getParameter("conversion");
		if (selectedCurrency.equals("Bitcoin")) {
			ServletOutputStream out = response.getOutputStream();
			BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();
			// Draw on the image
			g2d.setPaint(Color.red);
			g2d.draw(drawPolyline(generatePoints("Bitcoin")));
			/*g2d.translate(200, 1);
			g2d.scale(3.0, 3.0);
			g2d.draw(drawPolyline(generatePoints("Bitcoin")));*/
			// Sauver l’image dans le flux de sortie
			ImageIO.write(bufferedImage, "png", out);
			g2d.dispose();
		} else if (selectedCurrency.equals("Litecoin")) {
			ServletOutputStream out = response.getOutputStream();
			BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();
			// Draw on the image
			g2d.setColor(Color.blue);
			g2d.draw(drawPolyline(generatePoints("Litecoin")));
			// Sauver l’image dans le flux de sortie
			ImageIO.write(bufferedImage, "png", out);
			g2d.dispose();
		} else if(selectedCurrency.equals("Namecoin")) {
			ServletOutputStream out = response.getOutputStream();
			BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();
			// Draw on the image
			g2d.setColor(Color.green);
			g2d.draw(drawPolyline(generatePoints("Namecoin")));
			// Sauver l’image dans le flux de sortie
			ImageIO.write(bufferedImage, "png", out);
			g2d.dispose();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
