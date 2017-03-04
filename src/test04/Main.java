package test04;

public class Main {

	public static void main(String[] args) {

		java.lang.System.out.println("MAIN START !");

		a01();

	}

	private static void a01() {
		java.lang.System.out.println("\na01 ArrayList");

		final java.util.ArrayList<Tsun> thunList1 = createTsunList();

		final String xmlParh = "c:\\benJave\\myTsuns.xml";
		try {
			new WriteXML().execute(thunList1, xmlParh);
			final java.util.ArrayList<Tsun> tsunList2 = new ReadXML().execute(xmlParh);
			new WriteXML().execute(tsunList2, xmlParh);
		} catch (Exception e) {
		}
	}

	private static java.util.ArrayList<Tsun> createTsunList() {
		final java.util.ArrayList<Tsun> tsunList = new java.util.ArrayList<Tsun>();

		final Tsun beasu = new Beasu();
		tsunList.add(beasu);

		final Tsun mickez = new Mickez();
		tsunList.add(mickez);

		final Tsun a = new Mickez();
		tsunList.add(a);

		return tsunList;
	}

}
