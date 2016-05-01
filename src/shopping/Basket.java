package shopping;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	
	private Map<Product,Integer> products;
	
	public Basket() {
		products = new HashMap<Product,Integer>();
	}
	
	public double getTotal(){
		double total = 0;
		for(Map.Entry<Product, Integer>pair : this.products.entrySet()){
			total += pair.getKey().getPrice() * pair.getValue();
		}
		return total;
    }
	
	public void addProduct(Product product, int quantity) throws Exception{
		if(quantity<1){
			throw new Exception("invalid quantitiy");
		}
		if(this.products.containsKey(product)){
			//already in Map
			this.products.put(product, this.products.get(product)+quantity);
		}else{
			//add to Map
			this.products.put(product, quantity);
		}
	}
	
	public void removeProduct(Product p, int quantity) throws Exception{
		if(quantity<1){
			throw new Exception("invalid quantitiy");
		}
		if(this.products.containsKey(p)){
			if(this.products.get(p)>quantity){
				this.products.put(p, this.products.get(p)- quantity);
			}else{
				this.products.remove(p);
			}
		}else{
			throw new Exception("product not in basket");
		}
	}
	
	public int getQuantity(Product p){
		if(this.products.containsKey(p)){
			return this.products.get(p);
		}else{
			return 0;
		}
	}
}
