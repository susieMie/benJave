package test04;

public class Main {

	public static void main(String[] args) {

		java.lang.System.out.println("START !");

		a01();

	}

	private static void a01() {
		final String xmlParh = "c:\\benJave\\myTsuns.xml";

		try {
			new WriteXML().execute(createTsunList(), xmlParh);
			new WriteXML().execute(new ReadXML().execute(xmlParh), xmlParh);
		} catch (Exception e) {
		}
	}

	private static java.util.ArrayList<Tsun> createTsunList() {
		final java.util.ArrayList<Tsun> tsunList = new java.util.ArrayList<Tsun>();
		tsunList.add(new Beasu());
		tsunList.add(new Mickez());
		tsunList.add(new Mickez());
		return tsunList;
	}

}
