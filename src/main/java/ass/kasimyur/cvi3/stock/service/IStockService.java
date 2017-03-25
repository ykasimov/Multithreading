package ass.kasimyur.cvi3.stock.service;

import java.util.Iterator;
import java.util.Optional;

import ass.kasimyur.cvi3.stock.Stock;

public interface IStockService extends Iterable<Optional<Stock>>, Iterator<Optional<Stock>> {
	
	default Iterator<Optional<Stock>> iterator() {
		return this;
	}
	
}
