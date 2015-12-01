import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * PS Software Engineering WS2015 <br>
 * <br>
 * 
 * Class that reads from an XML-Input and creates a hierarchy of Item-Objects
 * from it
 * 
 * @author Kevin Schoergnhofer
 * @author Markus Seiwald
 */
public class XMLReader {

	ItemList rootList;

	/**
	 * Constructs a new XMLReader AND instantiates Item-Objects.
	 * 
	 * @param filename
	 *            the filename of the XML-input
	 */
	public XMLReader(String filename)
			throws ParserConfigurationException, SAXException, IOException {

		// create a new document from the input file:
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder reader = factory.newDocumentBuilder();
		FileInputStream input = new FileInputStream(filename);
		Document doc = reader.parse(input);

		// take root element and create a list of child nodes:
		Element root = doc.getDocumentElement();
		NodeList rootChildren = root.getChildNodes();
		// suppose the root element is a list and create a new instance:
		this.rootList = new ItemList(root.getAttribute("name"));
		// scan children of root list:
		scan(rootChildren, rootList);
	}

	private void scan(NodeList currentList, ItemList parentList) {
		for (int i = 0; i < currentList.getLength(); i++) {
			Node tempNode = currentList.item(i);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) tempNode;

				// create a new Book, CD or ItemList.
				// if element is an ItemList call scan-method recursively
				if (item.getTagName().equals("book")) {
					Book newBook = new Book(item.getAttribute("name"),
							Double.parseDouble(item.getAttribute("price")),
							Integer.parseInt(item.getAttribute("isbn")));
					parentList.add(newBook);
				} else if (item.getTagName().equals("cd")) {
					CD newCD = new CD(item.getAttribute("name"),
							Double.parseDouble(item.getAttribute("price")));
					parentList.add(newCD);
				} else if (item.getTagName().equals("list")) {
					ItemList newList = new ItemList(item.getAttribute("name"));
					parentList.add(newList);
					NodeList listChildren = item.getChildNodes();
					scan(listChildren, newList);
				}
			}
		}
	}
}
