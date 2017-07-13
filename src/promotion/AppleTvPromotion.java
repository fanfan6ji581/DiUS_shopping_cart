package promotion;

import model.IPriceCalculator;
import model.Item;
import model.Storage;

public class AppleTvPromotion extends Promotion {

	public AppleTvPromotion(IPriceCalculator order) {
		super(order);
	}

	@Override
	public double cost() {
		double cost = this.order.cost();
		double discount = 0;
		// apply buy 3 atv for 2 discount
		int count = 0;
		for (Item p : this.getItems()) {
			if (p == Storage.atv) {
				count++;
			}
		}

		// apply discount
		discount = Storage.atv.getPrice() * (count / 3);
		return cost - discount;
	}

}
