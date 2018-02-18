/*@author Agnes Aronsson [agar3573]*/
class Stock extends Valuable {
	private int shares;
	private double price;
	
	public Stock(String name, int shares, double price) {
		super(name);
		this.shares = shares;
		this.price = price;
	}
	
	public int getShares() {
		return shares;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public String toString() {
		return "Stock: " + getName() + " Value: " + getValueAfterVat() + " Shares: " + shares + " Trading price: "	+ price;
		}
	
	@Override
	public double getValue() {
		return shares * price;
	}

}
