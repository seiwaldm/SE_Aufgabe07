

/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 *
 */
public abstract class Item {
	
	private String name;
	
	public Item(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract double getPrice();
	public abstract double getPrice(String itemName);

}
