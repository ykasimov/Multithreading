package ass.kasimyur.cvi3.functional;

import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import ass.kasimyur.cvi3.stock.Stock;

public class AverageStockPriceTest {

	@Test
	public void average() {
		List<Stock> stocks = new LinkedList<>();
		stocks.add(new Stock("A", 1));
		stocks.add(new Stock("A", 2));
		stocks.add(new Stock("B", 3));
		stocks.add(new Stock("B", 4));
		stocks.add(new Stock("C", 5));
		stocks.add(new Stock("C", 10));
		
		List<Stock> expected = new LinkedList<>();
		expected.add(new Stock("A", 1.5f));
		expected.add(new Stock("B", 3.5f));
		expected.add(new Stock("C", 7.5f));
		
		AverageStockPrice asp = new AverageStockPrice();
		Assert.assertEquals(asp.average(stocks), expected);
	}
}
