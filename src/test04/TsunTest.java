package test04;

import org.junit.Test;

public class TsunTest {

	@Test
	public void test() {

		java.lang.System.out.println("TEST START !");

		a01();
		a02();
		a03();
		a04();
		a05();

		// fail("まだ実装されていません");
	}

	// ArrayList実験
	private void a01() {
		java.lang.System.out.println("\na01 ArrayList");

		final java.util.ArrayList<Tsun> tsunList = new java.util.ArrayList<Tsun>();

		final Tsun beasu = new Beasu();
		tsunList.add(beasu);

		final Tsun mickez = new Mickez();
		tsunList.add(mickez);

		for (final Tsun tsun : tsunList) {
			tsun.printInfo();
		}

	}

	// HashMap実験
	private final String KEDAMONO = "kedamono";
	private final String NEZUMI = "nezumi";

	private void a02() {
		java.lang.System.out.println("\na02 HashMap");

		final java.util.HashMap<String, Tsun> tsunMap = new java.util.HashMap<String, Tsun>();

		tsunMap.put(KEDAMONO, new Beasu());
		tsunMap.put(NEZUMI, new Mickez());
		tsunMap.put(NEZUMI, new Beasu());

		if (tsunMap.containsKey(KEDAMONO)) {
			java.lang.System.out.println(KEDAMONO);
			tsunMap.get(KEDAMONO).printInfo();
		}
		if (tsunMap.containsKey(NEZUMI)) {
			java.lang.System.out.println(NEZUMI);
			tsunMap.get(NEZUMI).printInfo();
		}

	}

	// final実験
	private void a03() {
		java.lang.System.out.println("\na03 final");

		final Tsun tsum;

		tsum = new Beasu();

		// ↓コンパイルエラー
		// tsum = new Mickey();

		tsum.printInfo();

	}

	// equals実験
	private void a04() {
		java.lang.System.out.println("\na04 equals");

		if (new Beasu().equals(new Mickez())) {
			java.lang.System.out.println("Beasu , Mickez is equal");
		} else {
			java.lang.System.out.println("Beasu , Mickez is not equal");
		}

		if (new Beasu().equals(new Beasu())) {
			java.lang.System.out.println("Beasu , Beasu is equal");
		} else {
			java.lang.System.out.println("Beasu , Beasu is not equal");
		}
	}

	// HashSet実験
	private void a05() {
		java.lang.System.out.println("\na05 HashSet");

		final java.util.HashSet<Tsun> tsunSet = new java.util.HashSet<Tsun>();
		tsunSet.add(new Beasu());

		final Tsun beasu = new Beasu();
		tsunSet.add(beasu);
		tsunSet.add(beasu); // これが追加されてないっぽい

		final java.util.Iterator<Tsun> it = tsunSet.iterator();
		while (it.hasNext()) {
			it.next().printInfo();
		}

	}

}
