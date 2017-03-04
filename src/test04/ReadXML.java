package test04;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ReadXML {

	public ArrayList<Tsun> execute(String path) throws Exception {
		final DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		final Document document = documentBuilder.parse(new File(path));

		final java.util.ArrayList<Tsun> tsunList = new java.util.ArrayList<Tsun>();

		// 要素情報の取得
		if (document.hasChildNodes()) {
			final Node tsunsNode = document.getFirstChild();
			if (tsunsNode.hasChildNodes()) {
				Node tsunNode = tsunsNode.getFirstChild();
				while (tsunNode != null) {

					if (tsunNode.getNodeName().equals("Beasu")) {
						final Tsun beasu = new Beasu();
						readAttr(beasu, tsunNode);
						tsunList.add(beasu);

					} else if (tsunNode.getNodeName().equals("Mickez")) {
						final Tsun mickez = new Mickez();
						readAttr(mickez, tsunNode);
						tsunList.add(mickez);

					}

					tsunNode = tsunNode.getNextSibling();
				}
			}
		}
		return tsunList;
	}

	private void readAttr(final Tsun tsun, final Node node) {
		final org.w3c.dom.NamedNodeMap namedNodeMap = node.getAttributes();
		if (node != null) {
			final Node item = namedNodeMap.getNamedItem("skilmLevel");
			if (item != null) {
				tsun.setSkilmeLevel(Integer.parseInt(item.getNodeValue()));
			}
		}
	}

}
