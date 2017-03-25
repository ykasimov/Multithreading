package ass.kasimyur.cvi3.functional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ass.kasimyur.cvi3.stock.Stock;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class AverageStockPrice {
	
	public List<Stock> average(Collection<Stock> stocks) {
		return stocks.stream()
				.collect(Collectors.groupingBy(Stock::getCode))
				.entrySet().stream()
				.map(entry -> new ImmutablePair<String, Float>(entry.getKey(),
						entry.getValue().stream()
								.map(Stock::getValue)
								.reduce((v1, v2) -> v1 + v2)
								.orElse(0f) / entry.getValue().size()
				))
				.map(pair -> new Stock(pair.left, pair.right))
				.collect(Collectors.toList());
	}
}
