
public class CD extends Item{
	
	private Double price;

	public CD(String name, Double price) {
		super(name);
		this.setPrice(price);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPrice(String itemName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
