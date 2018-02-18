/*@author Agnes Aronsson [agar3573]*/
class Jewelry extends Valuable {
	private int gems;
	private boolean element;
	
	public Jewelry(String name, int gems, boolean element) {
		super(name);
		this.gems = gems;
		this.element = element;
	}
	
	public int getGems() {
		return gems;
	}
	
	public String getElement() {
		if(element) {
			return "Gold";
		} else {
			return "Silver";
		}
	}
	
	
	public String toString() {
		return "Jewelry: " + getName() + " Value: " + getValueAfterVat() + " Gems: " + gems + " " + getElement();
	}

	@Override
	public double getValue() {
		double addValue = 500 * gems;
		
		if(element) {
			return 2000 + addValue;
		} else {
			return 700 + addValue;
		}
	}
}
