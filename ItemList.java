import java.util.LinkedList;

/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * Class to store Items in a LinkedList. Provides template-methods for bulk operations on Items
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 *
 */
public class ItemList extends Item {

	private LinkedList<Item> itemList = new LinkedList<>();
	Double tempPrice;

	/**
	 * Constructs an empty List with specified name.
	 * 
	 * @param name
	 *            name of the ItemList
	 */
	public ItemList(String name) {
		super(name);
	}

	@Override
	public double getPrice() {
		double price = 0;
		for (Item i : itemList) {
			price += i.getPrice();
		}
		return price;
	}

	@Override
	public Double getPrice(String itemName) {
		tempPrice = null;
		checkPrice(itemName, this);
		return tempPrice;
	}

	private void checkPrice(String itemName, ItemList caller) {
		// check if current ItemList is the Item to be found and
		// getPrice() if true:
		if (this.getName().equals(itemName))
			caller.tempPrice = this.getPrice();
		// iterate over Items and check for Item name
		// (and price if correct Item is found).
		// if Item is an ItemList recursively call checkPrice
		for (Item i : this.itemList) {
			if (i instanceof ItemList) {
				ItemList l = (ItemList) i;
				l.checkPrice(itemName, caller);
			} else {
				if (i.getPrice(itemName) != null)
					caller.tempPrice = i.getPrice(itemName);
			}
		}
	}

	/**
	 * adds an Item to the ItemList
	 * 
	 * @param i
	 *            the Item that shall be added
	 */
	public void add(Item i) {
		this.itemList.add(i);
	}
}
