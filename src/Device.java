/*@author Agnes Aronsson [agar3573]*/
package Valuables;

class Device extends Valuable {
	private double price;
	private int wear;
	
	public Device(String name, double price, int wear) {
		super(name);
		this.price = price;
		this.wear = wear;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getWear() {
		return wear;
	}
	
	public String toString() {
		return "Device: " + getName() + " Value: " + getValueAfterVat() + " Price: " + price + " Wear: " + wear;
	}

	@Override
	public double getValue() {
		return ((double)wear / 10) * price;
	}
}
