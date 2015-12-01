import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * Class to demonstrate functionality of XMLReader-Class and Item-Hierarchy 
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 *
 */
public class CompositeDemo {

	public static void main(String[] args) {

		try {
			XMLReader test = new XMLReader("C:\\Users\\ms\\workspace\\SE_Aufgabe07\\src\\demo.xml");
			ItemList list = test.rootList;
			System.out.println(list.getPrice());
			System.out.println(list.getPrice("L2"));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
