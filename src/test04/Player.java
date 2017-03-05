/**
 *
 */
package test04;

import java.util.ArrayList;

/**
 * @author susieMieW10
 *
 */
public class Player {

	private String name;

	private ArrayList<Tsun> tsunList;

	/**
	 * コンストラクタ
	 */
	protected Player() {
		this.name = "";
		this.tsunList = new ArrayList<Tsun>();
	}

	public void addTsun(Tsun tsun) {
		tsunList.add(tsun);
	}

	public final org.w3c.dom.Element createElement(final org.w3c.dom.Document document) {
		final org.w3c.dom.Element element = document.createElement(this.getClass().getSimpleName());

		element.setAttribute("name", this.name);
		for (final Tsun tsun : this.tsunList) {
			element.appendChild(tsun.createElement(document));
		}

		return element;
	}

	public void loadNode(final org.w3c.dom.Node node) {
		final org.w3c.dom.NamedNodeMap namedNodeMap = node.getAttributes();
		if (node != null) {
			final org.w3c.dom.Node item = namedNodeMap.getNamedItem("name");
			if (item != null) {
				this.name = item.getNodeValue();
			}
		}
		if (node.hasChildNodes()) {
			org.w3c.dom.Node tsunNode = node.getFirstChild();
			while (tsunNode != null) {

				if (tsunNode.getNodeName().equals("Beasu")) {
					final Beasu beasu = new Beasu();
					beasu.loadNode(tsunNode);
					this.tsunList.add(beasu);

				} else if (tsunNode.getNodeName().equals("Mickez")) {
					final Mickez mickez = new Mickez();
					mickez.loadNode(tsunNode);
					this.tsunList.add(mickez);

				}

				tsunNode = tsunNode.getNextSibling();
			}
		}
	}

}
