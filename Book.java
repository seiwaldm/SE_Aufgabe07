/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * Class to manage Book-Items
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 */
public class Book extends Item {

	private double price;
	private int isbn;

	/**
	 * Constructs a new Book with specified name, price and identification
	 * number.
	 * 
	 * @param name
	 *            Book title
	 * @param price
	 *            Book price
	 * @param isbn
	 *            Book identification number
	 */
	public Book(String name, double price, int isbn) {
		super(name);
		this.price = price;
		this.isbn = isbn;
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

	/**
	 * gets the identification number of the Book
	 * 
	 * @return the Book identification number
	 */
	public int getIsbn() {
		return isbn;
	}
}
