package test04;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXML {

	public ArrayList<Tsun> execute(String path) throws Exception {
		final DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		final org.w3c.dom.Document document = documentBuilder.parse(new File(path));

		final ArrayList<Tsun> tsunList = new ArrayList<Tsun>();

		// 要素情報の取得
		if (document.hasChildNodes()) {
			final org.w3c.dom.Node tsunsNode = document.getFirstChild();
			if (tsunsNode.hasChildNodes()) {
				org.w3c.dom.Node tsunNode = tsunsNode.getFirstChild();
				while (tsunNode != null) {

					if (tsunNode.getNodeName().equals("Beasu")) {
						final Tsun beasu = new Beasu();
						beasu.loadNode(tsunNode);
						tsunList.add(beasu);

					} else if (tsunNode.getNodeName().equals("Mickez")) {
						final Tsun mickez = new Mickez();
						mickez.loadNode(tsunNode);
						tsunList.add(mickez);

					}

					tsunNode = tsunNode.getNextSibling();
				}
			}
		}
		return tsunList;
	}

}
