package test04;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXML {

	public ArrayList<Player> execute(final String path) throws Exception {
		final DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		final org.w3c.dom.Document document = documentBuilder.parse(new File(path));

		final ArrayList<Player> playerList = new ArrayList<Player>();

		// 要素情報の取得
		if (document.hasChildNodes()) {
			final org.w3c.dom.Node playersNode = document.getFirstChild();
			if (playersNode.hasChildNodes()) {
				org.w3c.dom.Node playerNode = playersNode.getFirstChild();
				while (playerNode != null) {
					if (playerNode.getNodeName().equals("Player")) {
						final Player player = new Player();
						player.loadNode(playerNode);
						playerList.add(player);
					}

					playerNode = playerNode.getNextSibling();
				}
			}
		}
		return playerList;
	}
}
