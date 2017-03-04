package test04;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {

	public void execute(final ArrayList<Tsun> tsunList, final String xmlPath) throws Exception {

		final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		final Element tsunsElement = document.createElement("Tsuns");
		document.appendChild(tsunsElement);

		for (final Tsun tsun : tsunList) {

			final Element tsunElement = document.createElement(tsun.getClass().getSimpleName());
			tsunElement.setAttribute("skilmLevel", Integer.toString(tsun.getSkilmLevel()));
			tsunElement.appendChild(document.createTextNode("a123456789z"));

			tsunsElement.appendChild(tsunElement);

		}

		final Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty("indent", "yes");
		transformer.setOutputProperty("encoding", "Shift_JIS");

		final javax.xml.transform.Result streamResult = new StreamResult(new File(xmlPath));
		final javax.xml.transform.Source domSource = new DOMSource(document);
		transformer.transform(domSource, streamResult);

	}

}