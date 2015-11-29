import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class CompositeDemo {

	public static void main(String[] args) {

		try {
			XMLReader test = new XMLReader("C:\\Users\\ms\\workspace\\SE_Aufgabe07\\src\\demo.xml");
			ItemList list = test.rootList;
			System.out.println(list.getPrice());
			System.out.println(list.getPrice("B3"));
			System.out.println("stop");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
