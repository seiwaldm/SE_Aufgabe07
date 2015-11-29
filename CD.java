
public class CD extends Item{
	
	private Double price;

	public CD(String name, Double price) {
		super(name);
		this.setPrice(price);
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double getPrice(String itemName) {
		double price = -999;
		if (itemName.equals(this.getName()))
			price = this.getPrice();
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
