package ass.kasimyur.cvi3.stock.trader.solution;

import ass.kasimyur.cvi3.stock.Stock;
import ass.kasimyur.cvi3.stock.service.IStockService;
import ass.kasimyur.cvi3.stock.trader.IStockTrader;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Optional;

/**
 * Created by username on 3/20/17.
 */
public class ReactiveTrader implements IStockTrader {


    @Override
    public String suggestStockToBuy(IStockService stockService) {

        return Observable.range(0, 10)
                .flatMap(i -> Observable.just(i)
                                .subscribeOn(Schedulers.io())
                                .map((y) -> stockService.next())
                                .onErrorReturn(error -> Optional.<Stock>empty())
                )

                .filter(Optional::isPresent)
                .map(Optional::get).reduce((x, y) -> x.getValue() < y.getValue() ? x : y).blockingGet().getCode();


    }
}
