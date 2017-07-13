package model;
import java.util.ArrayList;
import java.util.List;

public class Checkout implements IPriceCalculator {

	private List<Item> items;

	public Checkout() {
		this.items = new ArrayList<Item>();
	}

	@Override
	public void addItem(Item item) {
		this.items.add(item);
	}

	@Override
	public List<Item> getItems() {
		return this.items;
	}

	@Override
	public double cost() {
		double sum = 0;
		for (Item item : this.items) {
			sum += item.getPrice();
		}
		return sum;
	}
}
