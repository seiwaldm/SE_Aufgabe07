/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * Abstract class that contains common fields (name) and methods that must be
 * implemented by sub-classes
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 *
 */
public abstract class Item {

	private String name;

	public Item(String name) {
		this.name = name;
	}

	/**
	 * gets Item name
	 * 
	 * @return the name of the Item on which the method is invoked
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets Item price - for ItemList the price is the sum of its components
	 * 
	 * @return the price of the Item on which the method is invoked
	 */
	public abstract double getPrice();

	/**
	 * searches for the price of a certain Item
	 * 
	 * @param itemName
	 *            the name of the Item whose price should be found
	 * @return null if Item couldn't be found
	 */
	public abstract Double getPrice(String itemName);

}
