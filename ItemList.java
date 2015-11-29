import java.util.LinkedList;

public class ItemList extends Item {

	private LinkedList<Item> itemList = new LinkedList<>();

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
	public double getPrice(String itemName) {
		double price = -999;
		for (Item i : this.itemList) {
			if (i.getName().equals(itemName))
				return i.getPrice();
			else {
				if (i.getClass().equals(this.getClass())) {
					i.getPrice(itemName);
				}
			}
			return price;
		}
		for (Item i : itemList) {
			price = i.getPrice(itemName);
		}
		return price;
	}

	public void add(Item i) {
		this.itemList.add(i);
	}

}
