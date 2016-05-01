package shopping;

public class Discount {
	
	int triggerQty;
	int targetQty;
	Product trigger;
	Product target;
	double discount;

	public Discount(int triggerQty, Product trigger, int targetQty, Product target, double discount) {
		this.triggerQty = triggerQty;
		this.targetQty = targetQty;
		this.trigger = trigger;
		this.target = target;
		this.discount = discount;
	}
	
	public double apply(Basket basket) {
		int times = Math.min(basket.getQuantity(trigger)/triggerQty, basket.getQuantity(target)/targetQty);
		double amount = targetQty * (target.getPrice() * (1.0-discount));
		return amount * times;
	}
}
