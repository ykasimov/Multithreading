package ass.kasimyur.cvi3.stock.trader.solution;

import ass.kasimyur.cvi3.stock.Stock;
import ass.kasimyur.cvi3.stock.service.IStockService;
import ass.kasimyur.cvi3.stock.service.StockServiceException;
import ass.kasimyur.cvi3.stock.trader.IStockTrader;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.StreamSupport;

public class ExecutorTrader implements IStockTrader {

    protected ExecutorService executors = Executors.newFixedThreadPool(10);


    @Override
    public String suggestStockToBuy(IStockService stockService) {
        CompletionService<Optional<Stock>> completionService = new ExecutorCompletionService<>(executors);
        Set<Future<Optional<Stock>>> futures = new HashSet<>();
        for (int i = 0; i < 10; i++) {

            futures.add(completionService.submit(() -> {
                Optional<Stock> output = null;
                try {
                    output = stockService.next();

                } catch (StockServiceException e) {
                    output = Optional.empty();
                }

                return output;
            }));
        }
//        }
        List<Optional<Stock>> completedStocks = new ArrayList<>();

        while (futures.size() > 0) {
            try {
                Future<Optional<Stock>> tmp = completionService.take();
                Optional<Stock> tmp1 = tmp.get();
                if (tmp1.isPresent()) {
                    completedStocks.add(tmp1);
                }
                futures.remove(tmp);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
        if (completedStocks.size() == 0) {
            return "N/A";
        }
        return StreamSupport.stream(completedStocks.spliterator(), false)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stock -> stock.getValue() < 200)
                .limit(10)
                .min((s1, s2) -> s1.getValue() - s2.getValue() < 0 ? -1 : 1).get().getCode();


    }


}


