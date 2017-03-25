package ass.kasimyur.cvi3.stock.service;

import java.util.Iterator;

import ass.kasimyur.cvi3.stock.Stock;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomStockService extends SlowStockService {

	public RandomStockService(int stockCodeLength, float lowPrice, float highPrice, Long minDelay, Long maxDelay,
			float failureProbability) {
		super(new Iterator<Stock>() {

			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public Stock next() {
				return new Stock(
						RandomStringUtils.randomAlphabetic(stockCodeLength), 
						RandomUtils.nextFloat(lowPrice, highPrice)
				);
			}
			
		}, minDelay, maxDelay, failureProbability);
	}
	
	

}
