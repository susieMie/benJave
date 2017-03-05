package test04;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		java.lang.System.out.println("START !");

		try {
			final String bb = "c:\\benJave\\myTsuns.xml";
			new WriteXML().execute(createPlayerList(), bb);
			final ArrayList<Player> a = new ReadXML().execute(bb);
			new WriteXML().execute(a, bb);

		} catch (Exception e) {
		}
	}

	private static ArrayList<Player> createPlayerList() {
		ArrayList<Player> list = new ArrayList<Player>();
		Player a = new Player();
		a.addTsun(new Beasu());
		a.addTsun(new Mickez());
		list.add(a);
		Player b = new Player();
		b.addTsun(new Beasu());
		b.addTsun(new Mickez());
		b.addTsun(new Mickez());
		list.add(b);
		return list;
	}

}
