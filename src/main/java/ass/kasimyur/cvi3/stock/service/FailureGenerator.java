package ass.kasimyur.cvi3.stock.service;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;

public class FailureGenerator {
	
	protected float failureProbability;
	
	public FailureGenerator(float failureProbability) {
		Validate.inclusiveBetween(0, 1, failureProbability);
		this.failureProbability = failureProbability;
	}

	public void maybeFail() {
		if(RandomUtils.nextFloat(0, 1f) <= failureProbability) {
			throw new StockServiceException();
		}
	}
	
}
