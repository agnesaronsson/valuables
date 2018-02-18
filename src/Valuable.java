/*@author Agnes Aronsson [agar3573]*/
package Valuables;

abstract class Valuable {
	private String name;
	
	public Valuable(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValueAfterVat() {
		double valueAfterVat = getValue() * 1.25;
		return String.format("%.2f", valueAfterVat);
	}
	
	abstract public double getValue();
}
