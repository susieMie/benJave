package test04;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class WriteXML {



	public void execute(final ArrayList<Player> tsunList, final String xmlPath) throws Exception {

		final org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		final org.w3c.dom.Element tsunsElement = document.createElement("Players");
		document.appendChild(tsunsElement);

		for (final Player tsun : tsunList) {
			tsunsElement.appendChild(tsun.createElement(document));
		}

		final Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty("indent", "yes");
		transformer.setOutputProperty("encoding", "Shift_JIS");

		final javax.xml.transform.Result streamResult = new StreamResult(new File(xmlPath));
		final javax.xml.transform.Source domSource = new DOMSource(document);
		transformer.transform(domSource, streamResult);

	}

}