/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * Class to manage CD-Items
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 *
 */
public class CD extends Item {

	private double price;

	/**
	 * Constructs a new CD with specified name and price.
	 * 
	 * @param name
	 *            CD title
	 * @param price
	 *            CD price
	 */
	public CD(String name, double price) {
		super(name);
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public Double getPrice(String itemName) {
		if (itemName.equals(this.getName()))
			return this.getPrice();
		else
			return null;
	}
}
