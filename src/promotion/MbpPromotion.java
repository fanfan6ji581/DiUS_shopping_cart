package promotion;

import model.IPriceCalculator;
import model.Item;
import model.Storage;

public class MbpPromotion extends Promotion {

	public MbpPromotion(IPriceCalculator order) {
		super(order);
	}

	@Override
	public double cost() {
		double cost = this.order.cost();
		double discount = 0;

		// count how many mbp and vga bought
		int countMbp = 0, countVga = 0;
		for (Item item : this.getItems()) {
			if (item == Storage.mbp) {
				countMbp++;
			}
			if (item == Storage.vga) {
				countVga++;
			}
		}

		// apply discount, buy one mbp get one vga for free
		if (countMbp > countVga) {
			discount = countVga * Storage.vga.getPrice();
		}
		return cost - discount;
	}

}
