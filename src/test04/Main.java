package test04;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		java.lang.System.out.println("START !");

		final String xmlParh = "c:\\benJave\\myTsuns.xml";
		try {
			new WriteXML().execute(createTsunList(), xmlParh);
			new WriteXML().execute(new ReadXML().execute(xmlParh), xmlParh);
		} catch (Exception e) {
		}
	}

	private static ArrayList<Tsun> createTsunList() {
		final ArrayList<Tsun> tsunList = new ArrayList<Tsun>();
		tsunList.add(new Beasu());
		tsunList.add(new Mickez());
		tsunList.add(new Mickez());
		return tsunList;
	}

}
