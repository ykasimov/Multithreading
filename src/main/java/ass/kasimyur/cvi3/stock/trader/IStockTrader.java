package ass.kasimyur.cvi3.stock.trader;

import ass.kasimyur.cvi3.stock.service.IStockService;

public interface IStockTrader {
	
	/** 
	 *	Analyzes stocks returned by stockService and suggests stock code to buy 
	 */
	String suggestStockToBuy(IStockService stockService);

}
