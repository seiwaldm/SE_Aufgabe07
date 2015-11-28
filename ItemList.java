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
		for (Item i : itemList) {
			if (i.getName().equals(itemName)) {
				price = i.getPrice();
			}
		}
		return price;
	}
	
	public void add(Item i){
		this.itemList.add(i);
	}

}
