package ass.kasimyur.cvi3.stock.trader;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ass.kasimyur.cvi3.stock.Stock;
import ass.kasimyur.cvi3.stock.service.SlowStockService;
import ass.kasimyur.cvi3.stock.trader.solution.ExecutorTrader;
import ass.kasimyur.cvi3.stock.trader.solution.ReactiveTrader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TraderTest {
	
	// TODO: change this to your new implementation that passes more tests!
	protected IStockTrader trader = new ReactiveTrader();

	protected List<Stock> tenStocks;
	
	@Test
	public void testShouldFindCorrectMinimum() {
		String suggestion = trader.suggestStockToBuy(new SlowStockService(tenStocks.iterator(), 10L, 30L, 0f));
		Assert.assertEquals(suggestion, "A0");
	}
	
	@Test(timeOut=2000)
	public void testShouldFindCorrectMinimumFast() {
		String suggestion = trader.suggestStockToBuy(new SlowStockService(tenStocks.iterator(), 500L, 600L, 0f));
		Assert.assertEquals(suggestion, "A0");
	}


    //test exception failing
	@Test(timeOut=2000)
	public void testShouldSkipFailed() {
		trader.suggestStockToBuy(new SlowStockService(tenStocks.iterator(), 10L, 30L, .3f));
	}

	@BeforeClass
	public void setup() {
		tenStocks = IntStream.range(0, 10)
				.boxed()
				.map(i -> new Stock("A"+i, i * 100 + 50))
				.collect(Collectors.toList());
		
		Collections.shuffle(tenStocks);
	}
}
