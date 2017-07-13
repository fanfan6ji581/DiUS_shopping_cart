package promotion;

import model.IPriceCalculator;
import model.Item;
import model.Storage;

public class IPadPromotion extends Promotion {

	public IPadPromotion(IPriceCalculator order) {
		super(order);
	}

	@Override
	public double cost() {
		double cost = this.order.cost();
		double discount = 0;

		// apply buy 4 and above ipad, have discount unit price discount
		int count = 0;
		for (Item item : this.getItems()) {
			if (item == Storage.ipd) {
				count++;
			}
		}

		// apply discount
		if (count > 4) {
			discount = 50 * count;
		}
		return cost - discount;
	}

}
