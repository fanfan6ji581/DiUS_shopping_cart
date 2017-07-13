package model;

import java.util.List;

public interface IPriceCalculator {
	public List<Item> getItems();

	public void addItem(Item item);

	public double cost();
}
