package test;

import model.IPriceCalculator;
import model.Checkout;
import model.Storage;
import promotion.AppleTvPromotion;
import promotion.IPadPromotion;
import promotion.MbpPromotion;

public class Main {

	/**
	 * apply promotion rules here
	 * @return
	 */
	public static IPriceCalculator getCheckout() {
		// base checkout
		IPriceCalculator co = new Checkout();
		
		// apply lists of promotion here
		// all the promotion class is using decorator pattern
		co = new AppleTvPromotion(co);
		co = new IPadPromotion(co);
		co = new MbpPromotion(co);
		return co;
	}

	// first test, should be $249
	public static void test1() {
		IPriceCalculator co = getCheckout();
		co.addItem(Storage.atv);
		co.addItem(Storage.atv);
		co.addItem(Storage.atv);
		co.addItem(Storage.vga);
		System.out.println(co.cost());
	}

	// first test, should be $2718.95
	public static void test2() {
		IPriceCalculator co = getCheckout();

		co.addItem(Storage.atv);
		co.addItem(Storage.ipd);
		co.addItem(Storage.ipd);
		co.addItem(Storage.atv);
		co.addItem(Storage.ipd);
		co.addItem(Storage.ipd);
		co.addItem(Storage.ipd);

		System.out.println(co.cost());
	}

	// first test, should be $1949.98
	public static void test3() {
		IPriceCalculator co = getCheckout();

		co.addItem(Storage.mbp);
		co.addItem(Storage.vga);
		co.addItem(Storage.ipd);

		System.out.println(co.cost());
	}

	public static void main(String args[]) {
		test1();
		test2();
		test3();
	}
}
