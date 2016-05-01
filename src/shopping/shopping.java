package shopping;

public class shopping {

	public static void main(String[] args) {
		Product butter = new Product("butter",0.80);
		Product milk = new Product("milk",1.15);
		Product bread = new Product("bread",1.00);
		
		Discount butterDiscount = new Discount(2,butter,1,bread,0.5); //if we have 2 butter, we get 1 bread at 50% of its price
		Discount milkDiscount = new Discount(4,milk,1,milk,0.0); //if we have 4 milk, we get 1 milk at 0% of its price
		
		Basket scenario1 = new Basket();
		Basket scenario2 = new Basket();
		Basket scenario3 = new Basket();
		Basket scenario4 = new Basket();
		
		try {
			scenario1.addProduct(butter,1);
			scenario1.addProduct(milk,1);
			scenario1.addProduct(bread,1);
			
			scenario2.addProduct(butter,2);
			scenario2.addProduct(bread,2);
			
			scenario3.addProduct(milk,4);
			
			scenario4.addProduct(butter,2);
			scenario4.addProduct(milk,8);
			scenario4.addProduct(bread,1);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		double scenario1Total = scenario1.getTotal();
		scenario1Total -= butterDiscount.apply(scenario1);
		scenario1Total -= milkDiscount.apply(scenario1);
		System.out.printf("Scenario 1 total: £%f\n", scenario1Total);
	
		double scenario2Total = scenario2.getTotal();
		scenario2Total -= butterDiscount.apply(scenario2);
		scenario2Total -= milkDiscount.apply(scenario2);
		System.out.printf("Scenario 2 total: £%f\n", scenario2Total);
	
		double scenario3Total = scenario3.getTotal();
		scenario3Total -= butterDiscount.apply(scenario3);
		scenario3Total -= milkDiscount.apply(scenario3);
		System.out.printf("Scenario 3 total: £%f\n", scenario3Total);
		
		double scenario4Total = scenario4.getTotal();
		scenario4Total -= butterDiscount.apply(scenario4);
		scenario4Total -= milkDiscount.apply(scenario4);
		System.out.printf("Scenario 4 total: £%f\n", scenario4Total);
	}
}
