package ass.kasimyur.cvi3.stock.trader;

import java.util.Optional;
import java.util.stream.StreamSupport;

import ass.kasimyur.cvi3.stock.service.IStockService;

public class SingleThreadedTrader implements IStockTrader {

	@Override
	public String suggestStockToBuy(IStockService stockService) {
		return StreamSupport.stream(stockService.spliterator(), false) // parallel_stream=false
		.filter(Optional::isPresent)
		.map(Optional::get)
		.filter(stock -> stock.getValue() < 200)
		.limit(10)
		.min((s1, s2) -> s1.getValue() - s2.getValue() < 0 ? -1 : 1)
		.get().getCode();
	}
	
}
