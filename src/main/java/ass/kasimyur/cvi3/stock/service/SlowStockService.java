package ass.kasimyur.cvi3.stock.service;

import java.util.Iterator;
import java.util.Optional;

import org.apache.commons.lang3.ThreadUtils;
import org.apache.commons.lang3.Validate;

import ass.kasimyur.cvi3.stock.Stock;
import ass.kasimyur.cvi3.util.ThreadsUtil;

public class SlowStockService implements IStockService {
	
	protected FailureGenerator failGenerator;
	
	protected Long minDelay;
	protected Long maxDelay;
	
	protected Iterator<Stock> stocksIter;
	
	public SlowStockService(Iterator<Stock> stocks, Long minDelay, Long maxDelay, float failureProbability) {
		Validate.isTrue(minDelay <= maxDelay);
		this.failGenerator = new FailureGenerator(failureProbability);
		this.minDelay = minDelay;
		this.maxDelay = maxDelay;
		this.stocksIter = stocks;
	}

	public Optional<Stock> next() {
		ThreadsUtil.randomDelay(minDelay, maxDelay);
		failGenerator.maybeFail();
		return stocksIter.hasNext() ?
			Optional.of(stocksIter.next()) :
			Optional.empty();
	}
	
	public boolean hasNext() {
		return stocksIter.hasNext();
	}

}
