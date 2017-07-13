package promotion;

import java.util.List;

import model.IPriceCalculator;
import model.Item;

/**
 * apply decorator pattern
 */
public abstract class Promotion implements IPriceCalculator {
	protected IPriceCalculator order;

	public Promotion(IPriceCalculator order) {
		this.order = order;
	}

	@Override
	public void addItem(Item p) {
		this.order.addItem(p);
	}

	@Override
	public List<Item> getItems() {
		return this.order.getItems();
	}
}
