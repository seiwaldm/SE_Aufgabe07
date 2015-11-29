
public class Book extends Item{
	
	private Double price;
	private Integer isbn;

	public Book(String name, Double price, Integer isbn) {
		super(name);
		this.setPrice(price);
		this.setIsbn(isbn);
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
	

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
