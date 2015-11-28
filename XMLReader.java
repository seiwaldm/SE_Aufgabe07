
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

public class XMLReader {

	ItemList rootList;

	public XMLReader(String filename)
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder reader = factory.newDocumentBuilder();
		FileInputStream input = new FileInputStream(filename);
		Document doc = reader.parse(input);

		// nehme fürs erste an, dass das root-element immer eine Liste ist (und
		// keine Buch oder CD...):
		Element root = doc.getDocumentElement();
		NodeList rootChildren = root.getChildNodes();
		this.rootList = new ItemList(root.getAttribute("name"));
		scan(rootChildren, rootList);
	}

	private void scan(NodeList currentList, ItemList parentList) {
		for (int i = 0; i < currentList.getLength(); i++) {
			Node tempNode = currentList.item(i);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) tempNode;
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
