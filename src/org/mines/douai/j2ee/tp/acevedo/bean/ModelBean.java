package org.mines.douai.j2ee.tp.acevedo.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ModelBean {

	HashMap<String, BigDecimal> cryptoCurrency = new HashMap<String, BigDecimal>();
	Random rand = new Random();

	public ModelBean() {
		setCryptoCurrency(updateCurrency());
	}

	public HashMap<String, BigDecimal> updateCurrency() {
		HashMap<String, BigDecimal> newCurrency = new HashMap<String,BigDecimal>();
		newCurrency.put("Bitcoin", generateBigDecimalRandom(10000.0));
		newCurrency.put("Litecoin", generateBigDecimalRandom(100.0));
		newCurrency.put("Namecoin", generateBigDecimalRandom(30.0));
		return newCurrency;
	}
	
	public BigDecimal generateBigDecimalRandom(double max){
		double random = ThreadLocalRandom.current().nextDouble(0, max);
		return new BigDecimal(random);
		
	}

	public HashMap<String, BigDecimal> getCryptoCurrency() {
		return cryptoCurrency;
	}

	public void setCryptoCurrency(HashMap<String, BigDecimal> cryptoCurrencies) {
		this.cryptoCurrency = cryptoCurrencies;
	}

}
