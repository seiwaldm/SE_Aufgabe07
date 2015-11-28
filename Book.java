
public class Book extends Item{
	
	private Double price;
	private Integer isbn;

	public Book(String name, Double price, Integer isbn) {
		super(name);
		this.setPrice(price);
		this.setIsbn(isbn);
		// TODO Auto-generated constructor stub
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
